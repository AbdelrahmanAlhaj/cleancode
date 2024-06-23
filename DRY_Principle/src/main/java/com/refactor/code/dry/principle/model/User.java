package com.refactor.code.dry.principle.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Table(name = "orders")
@Entity
public class User {
    @Id
    private Long Id;
    private String name;
    private String email;
    private String age;

}
