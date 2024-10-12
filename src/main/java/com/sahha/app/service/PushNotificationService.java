package com.sahha.app.service;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingException;
import com.google.firebase.messaging.Message;
import com.sahha.app.dto.NotificationDTO;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.IOException;

@Service
public class PushNotificationService {



    public PushNotificationService() {
    }



    public String pushNotification(NotificationDTO notificationItem) throws FirebaseMessagingException {

        Message msg = Message.builder()
                .setToken(notificationItem.registrationToken())
                .putData("title", notificationItem.title())
                .putData("body", notificationItem.body())
                .build();

        return FirebaseMessaging.getInstance().send(msg);
    }
}