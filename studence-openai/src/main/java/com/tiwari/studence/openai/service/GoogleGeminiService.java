package com.tiwari.studence.openai.service;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class GoogleGeminiService {

  public void buidWithGoogleGemini(String req) throws IOException {
    try {
      // Replace YOUR_API_KEY with your actual API key
      String apiKey = "AIzaSyDeoPnEs-BGbQ09qm1uOerYrvtLUfJBAnU";
      String endpoint = "https://generativelanguage.googleapis.com/v1beta/models/gemini-1.5-flash:generateContent?key=" + apiKey;

      // Request body
      String requestBody = "{ \"contents\": { \"parts\": { \"text\": \"" + req + "\" } } }";

      // Create URL object
      URL url = new URL(endpoint);

      // Create connection
      HttpURLConnection connection = (HttpURLConnection) url.openConnection();

      // Set request method
      connection.setRequestMethod("POST");

      // Set request headers
      connection.setRequestProperty("Content-Type", "application/json");

      // Enable output and set request body
      connection.setDoOutput(true);
      DataOutputStream outputStream = new DataOutputStream(connection.getOutputStream());
      outputStream.writeBytes(requestBody);
      outputStream.flush();
      outputStream.close();

      // Get the response code
      int responseCode = connection.getResponseCode();
      System.out.println("Response Code: " + responseCode);

      // Read the response
      BufferedReader reader;
      if (responseCode == HttpURLConnection.HTTP_OK) {
        reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
      } else {
        reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
      }
      String line;
      StringBuilder response = new StringBuilder();
      while ((line = reader.readLine()) != null) {
        response.append(line);
      }
      reader.close();

      // Print response
      System.out.println("Response: " + response.toString());

    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
