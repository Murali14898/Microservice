package com.microservice.order.OrderMicroservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.order.OrderMicroservice.dtos.ProductDTO;
import com.microservice.order.OrderMicroservice.models.Product;
import com.microservice.order.OrderMicroservice.services.OrderService;


@RestController
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	OrderService orderService;
	
	@GetMapping("/{id}")
	public ResponseEntity<Product> getOrder(@PathVariable String id){
		return orderService.getProduct(id);
	}
	
	@PostMapping("/save")
	public ResponseEntity<Product> saveOrder(@RequestBody ProductDTO productDTO){
		return orderService.saveProduct(productDTO);
	}
}