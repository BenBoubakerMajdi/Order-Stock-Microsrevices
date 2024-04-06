package com.Microservices.StockService.OrderEvent;

import com.Microservices.StockService.Service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class OrderEventConsumer {
    private final StockService stockService;

    @Autowired
    public OrderEventConsumer(StockService stockService) {
        this.stockService = stockService;
    }

    @KafkaListener(topics = "${spring.kafka.topic.name}", groupId = "${spring.kafka.consumer.group-id}")
    public void consumeOrderEvent(OrderEvent orderEvent) {
        System.out.println("\nOrder event received => " + orderEvent);
        try {
            stockService.removeQuantityFromStock(orderEvent.getIdProd(), orderEvent.getQuantity());
            System.out.println("==> Quantity removed from stock successfully for productId: " + orderEvent.getIdProd());
        } catch (IllegalArgumentException e) {
            System.out.printf("==> Error removing quantity from stock for productId: %s. Reason: %s", orderEvent.getIdProd(), e.getMessage());
        } catch (Exception e) {
            System.out.println("==> An unexpected error occurred while removing quantity from stock for productId: " + orderEvent.getIdProd() + e);
        }
    }
}
