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
public class ModelElement implements org.apache.thrift.TBase<ModelElement, ModelElement._Fields>, java.io.Serializable, Cloneable, Comparable<ModelElement> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("ModelElement");

  private static final org.apache.thrift.protocol.TField ID_FIELD_DESC = new org.apache.thrift.protocol.TField("id", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField METAMODEL_URI_FIELD_DESC = new org.apache.thrift.protocol.TField("metamodelUri", org.apache.thrift.protocol.TType.STRING, (short)2);
  private static final org.apache.thrift.protocol.TField TYPE_NAME_FIELD_DESC = new org.apache.thrift.protocol.TField("typeName", org.apache.thrift.protocol.TType.STRING, (short)3);
  private static final org.apache.thrift.protocol.TField IS_PROXY_FIELD_DESC = new org.apache.thrift.protocol.TField("isProxy", org.apache.thrift.protocol.TType.BOOL, (short)4);
  private static final org.apache.thrift.protocol.TField SLOTS_FIELD_DESC = new org.apache.thrift.protocol.TField("slots", org.apache.thrift.protocol.TType.LIST, (short)5);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new ModelElementStandardSchemeFactory());
    schemes.put(TupleScheme.class, new ModelElementTupleSchemeFactory());
  }

  public String id; // required
  public String metamodelUri; // required
  public String typeName; // required
  public boolean isProxy; // required
  public List<Slot> slots; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    ID((short)1, "id"),
    METAMODEL_URI((short)2, "metamodelUri"),
    TYPE_NAME((short)3, "typeName"),
    IS_PROXY((short)4, "isProxy"),
    SLOTS((short)5, "slots");

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
        case 1: // ID
          return ID;
        case 2: // METAMODEL_URI
          return METAMODEL_URI;
        case 3: // TYPE_NAME
          return TYPE_NAME;
        case 4: // IS_PROXY
          return IS_PROXY;
        case 5: // SLOTS
          return SLOTS;
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
  private static final int __ISPROXY_ISSET_ID = 0;
  private byte __isset_bitfield = 0;
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.ID, new org.apache.thrift.meta_data.FieldMetaData("id", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.METAMODEL_URI, new org.apache.thrift.meta_data.FieldMetaData("metamodelUri", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.TYPE_NAME, new org.apache.thrift.meta_data.FieldMetaData("typeName", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.IS_PROXY, new org.apache.thrift.meta_data.FieldMetaData("isProxy", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.BOOL)));
    tmpMap.put(_Fields.SLOTS, new org.apache.thrift.meta_data.FieldMetaData("slots", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, Slot.class))));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(ModelElement.class, metaDataMap);
  }

  public ModelElement() {
  }

  public ModelElement(
    String id,
    String metamodelUri,
    String typeName,
    boolean isProxy,
    List<Slot> slots)
  {
    this();
    this.id = id;
    this.metamodelUri = metamodelUri;
    this.typeName = typeName;
    this.isProxy = isProxy;
    setIsProxyIsSet(true);
    this.slots = slots;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public ModelElement(ModelElement other) {
    __isset_bitfield = other.__isset_bitfield;
    if (other.isSetId()) {
      this.id = other.id;
    }
    if (other.isSetMetamodelUri()) {
      this.metamodelUri = other.metamodelUri;
    }
    if (other.isSetTypeName()) {
      this.typeName = other.typeName;
    }
    this.isProxy = other.isProxy;
    if (other.isSetSlots()) {
      List<Slot> __this__slots = new ArrayList<Slot>(other.slots.size());
      for (Slot other_element : other.slots) {
        __this__slots.add(new Slot(other_element));
      }
      this.slots = __this__slots;
    }
  }

  public ModelElement deepCopy() {
    return new ModelElement(this);
  }

  @Override
  public void clear() {
    this.id = null;
    this.metamodelUri = null;
    this.typeName = null;
    setIsProxyIsSet(false);
    this.isProxy = false;
    this.slots = null;
  }

  public String getId() {
    return this.id;
  }

  public ModelElement setId(String id) {
    this.id = id;
    return this;
  }

  public void unsetId() {
    this.id = null;
  }

  /** Returns true if field id is set (has been assigned a value) and false otherwise */
  public boolean isSetId() {
    return this.id != null;
  }

  public void setIdIsSet(boolean value) {
    if (!value) {
      this.id = null;
    }
  }

  public String getMetamodelUri() {
    return this.metamodelUri;
  }

  public ModelElement setMetamodelUri(String metamodelUri) {
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

  public String getTypeName() {
    return this.typeName;
  }

  public ModelElement setTypeName(String typeName) {
    this.typeName = typeName;
    return this;
  }

  public void unsetTypeName() {
    this.typeName = null;
  }

  /** Returns true if field typeName is set (has been assigned a value) and false otherwise */
  public boolean isSetTypeName() {
    return this.typeName != null;
  }

  public void setTypeNameIsSet(boolean value) {
    if (!value) {
      this.typeName = null;
    }
  }

  public boolean isIsProxy() {
    return this.isProxy;
  }

  public ModelElement setIsProxy(boolean isProxy) {
    this.isProxy = isProxy;
    setIsProxyIsSet(true);
    return this;
  }

  public void unsetIsProxy() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __ISPROXY_ISSET_ID);
  }

  /** Returns true if field isProxy is set (has been assigned a value) and false otherwise */
  public boolean isSetIsProxy() {
    return EncodingUtils.testBit(__isset_bitfield, __ISPROXY_ISSET_ID);
  }

  public void setIsProxyIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __ISPROXY_ISSET_ID, value);
  }

  public int getSlotsSize() {
    return (this.slots == null) ? 0 : this.slots.size();
  }

  public java.util.Iterator<Slot> getSlotsIterator() {
    return (this.slots == null) ? null : this.slots.iterator();
  }

  public void addToSlots(Slot elem) {
    if (this.slots == null) {
      this.slots = new ArrayList<Slot>();
    }
    this.slots.add(elem);
  }

  public List<Slot> getSlots() {
    return this.slots;
  }

  public ModelElement setSlots(List<Slot> slots) {
    this.slots = slots;
    return this;
  }

  public void unsetSlots() {
    this.slots = null;
  }

  /** Returns true if field slots is set (has been assigned a value) and false otherwise */
  public boolean isSetSlots() {
    return this.slots != null;
  }

  public void setSlotsIsSet(boolean value) {
    if (!value) {
      this.slots = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case ID:
      if (value == null) {
        unsetId();
      } else {
        setId((String)value);
      }
      break;

    case METAMODEL_URI:
      if (value == null) {
        unsetMetamodelUri();
      } else {
        setMetamodelUri((String)value);
      }
      break;

    case TYPE_NAME:
      if (value == null) {
        unsetTypeName();
      } else {
        setTypeName((String)value);
      }
      break;

    case IS_PROXY:
      if (value == null) {
        unsetIsProxy();
      } else {
        setIsProxy((Boolean)value);
      }
      break;

    case SLOTS:
      if (value == null) {
        unsetSlots();
      } else {
        setSlots((List<Slot>)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case ID:
      return getId();

    case METAMODEL_URI:
      return getMetamodelUri();

    case TYPE_NAME:
      return getTypeName();

    case IS_PROXY:
      return Boolean.valueOf(isIsProxy());

    case SLOTS:
      return getSlots();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case ID:
      return isSetId();
    case METAMODEL_URI:
      return isSetMetamodelUri();
    case TYPE_NAME:
      return isSetTypeName();
    case IS_PROXY:
      return isSetIsProxy();
    case SLOTS:
      return isSetSlots();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof ModelElement)
      return this.equals((ModelElement)that);
    return false;
  }

  public boolean equals(ModelElement that) {
    if (that == null)
      return false;

    boolean this_present_id = true && this.isSetId();
    boolean that_present_id = true && that.isSetId();
    if (this_present_id || that_present_id) {
      if (!(this_present_id && that_present_id))
        return false;
      if (!this.id.equals(that.id))
        return false;
    }

    boolean this_present_metamodelUri = true && this.isSetMetamodelUri();
    boolean that_present_metamodelUri = true && that.isSetMetamodelUri();
    if (this_present_metamodelUri || that_present_metamodelUri) {
      if (!(this_present_metamodelUri && that_present_metamodelUri))
        return false;
      if (!this.metamodelUri.equals(that.metamodelUri))
        return false;
    }

    boolean this_present_typeName = true && this.isSetTypeName();
    boolean that_present_typeName = true && that.isSetTypeName();
    if (this_present_typeName || that_present_typeName) {
      if (!(this_present_typeName && that_present_typeName))
        return false;
      if (!this.typeName.equals(that.typeName))
        return false;
    }

    boolean this_present_isProxy = true;
    boolean that_present_isProxy = true;
    if (this_present_isProxy || that_present_isProxy) {
      if (!(this_present_isProxy && that_present_isProxy))
        return false;
      if (this.isProxy != that.isProxy)
        return false;
    }

    boolean this_present_slots = true && this.isSetSlots();
    boolean that_present_slots = true && that.isSetSlots();
    if (this_present_slots || that_present_slots) {
      if (!(this_present_slots && that_present_slots))
        return false;
      if (!this.slots.equals(that.slots))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    List<Object> list = new ArrayList<Object>();

    boolean present_id = true && (isSetId());
    list.add(present_id);
    if (present_id)
      list.add(id);

    boolean present_metamodelUri = true && (isSetMetamodelUri());
    list.add(present_metamodelUri);
    if (present_metamodelUri)
      list.add(metamodelUri);

    boolean present_typeName = true && (isSetTypeName());
    list.add(present_typeName);
    if (present_typeName)
      list.add(typeName);

    boolean present_isProxy = true;
    list.add(present_isProxy);
    if (present_isProxy)
      list.add(isProxy);

    boolean present_slots = true && (isSetSlots());
    list.add(present_slots);
    if (present_slots)
      list.add(slots);

    return list.hashCode();
  }

  @Override
  public int compareTo(ModelElement other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetId()).compareTo(other.isSetId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetId()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.id, other.id);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
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
    lastComparison = Boolean.valueOf(isSetTypeName()).compareTo(other.isSetTypeName());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetTypeName()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.typeName, other.typeName);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetIsProxy()).compareTo(other.isSetIsProxy());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetIsProxy()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.isProxy, other.isProxy);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetSlots()).compareTo(other.isSetSlots());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetSlots()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.slots, other.slots);
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
    StringBuilder sb = new StringBuilder("ModelElement(");
    boolean first = true;

    sb.append("id:");
    if (this.id == null) {
      sb.append("null");
    } else {
      sb.append(this.id);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("metamodelUri:");
    if (this.metamodelUri == null) {
      sb.append("null");
    } else {
      sb.append(this.metamodelUri);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("typeName:");
    if (this.typeName == null) {
      sb.append("null");
    } else {
      sb.append(this.typeName);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("isProxy:");
    sb.append(this.isProxy);
    first = false;
    if (!first) sb.append(", ");
    sb.append("slots:");
    if (this.slots == null) {
      sb.append("null");
    } else {
      sb.append(this.slots);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    if (id == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'id' was not present! Struct: " + toString());
    }
    if (metamodelUri == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'metamodelUri' was not present! Struct: " + toString());
    }
    if (typeName == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'typeName' was not present! Struct: " + toString());
    }
    // alas, we cannot check 'isProxy' because it's a primitive and you chose the non-beans generator.
    if (slots == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'slots' was not present! Struct: " + toString());
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
      // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
      __isset_bitfield = 0;
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class ModelElementStandardSchemeFactory implements SchemeFactory {
    public ModelElementStandardScheme getScheme() {
      return new ModelElementStandardScheme();
    }
  }

  private static class ModelElementStandardScheme extends StandardScheme<ModelElement> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, ModelElement struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // ID
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.id = iprot.readString();
              struct.setIdIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // METAMODEL_URI
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.metamodelUri = iprot.readString();
              struct.setMetamodelUriIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // TYPE_NAME
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.typeName = iprot.readString();
              struct.setTypeNameIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // IS_PROXY
            if (schemeField.type == org.apache.thrift.protocol.TType.BOOL) {
              struct.isProxy = iprot.readBool();
              struct.setIsProxyIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 5: // SLOTS
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list24 = iprot.readListBegin();
                struct.slots = new ArrayList<Slot>(_list24.size);
                Slot _elem25;
                for (int _i26 = 0; _i26 < _list24.size; ++_i26)
                {
                  _elem25 = new Slot();
                  _elem25.read(iprot);
                  struct.slots.add(_elem25);
                }
                iprot.readListEnd();
              }
              struct.setSlotsIsSet(true);
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
      if (!struct.isSetIsProxy()) {
        throw new org.apache.thrift.protocol.TProtocolException("Required field 'isProxy' was not found in serialized data! Struct: " + toString());
      }
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, ModelElement struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.id != null) {
        oprot.writeFieldBegin(ID_FIELD_DESC);
        oprot.writeString(struct.id);
        oprot.writeFieldEnd();
      }
      if (struct.metamodelUri != null) {
        oprot.writeFieldBegin(METAMODEL_URI_FIELD_DESC);
        oprot.writeString(struct.metamodelUri);
        oprot.writeFieldEnd();
      }
      if (struct.typeName != null) {
        oprot.writeFieldBegin(TYPE_NAME_FIELD_DESC);
        oprot.writeString(struct.typeName);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldBegin(IS_PROXY_FIELD_DESC);
      oprot.writeBool(struct.isProxy);
      oprot.writeFieldEnd();
      if (struct.slots != null) {
        oprot.writeFieldBegin(SLOTS_FIELD_DESC);
        {
          oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, struct.slots.size()));
          for (Slot _iter27 : struct.slots)
          {
            _iter27.write(oprot);
          }
          oprot.writeListEnd();
        }
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class ModelElementTupleSchemeFactory implements SchemeFactory {
    public ModelElementTupleScheme getScheme() {
      return new ModelElementTupleScheme();
    }
  }

  private static class ModelElementTupleScheme extends TupleScheme<ModelElement> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, ModelElement struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      oprot.writeString(struct.id);
      oprot.writeString(struct.metamodelUri);
      oprot.writeString(struct.typeName);
      oprot.writeBool(struct.isProxy);
      {
        oprot.writeI32(struct.slots.size());
        for (Slot _iter28 : struct.slots)
        {
          _iter28.write(oprot);
        }
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, ModelElement struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      struct.id = iprot.readString();
      struct.setIdIsSet(true);
      struct.metamodelUri = iprot.readString();
      struct.setMetamodelUriIsSet(true);
      struct.typeName = iprot.readString();
      struct.setTypeNameIsSet(true);
      struct.isProxy = iprot.readBool();
      struct.setIsProxyIsSet(true);
      {
        org.apache.thrift.protocol.TList _list29 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, iprot.readI32());
        struct.slots = new ArrayList<Slot>(_list29.size);
        Slot _elem30;
        for (int _i31 = 0; _i31 < _list29.size; ++_i31)
        {
          _elem30 = new Slot();
          _elem30.read(iprot);
          struct.slots.add(_elem30);
        }
      }
      struct.setSlotsIsSet(true);
    }
  }

}

