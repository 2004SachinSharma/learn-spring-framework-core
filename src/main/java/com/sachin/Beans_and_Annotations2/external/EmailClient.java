package com.sachin.Beans_and_Annotations2.external;

import org.springframework.stereotype.Component;

//@Component //agar koi annotation use karo bean banane ke liye toh config file me @Bean na use karna on method returning the object of this class type
//I can either use @Component annotation here or in the config file the @Bean annotation there, but not both, ambiguity(confusion to Spring IoC container, both are same which one to pick) would occur

//This applies to all classes

//Though for all classes it applies, But I have intentionally not used any Stereotype annotation like @Service or @Component etc, because this is the external class, and as an standard practice such class shouldn't be annotated stereotiply
//but @Bean in a config file, as they might or definitely need to have some custom-logic, that would be configured in the configuration file only


public class EmailClient {

    private String host;

    public EmailClient(String host) {
        this.host = host;
    }

    public void sendEmail(String message) {
        System.out.println("Email sent via " + host + ": " + message);
    }
}
