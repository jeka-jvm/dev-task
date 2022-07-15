package com.example.developertask.repository;

import com.example.developertask.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {

    User getUserByName(String name);
}
