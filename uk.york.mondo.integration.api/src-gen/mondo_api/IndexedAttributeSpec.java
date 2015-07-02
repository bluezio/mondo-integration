/**
 * Autogenerated by Thrift Compiler (0.9.2)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package mondo_api;

import org.apache.thrift.scheme.IScheme;
import org.apache.thrift.scheme.SchemeFactory;
import org.apache.thrift.scheme.StandardScheme;

import org.apache.thrift.scheme.TupleScheme;
import org.apache.thrift.protocol.TTupleProtocol;
import org.apache.thrift.protocol.TProtocolException;
import org.apache.thrift.EncodingUtils;
import org.apache.thrift.TException;
import org.apache.thrift.async.AsyncMethodCallback;
import org.apache.thrift.server.AbstractNonblockingServer.*;
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
import javax.annotation.Generated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked"})
@Generated(value = "Autogenerated by Thrift Compiler (0.9.2)", date = "2015-7-2")
public class IndexedAttributeSpec implements org.apache.thrift.TBase<IndexedAttributeSpec, IndexedAttributeSpec._Fields>, java.io.Serializable, Cloneable, Comparable<IndexedAttributeSpec> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("IndexedAttributeSpec");

  private static final org.apache.thrift.protocol.TField METAMODEL_URI_FIELD_DESC = new org.apache.thrift.protocol.TField("metamodelUri", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField TYPENAME_FIELD_DESC = new org.apache.thrift.protocol.TField("typename", org.apache.thrift.protocol.TType.STRING, (short)2);
  private static final org.apache.thrift.protocol.TField ATTRIBUTENAME_FIELD_DESC = new org.apache.thrift.protocol.TField("attributename", org.apache.thrift.protocol.TType.STRING, (short)3);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new IndexedAttributeSpecStandardSchemeFactory());
    schemes.put(TupleScheme.class, new IndexedAttributeSpecTupleSchemeFactory());
  }

  public String metamodelUri; // required
  public String typename; // required
  public String attributename; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    METAMODEL_URI((short)1, "metamodelUri"),
    TYPENAME((short)2, "typename"),
    ATTRIBUTENAME((short)3, "attributename");

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
        case 1: // METAMODEL_URI
          return METAMODEL_URI;
        case 2: // TYPENAME
          return TYPENAME;
        case 3: // ATTRIBUTENAME
          return ATTRIBUTENAME;
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
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.METAMODEL_URI, new org.apache.thrift.meta_data.FieldMetaData("metamodelUri", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.TYPENAME, new org.apache.thrift.meta_data.FieldMetaData("typename", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.ATTRIBUTENAME, new org.apache.thrift.meta_data.FieldMetaData("attributename", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(IndexedAttributeSpec.class, metaDataMap);
  }

  public IndexedAttributeSpec() {
  }

  public IndexedAttributeSpec(
    String metamodelUri,
    String typename,
    String attributename)
  {
    this();
    this.metamodelUri = metamodelUri;
    this.typename = typename;
    this.attributename = attributename;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public IndexedAttributeSpec(IndexedAttributeSpec other) {
    if (other.isSetMetamodelUri()) {
      this.metamodelUri = other.metamodelUri;
    }
    if (other.isSetTypename()) {
      this.typename = other.typename;
    }
    if (other.isSetAttributename()) {
      this.attributename = other.attributename;
    }
  }

  public IndexedAttributeSpec deepCopy() {
    return new IndexedAttributeSpec(this);
  }

  @Override
  public void clear() {
    this.metamodelUri = null;
    this.typename = null;
    this.attributename = null;
  }

  public String getMetamodelUri() {
    return this.metamodelUri;
  }

  public IndexedAttributeSpec setMetamodelUri(String metamodelUri) {
    this.metamodelUri = metamodelUri;
    return this;
  }

  public void unsetMetamodelUri() {
    this.metamodelUri = null;
  }

  /** Returns true if field metamodelUri is set (has been assigned a value) and false otherwise */
  public boolean isSetMetamodelUri() {
    return this.metamodelUri != null;
  }

  public void setMetamodelUriIsSet(boolean value) {
    if (!value) {
      this.metamodelUri = null;
    }
  }

  public String getTypename() {
    return this.typename;
  }

  public IndexedAttributeSpec setTypename(String typename) {
    this.typename = typename;
    return this;
  }

  public void unsetTypename() {
    this.typename = null;
  }

  /** Returns true if field typename is set (has been assigned a value) and false otherwise */
  public boolean isSetTypename() {
    return this.typename != null;
  }

  public void setTypenameIsSet(boolean value) {
    if (!value) {
      this.typename = null;
    }
  }

  public String getAttributename() {
    return this.attributename;
  }

  public IndexedAttributeSpec setAttributename(String attributename) {
    this.attributename = attributename;
    return this;
  }

  public void unsetAttributename() {
    this.attributename = null;
  }

  /** Returns true if field attributename is set (has been assigned a value) and false otherwise */
  public boolean isSetAttributename() {
    return this.attributename != null;
  }

  public void setAttributenameIsSet(boolean value) {
    if (!value) {
      this.attributename = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case METAMODEL_URI:
      if (value == null) {
        unsetMetamodelUri();
      } else {
        setMetamodelUri((String)value);
      }
      break;

    case TYPENAME:
      if (value == null) {
        unsetTypename();
      } else {
        setTypename((String)value);
      }
      break;

    case ATTRIBUTENAME:
      if (value == null) {
        unsetAttributename();
      } else {
        setAttributename((String)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case METAMODEL_URI:
      return getMetamodelUri();

    case TYPENAME:
      return getTypename();

    case ATTRIBUTENAME:
      return getAttributename();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case METAMODEL_URI:
      return isSetMetamodelUri();
    case TYPENAME:
      return isSetTypename();
    case ATTRIBUTENAME:
      return isSetAttributename();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof IndexedAttributeSpec)
      return this.equals((IndexedAttributeSpec)that);
    return false;
  }

  public boolean equals(IndexedAttributeSpec that) {
    if (that == null)
      return false;

    boolean this_present_metamodelUri = true && this.isSetMetamodelUri();
    boolean that_present_metamodelUri = true && that.isSetMetamodelUri();
    if (this_present_metamodelUri || that_present_metamodelUri) {
      if (!(this_present_metamodelUri && that_present_metamodelUri))
        return false;
      if (!this.metamodelUri.equals(that.metamodelUri))
        return false;
    }

    boolean this_present_typename = true && this.isSetTypename();
    boolean that_present_typename = true && that.isSetTypename();
    if (this_present_typename || that_present_typename) {
      if (!(this_present_typename && that_present_typename))
        return false;
      if (!this.typename.equals(that.typename))
        return false;
    }

    boolean this_present_attributename = true && this.isSetAttributename();
    boolean that_present_attributename = true && that.isSetAttributename();
    if (this_present_attributename || that_present_attributename) {
      if (!(this_present_attributename && that_present_attributename))
        return false;
      if (!this.attributename.equals(that.attributename))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    List<Object> list = new ArrayList<Object>();

    boolean present_metamodelUri = true && (isSetMetamodelUri());
    list.add(present_metamodelUri);
    if (present_metamodelUri)
      list.add(metamodelUri);

    boolean present_typename = true && (isSetTypename());
    list.add(present_typename);
    if (present_typename)
      list.add(typename);

    boolean present_attributename = true && (isSetAttributename());
    list.add(present_attributename);
    if (present_attributename)
      list.add(attributename);

    return list.hashCode();
  }

  @Override
  public int compareTo(IndexedAttributeSpec other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetMetamodelUri()).compareTo(other.isSetMetamodelUri());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetMetamodelUri()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.metamodelUri, other.metamodelUri);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetTypename()).compareTo(other.isSetTypename());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetTypename()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.typename, other.typename);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetAttributename()).compareTo(other.isSetAttributename());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetAttributename()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.attributename, other.attributename);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("IndexedAttributeSpec(");
    boolean first = true;

    sb.append("metamodelUri:");
    if (this.metamodelUri == null) {
      sb.append("null");
    } else {
      sb.append(this.metamodelUri);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("typename:");
    if (this.typename == null) {
      sb.append("null");
    } else {
      sb.append(this.typename);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("attributename:");
    if (this.attributename == null) {
      sb.append("null");
    } else {
      sb.append(this.attributename);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    if (metamodelUri == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'metamodelUri' was not present! Struct: " + toString());
    }
    if (typename == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'typename' was not present! Struct: " + toString());
    }
    if (attributename == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'attributename' was not present! Struct: " + toString());
    }
    // check for sub-struct validity
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
    try {
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class IndexedAttributeSpecStandardSchemeFactory implements SchemeFactory {
    public IndexedAttributeSpecStandardScheme getScheme() {
      return new IndexedAttributeSpecStandardScheme();
    }
  }

  private static class IndexedAttributeSpecStandardScheme extends StandardScheme<IndexedAttributeSpec> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, IndexedAttributeSpec struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // METAMODEL_URI
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.metamodelUri = iprot.readString();
              struct.setMetamodelUriIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // TYPENAME
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.typename = iprot.readString();
              struct.setTypenameIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // ATTRIBUTENAME
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.attributename = iprot.readString();
              struct.setAttributenameIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, IndexedAttributeSpec struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.metamodelUri != null) {
        oprot.writeFieldBegin(METAMODEL_URI_FIELD_DESC);
        oprot.writeString(struct.metamodelUri);
        oprot.writeFieldEnd();
      }
      if (struct.typename != null) {
        oprot.writeFieldBegin(TYPENAME_FIELD_DESC);
        oprot.writeString(struct.typename);
        oprot.writeFieldEnd();
      }
      if (struct.attributename != null) {
        oprot.writeFieldBegin(ATTRIBUTENAME_FIELD_DESC);
        oprot.writeString(struct.attributename);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class IndexedAttributeSpecTupleSchemeFactory implements SchemeFactory {
    public IndexedAttributeSpecTupleScheme getScheme() {
      return new IndexedAttributeSpecTupleScheme();
    }
  }

  private static class IndexedAttributeSpecTupleScheme extends TupleScheme<IndexedAttributeSpec> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, IndexedAttributeSpec struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      oprot.writeString(struct.metamodelUri);
      oprot.writeString(struct.typename);
      oprot.writeString(struct.attributename);
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, IndexedAttributeSpec struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      struct.metamodelUri = iprot.readString();
      struct.setMetamodelUriIsSet(true);
      struct.typename = iprot.readString();
      struct.setTypenameIsSet(true);
      struct.attributename = iprot.readString();
      struct.setAttributenameIsSet(true);
    }
  }

}

