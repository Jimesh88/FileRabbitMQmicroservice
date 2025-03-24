package com.consumer.consumer_service.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;


@Service
public class RabbitMQConsumer {

    private final DataService dataService;

    public RabbitMQConsumer(DataService dataService) {
        this.dataService = dataService;
    }


    @RabbitListener(queues = "fileQueue")
    public void receiveMessage(String message) {
        // Process and store the data
        System.out.println(message);
            dataService.saveData(message);


    }
}