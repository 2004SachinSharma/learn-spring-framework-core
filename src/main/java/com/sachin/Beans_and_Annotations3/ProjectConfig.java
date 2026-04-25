package com.sachin.Beans_and_Annotations3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.sachin.Beans_and_Annotations3")
public class ProjectConfig {

    @Bean
 Message sendAcknowledgement(){
        return new SendSMS();
    }





}
