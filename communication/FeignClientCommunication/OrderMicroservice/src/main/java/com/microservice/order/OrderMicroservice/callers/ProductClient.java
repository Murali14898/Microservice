package com.microservice.order.OrderMicroservice.callers;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.microservice.order.OrderMicroservice.dtos.ProductDTO;
import com.microservice.order.OrderMicroservice.models.Product;

@FeignClient(name = "product-service",
             url = "${feign.cient.product-service.url}")
public interface ProductClient {
	
	@GetMapping("/products/{id}")
	public ResponseEntity<Product> getProduct(@PathVariable String id);
	
	@PostMapping("/products/save")
	public ResponseEntity<Product> saveOrder(@RequestBody ProductDTO productDTO);
}
