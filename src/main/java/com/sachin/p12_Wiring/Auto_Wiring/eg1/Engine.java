package com.sachin.p12_Wiring.Auto_Wiring.eg1;

import jakarta.annotation.PostConstruct;

//@Component
public class Engine {
    private String engineName;

    @PostConstruct
    private void init() {
        this.engineName = "v8";
    }
   public String getEngineName() {
       return engineName;
   }
}
