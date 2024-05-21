package com.tiwari.studence.util.provider;

import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.GeneratedMessageV3;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class ExtensionRegistryProvider<Pb extends GeneratedMessageV3> {
  private final ExtensionRegistry m_extensionRegistry;

  @Inject
  public ExtensionRegistryProvider() {
    m_extensionRegistry = ExtensionRegistry.getEmptyRegistry();
  }

  public ExtensionRegistryProvider(ExtensionRegistry extensionRegistry) {
    m_extensionRegistry = extensionRegistry;
  }

  public ExtensionRegistry getExtensionRegistry() {
    return m_extensionRegistry;
  }
}
