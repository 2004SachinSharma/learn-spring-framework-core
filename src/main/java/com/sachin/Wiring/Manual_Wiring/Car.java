package com.sachin.Wiring.Manual_Wiring;


public class Car {

    private Engine engine;

    // Setter (for method-based injection)
    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public void drive() {
        System.out.println(engine.start());
    }
}