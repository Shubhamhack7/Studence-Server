package com.tiwari.studence.firebase.service;

import com.google.firebase.auth.UserRecord;

public interface IFirebaseService {
  public String sendPushNotification(String title,String body,String device_token);
  public String getCustomToken(String data);

  public UserRecord createUserWithEmail(String email,String password,String userId);
  public UserRecord signInWithEmailAndPassword(String email,String password);
}
