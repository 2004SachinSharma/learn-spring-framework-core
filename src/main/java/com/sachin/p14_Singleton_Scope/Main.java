package com.sachin.p14_Singleton_Scope;

import com.sachin.p05_Beans_and_Annotations2.config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    /**
     * Demonstrates singleton scope sharing beans within context but not across contexts
     */
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Bank.class);
        ApplicationContext context1 = new AnnotationConfigApplicationContext(Bank.class);

        Bank b1 = context.getBean(Bank.class); //same obj
        Bank b2 = context.getBean(Bank.class); //same obj
        Bank b3 = context1.getBean(Bank.class); //different obj

        System.out.println(b1 == b2);
        System.out.println(b1 == b3);

        String name= b1.getBankName();
        System.out.println(name);

        System.out.println("b1 ----------------------------------------------");
        System.out.println(b1.getClass().getName());
        System.out.println(b1.hashCode());

        System.out.println("b2 ----------------------------------------------");
        System.out.println(b2.getClass().getName());
        System.out.println(b2.hashCode());

        System.out.println("b3 ----------------------------------------------");
        System.out.println(b3.getClass().getName());
        System.out.println(b3.hashCode());
    }
}
