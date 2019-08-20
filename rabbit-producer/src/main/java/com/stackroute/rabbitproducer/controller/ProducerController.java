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

    public ProducerController()
    {
    }
//Adding dependencies of RabbitMqSender
    @Autowired
    public ProducerController(RabbitMqSender rabbitMQSender) {
        this.rabbitMQSender = rabbitMQSender;
    }
//localhost:8001/producer
    @GetMapping(value = "/producer")
    //parsing values in the key and name in the postman
    public String producer(@RequestParam("empName") String empName, @RequestParam("empId") String empId) {
//setting the empId and empName
        ProducerEmployee producerEmployee = new ProducerEmployee();
        producerEmployee.setEmpId(empId);
        producerEmployee.setEmpName(empName);
        //send the empId and empName to the producerEmployee
        rabbitMQSender.send(producerEmployee);
//The message is displayed in the terminal and postman after passing the empid and empname
        return "Message sent to the RabbitMQ JavaInUse Successfully";
    }
}
