package com.microservice.order.OrderMicroservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.microservice.order.OrderMicroservice.callers.ProductClient;
import com.microservice.order.OrderMicroservice.dtos.ProductDTO;
import com.microservice.order.OrderMicroservice.models.Product;

@Service
public class OrderService {
	
	@Autowired
	ProductClient productClient;

	public ResponseEntity<Product> getProduct(String id) {
		ResponseEntity<Product> response = productClient.getProduct(id);
		return response;
	}

	public ResponseEntity<Product> saveProduct(ProductDTO productDTO) {
		ResponseEntity<Product> response = productClient.saveOrder(productDTO);
		return response;
	}

}
