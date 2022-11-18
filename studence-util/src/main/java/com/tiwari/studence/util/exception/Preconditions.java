// Copyright (c) 2011, All Right Reserved, http://nsimpl.com/

package com.tiwari.studence.util.exception;

import com.tiwari.studence.util.exception.LoggedRuntimeException;


public class Preconditions {
	public static void check(boolean acceptableCond, Object... args) {
		if (!acceptableCond) {
			throw new LoggedRuntimeException(new Throwable(), args);
		}
	}
//
//	public static void validateWithUiErrorString(boolean acceptableCond, String uiErrorString, String errorCode,
//			Object... args) {
//		ErrorCategoryUiEnum errorCategory = ErrorCategoryUiEnum.INPUT_VALIDATION_ERROR;
//		if (Strings.areEqual("VERSION_MISMATCHED", errorCode)) {
//			errorCategory = ErrorCategoryUiEnum.VERSION_MISMATCH;
//		}
//		if (!acceptableCond) {
//			throw new LoggedRuntimeException(errorCode, uiErrorString, errorCategory, args);
//		}
//	}
//
	public static void validate(boolean acceptableCond, Object... args) {
		if (!acceptableCond) {
			throw new LoggedRuntimeException("", args);
		}
	}
}
