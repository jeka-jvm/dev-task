package com.example.developertask;

import com.example.developertask.entity.User;
import com.example.developertask.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class MyRunner implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) {
        userRepository.save(new User().setName("Vasya").setPassword("123"));
        userRepository.save(new User().setName("Oleg").setPassword("1234"));
    }
}
