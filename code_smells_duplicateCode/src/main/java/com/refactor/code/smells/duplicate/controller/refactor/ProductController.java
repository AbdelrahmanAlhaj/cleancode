package com.refactor.code.smells.duplicate.controller.refactor;

import com.refactor.code.smells.duplicate.exception.ApplicationException;
import com.refactor.code.smells.duplicate.model.Product;
import com.refactor.code.smells.duplicate.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@ConditionalOnProperty(name = "refactor.enabled", havingValue = "true")
@RestController
public class ProductController { // NOPMD by ahmed on 5/25/23, 10:17 AM

	@Autowired
	private ProductService productService; // NOPMD by ahmed on 5/25/23, 10:15 AM

	@PostMapping("/refactor/products")
	public ResponseEntity<String> createProduct(@RequestBody final Product product) { // NOPMD by ahmed on 5/25/23, 10:15 AM
		
		ResponseEntity<String> responseEntity = ResponseEntity.ok("Product created successfully");
		try {
			productService.createProduct(product);
		} catch (ApplicationException e) {
			e.printStackTrace();
			responseEntity =  ResponseEntity.badRequest().body(e.getMessage());
	    }
		return responseEntity;
	}
	
	

}