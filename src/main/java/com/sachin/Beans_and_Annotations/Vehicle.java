package com.sachin.Beans_and_Annotations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

public class Vehicle {

    private String vehicle_name ;

    void setVehicle_name(String vehicle_name){
        this.vehicle_name = vehicle_name;
    }

    String getVehicle_name(){
        return this.vehicle_name;
    }



}
