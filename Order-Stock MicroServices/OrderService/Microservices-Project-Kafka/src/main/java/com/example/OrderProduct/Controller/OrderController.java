package com.example.OrderProduct.Controller;

import com.example.OrderProduct.Model.Order;
import com.example.OrderProduct.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/order")
public class OrderController {
    @Autowired
    OrderService orderService;
//    @Autowired
    //KafkaProducerController kafkaProducerController;
    @PostMapping("/save")
    public ResponseEntity<String> addOrder(@RequestBody Order order) {
        orderService.addNewOrder(order);
        return ResponseEntity.ok("Order added successfully");
        //kafkaProducerController.sendMessage(order.toString());
    }
}
