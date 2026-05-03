package com.sachin.p13_BeanRegistrar_autoBeanRegistry;

public class Vehicle {
    final private Engine engine;
    private  String name ;
    private  String engineName ;

    public Vehicle(Engine engine) {
        this.engine = engine;
    }

   public void setVehicleName(String vehicle_name) {
        this.name = vehicle_name;
    }

   public void getVehicleName(){
        System.out.println(name);
    }

   public  void setEngineName() {
        this.engineName = engine.engineName;
    }

   public void getEngineName(){
        System.out.println(engineName);
    }

}
