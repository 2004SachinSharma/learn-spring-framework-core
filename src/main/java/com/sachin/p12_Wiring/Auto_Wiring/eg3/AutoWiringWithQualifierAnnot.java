package com.sachin.p12_Wiring.Auto_Wiring.eg3;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AutoWiringWithQualifierAnnot {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ProjectConfig.class);

       NoodlesShop shop =  context.getBean(NoodlesShop.class);
       Noodles noodle = shop.getNoodle();
       noodle.noodleName();
       noodle.noodlePrice();





    }
}
