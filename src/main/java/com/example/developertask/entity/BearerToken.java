package com.example.developertask.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;


@Data
@RequiredArgsConstructor
@Entity
@JsonIgnoreProperties("id")
@Accessors(chain = true)
public class BearerToken {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String token;

    @OneToOne
    @JsonIgnore
    @JoinColumn(unique = true)
    private User user;
}
