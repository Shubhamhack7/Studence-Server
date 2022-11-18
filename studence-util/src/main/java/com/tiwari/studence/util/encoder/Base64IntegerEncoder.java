package com.tiwari.studence.util.encoder;

import javax.inject.Inject;

import org.apache.commons.codec.binary.Base64;

import com.google.inject.Singleton;
import com.tiwari.studence.util.exception.Preconditions;

/**
 * Base64 encoding is not correct for lexicographic comparisons.
 * 
 * @author shubham
 */
@Singleton
public class Base64IntegerEncoder implements IBaseEncoderDecoderConverter<Integer, String> {
  @Inject
  public Base64IntegerEncoder() {
    // TODO Auto-generated constructor stub
  }

  public String convert(Integer value) {
    byte[] intbytes = new byte[6];
    for (int i = 5; i > 1; --i) {
      intbytes[i] = value.byteValue();
      value = value >>> 8;
    }
    byte[] encodedBytes = Base64.encodeBase64(intbytes, false, true);
    Preconditions.check(encodedBytes.length == 8, "Encoded  should be 8 bytes for base64");
    int i = 2;
    for (; i < encodedBytes.length; ++i) {
      if (encodedBytes[i] != 'A') {
        break;
      }
    }
    byte[] truncatedBytes = new byte[encodedBytes.length - i];
    System.arraycopy(encodedBytes, i, truncatedBytes, 0, truncatedBytes.length);
    return new String(truncatedBytes);
  }

  public Integer reverseConvert(String value) {
    byte[] stringBytes = value.getBytes();
    Preconditions.check(stringBytes.length <= 6);
    byte[] encodedBytes = new byte[8];
    int i = 0;
    for (; i < 8 - stringBytes.length; ++i) {
      encodedBytes[i] = 'A';
    }
    for (int j = 0; i < 8; ++i, ++j) {
      encodedBytes[i] = stringBytes[j];
    }
    byte[] decodedBytes = Base64.decodeBase64(encodedBytes);
    Preconditions.check(decodedBytes.length == 6);
    Preconditions.check(decodedBytes[0] == 0 && decodedBytes[1] == 0);
    int intValue = 0;
    for (int byteIndex = 2; byteIndex < 6; ++byteIndex) {
      int byteValue = decodedBytes[byteIndex];
      if (byteValue < 0) {
        byteValue ^= -256;
      }
      intValue = (intValue << 8) | byteValue;
    }
    return intValue;
  }
}
