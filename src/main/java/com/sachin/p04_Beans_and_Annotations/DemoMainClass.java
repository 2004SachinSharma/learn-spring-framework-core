package com.sachin.p04_Beans_and_Annotations;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DemoMainClass {
    public static void main(String[] args) {

        Vehicle vehicle = new Vehicle();
        vehicle.setVehicle_name("Audi");
        System.out.println("Doing manual DI: " + vehicle.getVehicle_name());

        ApplicationContext context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        Vehicle veh = context.getBean(Vehicle.class);
        System.out.println("From the Application context, DI via IoC container: " + veh.getVehicle_name());




    }
}
