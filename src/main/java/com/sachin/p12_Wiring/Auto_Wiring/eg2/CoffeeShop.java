package com.sachin.p12_Wiring.Auto_Wiring.eg2;

import org.springframework.stereotype.Component;

@Component
class CoffeeShop {
    private final Coffee coffee;


    public CoffeeShop(Coffee coffee) {
        this.coffee = coffee;
    }

    void purchaseCoffee() {
        System.out.println("Purchased Coffee: ");
         coffee.coffeeName();
    }

    void coffeePrice(){
        System.out.println("CoffeePrice: ");
        coffee.coffeePrice();
    }

}
