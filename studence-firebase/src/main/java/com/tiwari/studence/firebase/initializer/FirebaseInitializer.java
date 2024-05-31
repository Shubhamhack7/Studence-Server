package com.tiwari.studence.firebase.initializer;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.storage.Bucket;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.cloud.FirestoreClient;
import com.google.firebase.cloud.StorageClient;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.messaging.FirebaseMessaging;
import com.tiwari.studence.util.common.Strings;
import com.tiwari.studence.util.exception.ErrorException;

import java.io.FileInputStream;
import java.io.IOException;

public class FirebaseInitializer {

  public static void init() {
    try {
      FileInputStream serviceAccount = new FileInputStream(
              "/home/tiwaritiwari/Studence/ConfigJSON/studence-dev-firebase-adminsdk-hdb11-fb9c7dc05a.json");
      FirebaseOptions options = new FirebaseOptions.Builder().setCredentials(
                      GoogleCredentials.fromStream(serviceAccount))
              .setDatabaseUrl("https://studence-dev-default-rtdb.firebaseio.com")
              .setProjectId("studence-dev").build();
      FirebaseApp.initializeApp(options);
     System.out.print( FirebaseAuth.getInstance().createCustomToken("HEELO"));
    } catch (IOException e) {
      new ErrorException(e);
    } catch (FirebaseAuthException e) {
      throw new RuntimeException(e);
    }

  }

  public static FirebaseAuth getFirebaseAuth() {
    return FirebaseAuth.getInstance();
  }

  public static StorageClient getFirebaseStorageClient() {
    return StorageClient.getInstance();
  }

  public DatabaseReference getDatabaseReference() {
    return FirebaseDatabase.getInstance().getReference();
  }

  public Firestore getFirestore() {
    return FirestoreClient.getFirestore();
  }

  public FirebaseMessaging getFirebaseMessaging() {
    return FirebaseMessaging.getInstance();
  }

  public static StorageClient getFirebaseStorageClient(String bucketName) {
    return StorageClient.getInstance();
  }

  public Bucket getFirebaseStorageClientWithBucket(String bucketName) {
    return StorageClient.getInstance().bucket(bucketName);
  }

  public String getFirebaseCustomToken(String data) {
    try {
      if (Strings.notEmpty(data)) {
        return FirebaseAuth.getInstance().createCustomToken(data);
      } else {
        return FirebaseAuth.getInstance().createCustomToken(Strings.generateRandomString(10));
      }
    } catch (FirebaseAuthException e) {
      new RuntimeException(e);
    }
    return "";
  }

}
