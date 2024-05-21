package com.tiwari.studence.common.util;

import com.tiwari.studence.common.service.v2.interfaces.IEntity;
import com.tiwari.studence.common.service.v2.partitioner.EntityTablesWithTablePartitioner;
import com.tiwari.studence.common.service.v2.table.EmptyTablePartitioner;
import com.tiwari.studence.util.serverConfig.ServerEnvironmentType;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class EntityTables<E extends IEntity> extends
        EntityTablesWithTablePartitioner<E, EmptyTablePartitioner> {

  @Inject
  public EntityTables(ServerEnvironmentType environment, E forEntity,
          EmptyTablePartitioner tablePartitioner) {
    super(environment, forEntity, tablePartitioner);
  }

  public EntityTables(ServerEnvironmentType environment, E forEntity, int tableMaxAttributeSize,
          EmptyTablePartitioner tablePartitioner) {
    super(environment, forEntity, tableMaxAttributeSize, tablePartitioner);
  }

}
