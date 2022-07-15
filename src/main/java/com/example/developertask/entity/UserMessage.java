package com.example.developertask.entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;


@Data
@Entity
@RequiredArgsConstructor
public class UserMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String message;

    @ManyToOne
    @JoinColumn
    private User user;
}
