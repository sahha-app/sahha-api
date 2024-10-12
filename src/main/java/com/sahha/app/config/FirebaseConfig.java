package com.sahha.app.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.FirebaseApp;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.FileInputStream;
import java.io.IOException;

@Configuration
public class FirebaseConfig {


    @Value("${GOOGLE_APPLICATION_CREDENTIALS}") // Inject the path to the JSON file from application.properties
    private String serviceAccountFilePath;

//    @Bean
    public GoogleCredentials googleCredentials() throws IOException {
        // Create a FileInputStream manually from the injected file path
        FileInputStream serviceAccount = new FileInputStream(serviceAccountFilePath);
        return GoogleCredentials.fromStream(serviceAccount);
    }
    @Bean
    public FirebaseApp initializeFirebaseApp() throws IOException {


        FirebaseOptions options = FirebaseOptions.builder()
//                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .setCredentials(googleCredentials())
                .build();

        return FirebaseApp.initializeApp(options);
    }

}