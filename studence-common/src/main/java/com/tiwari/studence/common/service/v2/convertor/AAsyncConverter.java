package com.tiwari.studence.common.service.v2.convertor;

import com.google.protobuf.GeneratedMessageV3;
import com.tiwari.studence.common.async.IFuture;
import com.tiwari.studence.common.async.WaitOnFutureAndExecuteRunnableControlFlow;
import com.tiwari.studence.common.service.v2.interfaces.IAsyncConverter;
import com.tiwari.studence.common.util.GNormalizedProto;
import com.tiwari.studence.util.callable.ALoggableCallable;
import com.tiwari.studence.util.collect.Lists;
import com.tiwari.studence.util.exception.ErrorException;

import java.util.List;

public abstract class AAsyncConverter<F, T extends GeneratedMessageV3>
        implements IAsyncConverter<F, T> {
  private final GNormalizedProto m_protoNormatizer;
  private boolean m_removeMetaInfo = true;

  public AAsyncConverter(GNormalizedProto protoNormalizer) {
    m_protoNormatizer = protoNormalizer;
  }

  @Override
  public final IFuture<T, ErrorException> convert(F value) {
    List<IFuture<?, ?>> futures = Lists.newArrayList();
    final List<ALoggableCallable<?>> callables = Lists.newArrayList();
    final GeneratedMessageV3.Builder<?> builder = convertIntenal(value, futures, callables);
    ALoggableCallable<T> finalBuilder = new ALoggableCallable<T>() {
      @Override
      public T call() throws ErrorException {
        for (ALoggableCallable<?> callable : callables) {
          callable.call();
        }
        T converted = (T) builder.build();
        converted = (T) m_protoNormatizer.getNormalizedProtoWithClearMetaInfo(converted,
                m_removeMetaInfo);
        return converted;
      }
    };
    return WaitOnFutureAndExecuteRunnableControlFlow.waitAndExecuteCallable(finalBuilder, futures);
  }

  protected abstract GeneratedMessageV3.Builder<?> convertIntenal(F value,
          List<IFuture<?, ?>> futures, List<ALoggableCallable<?>> callables);
}
