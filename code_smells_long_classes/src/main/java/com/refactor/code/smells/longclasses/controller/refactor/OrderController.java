package com.refactor.code.smells.longclasses.controller.refactor;

import com.refactor.code.smells.longclasses.model.Order;
import com.refactor.code.smells.longclasses.model.OrderDTO;
import com.refactor.code.smells.longclasses.model.refactor.OrderDTOConverter;
import com.refactor.code.smells.longclasses.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@ConditionalOnProperty(name = "refactor.enabled", havingValue = "true")
@RestController
@RequestMapping("/api/refactor")
public class OrderController {

    private final OrderRepository orderRepository;
    private final OrderDTOConverter orderDTOConverter;

    public OrderController(OrderRepository orderRepository,
                           OrderDTOConverter orderDTOConverter) {
        this.orderRepository = orderRepository;
        this.orderDTOConverter = orderDTOConverter;
    }

    @GetMapping("/users/{userId}/orders")
    public List<OrderDTO> getOrderHistoryForUser(@PathVariable Long userId) {
        List<Order> orders = orderRepository.getOrderHistoryForUser(userId);
        return orderDTOConverter.convertOrderToDTO(orders);
    }

}
