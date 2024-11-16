package com.saiteja.spring_jwt.service;

import com.saiteja.spring_jwt.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
public class KafkaMessagePublisher {

    // Only need this one KafkaTemplate for sending User objects and Strings
    private final KafkaTemplate<String, Object> kafkaTemplate;

    /**
     * Method to send a generic message (String) to Kafka topic.
     *
     * @param message The string message to be sent
     */
    public void messageSendToTopic(String message) {
        CompletableFuture<SendResult<String, Object>> future = kafkaTemplate.send("spring-jwt", message);

        future.whenComplete((result, ex) -> {
            if (ex == null) {
                System.out.println("Sent message=[" + message +
                        "] with offset=[" + result.getRecordMetadata().offset() + "]");
            } else {
                System.out.println("Unable to send message=[" +
                        message + "] due to : " + ex.getMessage());
            }
        });
    }

    /**
     * Method to send a User object to Kafka topic.
     *
     * @param user The user object to be sent
     */
    public void sendUserToTopic(User user) {
        CompletableFuture<SendResult<String, Object>> future = kafkaTemplate.send("spring-jwt", user);

        future.whenComplete((result, ex) -> {
            if (ex == null) {
                System.out.println("Sent User=[" + user +
                        "] with offset=[" + result.getRecordMetadata().offset() + "]");
            } else {
                System.out.println("Unable to send User=[" + user + "] due to: " + ex.getMessage());
            }
        });
    }
}
