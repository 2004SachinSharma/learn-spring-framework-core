package com.sachin.p09_Annotation_Primary;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;


@Configuration
public class ProjectConfig {

    @Bean("myvehicle1")
    Vehicle vehicle1() {
        Vehicle v =  new Vehicle();
        v.setName("Audi");
        return v;
    }

    @Bean("myvehicle2")
    Vehicle vehicle2() {
        Vehicle v =  new Vehicle();
        v.setName("Ferrari");
        return v;
    }

    @Bean
    @Primary
    Vehicle vehicle3() {
        Vehicle v =  new Vehicle();
        v.setName("Jaguar");
        return v;
    }
}