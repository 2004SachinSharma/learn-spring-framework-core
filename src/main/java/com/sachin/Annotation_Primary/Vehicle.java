package com.sachin.Annotation_Primary;

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