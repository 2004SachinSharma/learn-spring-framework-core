package com.sachin.Beans_and_Annotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
public class Aclass {

@Bean
    Object myname(){
        System.out.println("My name is Sachin!");
}


    @Bean
    public Aclass takeObject(){
        return new Aclass();
    }

}
