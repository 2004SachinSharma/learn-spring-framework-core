package com.sachin.p06_Beans_and_Annotations3;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.sachin.p06_Beans_and_Annotations3") // Spring ki aankhein—yahan beans dhundo.
public class ProjectConfig {
    @Bean
    Message sendAcknowledgement() {
        return new SendSMS(); // Manual plugging: Message = SendSMS.
    }
}