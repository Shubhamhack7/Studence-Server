package com.tiwari.studence.util.protobuf;

import java.math.BigDecimal;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * @author Stepan Koltsov
 */
public class JsonUtils {

    private static void quoteCharTo(char c, Appendable to) {
        IoUtils.executeRunnable(() -> {
            // TODO: more escapes
            if (c == '"') {
                to.append("\\\"");
            } else {
                to.append(c);
            }
        });
    }

    public static void quoteTo(String s, Appendable to) {
        IoUtils.executeRunnable(() -> to.append('"'));
        s.chars().forEach(c -> quoteCharTo((char) c, to));
        IoUtils.executeRunnable(() -> to.append('"'));
    }

    public static String quote(String s) {
        StringBuilder r = new StringBuilder();
        quoteTo(s, r);
        return r.toString();
    }

    public static BigDecimal toBigDecimal(Number number) {
        if (number instanceof BigDecimal) {
            return (BigDecimal) number;
        } else if (number instanceof Float || number instanceof Double) {
            return BigDecimal.valueOf(number.doubleValue());
        } else if (number instanceof Byte || number instanceof Short
                || number instanceof Integer || number instanceof Long)
        {
            return BigDecimal.valueOf(number.longValue());
        } else {
            throw new IllegalArgumentException();
        }
    }
    
  
}