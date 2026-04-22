package com.sachin.Beans_and_Annotations2.config;

import com.sachin.Beans_and_Annotations2.external.EmailClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.sachin.Beans_and_Annotations2")
public class AppConfig {

    @Bean
    EmailClient emailClient(){
        return new EmailClient("smtp.gmail.com");
    }

}
