package com.microservice.order.OrderMicroservice.services;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import com.microservice.order.OrderMicroservice.dtos.ProductDTO;
import com.microservice.order.OrderMicroservice.models.Product;

@Service
public class OrderService {

	@Autowired
	RestClient restClient;

	public ResponseEntity<Product> getProduct(String id) {
		Product product = restClient.get().uri("http://localhost:8082/products/" + id)
				.accept(org.springframework.http.MediaType.APPLICATION_JSON).retrieve().body(Product.class);
		return ResponseEntity.ok(product);
	}
	
	public ResponseEntity<Product> saveProduct(ProductDTO product) {
		ResponseEntity<Product> savedProduct = restClient.post().uri("http://localhost:8082/products/save")
				.accept(org.springframework.http.MediaType.APPLICATION_JSON)
				.contentType(org.springframework.http.MediaType.APPLICATION_JSON)
				.body(product)
				.retrieve().toEntity(Product.class);
		return savedProduct;
	}

}