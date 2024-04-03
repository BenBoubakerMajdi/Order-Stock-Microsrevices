package com.MicroServices.StockService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;


@SpringBootApplication
@EntityScan("com.MicroServices.StockService")
public class StockServiceApplication {

	public static void main(String[] args) {
		System.setProperty("server.port", "1111");
		SpringApplication.run(StockServiceApplication.class, args);
	}
}
