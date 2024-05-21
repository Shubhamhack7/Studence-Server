package com.tiwari.studence.common.service.v2.store;

import com.tiwari.studence.common.service.v2.interfaces.IEntityProtoWrapper;
import com.tiwari.studence.common.service.v2.interfaces.IIdEntityStore;
import com.tiwari.studence.common.service.v2.interfaces.IPbTableStore;
import com.tiwari.studence.common.service.v2.listener.TableUpdateListenerNotifier;
import com.tiwari.studence.common.service.v2.listener.VoidTableUpdateListener;
import com.tiwari.studence.common.service.v2.manager.EntityStoreManager;
import com.tiwari.studence.proto.id.IdProtoPb;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class IdEntityStore<IdStore extends IPbTableStore<IdProtoPb>>
        extends
        BaseEntityStore<IdProtoPb, IdStore, IIdEntityStore, VoidTableUpdateListener<IdProtoPb>>
        implements IIdEntityStore {

  @Inject
  public IdEntityStore(EntityStoreManager<IdProtoPb, IdStore> entityStoreManager,
          IEntityProtoWrapper<IdProtoPb> entityWrapper, TableUpdateListenerNotifier notifier) {
    super(entityStoreManager, null, entityWrapper, null, notifier);
  }

  @Override
  public String getIdRowDbId() {
    return "A";
  }
}
