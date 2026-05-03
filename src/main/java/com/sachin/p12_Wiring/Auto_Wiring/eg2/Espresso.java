package com.sachin.p12_Wiring.Auto_Wiring.eg2;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary //Inside the CoffeShop the checked exception was rising on, due to the same type of the dependency
 /** {Espresso class} and {cappuccino class} have the same type,which is the Interface {@Coffee}*/

 /**so {@Primary} annotation is used here to avoid the ambuiguity by making one choice as the default to use in condition of ambuiguity*/

class Espresso implements Coffee {

    @Override
    public void coffeeName() {
        System.out.println("Espresso");
    }
    @Override
    public void coffeePrice() {
        System.out.println("340 Rs.");
    }
}
