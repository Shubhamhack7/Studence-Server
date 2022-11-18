package com.tiwari.studence.util;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import org.apache.commons.text.StringEscapeUtils;

/**
 * Hello world!
 *
 */
public class App {
  public static void main(String[] args) throws UnsupportedEncodingException {
    String json = "{\\\"items\\\":{\\\"item\\\":[{\\\"id\\\":\\\"0001\\\",\\\"type\\\":\\\"donut\\\",\\\"name\\\":\\\"Cake\\\",\\\"ppu\\\":0.55,\\\"batters\\\":{\\\"batter\\\":[{\\\"id\\\":\\\"1001\\\",\\\"type\\\":\\\"Regular\\\"},{\\\"id\\\":\\\"1002\\\",\\\"type\\\":\\\"Chocolate\\\"},{\\\"id\\\":\\\"1003\\\",\\\"type\\\":\\\"Blueberry\\\"},{\\\"id\\\":\\\"1004\\\",\\\"type\\\":\\\"Devil's Food\\\"}]},\\\"topping\\\":[{\\\"id\\\":\\\"5001\\\",\\\"type\\\":\\\"None\\\"},{\\\"id\\\":\\\"5002\\\",\\\"type\\\":\\\"Glazed\\\"},{\\\"id\\\":\\\"5005\\\",\\\"type\\\":\\\"Sugar\\\"},{\\\"id\\\":\\\"5007\\\",\\\"type\\\":\\\"Powdered Sugar\\\"},{\\\"id\\\":\\\"5006\\\",\\\"type\\\":\\\"Chocolate with Sprinkles\\\"},{\\\"id\\\":\\\"5003\\\",\\\"type\\\":\\\"Chocolate\\\"},{\\\"id\\\":\\\"5004\\\",\\\"type\\\":\\\"Maple\\\"}]}]}}";
    System.out.println(json);
    byte[] bytes = json.getBytes("UTF-8");
    String encoded = Base64.getEncoder().encodeToString(bytes);
    System.out.println(encoded);
    byte[] decoded = Base64.getDecoder().decode(encoded);
    String decodedStr = new String(decoded, StandardCharsets.UTF_8);
    System.out.println(decodedStr);
  }
}
