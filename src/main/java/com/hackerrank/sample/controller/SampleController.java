package com.hackerrank.sample.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {
    @GetMapping("/defaultHello")
    public ResponseEntity<?> defaultHello(@RequestParam(required = false, defaultValue = "World!") String message) {
        String finalMessage = "Hello " + message;
        return ResponseEntity.ok().body("{\"echo\": \"" + finalMessage + "\"}");
    }

//    @PostMapping("/customHello")
//    public ResponseEntity<?> customHello(@RequestParam(required = false) String message) {
//        String finalMessage = "Custom ";
//        if (message != null && !message.isEmpty()) {
//            finalMessage = finalMessage + message;
//            return ResponseEntity.ok().body("{\"echo\": \"" + finalMessage + "\"}");
//        } else {
//            // Return a response with the "echo" key even when message is empty
//            return ResponseEntity.badRequest().body("{\"echo\": \"" + finalMessage + "\"}");
//        }
//    }

    @PostMapping("/customHello")
    public ResponseEntity<?> customHello(@RequestParam(required = false) String message) {
        if (message != null) {
            String finalMessage = "Custom " + message;
            return ResponseEntity.ok().body("{\"echo\": \"" + finalMessage + "\"}");
        } else {
            // Return a response with the "echo" key and status code 400 (Bad Request) when message is empty or not provided
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\": \"Bad Request\"}");
        }
    }
}
