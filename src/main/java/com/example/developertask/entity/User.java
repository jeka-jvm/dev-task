package com.example.developertask.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;


@Data
@RequiredArgsConstructor
@Entity
@Table(name = "users", uniqueConstraints = @UniqueConstraint(columnNames = "name"))
@Accessors(chain = true)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;
    private String name;
    private String password;

}
