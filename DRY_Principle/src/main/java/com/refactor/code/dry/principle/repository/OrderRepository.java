package com.refactor.code.dry.principle.repository;

import com.refactor.code.dry.principle.model.Order;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface OrderRepository extends CrudRepository<Order, Long> {

    Optional<Order> findByCustomerNameAndStatus(String customerName, String status);
}
