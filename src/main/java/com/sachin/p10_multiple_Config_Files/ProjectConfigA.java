package com.sachin.p10_multiple_Config_Files;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

import java.util.Date;

public class ProjectConfigA {

    @Bean()
    String configFileVersion2()
    {
        return "Its's A config file";
    }

    @Bean
    String sayHello(){
        return "Hello! :)";
    }

    @Bean
    @Primary
    Integer timeNow(){
        Date d= new Date();

        return Integer.valueOf((int) d.getTime());

    }


}
