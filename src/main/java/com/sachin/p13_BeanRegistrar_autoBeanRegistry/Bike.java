package com.sachin.p13_BeanRegistrar_autoBeanRegistry;

public class Bike {
    private final Engine engine;
    private String bikeName;
   public Bike(Engine engine){
        this.engine = engine;

    }
    public void setBikeName(String bikeName) {
       this.bikeName = bikeName;

    }
    public String getBikeName(){
       return bikeName;
    }

}
