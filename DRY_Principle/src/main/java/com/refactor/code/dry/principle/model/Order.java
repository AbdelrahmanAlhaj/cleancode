package com.refactor.code.dry.principle.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

@Setter
@Getter
@Entity
@Table(name = "orders")
public class Order {

    @Id
    private Long Id;
    private String customerName;
    private BigDecimal total;

    @CreatedDate
    private LocalDate orderDate;

    @ManyToOne
    private Customer customer;
}
