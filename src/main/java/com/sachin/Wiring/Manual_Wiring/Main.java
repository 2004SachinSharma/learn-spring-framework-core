package com.sachin.Wiring.Manual_Wiring;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {

        ApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        Car car1 = context.getBean("carMethodBased", Car.class);
        car1.drive();

        Car car2 = context.getBean("carParameterBased", Car.class);
        car2.drive();
    }
}
