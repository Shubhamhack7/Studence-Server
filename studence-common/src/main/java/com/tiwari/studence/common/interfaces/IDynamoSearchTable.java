package com.tiwari.studence.common.interfaces;

import com.tiwari.studence.common.async.IFuture;
import com.tiwari.studence.proto.search.SearchPb;
import com.tiwari.studence.proto.search.SearchRequestsPb;
import com.tiwari.studence.util.collect.Pair;
import com.tiwari.studence.util.exception.ErrorException;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface IDynamoSearchTable {
  public IFuture<Pair<Set<Map.Entry<String, AttributeValue>>, List<Map<String, AttributeValue>>>, ErrorException> searchDbTable(String tablename, SearchRequestsPb build);

}
