package com.tiwari.studence.util.encoder;

public interface IBiConverter<F, T> extends IConverter<F, T> {
	  public F reverseConvert(T value);
	}
