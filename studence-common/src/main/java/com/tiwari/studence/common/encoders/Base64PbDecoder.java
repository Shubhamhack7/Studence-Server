package com.tiwari.studence.common.encoders;

import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.InvalidProtocolBufferException;
import com.tiwari.studence.common.service.v2.interfaces.IPbBuilderProvider;
import com.tiwari.studence.common.util.Converters;
import com.tiwari.studence.util.common.Strings;
import com.tiwari.studence.util.encoder.IBiConverter;
import com.tiwari.studence.util.exception.Exceptions;
import com.tiwari.studence.util.provider.ExtensionRegistryProvider;


import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class Base64PbDecoder<T extends GeneratedMessageV3, B extends GeneratedMessageV3.Builder<B>>
        implements IBiConverter<String, T> {
  private final IPbBuilderProvider<B> m_builderProvider;
  private final ExtensionRegistryProvider<T> m_extensionRegistry;

  @Inject
  public Base64PbDecoder(IPbBuilderProvider<B> builderProvider,
          ExtensionRegistryProvider<T> extensionRegistry) {
    m_builderProvider = builderProvider;
    m_extensionRegistry = extensionRegistry;
  }

  public T convert(String value) {
    if (Strings.isEmpty(value)) {
      return null;
    }
    byte[] bytes = Converters.getBase64ByteArrayEncoder().reverseConvert(value);
    try {
      return (T) m_builderProvider.getPbBuilder()
              .mergeFrom(bytes, m_extensionRegistry.getExtensionRegistry()).build();
    } catch (InvalidProtocolBufferException ipb) {
      throw Exceptions.handleThrowable(ipb, value);
    }
  }

  public String reverseConvert(T value) {
    return Converters.getBase64ByteArrayEncoder().convert(value.toByteArray());
  }
}