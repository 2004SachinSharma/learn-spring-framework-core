package com.sachin.p12_Wiring.Auto_Wiring.eg1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        System.out.println("From the Engine Bean/class");

//        Engine engine = context.getBean(Engine.class);
//        System.out.println(engine.getEngineName());

        System.out.println("From the Car Bean/class");
        Car car =  context.getBean(Car.class);
        System.out.println(car.getCarEngine());




    }
}
