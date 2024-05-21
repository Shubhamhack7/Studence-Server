package com.tiwari.studence.common.service.v2.store;

import com.google.protobuf.GeneratedMessageV3;
import com.tiwari.studence.common.service.v2.idGenerator.IdGenerator;
import com.tiwari.studence.common.service.v2.interfaces.IEntityProtoWrapper;
import com.tiwari.studence.common.service.v2.interfaces.IIdEntityStore;
import com.tiwari.studence.common.service.v2.interfaces.IPbTableStore;
import com.tiwari.studence.common.service.v2.interfaces.ITableUpdateListener;
import com.tiwari.studence.common.service.v2.listener.TableUpdateListenerNotifier;
import com.tiwari.studence.common.service.v2.manager.EntityStoreManager;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class BaseEntityStore<Pb extends GeneratedMessageV3, Store extends IPbTableStore<Pb>, IdStore extends IIdEntityStore, Ul extends ITableUpdateListener<Pb>>
        extends BaseEntityStoreWithExternalIdChecker<Pb, Store, IdStore, Ul> {
  @Inject
  public BaseEntityStore(EntityStoreManager<Pb, Store> entityStoreManager,
          IdGenerator<IdStore> idGenerator, IEntityProtoWrapper<Pb> entityWrapper,
          Ul tableUpdateListener, TableUpdateListenerNotifier notifier) {
    super(entityStoreManager, idGenerator, entityWrapper, null, null, tableUpdateListener,
            notifier);
  }
}
