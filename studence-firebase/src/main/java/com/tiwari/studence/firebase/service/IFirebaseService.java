package com.tiwari.studence.firebase.service;

public interface IFirebaseService {
  public String sendPushNotification(String title,String body,String device_token);
  public String getCustomToken(String data);
}
