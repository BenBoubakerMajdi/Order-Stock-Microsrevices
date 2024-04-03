//package com.example.OrderProduct.Controller;
//
//import org.apache.kafka.clients.producer.ProducerRecord;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class KafkaProducerController
//{
//    private final KafkaTemplate<String, String> kafkaTemplate;
//    private static final String TOPIC_NAME = "new-order"; // Remplacez "my-topic" par le nom de votre topic Kafka
//
//    @Autowired
//    public KafkaProducerController(KafkaTemplate<String, String> kafkaTemplate) {
//        this.kafkaTemplate = kafkaTemplate;
//    }
//
//    @GetMapping("/send-message")
//    public String sendMessage(String msg) {
//        try {
//            //String message = "Hello Kafka!"; // Message à envoyer
//            kafkaTemplate.send(new ProducerRecord<>(TOPIC_NAME, msg));
//            return "Message sent successfully!  ::"+msg;
//        } catch (Exception e) {
//            return "Error sending message: " + e.getMessage();
//        }
//    }
//}
