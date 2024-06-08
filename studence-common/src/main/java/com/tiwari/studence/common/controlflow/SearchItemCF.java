package com.tiwari.studence.common.controlflow;

import com.tiwari.studence.common.async.AControlFlow;
import com.tiwari.studence.dynamodb.database.helper.DynamoDBSearchHelper;
import com.tiwari.studence.dynamodb.database.table.SearchItemInDynamoDbTable;
import com.tiwari.studence.proto.search.DynamoDbSearchPb;
import com.tiwari.studence.proto.search.SearchRequestsPb;
import com.tiwari.studence.util.database.TableNameUtil;
import com.tiwari.studence.util.exception.ErrorException;
import com.tiwari.studence.util.serverConfig.IServerListener;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Singleton
public class SearchItemCF extends AControlFlow<SearchItemCF.State, List<Map<String, AttributeValue>>, ErrorException> {

    private SearchItemInDynamoDbTable m_searchItemInDynamoDbTable;
    private TableNameUtil m_tableNameUtil;
    private String m_tableName;
    private IServerListener m_ServerListener;
    private SearchRequestsPb m_attributeValues;

    private DynamoDBSearchHelper m_helper;


    @Inject
    public SearchItemCF(String tableName, SearchRequestsPb attributeValues,
                        SearchItemInDynamoDbTable searchItemInDynamoDbTable, DynamoDBSearchHelper helper,TableNameUtil tableNameUtil,
                        IServerListener serverListener) {
        super(State.IN_DYANMODB, State.DONE);
        m_searchItemInDynamoDbTable = searchItemInDynamoDbTable;
        m_attributeValues = attributeValues;
        m_tableName = tableName;
        m_helper=helper;
        m_tableNameUtil = tableNameUtil;
        m_ServerListener = serverListener;
        addStateHandler(State.IN_DYANMODB, new SearchInDynamoDB());
    }

    enum State{
        IN_DYANMODB,
        DONE,
    }

    public class SearchInDynamoDB implements StateHandler<State> {
        List<Map<String, AttributeValue>> m_future =  null;

        @Override
        public void registerCalls() {
            System.out.println(m_tableName);

        }

        @Override
        public State handleState() {
            try {
                DynamoDbSearchPb.Builder dynamoDbSearchPb =  DynamoDbSearchPb.newBuilder();
                dynamoDbSearchPb.setTableName(m_tableNameUtil.getTableOverServerEnvironmentType(
                        m_ServerListener.getEnvironmentType(), m_tableName));
                dynamoDbSearchPb.setMode(m_attributeValues.getMode());
                m_helper.getAttributesToQuery(dynamoDbSearchPb,m_attributeValues);
               // m_future = m_searchItemInDynamoDbTable.searchItemsScanSpec(dynamoDbSearchPb.build());
                getAsyncCallback().set(0, m_future);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            return State.DONE;
        }

    }

}