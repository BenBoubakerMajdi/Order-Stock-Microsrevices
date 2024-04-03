//package com.example.OrderProduct.Controller;
//
//import com.example.OrderProduct.Model.Order;
//import org.apache.kafka.clients.consumer.ConsumerRecord;
//import org.springframework.kafka.annotation.KafkaListener;
//import org.springframework.stereotype.Component;
//
//@Component
//public class KafkaConsumerController {
//    private static final String TOPIC_NAME = "new-order";
//
//    @KafkaListener(topics = TOPIC_NAME, groupId = "my-group")
//    public void listen(ConsumerRecord<String, String> record) {
//        Order newOrder = new Order();
//        newOrder= Order.parse(record.value());
//        System.out.println("Received message:    "+ newOrder.getId_order());
//        System.out.println("Key: " + record.key());
//        System.out.println("Value: " + record.value());
//        System.out.println("Partition: " + record.partition());
//        System.out.println("Offset: " + record.offset());
//        System.out.println("----------------------");
//    }
//}
