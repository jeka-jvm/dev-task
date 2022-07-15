package com.example.developertask.controller;

import com.example.developertask.entity.BearerToken;
import com.example.developertask.entity.User;
import com.example.developertask.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/token")
public class TokenController {

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping
    public ResponseEntity<BearerToken> getToken(@RequestBody User user) {
        return ResponseEntity.ok(authenticationService.getToken(user));
    }
}
