package com.refactor.code.smells.dataClumps.controller.refactor;

import java.math.BigDecimal;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.refactor.code.smells.dataClumps.model.Product;
import com.refactor.code.smells.dataClumps.model.User;
import com.refactor.code.smells.dataClumps.service.DiscountCalculator;
import com.refactor.code.smells.dataClumps.service.ProductService;

@ConditionalOnProperty(name = "refactor.enabled", havingValue = "true")
@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;
    private final DiscountCalculator discountCalculator;

    public ProductController(ProductService productService, DiscountCalculator discountCalculator) {
        this.productService = productService;
        this.discountCalculator = discountCalculator;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        // Retrieve product details from the database
        Product product = productService.getProductById(id);

        // Apply discount based on user type
        User currentUser = getCurrentUser();
        double discountedPrice = discountCalculator.calculateDiscount(currentUser.getRole(), product.getPrice());
        product.setPrice(BigDecimal.valueOf(discountedPrice));

        return ResponseEntity.ok(product);
    }

    // Other methods...

    private User getCurrentUser() {
        User user = new User();
        user.setUserId(1L);
        user.setUsername("john.doe");
        user.setRole("premium");
        return user;
    }
}
