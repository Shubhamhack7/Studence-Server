package com.tiwari.studence.common.service.v1.convertor;


import com.tiwari.studence.common.async.IFuture;
import com.tiwari.studence.util.encoder.IConverter;
import com.tiwari.studence.util.exception.ErrorException;

public interface IAsyncConverter<F, T> extends IConverter<F, IFuture<T, ErrorException>> {
}