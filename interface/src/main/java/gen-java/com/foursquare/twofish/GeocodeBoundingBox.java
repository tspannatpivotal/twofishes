/**
 * Autogenerated by Thrift
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 */
package com.foursquare.twofish;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.EnumMap;
import java.util.Set;
import java.util.HashSet;
import java.util.EnumSet;
import java.util.Collections;
import java.util.BitSet;
import java.nio.ByteBuffer;
import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.apache.thrift.*;
import org.apache.thrift.async.*;
import org.apache.thrift.meta_data.*;
import org.apache.thrift.transport.*;
import org.apache.thrift.protocol.*;

// No additional import required for struct/union.

public class GeocodeBoundingBox implements TBase<GeocodeBoundingBox, GeocodeBoundingBox._Fields>, java.io.Serializable, Cloneable {
  private static final TStruct STRUCT_DESC = new TStruct("GeocodeBoundingBox");

  private static final TField NE_FIELD_DESC = new TField("ne", TType.STRUCT, (short)1);
  private static final TField SW_FIELD_DESC = new TField("sw", TType.STRUCT, (short)2);

  public GeocodePoint ne;
  public GeocodePoint sw;

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements TFieldIdEnum {
    NE((short)1, "ne"),
    SW((short)2, "sw");

    private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

    static {
      for (_Fields field : EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // NE
          return NE;
        case 2: // SW
          return SW;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final String _fieldName;

    _Fields(short thriftId, String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments

  public static final Map<_Fields, FieldMetaData> metaDataMap;
  static {
    Map<_Fields, FieldMetaData> tmpMap = new EnumMap<_Fields, FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.NE, new FieldMetaData("ne", TFieldRequirementType.DEFAULT, 
        new StructMetaData(TType.STRUCT, GeocodePoint.class)));
    tmpMap.put(_Fields.SW, new FieldMetaData("sw", TFieldRequirementType.DEFAULT, 
        new StructMetaData(TType.STRUCT, GeocodePoint.class)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    FieldMetaData.addStructMetaDataMap(GeocodeBoundingBox.class, metaDataMap);
  }

  public GeocodeBoundingBox() {
  }

  public GeocodeBoundingBox(
    GeocodePoint ne,
    GeocodePoint sw)
  {
    this();
    this.ne = ne;
    this.sw = sw;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public GeocodeBoundingBox(GeocodeBoundingBox other) {
    if (other.isSetNe()) {
      this.ne = new GeocodePoint(other.ne);
    }
    if (other.isSetSw()) {
      this.sw = new GeocodePoint(other.sw);
    }
  }

  public GeocodeBoundingBox deepCopy() {
    return new GeocodeBoundingBox(this);
  }

  @Override
  public void clear() {
    this.ne = null;
    this.sw = null;
  }

  public GeocodePoint getNe() {
    return this.ne;
  }

  public GeocodeBoundingBox setNe(GeocodePoint ne) {
    this.ne = ne;
    return this;
  }

  public void unsetNe() {
    this.ne = null;
  }

  /** Returns true if field ne is set (has been asigned a value) and false otherwise */
  public boolean isSetNe() {
    return this.ne != null;
  }

  public void setNeIsSet(boolean value) {
    if (!value) {
      this.ne = null;
    }
  }

  public GeocodePoint getSw() {
    return this.sw;
  }

  public GeocodeBoundingBox setSw(GeocodePoint sw) {
    this.sw = sw;
    return this;
  }

  public void unsetSw() {
    this.sw = null;
  }

  /** Returns true if field sw is set (has been asigned a value) and false otherwise */
  public boolean isSetSw() {
    return this.sw != null;
  }

  public void setSwIsSet(boolean value) {
    if (!value) {
      this.sw = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case NE:
      if (value == null) {
        unsetNe();
      } else {
        setNe((GeocodePoint)value);
      }
      break;

    case SW:
      if (value == null) {
        unsetSw();
      } else {
        setSw((GeocodePoint)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case NE:
      return getNe();

    case SW:
      return getSw();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been asigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case NE:
      return isSetNe();
    case SW:
      return isSetSw();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof GeocodeBoundingBox)
      return this.equals((GeocodeBoundingBox)that);
    return false;
  }

  public boolean equals(GeocodeBoundingBox that) {
    if (that == null)
      return false;

    boolean this_present_ne = true && this.isSetNe();
    boolean that_present_ne = true && that.isSetNe();
    if (this_present_ne || that_present_ne) {
      if (!(this_present_ne && that_present_ne))
        return false;
      if (!this.ne.equals(that.ne))
        return false;
    }

    boolean this_present_sw = true && this.isSetSw();
    boolean that_present_sw = true && that.isSetSw();
    if (this_present_sw || that_present_sw) {
      if (!(this_present_sw && that_present_sw))
        return false;
      if (!this.sw.equals(that.sw))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  public int compareTo(GeocodeBoundingBox other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;
    GeocodeBoundingBox typedOther = (GeocodeBoundingBox)other;

    lastComparison = Boolean.valueOf(isSetNe()).compareTo(typedOther.isSetNe());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetNe()) {
      lastComparison = TBaseHelper.compareTo(this.ne, typedOther.ne);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetSw()).compareTo(typedOther.isSetSw());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetSw()) {
      lastComparison = TBaseHelper.compareTo(this.sw, typedOther.sw);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(TProtocol iprot) throws TException {
    TField field;
    iprot.readStructBegin();
    while (true)
    {
      field = iprot.readFieldBegin();
      if (field.type == TType.STOP) { 
        break;
      }
      switch (field.id) {
        case 1: // NE
          if (field.type == TType.STRUCT) {
            this.ne = new GeocodePoint();
            this.ne.read(iprot);
          } else { 
            TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 2: // SW
          if (field.type == TType.STRUCT) {
            this.sw = new GeocodePoint();
            this.sw.read(iprot);
          } else { 
            TProtocolUtil.skip(iprot, field.type);
          }
          break;
        default:
          TProtocolUtil.skip(iprot, field.type);
      }
      iprot.readFieldEnd();
    }
    iprot.readStructEnd();

    // check for required fields of primitive type, which can't be checked in the validate method
    validate();
  }

  public void write(TProtocol oprot) throws TException {
    validate();

    oprot.writeStructBegin(STRUCT_DESC);
    if (this.ne != null) {
      oprot.writeFieldBegin(NE_FIELD_DESC);
      this.ne.write(oprot);
      oprot.writeFieldEnd();
    }
    if (this.sw != null) {
      oprot.writeFieldBegin(SW_FIELD_DESC);
      this.sw.write(oprot);
      oprot.writeFieldEnd();
    }
    oprot.writeFieldStop();
    oprot.writeStructEnd();
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("GeocodeBoundingBox(");
    boolean first = true;

    sb.append("ne:");
    if (this.ne == null) {
      sb.append("null");
    } else {
      sb.append(this.ne);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("sw:");
    if (this.sw == null) {
      sb.append("null");
    } else {
      sb.append(this.sw);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws TException {
    // check for required fields
  }

}

