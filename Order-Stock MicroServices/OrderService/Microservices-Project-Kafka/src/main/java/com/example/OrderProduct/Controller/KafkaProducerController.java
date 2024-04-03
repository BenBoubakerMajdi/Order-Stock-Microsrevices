//package com.example.OrderProduct.Controller;
//
//import org.apache.kafka.clients.producer.ProducerRecord;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class KafkaProducerController {
//    private final KafkaTemplate<String, String> kafkaTemplate;
//    private static final String TOPIC_NAME = "new-order"; // Replace "new-order" with your Kafka topic name
//
//    @Autowired
//    public KafkaProducerController(KafkaTemplate<String, String> kafkaTemplate) {
//        this.kafkaTemplate = kafkaTemplate;
//    }
//
//    @PostMapping("/send-message")
//    public String sendMessage(@RequestBody String msg) {
//        try {
//            kafkaTemplate.send(new ProducerRecord<>(TOPIC_NAME, msg));
//            return "Message sent successfully!  ::" + msg;
//        } catch (Exception e) {
//            return "Error sending message: " + e.getMessage();
//        }
//    }
//}
