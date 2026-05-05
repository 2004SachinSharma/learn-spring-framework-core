package com.sachin.p15_EagervsLazyLoadingOfBeans;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
//By default, in Spring the Beans are Eager loading
//Only applicable for Singleton Beans not Protypes

/**
 * Eager (Default): Jaise hi ApplicationContext start hota hai, Spring saare Singleton beans ko
 * turant "paida" (instantiate) kar deta hai. Isliye constructor turant chalta hai.

 Kyunki beans pehle se ready hain, jab user request aati hai toh response fast milta hai
 kyunki bean creation mein time waste nahi hota.

 * Lazy (@Lazy): Bean tab tak "so rahi" hoti hai jab tak tum use pehli baar request na karo
 * (context.getBean() ya kisi dusri bean mein @Autowired ke zariye).*/
public class Demo {

    Demo(){
    System.out.println("Demo Class loaded Eagerly, right after the start of ApplicationContext...");
 }
}
//Generally Default Eager is used.

//Now by def as soon we will run the IoC container or the context, this class
//will be loaded as the constructor will print the given log on the console.

//This "as-soon-as" behaviour is that eager loading here.
//But in lazy loading the class will only be loaded when it's asked from the IoC
//to provide the Bean of that class. using context.getBean("bean_id").

//we can see this in action just by using the @Lazy annotation
@Component
@Lazy
class Demo2{
    Demo2(){
        System.out.println("Demo2 Class loaded Lazily, when IoC is asked to getBean of Demo2...");
    }
}

