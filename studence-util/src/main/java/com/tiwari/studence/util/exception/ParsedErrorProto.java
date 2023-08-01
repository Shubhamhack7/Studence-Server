
package com.tiwari.studence.util.exception;

import com.tiwari.studence.proto.error.ErrorCategoryUiEnum;
import com.tiwari.studence.proto.error.ErrorProtoPb;
import com.tiwari.studence.proto.error.ErrorTypePbEnum;

public class ParsedErrorProto {
	private boolean m_deserializedEnum;
	private boolean m_deserializedData;
	private final ErrorProtoPb m_errorProto;

	// private E m_enumValue;
	// private F m_errorData;

	@Deprecated
	public ParsedErrorProto(ErrorTypePbEnum type) {
		m_errorProto = ErrorProtoBuilder.createErrorProto(type);

	}

	public ParsedErrorProto(ErrorCategoryUiEnum type) {
		ErrorProtoPb.Builder error = ErrorProtoPb.newBuilder();
		error.setErrorCategory(type);
		m_errorProto = error.build();
	}

	public ParsedErrorProto(ErrorCategoryUiEnum type, ErrorTypePbEnum errorType) {
		ErrorProtoPb.Builder error = ErrorProtoPb.newBuilder();
		error.setErrorCategory(type);
		error.setErrorTypePbEnum(errorType);
		m_errorProto = error.build();
	}

	// public ParsedErrorProto(ErrorTypeUiPbEnum type, E errorEnum) {
	// this(type, errorEnum, null, null);
	// }
	//
	// public ParsedErrorProto(ErrorTypeUiPbEnum type, E errorEnum, F errorData) {
	// this(type, errorEnum, errorData, null);
	// }
	//
	// public ParsedErrorProto(ErrorTypeUiPbEnum type, E errorEnum, F errorData,
	// List<String> serviceIds) {
	// Preconditions.check(type != null, "ErrorTypeUiPbEnum should not be null.");
	// m_deserializedEnum = true;
	// m_deserializedData = true;
	// m_enumValue = errorEnum;
	// m_errorData = errorData;
	// m_errorProto = ErrorProtoBuilder.createErrorProto(type, errorEnum,
	// errorData, serviceIds);
	// }

	public ParsedErrorProto(ErrorProtoPb errorProto) {
		m_deserializedEnum = false;
		m_deserializedData = false;
		m_errorProto = errorProto;
	}

	// public E getErrorEnum() {
	// if (!m_deserializedEnum) {
	// // TODO(mgupta): Set the value of enum
	// }
	// return m_enumValue;
	// }
	//
	// public F getErrorData() {
	// if (!m_deserializedData) {
	// // TODO(mgupta): Parse data
	// }
	// return m_errorData;
	// }

	public ErrorProtoPb getErrorProto() {
		return m_errorProto;
	}

	public String toString() {
		return m_errorProto.toString();
	}
}