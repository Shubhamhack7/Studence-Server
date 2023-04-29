package com.tiwari.studence.common.convertor;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;

import com.tiwari.studence.common.async.IFuture;
import com.tiwari.studence.common.async.WaitOnFutureAndExecuteRunnableControlFlow;
import com.tiwari.studence.util.collect.Lists;
import com.tiwari.studence.util.encoder.Base64ByteArrayEncoder;
import com.tiwari.studence.util.encoder.Base64IntegerEncoder;
import com.tiwari.studence.util.encoder.IConverter;
import com.tiwari.studence.util.exception.ErrorException;

public class Converters {
	private static final Base64IntegerEncoder BASE64_INTEGER_ENCODER = new Base64IntegerEncoder();
	private static final Base64ByteArrayEncoder BASE64_BYTE_ARRAY_ENCODER = new Base64ByteArrayEncoder();

	public static Base64IntegerEncoder getBase64IntegerEncoder() {
		return BASE64_INTEGER_ENCODER;
	}

	public static Base64ByteArrayEncoder getBase64ByteArrayEncoder() {
		return BASE64_BYTE_ARRAY_ENCODER;
	}

	public static <F, T> List<T> convert(IConverter<F, T> converter, List<F> fromList) {
		List<T> toList = Lists.newArrayList();
		for (F from : fromList) {
			toList.add(converter.convert(from));
		}
		return toList;
	}

	public static <F, T> IFuture<List<T>, ErrorException> asyncListConvert(final IAsyncConverter<F, T> converter,
			List<F> fromList) {
		final List<IFuture<T, ErrorException>> convertedList = convert(converter, fromList);
		Callable<List<T>> callable = new Callable<List<T>>() {
			@Override
			public List<T> call() throws ErrorException {
				List<T> toData = Lists.newArrayList();
				for (IFuture<T, ErrorException> fData : convertedList) {
					toData.add(fData.get());
				}
				return toData;
			}
		};
		return WaitOnFutureAndExecuteRunnableControlFlow.waitAndExecuteCallable(callable,
				Arrays.asList(convertedList.toArray(new IFuture<?, ?>[0])));
	}
}