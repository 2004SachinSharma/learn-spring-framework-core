package com.sachin.p11_Annotation_PostConstruct_and_PreDestroy;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main{
    public static void main(String[] args) {
        System.out.println("--- Starting Jakarta Context ---");

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("com.sachin.lifecycle"); // Scans for @Component classes
        context.refresh();

        System.out.println("Context is ready!");

        // CRITICAL: Must close context to see @PreDestroy
        context.close();
        System.out.println("--- Context Closed ---");
    }
}//Understand this the Jakarta @Post and @Pre annotations are the standard to use, as they are quick and easy to use, countering to the Spings long way of implementing and overriding the methods()

/*Can refer to the notes on page no. 48, 49, 50, 51 in the Udemy notes */

