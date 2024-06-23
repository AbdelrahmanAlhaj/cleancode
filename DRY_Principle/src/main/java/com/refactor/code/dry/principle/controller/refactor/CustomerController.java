package com.refactor.code.dry.principle.controller.refactor;

import com.refactor.code.dry.principle.model.Customer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/customers")
@RestController
public class CustomerController extends CrudController<Customer, Long> {

}
