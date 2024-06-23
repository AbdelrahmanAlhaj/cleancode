package com.refactor.code.dry.principle.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Customer {

    @Id
    private Long id;
    private String name;

    @OneToMany(mappedBy = "customer")
    private List<Order> orders;

}
