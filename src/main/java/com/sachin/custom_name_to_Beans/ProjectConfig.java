package com.sachin.custom_name_to_Beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;

/**
 * @Configuration: Marks this class as a source of bean definitions.
 * Spring IoC container will process this class to generate BeanDefinitions.
 */
@Configuration
public class ProjectConfig {

    /*
     * 1. EXPLICIT NAMING (name parameter)
     * When you use the 'name' attribute, the method name 'vehicle1' is ignored.
     * The bean is registered in the context with the ID "mycustomVehicle1".
     */
    @Bean(name = "mycustomVehicle1")
    Vehicle vehicle1() {
        Vehicle v =  new Vehicle();
        v.setName("Audi");
        return v;
    }

    /*
     * 2. ALIASING VIA 'VALUE' & METADATA
     * 'value' is an alias for 'name' in the @Bean annotation; they work identically.
     * @Description: Purely for documentation. It’s useful when inspecting the
     * BeanFactory programmatically or using Spring JMX/Monitoring tools.
     */
    @Bean(value = "myVehicle2")
    @Description("Represents a bean of type Vehicle named Ferrari")
    Vehicle vehicle2() {
        Vehicle v =  new Vehicle();
        v.setName("Ferrari");
        return v;
    }

    /*
     * 3. SHORT-HAND EXPLICIT NAMING
     * Passing a String directly to @Bean is the same as @Bean(name="...").
     * This is the most common way developers set custom IDs for brevity.
     */
    @Bean("mycustomBean3")
    Vehicle vehicle3() {
        Vehicle v =  new Vehicle();
        v.setName("Jaguar");
        return v;
    }

    /*
     * 4. DEFAULT BEAN NAMING
     * If no name/value is provided, Spring uses the method name as the Bean ID.
     * Here, the bean name will be exactly "vehicle4".
     */
    @Bean
    Vehicle vehicle4() {
        Vehicle v =  new Vehicle();
        v.setName("Fortuner");
        return v;
    }

    /*
     * 5. MULTIPLE ALIASING (The "Nickname" Concept)
     * By passing a String array, you register one bean instance with multiple keys.
     * context.getBean("sachinKiBike") and context.getBean("myCar") will return
     * the EXACT SAME object reference (Singleton).
     *Multiple Aliasing allows different parts of a system (old code, new code, or third-party libraries) to find the same object using different names they already expect.
     */
    @Bean(name = {"sachinKiBike", "myCar", "heroVehicle"})
    public Vehicle vehicle5() {
        Vehicle v =  new Vehicle();
        v.setName("Range-Rover");
        return v;
    }
}