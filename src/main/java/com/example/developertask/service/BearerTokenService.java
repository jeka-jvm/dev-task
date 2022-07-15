package com.example.developertask.service;

import com.example.developertask.entity.BearerToken;
import com.example.developertask.repository.BearerTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BearerTokenService {

    @Autowired
    private BearerTokenRepository bearerTokenRepository;

    public void save(BearerToken bearerToken) {
        bearerTokenRepository.save(bearerToken);
    }
}
