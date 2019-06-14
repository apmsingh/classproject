package com.cs.plugin.utils.dbutils;

import java.util.Map;

public class DbUtils {
  
  public static Map<String, Object> getSourceByRequest(Map<String, Object> requestData)
  {
    return (Map<String, Object>) requestData.get("_source");
  }
}
