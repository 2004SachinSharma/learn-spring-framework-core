package com.sachin.Annotation_PostConstruct_and_PreDestroy;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

    @Component
    public class JakartaLifecycleBean {
        public JakartaLifecycleBean() {
            System.out.println("1. Constructor: Jakarta Bean created");
        }

        @PostConstruct //Need to add jakarta.annotation dependency to get this annotation,
        public void init() {
            System.out.println("2. PostConstruct: Jakarta Bean initialization logic");
        }

        @PreDestroy //Need to add jakarta.annotation dependency to get this annotation,
        public void cleanup() {
            System.out.println("3. PreDestroy: Jakarta Bean cleaning up before death");
        }
    }

