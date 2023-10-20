package com.tiwari.studence.util.entity;

import com.tiwari.studence.proto.entity.EntityPb;
import com.tiwari.studence.proto.entity.LifeTimeEnum;
import com.tiwari.studence.proto.time.TimePb;
import com.tiwari.studence.proto.time.TimezoneEnum;
import com.tiwari.studence.util.Strings;
import com.tiwari.studence.util.StudenceSpecialCharecterEnum;
import com.tiwari.studence.util.collect.Pair;
import com.tiwari.studence.util.exception.Preconditions;
import com.tiwari.studence.util.time.TimeUtil;

public class EntityUtilHelper {

  public static String getDbInfoIdWithSpecialCharecter(String hash, String range) {

    return hash + StudenceSpecialCharecterEnum.EXCLAMATION.getSign() + range;
  }

  public static String getDbInfoIdWithSpecialCharecterUsingEntityPb(EntityPb entity) {

    return entity.getHashId() + StudenceSpecialCharecterEnum.EXCLAMATION.getSign() + entity.getRangeId();
  }

  public static Pair<String, String> getHashandRangeKey(String dbInfoId) {
    Preconditions.check(dbInfoId.contains(StudenceSpecialCharecterEnum.EXCLAMATION.getSign()),
            "Id is not valid");
    String[] id_split = dbInfoId.split(StudenceSpecialCharecterEnum.EXCLAMATION.getSign());
    return new Pair<String, String>(id_split[0], id_split[1]);
  }

  public static EntityPb.Builder getCreateEntity(EntityPb.Builder entity,
          Pair<Integer, String> new_id) {
    entity.clear();
    entity.setHashId(new_id.getSecond());
    entity.setRangeId(String.valueOf(new_id.getFirst()));
    entity.setLifetime(LifeTimeEnum.ACTIVE);
    entity.getConfigBuilder().setVersion(1);
    if (entity.getTimezone() == TimezoneEnum.UNKNOWN_TIMEZONE) {
      entity.setTimezone(TimezoneEnum.ASIA_KOLKATA);
    } else {
      //entity.setTimezone()
    }
    TimePb timePb = TimeUtil.getCurrentTime(entity.getTimezone());
    entity.getConfigBuilder().setCreatedAt(timePb);
    entity.getConfigBuilder().setUpdatedAt(timePb);
    entity.getConfigBuilder().setUpdatedBy("system");
    return entity;

  }

  public static EntityPb updateEntityWithVersion(EntityPb field) {
    EntityPb.Builder pb = EntityPb.newBuilder(field);
    pb.getConfigBuilder().setVersion(pb.getConfig().getVersion() + 1);
    pb.getConfigBuilder().setUpdatedAt(TimeUtil.getCurrentTime(pb.getTimezone()));
    pb.getConfigBuilder().setUpdatedBy("system");
    return pb.build();
  }

  public static EntityPb deleteEntity(EntityPb field) {
    EntityPb.Builder pb = EntityPb.newBuilder(field);
    pb.setLifetime(LifeTimeEnum.DELETED);
    pb.getConfigBuilder().setVersion(pb.getConfig().getVersion() + 1);
    pb.getConfigBuilder().setUpdatedAt(TimeUtil.getCurrentTime(pb.getTimezone()));
    pb.getConfigBuilder().setUpdatedBy("system");
    return pb.build();
  }

  public static boolean isDbEntityEmpty(EntityPb dbInfo) {
    if (Strings.notEmpty(dbInfo.getHashId()) && Strings.notEmpty(dbInfo.getRangeId())) {
      return false;
    } else {
      return true;
    }
  }

  public static boolean isDbEntityNotEmpty(EntityPb dbInfo) {
   return !isDbEntityEmpty(dbInfo);
  }
}
