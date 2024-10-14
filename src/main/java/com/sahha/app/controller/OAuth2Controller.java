package com.sahha.app.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class OAuth2Controller {
//    @GetMapping("/code/google")
//    public String code(@RequestBody String body){
//        System.out.println("received body     "+body);
//        return "";
//    }
//

    @GetMapping("")
    public String publicendpoint() {

        System.out.println("publicendpoint     " );
        return "hello";
    }

    @GetMapping("private")
    public String returnString(Authentication authentication) {
//        authentication.getAuthorities()

        System.out.println("authentication.getDetails()     " + authentication.getDetails().toString());
        return "hello";
    }

    @PostMapping("private")
    public String post(Authentication authentication) {
//        authentication.getAuthorities()

        System.out.println("authentication.getDetails()     " + authentication.getDetails().toString());
        return "hello";
    }
}
