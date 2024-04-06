package com.Microservices.OrderService.Service;

import com.Microservices.OrderService.Model.Order;
import com.Microservices.OrderService.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;
    public void addNewOrder(Order order){
        orderRepository.save(order);
    }
}
