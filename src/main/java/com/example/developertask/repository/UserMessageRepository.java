package com.example.developertask.repository;

import com.example.developertask.entity.UserMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserMessageRepository extends JpaRepository<UserMessage, Long> {

    @Query(value = "select * FROM (select * from user_message where user_id=:userId) order by id desc limit :count", nativeQuery = true)
    List<UserMessage> findMessages(Long userId, Long count);
}
