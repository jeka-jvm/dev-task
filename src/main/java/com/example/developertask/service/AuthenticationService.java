package com.example.developertask.service;

import com.example.developertask.entity.BearerToken;
import com.example.developertask.entity.User;
import com.example.developertask.exception.AccountNameNotFoundException;
import com.example.developertask.exception.PasswordValueIncorrectException;
import com.example.developertask.repository.BearerTokenRepository;
import com.example.developertask.repository.UserRepository;
import com.example.developertask.util.TokenGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AuthenticationService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BearerTokenRepository bearerTokenRepository;

    public BearerToken getToken(User user) {
        User foundUser = userRepository.getUserByName(user.getName());
        if (foundUser == null) {
            throw new AccountNameNotFoundException();
        } else {
            if (foundUser.getPassword().equals(user.getPassword())) {
                String generatedToken = TokenGenerator.generate(user.getName());

                BearerToken newToken = new BearerToken().setToken(generatedToken).setUser(foundUser);
                bearerTokenRepository.save(newToken);

                return new BearerToken().setToken(generatedToken);
            } else {
                throw new PasswordValueIncorrectException();
            }
        }
    }

    public boolean isTokenValid(String token) {
        return bearerTokenRepository.findBearerToken(token) != null;
    }

}
