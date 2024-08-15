package com.tiwari.studence.uiParser;

import com.tiwari.studence.uiParser.uiParser.HTMLDocReaderAndParser;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class App {

  public static void main(String[] args) throws IOException {
    HTMLDocReaderAndParser parser = new HTMLDocReaderAndParser();
    parser.convertHtmlToDocument("html_web_rsrc/login_page.html");
   // System.out.println(doc.getElementsByTag("title").first().text());
  }
}
