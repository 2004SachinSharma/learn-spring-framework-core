package com.sachin.p07_Resolving_famous_Exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class NoUniqueBeanDefinitionException {

    /**
     * @Autowired:
     * Yahan Spring crash ho jayega (BeanCreationException).
     * Kyunki Spring ko pata hi nahi chal raha ki vehicle1, vehicle2 ya vehicle3
     * mein se kise yahan "Inject" (Plug) karna hai.
     */
    @Autowired
    Vehicle v;

    public static void main(String[] args) {
        // Step 1: Context load hua. ProjectConfig ke saare beans ban gaye.
        ApplicationContext context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        /**
         * Step 2: CRASH POINT!
         * context.getBean(Vehicle.class) bolne par Spring 'NoUniqueBeanDefinitionException' fekega.
         * Kyun? Kyunki "Vehicle" type ke multiple beans available hain.
         */


        //Uncomment this section to raise the exception
        /**
         *
         Vehicle v = context.getBean(Vehicle.class);
         v.setName("sa");
         v.getName();
         *
         */



        //let's talk of the solution

        /**
         *
         * Bhai, is Exception ko solve kaise karein?
         * Agar tum chahte ho ki code chale, toh tumhare paas 3 raaste hain:
         *
         *  @Primary Use Karo: Kisi ek @Bean par @Primary laga do. Spring hamesha wahi pick karega.
         *
         *  @Qualifier Use Karo: @Autowired ke saath @Qualifier("vehicle1") likho taaki Spring ko pata chale kaunsa wala uthana hai.
         *
         * Variable Name Match Karo: Agar tum variable ka naam @Bean method ke naam se match kar do (jaise Vehicle vehicle1), toh Spring naam ke basis par dhoond lega
         *
         * */

//        I am going to implement the 3rd solution among these mentioned

        Vehicle v2 = context.getBean("vehicle1", Vehicle.class); //By providing the method name too, along with the Type, now it has become clear to the IoC(App context) to use which object among 3 + 1 objects which are having the same type the 'Vehicle'
        v2.getName();

        Vehicle v3 = context.getBean("vehicle2", Vehicle.class); //By providing the method name too, along with the Type, now it has become clear to the IoC(App context) to use which object among 3 + 1 objects
        v3.getName();

        Vehicle v4 = context.getBean("vehicle3", Vehicle.class); //By providing the method name too, along with the Type, now it has become clear to the IoC(App context) to use which object among 3 + 1 objects
        v4.getName();

        //We can also just give the name only, no type then also it will work fine

        Vehicle v5 = (Vehicle) context.getBean("vehicle1");

    }
}