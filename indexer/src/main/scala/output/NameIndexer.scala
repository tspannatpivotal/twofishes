package com.foursquare.twofishes.output

import com.foursquare.twofishes.Indexes
import com.foursquare.twofishes.mongo.NameIndexDAO
import com.foursquare.twofishes.util.StoredFeatureId
import com.mongodb.Bytes
import com.mongodb.casbah.Imports._
import com.novus.salat._
import com.novus.salat.annotations._
import com.novus.salat.dao._
import com.novus.salat.global._
import java.io._
import org.apache.hadoop.hbase.util.Bytes._
import scala.collection.mutable.HashSet
import scalaj.collection.Implicits._


class NameIndexer(
  override val basepath: String,
  override val fidMap: FidMap,
  outputPrefixIndex: Boolean
) extends Indexer {
  val index = Indexes.NameIndex
  override val outputs = Seq(index) ++
    (if (outputPrefixIndex) { Seq(PrefixIndexer.index) } else { Seq.empty })

  def writeIndexImpl() {
    var nameCount = 0
    val nameSize = NameIndexDAO.collection.count()
    val nameCursor = NameIndexDAO.find(MongoDBObject())
      .sort(orderBy = MongoDBObject("name" -> 1)) // sort by nameBytes asc
    nameCursor.option = Bytes.QUERYOPTION_NOTIMEOUT

    var prefixSet = new HashSet[String]

    var lastName = ""
    val nameFids = new HashSet[StoredFeatureId]

    val writer = buildHFileV1Writer(index)

    def writeFidsForLastName() {
      writer.append(lastName, fidsToCanonicalFids(nameFids.toList))
      if (outputPrefixIndex) {
        for {
         length <- 1 to math.min(PrefixIndexer.MaxPrefixLength, lastName.size)
        } {
          prefixSet.add(lastName.substring(0, length))
        }
      }
    }

    nameCursor.filterNot(_.name.isEmpty).foreach(n => {
      if (lastName != n.name) {
        if (lastName != "") {
          writeFidsForLastName()
        }
        nameFids.clear()
        lastName = n.name
      }

      nameFids.add(n.fidAsFeatureId)

      nameCount += 1
      if (nameCount % 100000 == 0) {
        logger.info("processed %d of %d names".format(nameCount, nameSize))
      }
    })
    writeFidsForLastName()
    writer.close()

    if (outputPrefixIndex) {
      val prefixIndexer = new PrefixIndexer(basepath, fidMap, prefixSet)
      prefixIndexer.writeIndex()
    }
  }
}
