package com.sachin.p07_Resolving_famous_Exception;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Configuration: Ye Spring ka manual "Menu Card" hai.
 */
@Configuration
public class ProjectConfig {

    /**
     * @Bean vehicle1, vehicle2, vehicle3:
     * Bhai, Spring ke IoC container mein ab teen alag-alag 'Vehicle' objects hain.
     * Jab tum context.getBean(Vehicle.class) karoge, toh Spring sochega:
     * "Mere paas toh 3 Vehicles hain (v1, v2, v3), main kaunsa wala doon?"
     * Kyuki IoC basically focuses on the type, like here three Objects of the Same type, now which one to call!!
     * Isi confusion ko Spring 'NoUniqueBeanDefinitionException' bolta hai.
     */

    @Bean
    Vehicle vehicle1() {
        Vehicle v =  new Vehicle();
        v.setName("Audi");
        return v;
    }

    @Bean
    Vehicle vehicle2() {
        Vehicle v =  new Vehicle();
        v.setName("Ferrari");
        return v;
    }

    @Bean
    Vehicle vehicle3() {
        Vehicle v =  new Vehicle();
        v.setName("Jaguar");
        return v;
    }
}