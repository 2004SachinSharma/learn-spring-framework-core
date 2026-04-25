package com.sachin.Beans_and_Annotations3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    private static UserManager u;

    /**
     * Initializes Spring context; retrieves bank bean; executes deposit withdrawal balance operations
     */
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ProjectConfig.class);
             u = context.getBean(UserManager.class);
             u.depositMoney(1000000);
             u.withdrawMoney(12000);
             u.getTotalBalance();
             u.depositMoney(1320000);
             u.withdrawMoney(1408000);

    }
}
