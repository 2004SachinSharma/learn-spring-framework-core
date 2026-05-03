package com.sachin.p09_Annotation_Primary;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

public class ProjectConfigA {
    /**
     * SAME NAME BEAN AGAIN
     */
    @Bean("commonBean")
    String bean2() {
        return "ConfigA Bean";
    }

    /**
     * INTEGER BEAN (PRIMARY)
     */
    @Bean
    @Primary
    Integer num2() {
        return 99;
    }
}
