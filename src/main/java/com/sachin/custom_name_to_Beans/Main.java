package com.sachin.custom_name_to_Beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class Main {

    @Autowired
    Vehicle v;

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        Vehicle v1 = context.getBean("mycustomVehicle1", Vehicle.class); //See used my custom name provided to the Bean
        v1.getName();

        Vehicle v2 = context.getBean("myVehicle2", Vehicle.class);
        v2.getName();

        Vehicle v3 = (Vehicle) context.getBean("mycustomVehicle1");
        v3.getName();

        Vehicle v4 = (Vehicle) context.getBean("mycustomBean3");
        v4.getName();

        Vehicle v5 = (Vehicle) context.getBean("vehicle4");

        Vehicle v6 = (Vehicle) context.getBean("sachinKiBike");
        v6.getName();

        Vehicle v7 = (Vehicle) context.getBean("myCar");
        v7.getName();

        Vehicle v8 = (Vehicle) context.getBean("heroVehicle");
        v8.getName();


//        Vehicle v9 = (Vehicle) context.getBean("vehicle5");
//        v9.getName(); //Now method-name is invalid to provide to get the Bean




    }
}