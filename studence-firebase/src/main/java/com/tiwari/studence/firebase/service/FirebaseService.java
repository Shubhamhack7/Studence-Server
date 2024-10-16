package com.tiwari.studence.firebase.service;

import com.google.cloud.storage.Blob;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.Storage;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.UserRecord;
import com.google.firebase.messaging.FirebaseMessagingException;
import com.google.firebase.messaging.Message;
import com.google.firebase.messaging.Notification;
import com.tiwari.studence.firebase.initializer.FirebaseInitializer;
import com.tiwari.studence.util.log.DebugLogger;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class FirebaseService extends FirebaseInitializer implements IFirebaseService {

  @Inject
  public FirebaseService() {

  }

  @Override
  public String sendPushNotification(String title, String body, String device_token) {
    try {
      return getFirebaseMessaging().send(Message.builder()
              .setNotification(Notification.builder().setTitle(title).setBody(body).build())
              .setToken(device_token).build());
    } catch (FirebaseMessagingException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public String getCustomToken(String data) {
    return getFirebaseCustomToken(data);
  }

  @Override
  public UserRecord createUserWithEmail(String email, String password, String userId) {
    FirebaseAuth auth = FirebaseInitializer.getFirebaseAuth();
    UserRecord.CreateRequest request = new UserRecord.CreateRequest().setEmail(email)
            .setEmailVerified(false).setPassword(password).setDisplayName(userId);
    UserRecord ursRecord = null;
    try {
      ursRecord = auth.createUser(request);
    } catch (FirebaseAuthException e) {
      throw new RuntimeException(e);
    }
    System.out.println("Successfully created new user: " + ursRecord.getUid());
    return ursRecord;
  }


  public UserRecord signInWithEmailAndPassword(String email, String password) {
    return null;
  }


  public void moveFiles(Storage storage, String sourceBucketName, String sourceObjectName,
                        String targetBucketName, String targetObjectName) {
    BlobId source = BlobId.of(sourceBucketName, sourceObjectName);
    BlobId target = BlobId.of(targetBucketName, targetObjectName);
    Storage.BlobTargetOption precondition;
    if (storage.get(targetBucketName, targetObjectName) == null) {
      precondition = Storage.BlobTargetOption.doesNotExist();
    } else {
      precondition = Storage.BlobTargetOption.generationMatch();
      // precondition = Storage.BlobTargetOption.generationMatch(
      // storage.get(targetBucketName, targetObjectName).getGeneration());
    }
    storage.copy(Storage.CopyRequest.newBuilder().setSource(source).setTarget(target, precondition)
            .build());
    Blob copiedObject = storage.get(target);
    storage.get(source).delete();

    DebugLogger.info(
            "Moved object " + sourceObjectName + " from bucket " + sourceBucketName + " to " + targetObjectName + " in bucket " + copiedObject.getBucket());
  }
}