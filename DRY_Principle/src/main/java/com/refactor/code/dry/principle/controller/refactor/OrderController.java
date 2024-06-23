package com.refactor.code.dry.principle.controller.refactor;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.refactor.code.dry.principle.model.Order;

@ConditionalOnProperty(name = "dry.principle.enabled", havingValue = "true")
@RestController
@RequestMapping("/orders")
public class OrderController extends CrudController<Order, Long>{
	
    // no need to repeat CRUD methods here

}
