package com.tiwari.studence.common.service.v2.partitioner;

import com.tiwari.studence.common.service.v2.interfaces.IEntity;
import com.tiwari.studence.common.service.v2.interfaces.ITables;
import com.tiwari.studence.common.service.v2.table.ATablePartitioner;
import com.tiwari.studence.proto.error.ErrorCategoryUiEnum;
import com.tiwari.studence.util.common.Strings;
import com.tiwari.studence.util.exception.LoggedRuntimeException;
import com.tiwari.studence.util.serverConfig.ServerEnvironmentType;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class EntityTablesWithTablePartitioner<E extends IEntity, TP extends ATablePartitioner>
        implements ITables<TP> {
  private final int m_tableMaxAttributeSize;
  private final TP m_tablePartitioner;
  private final E m_entity;
  private final ServerEnvironmentType m_envType;

  public enum TableType {
    PRODUCTION("PRODUCTION"),
    QA("QA"),
    PRODUCTION_TEST("PRODUCTION_TEST"),
    DEVELOPMENT("DEVELOPMENT");

    private String m_type;

    TableType(String type) {
      this.m_type = type;
    }

    String getType() {
      return m_type;
    }
  }

  ;

  @Inject
  public EntityTablesWithTablePartitioner(ServerEnvironmentType environment, E forEntity,
          TP tablePartitioner) {
    this(environment, forEntity, 1024, tablePartitioner);
  }

  public EntityTablesWithTablePartitioner(ServerEnvironmentType environment, E forEntity,
          int tableMaxAttributeSize, TP tablePartitioner) {
    m_tableMaxAttributeSize = tableMaxAttributeSize;
    m_tablePartitioner = tablePartitioner;
    m_envType = environment;
    m_entity = forEntity;
  }

  private String createTableName(ServerEnvironmentType environment, E forEntity,
          String tablePartitionKey) {
    String test = false ? TableType.DEVELOPMENT.getType() : TableType.PRODUCTION.getType();
    switch (environment) {

    case UNKNOWN_SERVER:
      throw new LoggedRuntimeException(ErrorCategoryUiEnum.SERVER_MISCONFIGURED_ERROR,
              ServerEnvironmentType.UNKNOWN_SERVER.name(), "PLease set correct server");
    case PRODUCTION:
      return String.format("%s_%s", forEntity.getEntityFullName(),
              ServerEnvironmentType.PRODUCTION.name());
    case QA:
      return String.format("%s_%s", forEntity.getEntityFullName(), ServerEnvironmentType.QA.name());
    case PRODUCTION_TEST:
      return String.format("%s_%s", forEntity.getEntityFullName(),
              ServerEnvironmentType.PRODUCTION_TEST.name());
    case DEVELOPMENT:
      return String.format("%s_%s", forEntity.getEntityFullName(),
              ServerEnvironmentType.DEVELOPMENT.name());
    default:
      throw new LoggedRuntimeException(ErrorCategoryUiEnum.SERVER_MISCONFIGURED_ERROR,
              ServerEnvironmentType.UNKNOWN_SERVER.name(), "PLease set correct server");
    }
    /*if (Strings.isEmpty(tablePartitionKey)) {
      return String.format("%s_%s_%s", forEntity.getEntityFullName(), environment.name(), test);
    } else {
      return String.format("%s_%s_%s_%s", forEntity.getEntityFullName(), tablePartitionKey,
              environment.name(), test);
    }*/
  }

  @Override
  public String getDbTableName(String id) {
    if (id == null) {
      return getDbTableNameWithTablePartitionKey(null);
    }
    String tablePartitionKey = m_tablePartitioner.getPartitionKey(id);
    return getDbTableNameWithTablePartitionKey(tablePartitionKey);
  }

  @Override
  public int getTableMaxAttributesSize() {
    return m_tableMaxAttributeSize;
  }

  @Override
  public String getDbTableNameWithTablePartitionKey(String tablePartitionKey) {
    return createTableName(m_envType, m_entity, tablePartitionKey);
  }

}
