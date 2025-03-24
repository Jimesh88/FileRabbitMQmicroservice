package com.fileservice.demo.service.demo.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Bean
    public Queue fileQueue() {
        return new Queue("fileQueue", true);
    }
}