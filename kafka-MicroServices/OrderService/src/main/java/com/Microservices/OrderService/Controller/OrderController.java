package com.Microservices.OrderService.Controller;

import com.Microservices.OrderService.Model.Order;
import com.Microservices.OrderService.OrderEvent.OrderEvent;
import com.Microservices.OrderService.OrderEvent.OrderEventProducer;
import com.Microservices.OrderService.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/order")
public class OrderController {
    @Autowired
    OrderService orderService;

    @Autowired
    OrderEventProducer orderEventProducer;

    @PostMapping("/save")
    public ResponseEntity<String> addOrder(@RequestBody Order order) {
        orderService.addNewOrder(order);
        OrderEvent orderEvent = new OrderEvent(order.getId_prod(), order.getQuantity());
        orderEventProducer.sendOrderEvent(orderEvent);

        return ResponseEntity.ok("Order added successfully");

    }
}
