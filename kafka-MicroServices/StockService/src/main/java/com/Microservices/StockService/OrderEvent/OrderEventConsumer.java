package com.Microservices.StockService.OrderEvent;

import com.Microservices.StockService.Service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class OrderEventConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderEventConsumer.class);
    private final StockService stockService;

    @Autowired
    public OrderEventConsumer(StockService stockService) {
        this.stockService = stockService;
    }

    @KafkaListener(topics = "${spring.kafka.topic.name}", groupId = "${spring.kafka.consumer.group-id}")
    public void consumeOrderEvent(OrderEvent orderEvent) {
        LOGGER.info("Order event received in stock service => {}", orderEvent.toString());
        try {
            stockService.removeQuantityFromStock(orderEvent.getIdProd(), orderEvent.getQuantity());
            LOGGER.info("Quantity removed from stock successfully for productId: {}", orderEvent.getIdProd());
        } catch (IllegalArgumentException e) {
            LOGGER.error("Error removing quantity from stock for productId: {}. Reason: {}", orderEvent.getIdProd(), e.getMessage());
        } catch (Exception e) {
            LOGGER.error("An unexpected error occurred while removing quantity from stock for productId: {}", orderEvent.getIdProd(), e);
        }
    }
}
