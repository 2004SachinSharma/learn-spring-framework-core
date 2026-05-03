package com.sachin.p10_multiple_Config_Files;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Primary;

@Configuration
@Import({ProjectConfigA.class, ProjectConfigB.class})

public class ProjectConfig {

    @Bean
    @Primary
    String configFileVersion() {
        return "Its's Main config file";
    }

    @Bean
    Integer luckNumber() {
        return 7;
    }

}
