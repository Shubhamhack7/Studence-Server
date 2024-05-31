package com.tiwari.studence.pushNotification.provider;

import com.tiwari.studence.common.services.interfaces.ITableNameProvider;
import com.tiwari.studence.dynamodb.database.table.TableNameEnum;

public class PushNotificationTableNameProvider implements ITableNameProvider {
  @Override
  public String getTableName() {
    return TableNameEnum.PUSH_NOTIFICATION.getValue();
  }
}
