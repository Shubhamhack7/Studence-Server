package com.tiwari.studence.organisation.store;

import com.tiwari.studence.common.service.v2.idGenerator.IdGenerator;
import com.tiwari.studence.common.service.v2.interfaces.IEntityProtoWrapper;
import com.tiwari.studence.common.service.v2.listener.TableUpdateListenerNotifier;
import com.tiwari.studence.common.service.v2.manager.EntityStoreManager;
import com.tiwari.studence.common.service.v2.store.BaseEntityStore;
import com.tiwari.studence.common.service.v2.store.DynamoDbPbTableStore;
import com.tiwari.studence.common.service.v2.store.IdEntityStore;
import com.tiwari.studence.common.service.v2.table.EmptyTablePartitioner;
import com.tiwari.studence.common.util.EntityTables;
import com.tiwari.studence.organisation.entity.OraganisationEntity;
import com.tiwari.studence.organisation.listener.OrganisationTableUpdateListener;
import com.tiwari.studence.proto.id.IdProtoPb;
import com.tiwari.studence.proto.organisation.OrganisationPb;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class OrganisationEntityStore extends
        BaseEntityStore<OrganisationPb, DynamoDbPbTableStore<EntityTables<OraganisationEntity>, EmptyTablePartitioner, OrganisationPb, OrganisationPb.Builder>, IdEntityStore<DynamoDbPbTableStore<EntityTables<OraganisationEntity>,EmptyTablePartitioner, IdProtoPb, IdProtoPb.Builder>>, OrganisationTableUpdateListener> {

  @Inject
  public OrganisationEntityStore(
          EntityStoreManager<OrganisationPb, DynamoDbPbTableStore<EntityTables<OraganisationEntity>, EmptyTablePartitioner, OrganisationPb, OrganisationPb.Builder>> entityStoreManager,
          IdGenerator<IdEntityStore<DynamoDbPbTableStore<EntityTables<OraganisationEntity>, EmptyTablePartitioner, IdProtoPb, IdProtoPb.Builder>>> idGenerator,
          IEntityProtoWrapper<OrganisationPb> entityWrapper,
          OrganisationTableUpdateListener tableUpdateListener,
          TableUpdateListenerNotifier notifier) {
    super(entityStoreManager, idGenerator, entityWrapper, tableUpdateListener, notifier);
  }
}
