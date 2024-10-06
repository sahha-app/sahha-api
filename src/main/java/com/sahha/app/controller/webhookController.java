package com.sahha.app.controller;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/public/v1/notify")
public class webhookController {


    @PostMapping("/")
    public String notify(
            @RequestHeader("X-Signature") String signature,
            @RequestHeader("X-External-Id") String externalId,
            @RequestHeader("X-Event-Type") String eventType,
            @RequestBody String body){
        if(signature.equals("gy0SgfNvDErKUwLw5XXBzp8guDGUBC06q1tBOS2l8tU=")){
            System.out.println("received body is " + body);
        }
        else return "malicious";
        return body;
    }
}
