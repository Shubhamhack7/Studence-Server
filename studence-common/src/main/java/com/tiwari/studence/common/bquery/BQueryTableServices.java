package com.tiwari.studence.common.bquery;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ExecutorService;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.json.JSONException;
import org.json.JSONObject;

import com.google.api.services.bigquery.model.Table;
import com.google.api.services.bigquery.model.TableDataInsertAllRequest;
import com.google.api.services.bigquery.model.TableDataInsertAllResponse;
import com.google.api.services.bigquery.model.TableFieldSchema;
import com.google.api.services.bigquery.model.TableReference;
import com.google.api.services.bigquery.model.TableSchema;
import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.GeneratedMessageV3;
import com.googlecode.protobuf.format.JsonFormat;
import com.tiwari.studence.bquery.database.connection.BQueryConnector;
import com.tiwari.studence.bquery.database.enamuration.BQueryDatasetEnum;
import com.tiwari.studence.bquery.database.interfaces.IBQuerySchemaTable;
import com.tiwari.studence.bquery.database.interfaces.IBQueryTableServices;
import com.tiwari.studence.common.async.AsyncCallForSyncCall;
import com.tiwari.studence.common.async.IFuture;
import com.tiwari.studence.util.JsonToMapConverter;
import com.tiwari.studence.util.callable.ALoggableCallable;
import com.tiwari.studence.util.exception.ErrorException;
import com.tiwari.studence.util.exception.ExceptionHandler;
import com.tiwari.studence.util.exception.Exceptions;
import com.tiwari.studence.util.exception.LoggedRuntimeException;
import com.tiwari.studence.util.serverConfig.IServerListener;
import com.tiwari.studence.util.serverConfig.ServerEnvironmentType;

@Singleton
public class BQueryTableServices<S extends IBQuerySchemaTable , P extends GeneratedMessageV3> implements IBQueryTableServices {

	private BQueryConnector m_BQueryConnector;
	private ExceptionHandler m_exceptionHandler;
	private ExecutorService m_executorService;
	private IServerListener m_serverlistner;
	private S m_s;

	@Inject
	public BQueryTableServices(IServerListener serverlistner, BQueryConnector BQueryConnector,
			ExceptionHandler exceptionHandler, ExecutorService executorService, S s) {
		m_serverlistner = serverlistner;
		m_BQueryConnector = BQueryConnector;
		m_exceptionHandler = exceptionHandler;
		m_executorService = executorService;
		m_s = s;
	}

	@Override
	public String getProjectId() {
		return "studence-dev";
	}

	@Override
	public String getDatasetId() {
		if (m_serverlistner.getEnvironmentType() == ServerEnvironmentType.PRODUCTION) {
			return BQueryDatasetEnum.STUDENCE_DEV_PROD.getStringValue();
		} else {
			return BQueryDatasetEnum.STUDENCE_DEV_DEVEL.getStringValue();
		}
	}

	@Override
	public ArrayList<TableFieldSchema> getSchema() {
		return m_s.getSchema();
	}

	@Override
	public void simpleQuery(String query) {
		// TODO Auto-generated method stub

	}

	public Table createTable(String tableName, String dataset) {
		ALoggableCallable<Table> callable = new ALoggableCallable<Table>() {
			@Override
			public Table call() throws ErrorException {
				TableSchema schema = new TableSchema();
				schema.setFields(getSchema());

				TableReference ref = new TableReference();
				ref.setProjectId(getProjectId());
				ref.setDatasetId(dataset);
				ref.setTableId(tableName);

				Table content = new Table();
				content.setTableReference(ref);
				content.setSchema(schema);

				try {
					return m_BQueryConnector.getConnection().tables()
							.insert(ref.getProjectId(), ref.getDatasetId(), content).execute();
				} catch (Throwable e) {
					throw Exceptions.handleThrowable(e, e.getMessage());
				}
			}
		};
		AsyncCallForSyncCall<Table> asynCall = new AsyncCallForSyncCall<Table>(callable, m_executorService,
				m_exceptionHandler);
		asynCall.startAsyncCall();
		try {
			return asynCall.getFutureResult().get();
		} catch (ErrorException e) {
			throw Exceptions.handleThrowable(e, e.getMessage());
		}

	}

	public IFuture<P, ErrorException> insertTable(String datasetId, String tableId,
			 P pb) {

		ALoggableCallable<P> callable = new ALoggableCallable<P>() {
			@Override
			public P call() throws ErrorException {
				JSONObject object = null;
				try {
					object = new JSONObject(new JsonFormat().printToString(pb));
				} catch (JSONException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				Map<String, Object> map = new JsonToMapConverter().toMap(object);

				TableDataInsertAllRequest.Rows row = new TableDataInsertAllRequest.Rows();
				row.setJson(map);
				TableDataInsertAllRequest request = new TableDataInsertAllRequest();
				request.setIgnoreUnknownValues(true);
				request.setRows(Arrays.asList(row));

				try {
					TableDataInsertAllResponse response = m_BQueryConnector.getConnection().tabledata()
							.insertAll(getProjectId(), datasetId, tableId, request).execute();
					if (response.containsKey("insertErrors")) {
						throw new LoggedRuntimeException(response.toString(), tableId, pb);
					}
					return pb;
				} catch (Throwable e) {
					throw Exceptions.handleThrowable(e, e.getMessage());
				}
			}
		};

		AsyncCallForSyncCall<P> asynCall = new AsyncCallForSyncCall<P>(callable,
				m_executorService, m_exceptionHandler);
		asynCall.startAsyncCall();
		return asynCall.getFutureResult();

	}

	@Override
	public void insertingDataTypes(String tableName, Map<String, Object> rowContent) {
		// TODO Auto-generated method stub

	}

}
