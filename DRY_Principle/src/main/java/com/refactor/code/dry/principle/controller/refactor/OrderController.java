package com.refactor.code.dry.principle.controller.refactor;

import com.refactor.code.dry.principle.model.Order;
import com.refactor.code.dry.principle.repository.OrderRepository;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@ConditionalOnProperty(name = "dry.principle.enabled", havingValue = "true")
@RestController
@RequestMapping("/orders")
public class OrderController extends CrudController<Order, Long> {
    private final OrderRepository orderRepository;

    public OrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @GetMapping("/{status}/{customerName}")
    public Order fetchCustomerOrders(@PathVariable("status") String status, @PathVariable("customerName") String customerName) {
        Optional<Order> optionalT = orderRepository.findByCustomerNameAndStatus(customerName, status);
        if (optionalT.isPresent()) {
            return optionalT.get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Entity not found");
        }
    }

    @GetMapping("/")
    public List<Order> getAll() {
//        return orderRepository.findAll(Sort.by(Sort.Order.asc("orderDate")));
        return null;
    }
}
