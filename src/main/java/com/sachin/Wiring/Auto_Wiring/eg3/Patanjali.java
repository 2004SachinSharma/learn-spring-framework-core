package com.sachin.Wiring.Auto_Wiring;

import org.springframework.context.annotation.Configuration;
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
