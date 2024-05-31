package com.tiwari.studence.email;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.net.http.HttpTimeoutException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class EmailTest {
  public static void main(String[] args) {
    /*String url = "https://takeout.bysourfruit.com/api/email/send";

    // Form data
    String sender = "no-reply@studence.com";
    String receiver = "shubham.3dgame@gmail.com";
    String subject = "This is Test";
    String bodyText = "This is Test";
    String bodyHTML = "<html>\n" + "<body>\n" + "<h2>The partial differential symbol: &part;</h2>\n" + "</body>\n" + "</html>";

    // URL encode form data
    String formData = String.format("sender=%s&receiver=%s&subject=%s&bodyText=%s&bodyHTML=%s",
            URLEncoder.encode(sender, StandardCharsets.UTF_8),
            URLEncoder.encode(receiver, StandardCharsets.UTF_8),
            URLEncoder.encode(subject, StandardCharsets.UTF_8),
            URLEncoder.encode(bodyText, StandardCharsets.UTF_8),
            URLEncoder.encode(bodyHTML, StandardCharsets.UTF_8));

    HttpClient client = HttpClient.newHttpClient();
    HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url))
            .POST(HttpRequest.BodyPublishers.ofString(formData)).header("Accept", "*//*")
            .header("Authorization", "6V94M1LJ56ODXMZ683SGHF")
            .header("Content-Type", "application/x-www-form-urlencoded").build();
    HttpResponse<String> response = null;
    try {

      try {
        response = client.send(request, BodyHandlers.ofString());
      } catch (IOException e) {
        throw new RuntimeException(e);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    } finally {
      System.out.println("Response Code: " + response.statusCode());
      System.out.println("Response Body: " + response.body()d);
    }*/
    String senderEmail = "studence";
    String senderPassword = "Nikerisk@07";

    // Recipient's email address
    String recipientEmail = "get.er.shubham@gmail.com";

    // Mail server properties
    Properties props = new Properties();
    props.put("mail.smtp.host", "relay.dnsexit.com");
    props.put("mail.smtp.port", "80");
    props.put("mail.smtp.auth", "true");
    props.put("mail.smtp.starttls.enable", "true"); // Enable STARTTLS

    try {
      sendEmail(senderEmail, senderPassword, recipientEmail, props);
      System.out.println("Email sent successfully.");
    } catch (MessagingException e) {
      e.printStackTrace();
    }
  }

  public static void sendEmail(String senderEmail, String senderPassword, String recipientEmail, Properties props) throws MessagingException {
    // Creating a session with authentication
    Session session = Session.getInstance(props, new Authenticator() {
      protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(senderEmail, senderPassword);
      }
    });

    Transport transport = session.getTransport("smtp");

    // Connect to the mail server with STARTTLS enabled
    transport.connect(props.getProperty("mail.smtp.host"), Integer.parseInt(props.getProperty("mail.smtp.port")), senderEmail, senderPassword);
    // Creating a MimeMessage object
    Message message = new MimeMessage(session);

    // Setting sender and recipient addresses
    message.setFrom(new InternetAddress(senderEmail));
    message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmail));

    // Setting email subject
    message.setSubject("Test Email");

    // Setting email content
    message.setText("This is a test email sent from Java.");

    // Sending the email
    transport.send(message);
    transport.close();
  }
}
