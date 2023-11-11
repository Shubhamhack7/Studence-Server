package com.tiwari.studence.util;

import org.json.JSONObject;

public class CommonUtil {
  public static void mergeJSONObjects(JSONObject older, JSONObject updated) {
    for (String key : updated.keySet()) {
      older.put(key, updated.get(key));
    }
  }
}
