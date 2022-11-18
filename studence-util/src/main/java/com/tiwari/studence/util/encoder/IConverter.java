// Copyright (c) 2011, All Right Reserved, http://nsimpl.com/

package com.tiwari.studence.util.encoder;

public interface IConverter<F, T> {
  public T convert (F value);
}
