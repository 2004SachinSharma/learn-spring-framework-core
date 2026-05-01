package com.sachin.Wiring.Auto_Wiring;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

public class AutoWiringWithQualifierAnnot {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ProjectConfig.class);

       NoodlesShop shop =  context.getBean(NoodlesShop.class);
       Noodles noodle = shop.getNoodle();
       noodle.noodleName();
       noodle.noodlePrice();





    }
}
