package com.example.developertask.service;

import com.example.developertask.entity.User;
import com.example.developertask.entity.UserMessage;
import com.example.developertask.exception.TokenInvalidException;
import com.example.developertask.repository.UserMessageRepository;
import com.example.developertask.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserMessageService {

    @Autowired
    private UserMessageRepository userMessageRepository;

    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private UserRepository userRepository;

    public void save(UserMessage userMessage, String bearerToken) {

        String token = cutBearerToken(bearerToken);
        if (authenticationService.isTokenValid(token)) {
            User user = userRepository.getUserByName(userMessage.getUser().getName());
            userMessage.setUser(user);
            userMessageRepository.save(userMessage);
        } else {
            throw new TokenInvalidException();
        }
    }

    public List<UserMessage> findMessages(UserMessage userMessage, Long count) {
        System.out.println(userMessage + " " + count);
        User user = userRepository.getUserByName(userMessage.getUser().getName());
        return userMessageRepository.findMessages(user.getId(), count);
    }

    private String cutBearerToken(String token) {
        return token.trim().split("_")[1];
    }
}
