package com.tiwari.studence.common.refUpdater;

import com.google.protobuf.GeneratedMessageV3;
import com.tiwari.studence.common.controlflow.CreateTableCF;
import com.tiwari.studence.common.refConvertor.IRefConvetor;
import com.tiwari.studence.common.services.interfaces.IEntityService;
import com.tiwari.studence.util.collect.Pair;
import com.tiwari.studence.util.collect.Quadlets;
import com.tiwari.studence.util.collect.Triplets;

import javax.inject.Inject;
import java.util.Arrays;
import java.util.List;

public abstract class AEntityRefUpdator implements IRefUpdater {

  @Inject
  public AEntityRefUpdator() {
  }

  @Override
  public void refUpdater(
          List<Quadlets<IEntityService, IRefConvetor, GeneratedMessageV3.Builder, String>> reflist) {
    reflist.forEach(ref -> {
      RefUpdaterCF cf = new RefUpdaterCF(ref.getFirstValue(), ref.getMiddleValue(),
              ref.getSecondLastValue(), ref.getLastValue());
      cf.addLogObjects(ref.getFirstValue());
      cf.addLogObjects(ref.getSecondLastValue());
      cf.addLogObjects(ref.getSecondLastValue());
      cf.addLogObjects(ref.getLastValue());
      cf.startAsyncCall();
    });
  }
}
