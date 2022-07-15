package com.example.developertask.controller;

import com.example.developertask.entity.UserMessage;
import com.example.developertask.service.UserMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class UserMessageController {

    @Autowired
    private UserMessageService userMessageService;

    @PostMapping("/messages")
    public ResponseEntity<String> saveMessage(@RequestBody UserMessage userMessage, @RequestHeader("Authorization") String bearerToken) {
        userMessageService.save(userMessage, bearerToken);

        return ResponseEntity.ok("Saved!");
    }

    @GetMapping("/messages")
    public ResponseEntity<List<UserMessage>> findMessages(@RequestBody UserMessage userMessage, @RequestHeader("Authorization") String bearerToken) {
        return ResponseEntity.ok(userMessageService.findMessages(userMessage, Long.parseLong(userMessage.getMessage().split(" ")[1])));
    }
}
