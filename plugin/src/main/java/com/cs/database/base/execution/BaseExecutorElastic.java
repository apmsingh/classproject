package com.cs.database.base.execution;

import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.URI;
import java.net.URL;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;

public class BaseExecutorElastic<T> {
  
  private static String         elasticSearchHost      = "localhost";
  
  private static String         elasticSearchPort      = "9200";
  
  private static String         elasticSearchIndexName = "classdata";
  
  protected static ObjectMapper mapper                 = new ObjectMapper();
  
  protected static final String METHOD_POST            = "POST";
  protected static final String METHOD_GET             = "GET";
  protected static final String METHOD_DELETE          = "DELETE";
  protected static final String METHOD_PUT             = "PUT";
  
  public Map<String, Object> executePlugin(String pUrl, String contentJson, String mimeType)
      throws Exception
  {
    return mapper.readValue(this.execute(pUrl, contentJson, mimeType), Map.class);
  }
  
  public <T> T returnResponse(Map<String, Object> sourceByRequest, Class<T> classType)
      throws Exception
  {
    return mapper.readValue(sourceByRequest.toString(), classType);
  }
  
  private InputStream execute(String pUrl, String contentJson, String mimeType) throws Exception
  {
    try {
      InputStream inputStream = null;
      URI URI = new URI("http://" + elasticSearchHost + ":" + elasticSearchPort + "/"
          + elasticSearchIndexName + "/" + pUrl);
      
      HttpURLConnection connection = executeRequest(URI, contentJson, mimeType);
      int statusCode = connection.getResponseCode();
      if (statusCode == HttpURLConnection.HTTP_OK) {
        inputStream = connection.getInputStream();
      }
      else {
        inputStream = connection.getErrorStream();
      }
      
      if (inputStream == null) {
        throw new Exception("No Response Found");
      }
      else {
        if (statusCode == HttpURLConnection.HTTP_OK) {
          return inputStream;
        }
        else {
          return null;
        }
      }
    }
    catch (SocketTimeoutException e) {
      e.printStackTrace();
      throw e;
    }
  }
  
  private HttpURLConnection prepareConnection(URL URI, String methodType) throws Exception
  {
    HttpURLConnection connection = (HttpURLConnection) URI.openConnection();
    connection.setRequestMethod(methodType);
    connection.setDoInput(true);
    connection.setDoOutput(true);
    connection.setRequestProperty("Content-Type", "application/json");
    connection.setReadTimeout(50000);
    connection.connect();
    return connection;
  }
  
  protected String getElasticSearchIndex()
  {
    return elasticSearchIndexName;
  }
  
  private HttpURLConnection executeRequest(URI url, String contentJson, String methodType)
      throws MalformedURLException, Exception
  {
    HttpURLConnection connection = prepareConnection(url.toURL(), methodType);
    if (contentJson != null) {
      DataOutputStream output = new DataOutputStream(connection.getOutputStream());
      BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(output, "UTF-8"));
      writer.write(contentJson);
      writer.close();
    }
    
    return connection;
  }
  
  protected String getUsecase()
  {
    return "";
  }
  
}
