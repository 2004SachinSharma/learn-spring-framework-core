package com.sachin.p09_Annotation_Primary;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

public class ProjectConfig2 {
    /**
     * SAME NAME BEAN (commonBean)
     */
    @Bean("commonBean")
    @Primary //watch it failing to fill its job, because of the same name beans it finds
    String bean1() {
        return "Main Config Bean";
    }

    /**
     * INTEGER BEAN (NOT PRIMARY)
     */
    @Bean
    Integer num1() {
        return 10;
    }
}
