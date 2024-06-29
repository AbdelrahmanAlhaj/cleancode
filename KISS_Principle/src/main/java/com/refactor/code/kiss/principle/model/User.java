package com.refactor.code.kiss.principle.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class User {
    @Id
    private Long Id;
    private String username;
    private String email;
    private String firstName;
    private String lastName;

}
