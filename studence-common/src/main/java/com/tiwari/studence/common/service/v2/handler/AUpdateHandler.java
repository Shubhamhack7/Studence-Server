package com.tiwari.studence.common.service.v2.handler;

import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.Message;
import com.tiwari.studence.common.service.v2.interfaces.IUpdateHandler;
import com.tiwari.studence.util.exception.Preconditions;

public abstract class AUpdateHandler<U extends GeneratedMessageV3, F extends GeneratedMessageV3>
        implements IUpdateHandler<U, F> {
  private final U m_original;
  private final boolean m_forUpdate;
  private final Message.Builder m_updateBuilder;
  private boolean m_hasUpdates = false;
  private U m_updated;

  protected AUpdateHandler() {
    m_forUpdate = false;
    m_updateBuilder = createUpdateBuilder();
    m_original = (U) m_updateBuilder.getDefaultInstanceForType();
  }

  protected AUpdateHandler(U current) {
    m_original = current;
    m_forUpdate = true;
    Preconditions.check(current != null);
    m_updateBuilder = current.toBuilder();
  }

  public boolean hasUpdates() {
    return m_hasUpdates;
  }

  public U getUpdated() {
    Preconditions.check(m_hasUpdates);
    if (m_updated == null) {
      m_updated = (U) m_updateBuilder.build();
    }
    return m_updated;
  }

  protected abstract Message.Builder createUpdateBuilder();

  protected Message.Builder getUpdateBuilder() {
    return m_updateBuilder;
  }

  protected void markChanged() {
    m_hasUpdates = true;
  }

  public U getOriginal() {
    return m_original;
  }

  public boolean isForUpdate() {
    return m_forUpdate;
  }
}
