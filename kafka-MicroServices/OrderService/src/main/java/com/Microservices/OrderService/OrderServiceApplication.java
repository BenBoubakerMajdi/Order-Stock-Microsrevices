package com.Microservices.OrderService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OrderServiceApplication {

	public static void main(String[] args) {
		System.setProperty("server.port", "9090");
		SpringApplication.run(OrderServiceApplication.class, args);
	}

}
