package com.stackroute.rabbitproducer.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jdk.jfr.DataAmount;
import lombok.*;
import org.springframework.stereotype.Component;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id", scope = ProducerEmployee.class)
@Component
public class ProducerEmployee
{
    private String empName;
    private String empId;

    //**Getter and setter and constructions will be created by lombok
}
