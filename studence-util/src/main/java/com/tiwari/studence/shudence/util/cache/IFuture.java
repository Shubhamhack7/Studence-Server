package com.tiwari.studence.shudence.util.cache;

public interface IFuture<R, E extends Exception> {
	public R get() throws E;

	public void addDoneCallback(IDoneCallback callback);

	public boolean isDone();
}
