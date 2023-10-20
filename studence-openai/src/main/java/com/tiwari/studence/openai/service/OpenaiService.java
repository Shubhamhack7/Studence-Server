package com.tiwari.studence.openai.service;

import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.service.OpenAiService;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.HttpResponse;

import java.io.IOException;

import org.apache.http.util.EntityUtils;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class OpenaiService {

  //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 - Api key

  public static void testOpenAi() throws IOException {
    String apiKey = "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";

    // Define the API endpoint
    String apiUrl = "https://api.openai.com/v1/chat/completions";

    // Set up the HTTP client
    HttpClient httpClient = HttpClients.createDefault();
    HttpPost httpPost = new HttpPost(apiUrl);

    // Set headers
    httpPost.setHeader("Authorization", "Bearer " + apiKey);
    httpPost.setHeader("Content-Type", "application/json");
    httpPost.setHeader("Accept", "application/json");

    // Create the request payload
    String requestBody = "{\"model\":\"gpt-3.5-turbo\",\"messages\":[{\"role\":\"user\",\"content\":\"Hello, World!\"}],\"temperature\":0.5}";
    httpPost.setEntity(new StringEntity(requestBody));
    System.out.println(Arrays.toString(httpPost.getAllHeaders()));
    System.out.println(httpPost.toString());
    System.out.println(httpPost.getEntity());
    // Execute the request
    HttpResponse response = httpClient.execute(httpPost);

    // Process the response
    String responseContent = EntityUtils.toString(response.getEntity());
    System.out.println(responseContent);
  }

}
