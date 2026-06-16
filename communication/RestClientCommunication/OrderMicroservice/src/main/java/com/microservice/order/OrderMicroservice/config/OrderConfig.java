package com.microservice.order.OrderMicroservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class OrderConfig {
	
	@Bean
	public RestClient getObject() {
		return RestClient.create();
	}
	
//	@Bean
//	public RestClient getObject2() {
//		return RestClient.builder().build();
//	}

}
