package com.stackroute.rabbitproducer.service;

import com.stackroute.rabbitproducer.domain.ProducerEmployee;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMqSender
{
    //Advanced Message Queuing Protocol (AMQP)
    private RabbitTemplate amqpTemplate;

    public RabbitMqSender() {
    }
//Constructor AutoWiring
    @Autowired
    public RabbitMqSender(RabbitTemplate amqpTemplate)
    {
        this.amqpTemplate = amqpTemplate;
    }
//Exchange the data from two points
    @Value("${jsa.rabbitmq.exchange}")
    private String exchange;
//The exchange message should flow on the by using routing  key
    @Value("${jsa.rabbitmq.routingkey}")
    private String routingkey;
//The message is converted and send
    public void send(ProducerEmployee company)
    {
        amqpTemplate.convertAndSend(exchange, routingkey, company);
        System.out.println("Send msg = " + company);
    }

}
