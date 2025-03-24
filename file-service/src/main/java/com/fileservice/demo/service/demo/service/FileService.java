package com.fileservice.demo.service.demo.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@Service
public class FileService {

    private final RabbitTemplate rabbitTemplate;

    public FileService(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void readFileAndSendToQueue(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Send each line to RabbitMQ
                rabbitTemplate.convertAndSend("fileQueue", line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}