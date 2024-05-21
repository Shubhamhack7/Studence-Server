package com.tiwari.studence.common.service.v2.index;

import com.tiwari.studence.common.util.Converters;
import com.tiwari.studence.util.encoder.IBiConverter;

public enum EntityIndexAttributes {
  ITEM_ID(false, null),
  RANGE_KEY(false, null),
  RAW_DATA(false, Converters.getBase64ByteArrayEncoder()),
  VERSION(false, Converters.getBase64IntegerEncoder()),
  STATE(false, Converters.getBase64IntegerEncoder()),
  OWNER_ENTITY(false, Converters.getBase64ByteArrayEncoder()),
  USER_OWNER(false, Converters.getBase64ByteArrayEncoder()),
  EXTERNAL_ID(false, null),
  TRANSACTION_ID(false, null),
  MANAGED_TRANSACTION_STATE(false, Converters.getBase64IntegerEncoder()),
  // TODO : change this to a comparable date converter that can be used for
  // filtering transactions.
  MANAGED_TRANSACTION_TIME(true, Converters.getBase64IntegerEncoder()),
  BACKGROUND_TASK_STATES(false, null),
  LATEST_BACKGROUND_TASK_STATE(false, null),
  ENTITY_VERSION(false, null);

  private final boolean m_isComparable;
  private final IBiConverter<?, String> m_stringEncoder;

  private EntityIndexAttributes(boolean isComparable, IBiConverter<?, String> stringEncoder) {
    m_isComparable = isComparable;
    m_stringEncoder = stringEncoder;
  }

  public String getAttributeName() {
    return name();
  }

  public <R> IBiConverter<R, String> getStringEncoder() {
    return (IBiConverter<R, String>) m_stringEncoder;
  }

  public boolean isComparable() {
    return m_isComparable;
  }
}