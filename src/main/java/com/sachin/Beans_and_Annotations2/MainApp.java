package com.sachin.Beans_and_Annotations2;

import com.sachin.Beans_and_Annotations2.config.AppConfig;
import com.sachin.Beans_and_Annotations2.external.EmailClient;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        EmailClient ec =  context.getBean(EmailClient.class);
             ec.sendEmail("User you are credited with 1000000000000");
    }


}
