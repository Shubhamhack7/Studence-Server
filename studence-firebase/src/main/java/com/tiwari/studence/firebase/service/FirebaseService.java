package com.tiwari.studence.firebase.service;

import com.google.firebase.messaging.FirebaseMessagingException;
import com.google.firebase.messaging.Message;
import com.google.firebase.messaging.Notification;
import com.tiwari.studence.firebase.initializer.FirebaseInitializer;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class FirebaseService extends FirebaseInitializer implements IFirebaseService{

  @Inject
  public FirebaseService(){

  }

  @Override
  public String sendPushNotification(String title, String body, String device_token) {
    try {
      return getFirebaseMessaging().send(Message.builder()
              .setNotification(Notification.builder()
                      .setTitle(title)
                      .setBody(body)
                      .build())
              .setToken(device_token)
              .build());
    } catch (FirebaseMessagingException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public String getCustomToken(String data) {
    return getFirebaseCustomToken(data);
  }
}
