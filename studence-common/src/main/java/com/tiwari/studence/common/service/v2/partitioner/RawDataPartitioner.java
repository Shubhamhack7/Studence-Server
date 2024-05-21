package com.tiwari.studence.common.service.v2.partitioner;

import com.google.protobuf.GeneratedMessageV3;
import com.tiwari.studence.common.service.v2.index.EntityIndexAttributes;
import com.tiwari.studence.common.service.v2.interfaces.IDbInfo;
import com.tiwari.studence.common.service.v2.interfaces.ITables;
import com.tiwari.studence.util.collect.Maps;
import com.tiwari.studence.util.common.Strings;
import com.tiwari.studence.util.encoder.IBiConverter;
import com.tiwari.studence.util.exception.Preconditions;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.Map;

@Singleton
public class RawDataPartitioner<T extends ITables, Db extends IDbInfo> {
  private final int m_tableMaxAttributeSize;
  private final int m_dbMaxAttributeSize;

  @Inject
  public RawDataPartitioner(T tableInfo, Db forDB) {
    m_tableMaxAttributeSize = tableInfo.getTableMaxAttributesSize();
    m_dbMaxAttributeSize = forDB.getDBMaxAttributesSize();
  }

  public Map<String, String> getRawDataPartitions(GeneratedMessageV3 pb) {
    Map<String, String> rawDataPartitions = Maps.newHashMap();
    IBiConverter<byte[], String> encoder = EntityIndexAttributes.RAW_DATA.getStringEncoder();
    String encodedData = encoder.convert(pb.toByteArray());
    int encodedDataLength = encodedData.length();
    if (encodedDataLength == 0) {
      return rawDataPartitions;
    }
    Preconditions.check(encodedDataLength <= m_tableMaxAttributeSize,
            "EncodedDataLength : " + encodedDataLength + " Table Max : " + m_tableMaxAttributeSize,
            pb);
    int numberOfRawData = (int) Math.ceil(
            ((double) m_tableMaxAttributeSize) / m_dbMaxAttributeSize);
    for (int i = 0; i < numberOfRawData; i++) {
      String raw_data = "";
      int beginIndex = i * m_dbMaxAttributeSize;
      int endIndex = (i + 1) * m_dbMaxAttributeSize;
      if (beginIndex < encodedDataLength) {
        raw_data = endIndex < encodedDataLength ?
                encodedData.substring(beginIndex, endIndex) :
                encodedData.substring(beginIndex, encodedDataLength);
      }
      rawDataPartitions.put(
              EntityIndexAttributes.RAW_DATA.getAttributeName() + "_" + Integer.toString(i),
              raw_data);
    }
    return rawDataPartitions;
  }

  public Map<String, String> getRawDataPartitionsWithoutEmpty(GeneratedMessageV3 message) {
    Map<String, String> rawDataPartitions = Maps.newHashMap();
    for (Map.Entry<String, String> rawData : getRawDataPartitions(message).entrySet()) {
      if (Strings.notEmpty(rawData.getValue())) {
        rawDataPartitions.put(rawData.getKey(), rawData.getValue());
      }
    }
    return rawDataPartitions;
  }
}
