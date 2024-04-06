package com.Microservices.OrderService.OrderEvent;

import org.apache.kafka.clients.admin.NewTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.kafka.support.SendResult;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.messaging.Message;

import java.util.concurrent.CompletableFuture;


@Service
public class OrderEventProducer {

    private NewTopic topic;
    @Autowired
    private KafkaTemplate kafkaTemplate;

    @Autowired
    public OrderEventProducer(NewTopic topic, KafkaTemplate<String, OrderEvent> kafkaTemplate) {
        this.topic = topic;
        this.kafkaTemplate = kafkaTemplate;
    }
    public void sendOrderEvent(OrderEvent orderEvent) {

        CompletableFuture<SendResult<String, Object>> future = kafkaTemplate.send(topic.name(), orderEvent);
        future.whenComplete((result, exception)->{
            if(exception == null) {
                System.out.println("Order Sent: " + orderEvent.toString() +
                        "\nin Partition: " + result.getRecordMetadata().partition() +
                            "\nwith Offset: " + result.getRecordMetadata().offset() +
                                "\n---------------------------------------- ");
            } else {
                System.out.println("Order failed to be sent " + exception.getMessage());
            }
        });
    }
}
