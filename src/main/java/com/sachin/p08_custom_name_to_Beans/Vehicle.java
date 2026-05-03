package com.sachin.p08_custom_name_to_Beans;

import org.springframework.stereotype.Component;

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