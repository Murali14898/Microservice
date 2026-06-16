package com.microservice.product.ProductMicroservice.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.microservice.product.ProductMicroservice.dtos.ProductDTO;
import com.microservice.product.ProductMicroservice.models.Product;

@Service
public class ProductService {
	Map<String,Product> map;
	
	public ProductService() {
		map = new HashMap<>();
		map.put("1", new Product("AD123","Earphone",1200.00));
		map.put("2", new Product("AD435","Laptop Bag",560.00));
		map.put("3", new Product("AD998","Mobile Cover",250.00));
		map.put("4", new Product("AD058","Ipad",37000.00));
	}
	
	public ResponseEntity<Product> getProduct(String id) {
		return new ResponseEntity<>(map.get(id),HttpStatus.OK);
	}

	public ResponseEntity<Product> saveProduct(ProductDTO productDTO) {
		int keyVal = 5;
		String productID = ProductService.createID();
		map.put("5",new Product(productID, productDTO.getName(),productDTO.getPrice()));
		return ResponseEntity.ok(map.get(String.valueOf(keyVal)));
	}

	private static String createID() {
		return "AD"+Math.round(Math.random()*100);
	}
	
	

}
