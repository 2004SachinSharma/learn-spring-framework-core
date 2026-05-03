package com.sachin.p13_BeanRegistrar_autoBeanRegistry.Config;

import com.sachin.p13_BeanRegistrar_autoBeanRegistry.Bike;
import com.sachin.p13_BeanRegistrar_autoBeanRegistry.Engine;
import com.sachin.p13_BeanRegistrar_autoBeanRegistry.Vehicle;
import org.springframework.beans.factory.BeanRegistrar;
import org.springframework.core.env.Environment;

import java.util.Random;

public class BeanRegistry implements BeanRegistrar {
    @Override
    public void register(org.springframework.beans.factory.BeanRegistry registry, Environment env) {


        System.out.println("It should generate the (Engine+Vehicle) on EVEN\n and on ODD it should generate the (Engine+Bike) bean");

        int random = new Random().nextInt(50); //Remember it's the same form as the Random  r = new Random(); int random = r.nextInt(50);


        // Registers beans conditionally based on random parity

        if (random % 2 == 0) {
            System.out.println("EVEN CONDITION" + random);

            registry.registerBean("engine", Engine.class);
            registry.registerBean("vehicle", Vehicle.class, (spec) -> spec.supplier(
                    context -> {
                        Vehicle vehicle = new Vehicle(context.bean(Engine.class));
                        vehicle.setVehicleName("Mercedes Benz");
                        return vehicle;
                    })
            );
            System.out.println("Registered ENGINE & VEHICLE bean");

        } else {
            System.out.println("ODD CONDITION" + random);

            registry.registerBean(Engine.class);
            registry.registerBean("bike", Bike.class, spec -> spec.supplier( //See I have given the name here, explicitly
//                    because the by-default behaviour of the registryBean(...){...} is to register the bean, by its
//                    full class name that includes the full path + class's actual name, so in the main() method when we do,
//                    context.getBean("bike") or for vehicle bean, or for engine bean, the IoC actually could not find the vehicle or engine, because there is no any bean
//                    with the name bike, vehicle, or engine, but its (full_class_path+actual name)...That's why we get the runtime
//                    exception as NoSuchBeanDefinitionException...

//                    On explicitly specifying the name, the old name that is "full path +class name" is actually gets overridden by this new name.

//                    And yes! you know this very well that in the case of the @Bean or any Stereotype annotation the Bean created is actually of the actual class name i.e. vehicle for Vehicle,engine for Engine,
//                    bike for Bike.

//                    Bye!!

                    supplierContext -> {

                        Bike bike = new Bike(supplierContext.bean(Engine.class));
                        bike.setBikeName("Hayabusa");
                        return bike;

                    }
            ));

            System.out.println("Registered ENGINE & BIKE bean");

        }
    }
}