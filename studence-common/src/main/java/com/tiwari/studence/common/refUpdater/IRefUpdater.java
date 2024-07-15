package com.tiwari.studence.common.refUpdater;

import com.google.protobuf.GeneratedMessageV3;
import com.tiwari.studence.common.refConvertor.IRefConvetor;
import com.tiwari.studence.common.services.interfaces.IEntityService;
import com.tiwari.studence.util.collect.Quadlets;

import java.util.List;

public interface IRefUpdater {
  abstract void refUpdater(
          List<Quadlets<IEntityService, IRefConvetor, GeneratedMessageV3.Builder, String>> reflist);
}
