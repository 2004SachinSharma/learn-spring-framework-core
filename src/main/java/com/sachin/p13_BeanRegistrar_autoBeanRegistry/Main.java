package com.sachin.p13_BeanRegistrar_autoBeanRegistry;

import com.sachin.p13_BeanRegistrar_autoBeanRegistry.Config.ProjectConfig;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    /**
     * Creates context; checks and retrieves beans; handles exceptions
     */
    public static void main(String[] args) {
      AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        System.out.println("Start...");
        System.out.println(context.containsBean("bike")); //Explicit name dene ke baad, ab sahi kaam karega ye and will not always keep returning false.

      if(context.containsBean("vehicle")){ //This conditional is mandatory here to use, as there is some particular environment/condition where the Bean is expected to be
//          created, as the whole purpose of the BeanRegistry is this only.
//          so what when the JVM come to this line, but on that instant there is no any Bean like "vehicle", it is about to be created in future on some env/condition
//            Eventually we will run into the NoSuchBeanDefinitionException

//          Bye!!

      Vehicle v = context.getBean(Vehicle.class);
              v.getVehicleName();
              v.getEngineName();
          System.out.println("FIRST BEAN...");

      }


        if (context.containsBean("bike")) {
            Bike bike = context.getBean(Bike.class);
            String bikeName = bike.getBikeName();
            System.out.println(bikeName );
            System.out.println("SECOND BEAN...");

        }

        System.out.println("END...");

    }

}
