package com.sachin.p12_Wiring.Auto_Wiring.eg2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AutoWiringWithPrimaryAnnot {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ProjectConfig.class);

      CoffeeShop shop = context.getBean(CoffeeShop.class);
      shop.coffeePrice();
      shop.purchaseCoffee();

    }
}









