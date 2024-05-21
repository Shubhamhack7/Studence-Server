package com.tiwari.studence.common.service.v2.exception;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.tiwari.studence.common.util.ServiceCodeProvider;
import com.tiwari.studence.proto.error.ErrorCategoryUiEnum;
import com.tiwari.studence.util.exception.ExceptionHandler;
import com.tiwari.studence.util.exception.LoggedRuntimeException;

import javax.inject.Singleton;

@Singleton
public class AwsExceptionHandler extends ExceptionHandler {
  @Override
  public LoggedRuntimeException handleException(Throwable t, String serviceCode,
          Object... objects) {
    if (t instanceof AmazonServiceException) {
      AmazonServiceException ex = (AmazonServiceException) t;
      if ("ConditionalCheckFailedException".equals(ex.getErrorCode())
              || ex.getStatusCode() == 409) {
        return new LoggedRuntimeException(serviceCode, ErrorCategoryUiEnum.CONCURRENT_CALL_ERROR, t,
                objects);
      } else if ("ResourceNotFoundException".equals(ex.getErrorCode())
              || ex.getStatusCode() == 404) {
        return new LoggedRuntimeException(serviceCode, ErrorCategoryUiEnum.ITEM_NOT_FOUND, t,
                objects);
      } else if ("ProvisionedThroughputExceededException".equals(ex.getErrorCode())
              || "ThrottlingException".equals(ex.getErrorCode())
              || "RequestLimitExceededException".equals(ex.getErrorCode())
              || ex.getStatusCode() == 429) {
        return new LoggedRuntimeException(serviceCode,
                ErrorCategoryUiEnum.PROVISIONED_THROUGHPUT_EXCEPTION, t, objects);
      } else if (ex.getStatusCode() == 503) {
        return new LoggedRuntimeException(serviceCode,
                ErrorCategoryUiEnum.DOWNSTREAM_SERVER_UNAVAILABLE_ERROR, t, objects);
      } else if (ex.getStatusCode() == 504) {
        return new LoggedRuntimeException(serviceCode,
                ErrorCategoryUiEnum.DOWNSTREAM_REQUEST_TIMEOUT_ERROR, t, objects);
      } else if (ex.getStatusCode() >= 500 && ex.getStatusCode() < 600) {
        return new LoggedRuntimeException(serviceCode, ErrorCategoryUiEnum.DOWNSTREAM_SERVER_ERROR,
                t, objects);
      } else {
        return new LoggedRuntimeException(serviceCode,
                String.format("%s_%s", ex.getErrorCode(), String.valueOf(ex.getStatusCode())), "",
                ErrorCategoryUiEnum.SELF_CODE_ERROR, t, objects);
      }

      // TODO: mayank: More detailed handler
    } else if (t instanceof AmazonClientException) {
      AmazonClientException ce = ((AmazonClientException) t);
      return new LoggedRuntimeException(serviceCode,
              ErrorCategoryUiEnum.NO_OR_SLOW_DOWNSTREAM_CONNECTION_ERROR, t, objects);
    }
    return super.handleException(t, objects);
  }

  // only for backward compatibility until we implement serviceCode method with
  // all AWS Services
  @Override
  public LoggedRuntimeException handleException(Throwable t, Object... objects) {
    return handleException(t, ServiceCodeProvider.aws(), objects);
  }
}
