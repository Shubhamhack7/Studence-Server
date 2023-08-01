// Copyright (c) 2011, All Right Reserved, http://nsimpl.com/

package com.tiwari.studence.util.exception;

import com.tiwari.studence.proto.error.ErrorCategoryUiEnum;
import com.tiwari.studence.proto.error.ErrorProtoPb;
import com.tiwari.studence.proto.error.ErrorTypePbEnum;

class ErrorProtoBuilder {
	static ErrorProtoPb createErrorProto(ErrorTypePbEnum type) {
		ErrorProtoPb.Builder error = ErrorProtoPb.newBuilder();
		error.setErrorTypePbEnum(type);
		// if (errorEnum != null) {
		// error.setErrorEnumClass(errorEnum.getClass().getName());
		// error.setErrorEnumValue(errorEnum.getValueDescriptor().getName());
		// }
		// if (errorData != null) {
		// error.setErrorDataClass(errorData.getClass().getName());
		// error.setErrorData(errorData.toString());
		// }
		// if (serviceIds != null) {
		// error.addAllServiceId(serviceIds);
		// }
		switch (type) {
		case NOT_FOUND:
			error.setErrorCategory(ErrorCategoryUiEnum.ITEM_NOT_FOUND);
			break;
		case AUTHENTICATION_FAILED:
		case VALIDATION_FAILED:
			error.setErrorCategory(ErrorCategoryUiEnum.INPUT_VALIDATION_ERROR);
			break;
		case AUTHORIZATION_FAILED:
		case ERORTYPE_UNKNOWN_ERROR:
		case INVALID_VALUE:
		case CODE_INVARIANCE_FAILED:
		case UNCATCHED_EXCEPTION:
		case WRAPPED_LOGGED_RUNTIME:
			error.setErrorCategory(ErrorCategoryUiEnum.SELF_CODE_ERROR);
			break;
		case DUPLICATE_FOUND:
			error.setErrorCategory(ErrorCategoryUiEnum.DUPLICATE_ITEM_FOUND);
			break;

		case FOUND:
		case ERRORTYPE_NO_ERROR:
			error.setErrorCategory(ErrorCategoryUiEnum.UNKNOWN_ERROR_CATEGORY);
			break;
		case SERVER_CALL_TIMEOUT:
		case NO_INTERNET:
			error.setErrorCategory(ErrorCategoryUiEnum.NO_SLOW_OR_BLOCKED_DOWNSTREAM_CONNECTION_ERROR);
			break;
		case PARSE_FAILED:
		case UNRESOLVED:
		case UPDATE_CONFLICT:
			error.setErrorCategory(ErrorCategoryUiEnum.DATA_MISMATCH_ERROR);
			break;
		case SERVICE_CALL_FAILED:
			error.setErrorCategory(ErrorCategoryUiEnum.NO_OR_SLOW_DOWNSTREAM_CONNECTION_ERROR);
			break;
		}
		ErrorProtoPb errorProto = error.build();
		return errorProto;
	}
}
