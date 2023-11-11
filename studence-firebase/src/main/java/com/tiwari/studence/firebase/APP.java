package com.tiwari.studence.firebase;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.UserRecord;
import com.google.firebase.auth.UserRecord.CreateRequest;
import com.tiwari.studence.firebase.initializer.FirebaseInitializer;
import com.tiwari.studence.firebase.service.FirebaseService;

public class APP {
  public static void main(String[] args) throws FirebaseAuthException {
    FirebaseInitializer.init();
  FirebaseAuth auth = FirebaseInitializer.getFirebaseAuth();
  CreateRequest request = new CreateRequest()
          .setEmail("example@example.com")
          .setEmailVerified(false)
          .setPassword("password123")
          .setDisplayName("Example");
  UserRecord ursRecord = auth.createUser(request);
  System.out.println("Successfully created new user: " + ursRecord.getUid());
  }
}
