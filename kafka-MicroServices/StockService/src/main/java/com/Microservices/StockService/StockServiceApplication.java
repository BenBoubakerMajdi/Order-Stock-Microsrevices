package com.Microservices.StockService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StockServiceApplication {

	public static void main(String[] args) {
		System.setProperty("server.port", "1234");
		SpringApplication.run(StockServiceApplication.class, args);
	}

}
