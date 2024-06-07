package com.tiwari.studence.util.log;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.tiwari.studence.util.exception.ExceptionStackTrace;

public class DebugLogger implements IServerExceptionLogger{
	private static Logger s_logger = Logger.getLogger("DebugLogger");

	private static ILogger m_logger = new ILogger() {
		@Override
		public void addLog(Level level, String message) {
			s_logger.log(level, message);
		}
	};

	public static void error(String message) {
		m_logger.addLog(Level.SEVERE, message);
	}

	public static void error(Throwable e) {
		m_logger.addLog(Level.SEVERE, ExceptionStackTrace.getExceptionTrace(e));
	}

	public static void info(String message) {
		m_logger.addLog(Level.INFO, message);
	}

	public static void warn(String message) {
		m_logger.addLog(Level.WARNING, message);
	}

	public static void fine(String message) {
		m_logger.addLog(Level.FINE, message);
	}

	public static void finest(String message) {
		m_logger.addLog(Level.FINEST, message);
	}

	public static void log(Level level, String message) {
		m_logger.addLog(level, message);
	}

	@Override
	public void logError(Throwable t, String placeErrorMessage) {
		t = new Throwable(placeErrorMessage);
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		t.printStackTrace(pw);
		s_logger.severe(sw.toString());
	}

	public static interface ILogger {
		public void addLog(Level level, String message);
	}

}
