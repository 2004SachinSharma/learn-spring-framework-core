package com.sachin.p10_multiple_Config_Files;

import org.springframework.context.annotation.Bean;

public class ProjectConfigB {

    @Bean
    String configFileVersion3()
    {
        return "Its's B config file";
    }

    @Bean
    String giveGreetings(){
        return "BEST OF LUCK";
    }

}
