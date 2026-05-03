package com.sachin.p12_Wiring.Auto_Wiring.eg3;

import org.springframework.stereotype.Component;

@Component("maggi")//Bean gets registered with the same name as class but in lowercase
public class Maggi implements Noodles {

    int id ;

    void setId(int id ){
        this.id = id;
    }

    @Override
    public void noodleName() {
        System.out.println("Maggi");
        System.out.println(id);
    }

    @Override
    public void noodlePrice() {
        System.out.println("15 Rs.");
    }
}
