package com.tiwari.studence.common.util;

import com.google.protobuf.Descriptors;
import com.google.protobuf.GeneratedMessageV3;
import com.tiwari.studence.proto.entity.ChangeTrackUiPb;
import com.tiwari.studence.proto.match.MetaInfoUiPb;
import com.tiwari.studence.util.exception.ErrorException;

import javax.inject.Singleton;
import java.util.List;

@Singleton
public class GNormalizedProto {

  public Boolean isDefaultProto(GeneratedMessageV3 proto) {
    proto = getNormalizedProto(proto, true);
    for (Descriptors.FieldDescriptor fd : proto.getDescriptorForType().getFields()) {
      if (fd.isOptional() || fd.isRequired()) {
        if (!proto.hasField(fd)) {
          continue;
        }
        if (fd.getType() == Descriptors.FieldDescriptor.Type.MESSAGE) {
          boolean isDefault = isDefaultProto((GeneratedMessageV3) proto.getField(fd));
          if (!isDefault) {
            return false;
          }
        } else {
          if (!fd.getDefaultValue().equals(proto.getField(fd))) {
            return false;
          }
        }
      } else if (fd.isRepeated()) {
        int repeatedLength = proto.getRepeatedFieldCount(fd);
        if (repeatedLength > 0) {
          return false;
        }
      }

    }
    return true;
  }

  public Boolean isEqualProtos(GeneratedMessageV3 proto1, GeneratedMessageV3 proto2) {
    GeneratedMessageV3 message1 = getNormalizedProto(proto1, true);
    GeneratedMessageV3 message2 = getNormalizedProto(proto2, true);
    return message1.equals(message2);
  }

  @Deprecated
  public Boolean isEqualProtosWithoutMetaInfo(GeneratedMessageV3 proto1, GeneratedMessageV3 proto2) {
    return isEqualProtos(proto1, proto2);
  }

  public GeneratedMessageV3 getNormalizedProto(GeneratedMessageV3 proto) throws ErrorException {
    return getNormalizedProto(proto, false);
  }
  public GeneratedMessageV3 getNormalizedProtoWithClearMetaInfo(GeneratedMessageV3 proto,boolean removedMetaInfo) throws ErrorException {
    return getNormalizedProto(proto, removedMetaInfo);
  }

  private GeneratedMessageV3 getNormalizedProto(GeneratedMessageV3 proto, boolean clearMetaInfo) {
    GeneratedMessageV3.Builder builder = (GeneratedMessageV3.Builder) proto.toBuilder();
    for (Descriptors.FieldDescriptor fd : proto.getDescriptorForType().getFields()) {
      if (fd.isOptional() || fd.isRequired()) {
        if (!proto.hasField(fd)) {
          continue;
        }
        if (fd.getType() == Descriptors.FieldDescriptor.Type.MESSAGE) {
          if (isDefaultProto((GeneratedMessageV3) proto.getField(fd))) {
            builder.clearField(fd);
          } else {
            builder.setField(fd,
                    getNormalizedProto((GeneratedMessageV3) proto.getField(fd), clearMetaInfo));
          }
        } else {
          if (fd.getDefaultValue().equals(proto.getField(fd))) {
            builder.clearField(fd);
          }
        }
      } else {
        if (fd.getType() == Descriptors.FieldDescriptor.Type.MESSAGE) {
          builder.clearField(fd);
          for (GeneratedMessageV3 message : (List<GeneratedMessageV3>) proto.getField(fd)) {
            builder.addRepeatedField(fd, getNormalizedProto(message, clearMetaInfo));
          }
        }
      }

    }
    if (clearMetaInfo) {
      Descriptors.FieldDescriptor changeTrack = proto.getDescriptorForType().findFieldByNumber(4);
      if(changeTrack != null&&  proto.getField(changeTrack) instanceof ChangeTrackUiPb){
        builder.clearField(changeTrack);

      }
      Descriptors.FieldDescriptor descriptor = proto.getDescriptorForType().findFieldByNumber(13);
      if (descriptor != null&&  proto.getField(descriptor) instanceof MetaInfoUiPb) {
        builder.clearField(descriptor);
      }

    }
    return (GeneratedMessageV3) builder.build();
  }
}
