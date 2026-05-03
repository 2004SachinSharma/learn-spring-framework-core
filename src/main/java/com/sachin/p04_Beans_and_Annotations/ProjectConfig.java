package com.sachin.p04_Beans_and_Annotations;

import org.springframework.context.annotation.Bean;
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
