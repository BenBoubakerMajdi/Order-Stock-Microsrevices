package com.example.OrderProduct;

import com.example.OrderProduct.Model.Order;
import com.example.OrderProduct.Repository.OrderRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrderConfig {
    @Bean
    CommandLineRunner commandLineRunner(OrderRepository repository) {
        return args -> {
            Order o1 = new Order(
                    "1",
                    "1",
                    "2",
                    2);
            //repository.save(o1);
        };

    }

}

