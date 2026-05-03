package com.sachin.p12_Wiring.Auto_Wiring.eg2;

import org.springframework.stereotype.Component;

@Component
class Cappuccino implements Coffee {

    @Override
    public void coffeeName() {
        System.out.println("Cappucino");
    }
    @Override
    public void coffeePrice() {
        System.out.println("300 Rs.");
    }
}
