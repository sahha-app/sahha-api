//package com.sahha.app.config;
//
//import com.google.auth.oauth2.GoogleCredentials;
//import com.google.firebase.FirebaseOptions;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class FirebaseApp {
//
//    public FirebaseApp() {
//    }
//
//    @Bean
//    FirebaseApp firebaseApp(GoogleCredentials credentials) {
//        FirebaseOptions options = FirebaseOptions.builder()
//                .setCredentials(credentials)
//                .build();
//
//        return FirebaseApp.initializeApp(options);
//    }
//
//}