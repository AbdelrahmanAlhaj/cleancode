package com.refactor.code.dry.principle.model;

import java.math.BigDecimal;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "orders")
public class Order {

    @Id
    private Long Id;
    private String customerName;
    private BigDecimal total;

    @ManyToOne
    private Customer customer;
}
