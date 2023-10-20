package com.tiwari.studence.openai;

import com.tiwari.studence.openai.service.OpenaiService;

import java.io.IOException;

public class App {
  public static void main(String[] args) throws IOException {
    OpenaiService.testOpenAi();
  }
}