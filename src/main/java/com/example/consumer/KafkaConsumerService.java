package com.example.consumer;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
public class KafkaConsumerService {

    private static final Logger log= LoggerFactory.getLogger(KafkaConsumerService.class);
    private final OrderRepository orderRepository;

    @Autowired
    public KafkaConsumerService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @KafkaListener(topics ="test-topic",groupId = "test-group")
    public void consume(Order order){
        try{
            log.info("Received from Kafka : {}",order.getId());

            order.setProcess_date(LocalDateTime.now());
            order.setTotal_price(order.getQuantity()* order.getPrice());

            orderRepository.save(order);

            log.info("order saved to DataBase : {}",order.getId());
        } catch (Exception e) {
            log.error("Error processing order : {}",order.getId(),e);
        }
    }
}
