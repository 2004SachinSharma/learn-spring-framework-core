package com.sachin.Beans_and_Annotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ComponentScan(value = "com.sachin.Beans_and_Annotations")
public class ProjectConfig {

    @Bean
    Vehicle vehicle(){
        var vehicle =  new Vehicle();
        vehicle.setVehicle_name("Tesla");
        return vehicle;
    }

    @Bean
    Integer myLuckyNumber(){

        return 7;
    }

    @Bean
    String myName(){

        return "Sachin Sharma";
    }

}
