package com.tiwari.studence.common.service.v2.helper;

import com.tiwari.studence.proto.entity.EntityProtoPb;
import com.tiwari.studence.proto.entity.RequestIdPb;
import com.tiwari.studence.util.common.Strings;
import com.tiwari.studence.util.exception.Preconditions;

import javax.inject.Singleton;

@Singleton
public class RequestIdHelper {
  public boolean hasRequestId(String requestId, EntityProtoPb entityProto) {
    return (getRequestIdPb(requestId, entityProto) != null);
  }

  public boolean hasRequestId(String requestId, int version, EntityProtoPb entityProto) {
    RequestIdPb requestIdPb = getRequestIdPb(requestId, entityProto);
    return requestIdPb != null && (requestIdPb.getVersion() == version);
  }

  private RequestIdPb getRequestIdPb(String requestId, EntityProtoPb entityProto) {
    for (int i = 0; i < entityProto.getRequestIdsCount(); ++i) {
      RequestIdPb pbRequestId = entityProto.getRequestIds(i);
      if (pbRequestId.getRequestId().equals(requestId)) {
        return pbRequestId;
      }
    }
    return null;
  }

  public EntityProtoPb addRequestId(String requestId, EntityProtoPb entityProto) {
    Preconditions.check(!Strings.isEmpty(requestId));
    EntityProtoPb.Builder entityUpdater = EntityProtoPb.newBuilder(entityProto);
    RequestIdPb.Builder requestIdBuilder = entityUpdater.addRequestIdsBuilder();
    requestIdBuilder.setRequestId(requestId);
    requestIdBuilder.setVersion(entityProto.getVersion() + 1);
    return entityUpdater.build();
  }
}
