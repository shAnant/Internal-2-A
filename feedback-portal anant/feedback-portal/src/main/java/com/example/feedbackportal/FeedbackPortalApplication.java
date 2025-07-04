package com.example.feedbackportal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.example.feedbackportal")
public class FeedbackPortalApplication {

    public static void main(String[] args) {
        SpringApplication.run(FeedbackPortalApplication.class, args);
    }
}
