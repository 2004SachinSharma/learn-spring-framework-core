package com.sachin.p12_Wiring.Auto_Wiring.eg3;

import org.springframework.stereotype.Component;

@Component
public class Patanjali implements Noodles {
    @Override
    public void noodleName() {
        System.out.println("Patanjali");
    }

    @Override
    public void noodlePrice() {
        System.out.println("10 Rs.");
    }
}
