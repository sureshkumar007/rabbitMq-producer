package com.stackroute.rabbitproducer.controller;

import com.stackroute.rabbitproducer.domain.ProducerEmployee;
import com.stackroute.rabbitproducer.service.RabbitMqSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/v1")
public class ProducerController {
    private RabbitMqSender rabbitMQSender;

    public ProducerController() {
    }
//Adding dependencies of RabbitMqSender
    @Autowired
    public ProducerController(RabbitMqSender rabbitMQSender) {
        this.rabbitMQSender = rabbitMQSender;
    }

    @GetMapping(value = "/producer")
    public String producer(@RequestParam("empName") String empName, @RequestParam("empId") String empId) {

        ProducerEmployee producerEmployee = new ProducerEmployee();
        producerEmployee.setEmpId(empId);
        producerEmployee.setEmpName(empName);
        rabbitMQSender.send(producerEmployee);

        return "Message sent to the RabbitMQ JavaInUse Successfully";
    }
}
