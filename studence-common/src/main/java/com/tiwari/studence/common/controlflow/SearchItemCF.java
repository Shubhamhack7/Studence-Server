package com.tiwari.studence.common.controlflow;

import com.tiwari.studence.common.async.AControlFlow;
import com.tiwari.studence.dynamodb.database.helper.DynamoDBSearchHelper;
import com.tiwari.studence.dynamodb.database.table.SearchItemInDynamoDbTable;
import com.tiwari.studence.proto.search.SearchPb;
import com.tiwari.studence.util.database.TableNameUtil;
import com.tiwari.studence.util.exception.ErrorException;
import com.tiwari.studence.util.exception.LoggedRuntimeException;
import com.tiwari.studence.util.serverConfig.IServerListener;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.awssdk.services.dynamodb.model.ScanResponse;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Singleton
public class SearchItemCF extends AControlFlow<SearchItemCF.State, List<HashMap<String, AttributeValue>>, ErrorException> {

    private SearchItemInDynamoDbTable m_searchItemInDynamoDbTable;
    private TableNameUtil m_tableNameUtil;
    private String m_tableName;
    private IServerListener m_ServerListener;
    private List<SearchPb> m_attributeValues;

    private DynamoDBSearchHelper m_helper;


    @Inject
    public SearchItemCF(String tableName, List<SearchPb> attributeValues,
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
        ScanResponse m_future =  null;

        @Override
        public void registerCalls() {
            System.out.println(m_tableName);

        }

        @Override
        public State handleState() {
            try {
                m_future = m_searchItemInDynamoDbTable.searchItemsScanSpec(m_tableNameUtil.getTableOverServerEnvironmentType(
                        m_ServerListener.getEnvironmentType(), m_tableName), m_helper.getAttributesToQuery(m_attributeValues));
                getAsyncCallback().set(0, new ArrayList<>());
            } catch (ErrorException e) {
                getAsyncCallback().handleUnexpectedException(new LoggedRuntimeException(e));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            return State.DONE;
        }

    }

}
