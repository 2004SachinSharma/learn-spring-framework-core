package com.sachin.Resolving_famous_Exception;

import org.springframework.stereotype.Component;

/**
 * @Component: Bhai, yahan ek interesting point hai.
 * Tumne class par @Component lagaya hai, aur ProjectConfig mein @Bean bhi banaye hain.
 * Iska matlab Spring ke paas 'Vehicle' banane ke ab 4 raaste ho gaye hain!
 * (1 from @Component + 3 from @Bean in ProjectConfig).
 */
@Component
public class Vehicle {
    String name;

    void setName(String name){
        this.name = name ;
    }

    void getName(){
        System.out.println("Vehicle Name: " + name);
    }
}