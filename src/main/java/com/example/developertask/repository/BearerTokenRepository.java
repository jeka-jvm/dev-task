package com.example.developertask.repository;

import com.example.developertask.entity.BearerToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface BearerTokenRepository extends JpaRepository<BearerToken, Long> {

    @Query(value = "select * from bearer_token where token=:token", nativeQuery = true)
    BearerToken findBearerToken(String token);

}
