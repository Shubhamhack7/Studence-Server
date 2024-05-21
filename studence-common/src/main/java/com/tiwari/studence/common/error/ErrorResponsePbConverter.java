package com.tiwari.studence.common.error;

import java.util.Arrays;
import java.util.List;

import javax.inject.Singleton;

import com.google.inject.Inject;
import com.tiwari.studence.common.convertor.Converters;
import com.tiwari.studence.proto.error.ErrorProtoPb;
import com.tiwari.studence.proto.error.ErrorResponsePb;
import com.tiwari.studence.util.common.Strings;
import com.tiwari.studence.util.encoder.IConverter;
import com.tiwari.studence.util.exception.ErrorException;
import com.tiwari.studence.util.exception.LoggedRuntimeException;

@Singleton
public class ErrorResponsePbConverter implements IConverter<ErrorException, ErrorResponsePb> {
  private final ErrorProtoUiConverter m_errorProtoConverter;

  @Inject
  public ErrorResponsePbConverter(ErrorProtoUiConverter errorProtoConverter) {
    m_errorProtoConverter = errorProtoConverter;
  }

  public ErrorResponsePb convert(ErrorException ex) {
    List<ErrorProtoPb> errors = Converters.convert(m_errorProtoConverter, ex.getErrorProtoS());
    ErrorResponsePb.Builder errorResponse = ErrorResponsePb.newBuilder();
    errorResponse.addAllErrors(errors);
    errorResponse.setDebugStackTrace(
            ex.getStackTraceString().replaceAll("\n", " ").replaceAll(" \t", " ").trim());
    errorResponse.setExceptionId(ex.getExceptionId());
    if (Strings.notEmpty(ex.getErrorCode())) {
      errorResponse.setErrorCode(ex.getErrorCode());
    }
    if (Strings.notEmpty(ex.getUiErrorString())) {
      errorResponse.setUiErrorString(ex.getUiErrorString());
    }
    errorResponse.setErrorCategory(ex.getErrorProto().getErrorProto().getErrorCategory());
    return errorResponse.build();
  }

  public ErrorResponsePb convert(LoggedRuntimeException ex) {
    com.tiwari.studence.util.exception.ParsedErrorProto error = ex.getErrorProto();
    List<ErrorProtoPb> errors = Converters.convert(m_errorProtoConverter, Arrays.asList(error));
    ErrorResponsePb.Builder errorResponse = ErrorResponsePb.newBuilder();
    errorResponse.addAllErrors(errors);
    errorResponse.setDebugStackTrace(ex.getStackTraceString());
    errorResponse.setExceptionId(ex.getExceptionId());
    if (Strings.notEmpty(ex.getErrorCode())) {
      errorResponse.setErrorCode(ex.getErrorCode());
    }
    if (Strings.notEmpty(ex.getServiceCode())) {
      errorResponse.setServiceCode(ex.getServiceCode());
    }
    if (Strings.notEmpty(ex.getOperationId())) {
      errorResponse.setOperationId(ex.getOperationId());
    }
    if (Strings.notEmpty(ex.getUiErrorString())) {
      errorResponse.setUiErrorString(ex.getUiErrorString());
    }
    errorResponse.setErrorCategory(ex.getErrorProto().getErrorProto().getErrorCategory());
    return errorResponse.build();
  }
}