package com.saiteja.spring_jwt.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaTopic {

    @Bean
    public NewTopic createTopic() {
        return new NewTopic("spring-jwt", 5, (short) 1);
    }

    @Bean
    public NewTopic userRegistrationTopic() {
        return new NewTopic("user-topic", 3, (short) 1);
    }
}
