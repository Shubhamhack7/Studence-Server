package com.tiwari.studence.common.interfaces;

import com.tiwari.studence.common.async.IFuture;
import com.tiwari.studence.util.exception.ErrorException;

public interface IDynamoCreateTable {
  public IFuture<String, ErrorException> createDbTable(String tablename);
}
