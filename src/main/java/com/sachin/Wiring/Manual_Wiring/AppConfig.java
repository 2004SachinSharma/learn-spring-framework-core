package com.sachin.Wiring.Manual_Wiring;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


//The below two approaches Manual and Automatic wiring, Below are two manual wiring approaches.And Automatic approach is also there the
/** @Autowiring : This annotation helps in automatic wiring of the dependencies"*/

@Configuration
public class AppConfig {

    // Common bean
    @Bean
   public Engine engine(){
        return new Engine();
    }

    // 🔹 1. Method-based injection (calling method)
    @Bean
    public Car carMethodBased(){
        Car car = new Car();
        car.setEngine(engine()); //it can be called as Setter Injection too. Here we can see,
//    manually we are wiring the dependency by passing engine() to setter
        return car;
    }

    // 🔹 2. Method-parameter injection (recommended)
    @Bean
    public Car carParameterBased(Engine engine) {
        Car car = new Car();
        car.setEngine(engine); // injected by Spring //here no need to put @Autowiring
        // on the method or Object ref, it's managed automatically because of @Confuguration proxy.

        //But again, Here we can see: not fully manually but still we are doing some
        //task manually. Autowiring upto the method is automatically happening still we have
//        to pass the bean/object to the class using setter, and class is then utilizing it

        //But the magic comes with the @Autowiring where no need to do anything manually just put Autowiring inside the class itself
        return car;
    }
}
