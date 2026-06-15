package com.microservice.order.OrderMicroservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.microservice.order.OrderMicroservice.models.Product;

@Service
public class OrderService {

	@Autowired
	RestTemplate restTemplate;
	
	public ResponseEntity<Product> getProduct(String id) {
		//only one line code
		Product product = restTemplate.getForObject("http://localhost:8082/products/" + id, Product.class);
		//String product = restTemplate.getForObject("http://localhost:8082/products/" + id, String.class);
		return new ResponseEntity<>(product,HttpStatus.OK);
	}

}
