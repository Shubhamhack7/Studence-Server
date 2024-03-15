package com.tiwari.studence.firebase;

import com.google.cloud.storage.*;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.UserRecord;
import com.google.firebase.auth.UserRecord.CreateRequest;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.tiwari.studence.firebase.initializer.FirebaseInitializer;
import com.tiwari.studence.firebase.service.FirebaseService;
import com.tiwari.studence.util.collect.Lists;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;; // Not strictly necessary, but might be used for initialization

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.*;

public class APP {
  public static void main(String[] args) throws FirebaseAuthException, IOException {
    FirebaseInitializer.init();
    listFilesByPrefix("studence-dev.appspot.com", "DEVELOPMENT/");
    /*Map<String, Object> claims = new HashMap<>();
    claims.put("admin", true);

    DatabaseReference newRef = FirebaseInitializer.getDatabaseReference("");
    Map<String, Object> data = new HashMap<>();
    data.put("AWS ACCESS KEY", "DUMMYKEY");
    data.put("AWS SECRET KEY", "DUMMYSECRETKEY");

    String key = newRef.push().getKey();
    data.put("key",key);
    newRef.child(key).setValueAsync(data);*/
   /* DatabaseReference DbRef = FirebaseInitializer.getDatabaseReference().child("SERVER_CONFIG")
            .push();
    DbRef.setValue(data, new DatabaseReference.CompletionListener() {
      @Override
      public void onComplete(DatabaseError error, DatabaseReference ref) {
        if (error != null) {
          System.err.println("Error inserting data: " + error.getMessage());
        } else {
          System.out.println("Map inserted successfully!");
        }
      }
    });*/
  /*FirebaseAuth auth = FirebaseInitializer.getFirebaseAuth();
  CreateRequest request = new CreateRequest()
          .setEmail("example@example.com")
          .setEmailVerified(false)
          .setPassword("password123")
          .setDisplayName("Example");
  UserRecord ursRecord = auth.createUser(request);
  System.out.println("Successfully created new user: " + ursRecord.getUid());*/
  }

  public static void listFilesByPrefix(String bucketName, String prefix)
          throws StorageException, IOException {
    Bucket bucket = FirebaseInitializer.getFirebaseStorageClient().bucket(bucketName);
    List<String> listName = Lists.newArrayList();
    Storage.BlobListOption a = Storage.BlobListOption.prefix(prefix);
    for (Blob blob : bucket.getStorage().list(bucketName, Storage.BlobListOption.prefix(prefix))
            .iterateAll()) {
      if (true) {
        // blob.downloadTo(Paths.get("/home/test.txt"));
        Blob blob1 = bucket.getStorage().get(blob.getBlobId());
        if (blob1.getSize() > 0 && blob1.getContentType()
                .equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")) {
          System.out.println(blob1.getName());
          byte[] content = bucket.getStorage().readAllBytes(bucketName, blob1.getName());
          printExcelContent(content);
          moveObject(bucket.getStorage(), bucketName, blob1.getName(), bucketName,
                  blob1.getName().replace("In", "Done"));
        }
      }
    }

  }

  public static void moveObject(Storage storage, String sourceBucketName, String sourceObjectName,
          String targetBucketName, String targetObjectName) {

    BlobId source = BlobId.of(sourceBucketName, sourceObjectName);
    BlobId target = BlobId.of(targetBucketName, targetObjectName);

    // Optional: set a generation-match precondition to avoid potential race
    // conditions and data corruptions. The request returns a 412 error if the
    // preconditions are not met.
    Storage.BlobTargetOption precondition;
    if (storage.get(targetBucketName, targetObjectName) == null) {
      // For a target object that does not yet exist, set the DoesNotExist precondition.
      // This will cause the request to fail if the object is created before the request runs.
      precondition = Storage.BlobTargetOption.doesNotExist();
    } else {
      // If the destination already exists in your bucket, instead set a generation-match
      // precondition. This will cause the request to fail if the existing object's generation
      // changes before the request runs.
      precondition = Storage.BlobTargetOption.generationMatch(
              storage.get(targetBucketName, targetObjectName).getGeneration());
    }

    // Copy source object to target object
    storage.copy(Storage.CopyRequest.newBuilder().setSource(source).setTarget(target, precondition)
            .build());
    Blob copiedObject = storage.get(target);
    // Delete the original blob now that we've copied to where we want it, finishing the "move"
    // operation
    storage.get(source).delete();

    System.out.println(
            "Moved object " + sourceObjectName + " from bucket " + sourceBucketName + " to " + targetObjectName + " in bucket " + copiedObject.getBucket());
  }

  public static void printExcelContent(byte[] fileBytes) throws IOException {
    try (ByteArrayInputStream inputStream = new ByteArrayInputStream(fileBytes)) {
      Workbook workbook = new XSSFWorkbook(inputStream);
      Sheet sheet = workbook.getSheetAt(0); // Get the first sheet

      // Iterate through rows and cells
      for (Row row : sheet) {
        for (Cell cell : row) {
          switch (cell.getCellType()) {
          case STRING:
            System.out.println(cell.getStringCellValue());
            break;
          case NUMERIC:
            System.out.println(cell.getNumericCellValue());
            break;
          case BOOLEAN:
            System.out.println(cell.getBooleanCellValue());
            break;
          // Handle other cell types (formula, date, etc.) if needed
          }
        }
      }
    }
  }
}

/*
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.net.http.HttpTimeoutException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class EmailSender {
    public static void main(String[] args) throws IOException, InterruptedException {
        String url = "https://takeout.bysourfruit.com/api/email/send";

        // Form data
        String sender = "YOUR_SENDER";
        String receiver = "YOUR_RECEIVER";
        String subject = "YOUR_SUBJECT";
        String bodyText = "YOUR_TEXT_BODY";
        String bodyHTML = "YOUR_HTML_BODY";

        // URL encode form data
        String formData = String.format(
                "sender=%s&receiver=%s&subject=%s&bodyText=%s&bodyHTML=%s",
                URLEncoder.encode(sender, StandardCharsets.UTF_8),
                URLEncoder.encode(receiver, StandardCharsets.UTF_8),
                URLEncoder.encode(subject, StandardCharsets.UTF_8),
                URLEncoder.encode(bodyText, StandardCharsets.UTF_8),
                URLEncoder.encode(bodyHTML, StandardCharsets.UTF_8)
        );

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .POST(HttpRequest.BodyPublishers.ofString(formData))
                .header("Accept", "*//*")
        .header("Authorization", "Token YOUR_TOKEN_HERE")
        .header("Content-Type", "application/x-www-form-urlencoded")
        .build();

        try {
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        System.out.println("Response Code: " + response.statusCode());
        System.out.println("Response Body: " + response.body());
        } catch (HttpTimeoutException e) {
        System.out.println("Request timed out");
        }
        }
        }

 */