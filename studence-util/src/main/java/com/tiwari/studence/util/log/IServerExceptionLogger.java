package com.tiwari.studence.util.log;

public interface IServerExceptionLogger {
	public void logError(Throwable t, String placeErrorMessage);
}