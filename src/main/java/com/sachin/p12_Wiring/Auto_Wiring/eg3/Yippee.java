package com.sachin.p12_Wiring.Auto_Wiring.eg3;


import org.springframework.stereotype.Component;

@Component
public class Yippee implements Noodles {
    @Override
    public void noodleName() {
        System.out.println("Yippee");
    }

    @Override
    public void noodlePrice() {
        System.out.println("20 Rs.");
    }
}
