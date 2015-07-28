/**
 * Autogenerated by Thrift Compiler (0.9.2)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package uk.ac.york.mondo.integration.api;


import java.util.Map;
import java.util.HashMap;
import org.apache.thrift.TEnum;

public enum ModelElementChangeType implements org.apache.thrift.TEnum {
  ADDED(0),
  REMOVED(1),
  UPDATED(2);

  private final int value;

  private ModelElementChangeType(int value) {
    this.value = value;
  }

  /**
   * Get the integer value of this enum value, as defined in the Thrift IDL.
   */
  public int getValue() {
    return value;
  }

  /**
   * Find a the enum type by its integer value, as defined in the Thrift IDL.
   * @return null if the value is not found.
   */
  public static ModelElementChangeType findByValue(int value) { 
    switch (value) {
      case 0:
        return ADDED;
      case 1:
        return REMOVED;
      case 2:
        return UPDATED;
      default:
        return null;
    }
  }
}
