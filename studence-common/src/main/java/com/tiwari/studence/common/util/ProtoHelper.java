package com.tiwari.studence.common.util;

import com.google.protobuf.Descriptors;
import com.google.protobuf.GeneratedMessageV3;
import com.tiwari.studence.util.exception.Preconditions;

import javax.inject.Singleton;

@Singleton
public class ProtoHelper {

  public <V> V getFieldByNumber(GeneratedMessageV3 pb, int number) {
    Descriptors.FieldDescriptor descriptor = pb.getDescriptorForType()
            .findFieldByNumber(number);
    if (descriptor == null) {
      return null;
    }
    Object value = pb.getField(descriptor);
    if (!(value instanceof Descriptors.EnumValueDescriptor)) {
      return (V) value;
    }
    return (V) (Integer) ((Descriptors.EnumValueDescriptor) value).getNumber();
  }

  public <V> V setFieldByNumber(GeneratedMessageV3 pb, int number,
          GeneratedMessageV3 toSet) {
    Descriptors.FieldDescriptor descriptor = pb.getDescriptorForType()
            .findFieldByNumber(number);
    Preconditions.check(descriptor != null);
    return (V) pb.toBuilder().setField(descriptor, toSet).build();
  }
}
