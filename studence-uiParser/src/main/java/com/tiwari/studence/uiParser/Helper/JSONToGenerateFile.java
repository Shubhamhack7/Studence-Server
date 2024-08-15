package com.tiwari.studence.uiParser.Helper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.util.JsonFormat;
import com.tiwari.studence.uiParser.uiParser.HTMLDocReaderAndParser;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Enumeration;

public class JSONToGenerateFile {

  public static void generateJSONFile(GeneratedMessageV3 json, String filePath) throws IOException {
    String targetFolder = "/home/hacker/Project/Studence-Server/studence-uiParser/target";

    try {
      String jsonString = JsonFormat.printer().includingDefaultValueFields().print(json);
      ObjectMapper objectMapper = new ObjectMapper();

      // Convert JSON string to a Java object (Generic Object in this case)
      Object jsonObject = objectMapper.readValue(jsonString, Object.class);

      // Create the target file
      File targetFile = new File(targetFolder, filePath);

      // Create the target folder if it doesn't exist
      targetFile.getParentFile().mkdirs();

      // Write the object to the file with proper formatting
      objectMapper.writerWithDefaultPrettyPrinter().writeValue(targetFile, jsonObject);

      System.out.println("JSON file written to target folder successfully.");
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }

  }
}
