package com.microservice.order.OrderMicroservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
public class OrderConfig {
	
	@Bean
	public RestTemplate getObject() {
		SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
		
		factory.setConnectTimeout(100);
		factory.setReadTimeout(500);
		
		return new RestTemplate();
	}
	
//	@Bean
//	public RestTemplate getObject2() {
//		return new RestTemplate();
//	}
}
