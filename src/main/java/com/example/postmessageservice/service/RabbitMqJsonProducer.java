package com.example.postmessageservice.service;

import com.example.postmessageservice.dto.MessageDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMqJsonProducer {

    @Value("${rabbitmq.exchange.name}")
    private String exchange;

    @Value("${rabbitmq.routing.jason.key}")
    private String routingJsonKey;

    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMqJsonProducer.class);

    private RabbitTemplate rabbitTemplate;

    public RabbitMqJsonProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendJsonMessage(MessageDTO message) {
        LOGGER.info(String.format("Sending Json message: %s", message.toString()));
        rabbitTemplate.convertAndSend(exchange, routingJsonKey, message);
    }
}
