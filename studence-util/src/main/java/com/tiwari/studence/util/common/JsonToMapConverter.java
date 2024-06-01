package com.tiwari.studence.util.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.json.JSONArray;
import org.json.JSONObject;

import com.google.inject.Singleton;

@Singleton
public class JsonToMapConverter {
	
	@Inject
	public JsonToMapConverter() {
		// TODO Auto-generated constructor stub
	}
	
  public Map<String, Object> toMap(JSONObject object) {
    Map<String, Object> map = new HashMap<String, Object>();
    Iterator<String> keysItr = object.keySet().iterator();
    while (keysItr.hasNext()) {
      String key = keysItr.next();
      Object value = object.get(key);

      if (value instanceof JSONArray) {
        value = toList((JSONArray) value);
      }

      else if (value instanceof JSONObject) {
        value = toMap((JSONObject) value);
      }
      map.put(key, value);
    }
    return map;
  }

  private List<Object> toList(JSONArray array) {
    List<Object> list = new ArrayList<Object>();

    for (int i = 0; i < array.length(); i++) {
      Object value = array.get(i);
      if (value instanceof JSONArray) {
        value = toList((JSONArray) value);
      } else if (value instanceof JSONObject) {
        value = toMap((JSONObject) value);
      }
      list.add(value);
    }
    return list;
  }
}