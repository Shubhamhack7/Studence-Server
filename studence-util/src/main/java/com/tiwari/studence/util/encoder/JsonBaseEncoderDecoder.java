package com.tiwari.studence.util.encoder;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class JsonBaseEncoderDecoder implements IBaseEncoderDecoderConverter<String, String> {

  @Inject
  public JsonBaseEncoderDecoder() {

  }

  @Override
  public String convert(String toEncode) {
    byte[] bytes = {};
    try {
      bytes = toEncode.getBytes("UTF-8");
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    }
    String encoded = Base64.getEncoder().encodeToString(bytes);
    return encoded;
  }

  @Override
  public String reverseConvert(String toDecode) {
    byte[] decoded = Base64.getDecoder().decode(toDecode);
    String decodedStr = new String(decoded, StandardCharsets.UTF_8);
    return decodedStr;
  }

}
