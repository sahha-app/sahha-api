package com.sahha.app.controller;


import com.google.firebase.messaging.FirebaseMessagingException;
import com.sahha.app.dto.NotificationDTO;
import com.sahha.app.service.PushNotificationService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/public/v1/notify")
public class PushNotificationController {

    PushNotificationService pushNotificationService;

    public PushNotificationController(PushNotificationService pushNotificationService) {
        this.pushNotificationService = pushNotificationService;
    }

    @PostMapping("/post")
    public String PostPushNotification(@RequestBody NotificationDTO notificationDTO) throws FirebaseMessagingException {
        return pushNotificationService.pushNotification(notificationDTO);
    }
}