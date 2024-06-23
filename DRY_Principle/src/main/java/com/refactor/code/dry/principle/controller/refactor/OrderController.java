package com.refactor.code.dry.principle.controller.refactor;

import com.refactor.code.dry.principle.repository.OrderRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.refactor.code.dry.principle.model.Order;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@ConditionalOnProperty(name = "dry.principle.enabled", havingValue = "true")
@RestController
@RequestMapping("/orders")
public class OrderController extends CrudController<Order, Long> {
    private final OrderRepository orderRepository;

    public OrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @GetMapping("/{customerName}/{status}")
    public Order fetchCustomerOrders(@PathVariable("customerName") String customerName, @PathVariable("status") String status) {
        Optional<Order> optionalT = orderRepository.findByCustomerNameAndStatus(customerName, status);
        if (optionalT.isPresent()) {
            return optionalT.get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Entity not found");
        }
    }

}
