package com.tiwari.studence.common.service.v2.aws;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.model.*;
import com.tiwari.studence.common.async.AsyncCallForSyncCall;
import com.tiwari.studence.common.async.IFuture;
import com.tiwari.studence.common.service.v2.async.AsyncCallForSyncCallWithoutException;
import com.tiwari.studence.common.service.v2.exception.AwsExceptionHandler;
import com.tiwari.studence.common.util.ServiceCodeProvider;
import com.tiwari.studence.util.callable.ALoggableCallable;
import com.tiwari.studence.util.exception.ErrorException;
import com.tiwari.studence.util.exception.LoggedRuntimeException;
import com.tiwari.studence.util.exception.VoidException;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.concurrent.ExecutorService;

@Singleton
public class AwsDynamoDbAsyncClient {
  private final AmazonDynamoDBClient m_syncClient;
  private final ExecutorService m_executor;
  private final AwsExceptionHandler m_exceptionhandler;

  @Inject
  public AwsDynamoDbAsyncClient(AmazonDynamoDBClient syncClient, ExecutorService executor,
          AwsExceptionHandler exceptionhandler) {
    m_syncClient = syncClient;
    m_executor = executor;
    m_exceptionhandler = exceptionhandler;
  }

  public IFuture<QueryResult, VoidException> rangeQueryAsync(final QueryRequest rangeRequest)
          throws LoggedRuntimeException {
    ALoggableCallable<QueryResult> syncCall = new ALoggableCallable<QueryResult>(rangeRequest) {
      @Override
      public QueryResult call() {
        QueryResult res = m_syncClient.query(rangeRequest);
        return res;
      }
    };
    AsyncCallForSyncCallWithoutException<QueryResult> asyncCall = new AsyncCallForSyncCallWithoutException<QueryResult>(
            syncCall, m_executor, ServiceCodeProvider.awsDynamoDbCode(), m_exceptionhandler);
    asyncCall.startAsyncCall();
    return asyncCall.getFutureResult();
  }

  public IFuture<Void, ErrorException> putItemAsync(final PutItemRequest putRequest)
          throws LoggedRuntimeException {
    ALoggableCallable<Void> syncCall = new ALoggableCallable<Void>(putRequest) {
      @Override
      public Void call() {
        m_syncClient.putItem(putRequest);
        return null;
      }
    };
    AsyncCallForSyncCall<Void> asyncCall = new AsyncCallForSyncCall<Void>(syncCall, m_executor,
            ServiceCodeProvider.awsDynamoDbCode(), m_exceptionhandler);
    asyncCall.startAsyncCall();
    return asyncCall.getFutureResult();
  }

  public IFuture<GetItemResult, ErrorException> getItemAsync(final GetItemRequest getRequest)
          throws LoggedRuntimeException {
    ALoggableCallable<GetItemResult> syncCall = new ALoggableCallable<GetItemResult>(getRequest) {
      @Override
      public GetItemResult call() {
        GetItemResult res = m_syncClient.getItem(getRequest);
        return res;
      }
    };
    AsyncCallForSyncCall<GetItemResult> asyncCall = new AsyncCallForSyncCall<GetItemResult>(
            syncCall, m_executor, ServiceCodeProvider.awsDynamoDbCode(), m_exceptionhandler);
    asyncCall.startAsyncCall();
    return asyncCall.getFutureResult();
  }

  public IFuture<DeleteItemResult, ErrorException> deleteItemAsyn(
          final DeleteItemRequest delRequest) throws LoggedRuntimeException {
    ALoggableCallable<DeleteItemResult> syncCall = new ALoggableCallable<DeleteItemResult>(
            delRequest) {

      @Override
      public DeleteItemResult call() throws ErrorException {
        DeleteItemResult getResult = m_syncClient.deleteItem(delRequest);
        return getResult;
      }
    };
    AsyncCallForSyncCall<DeleteItemResult> asynCall = new AsyncCallForSyncCall<DeleteItemResult>(
            syncCall, m_executor, ServiceCodeProvider.awsDynamoDbCode(), m_exceptionhandler);
    asynCall.startAsyncCall();
    return asynCall.getFutureResult();
  }

  public IFuture<ScanResult, ErrorException> scanTableAsyn(final ScanRequest scanRequest)
          throws LoggedRuntimeException {

    ALoggableCallable<ScanResult> synCall = new ALoggableCallable<ScanResult>() {
      @Override
      public ScanResult call() throws ErrorException {
        ScanResult getResult = m_syncClient.scan(scanRequest);
        return getResult;
      }
    };
    AsyncCallForSyncCall<ScanResult> asyncall = new AsyncCallForSyncCall<ScanResult>(synCall,
            m_executor, ServiceCodeProvider.awsDynamoDbCode(), m_exceptionhandler);
    asyncall.startAsyncCall();
    return asyncall.getFutureResult();
  }

  public IFuture<BatchGetItemResult, ErrorException> batchGetItemAsyn(
          final BatchGetItemRequest batchItemRequest) throws LoggedRuntimeException {

    ALoggableCallable<BatchGetItemResult> synCall = new ALoggableCallable<BatchGetItemResult>() {
      @Override
      public BatchGetItemResult call() throws ErrorException {
        BatchGetItemResult getResult = m_syncClient.batchGetItem(batchItemRequest);
        return getResult;
      }
    };
    AsyncCallForSyncCall<BatchGetItemResult> asyncall = new AsyncCallForSyncCall<BatchGetItemResult>(
            synCall, m_executor, ServiceCodeProvider.awsDynamoDbCode(), m_exceptionhandler);
    asyncall.startAsyncCall();
    return asyncall.getFutureResult();
  }
}
