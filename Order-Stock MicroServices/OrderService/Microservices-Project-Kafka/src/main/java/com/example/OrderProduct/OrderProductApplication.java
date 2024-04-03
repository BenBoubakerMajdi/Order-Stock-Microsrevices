package com.example.OrderProduct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OrderProductApplication {

	public static void main(String[] args) {
		System.setProperty("server.port", "1234");
		SpringApplication.run(OrderProductApplication.class, args);
	}
}
