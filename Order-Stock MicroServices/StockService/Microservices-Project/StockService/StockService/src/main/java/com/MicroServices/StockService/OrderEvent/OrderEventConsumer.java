package com.MicroServices.StockService.OrderEvent;

import com.MicroServices.StockService.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class OrderEventConsumer {

    private final StockService stockService;

    @Autowired
    public OrderEventConsumer(StockService stockService) {
        this.stockService = stockService;
    }

    @KafkaListener(topics = "order-events", groupId = "stock-service")
    public void consumeOrderEvent(OrderEvent orderEvent) {
        // Execute removeQuantityFromStock function
        try {
            stockService.removeQuantityFromStock(orderEvent.getIdProd(), orderEvent.getQuantity());
            System.out.println("Quantity removed from stock successfully for productId: " + orderEvent.getIdProd());
        } catch (IllegalArgumentException e) {
            System.out.println("Error removing quantity from stock for productId: " + orderEvent.getIdProd() + ". Reason: " + e.getMessage());
        }
    }
}

