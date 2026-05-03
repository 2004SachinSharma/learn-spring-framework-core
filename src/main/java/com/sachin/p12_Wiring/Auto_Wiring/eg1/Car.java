package com.sachin.p12_Wiring.Auto_Wiring.eg1;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Car {
// @Autowired If used this, it's called Field Injection
//    private Engine carEngine;
    private Engine carEngine;
    private String carEngineName;
    private String carName;

    //Look at one more thing that is:
    // Spring will try to find an Engine bean.
    //  If not found, The Exception would occur NoSuchBeanFoundException;
    //  Now if we want "ki yaar ye dependency(for eg Engine) mandatory nahi h agar aa jaye toh accha h na aaye toh bhi thik h, lekin iss(Car) class ka bean banna chahiye bina ruke
    //  " toh hum @Autowired(required = false) use kar lenge.
    //   wese @Autowired(required = true ) hota h by default.

//    Dekho agar maan lo Engine Bean nahi bana, koi bhi kaaran ho annotation nahi lagaya, ya Class hi nahi banayi etc reason,
//    lekin Car Class/Bean toh Engine Dependency use kar rahi h, toh ab kya hoga! Ab hoga crash, kyuki IoC ne dekha bhai Car ne Engine managa lekin wo toh h nahi
//    toh Exception aa jayegi ki NoSuchBeanFoundException. ab maan lo hamen kaha ki yaar Bhale Engine na ho lekin firr bhi Car ka Bean banna chahiye toh firr hum iss case me
//    kya krnege hum simply:
//
//    Field injection h toh:
//    @Autowired(required = false)
//    private Engine carEngine;
//
//    Setter injection h toh:
//
//    @Autowired(required = false)
//    void setCar(Engine engine) {
//        this.carEngine = engine;
//
//    }
//
//    Constructor Injection h toh:
//
//    @Autowired(required = false)
//    Car(Engine engine) {
//        this.carEngine = engine;
//    }
//    Now Spring will simply ignore the Engine dependency and continue creating bean for Car class.
//    But what of Engine? You may think now!!
//    Engine will be null instead of throwing an error.
    /*
    * Important Notes
Null Checks: If you use @Autowired(required = false), you must perform a null check before using the dependency to avoid a NullPointerException.
Constructor Injection: Note that required = false cannot be used easily with Constructor Injection if you only have one constructor (since the constructor must be called to create the object). It is most commonly used with Field or Setter injection.
Modern Alternative: In newer versions of Spring/Java, many developers prefer using Optional<T> (e.g., private Optional<Engine> engine) instead of required = false to make the code cleaner and avoid manual null checks.*/

    @PostConstruct
    public void init()
    {
        this.carName = "ToyotaHilux";
        if (carEngine != null) {
            this.carEngineName = carEngine.getEngineName();
        } else {
            this.carEngineName = "No engine available";
        }
    }

    @Autowired(required = false) //If used this, it's called Constructor Injection
     Car(Engine engine) {
        this.carEngine = engine;
    }
     Car(){

     }
/**
    {@code @Autowired //if used this, it's called Setter Injection
    void setCar(Engine engine) {
        this.carEngine = engine;
    }
    }
 */
    public String getCarEngine() {
        return "The Car Engine name is: "+ carEngineName;
    }

    public String getCarName() {
        return carName;
    }

}


//Constructor injection is considered the best practices, among the three types of the Dependency Injections
//As it mandates to pass the Dependency at the Compile-time check only, of the suitable type, less code, ease of testing etc

/**
 * In the video Autowiring Demo — Field vs Setter Injection, Madan sir highlights several key disadvantages of using Field or Setter injection instead of Constructor Injection.
 *
 * Here are the main points explained in "Hinglish":
 *
 * 1. Immutability Issue (Final Fields)
 * Agar aap Field Injection use karte hain, toh aap apne dependencies ko final declare nahi kar sakte. Constructor injection allow karta hai ki aap private final Engine engine; use karein. Isse ye ensure hota hai ki ek baar object ban gaya, toh uski dependency change nahi hogi (Immutable rahegi).
 *
 * Problem: Setter injection mein dependency ko object banne ke baad kabhi bhi change kiya ja sakta hai, jo safety ke liye thik nahi hai.
 *
 * 2. NullPointerException (Partial Initialization)
 * Setter injection ke saath, Spring aapka object toh bana deta hai par zaroori nahi ki saari dependencies usi waqt inject ho jayein.
 *
 * Problem: Agar aapne setEngine() call hone se pehle hi engine ko use karne ki koshish ki, toh aapko NullPointerException mil sakta hai. Constructor injection mein object tabhi banta hai jab saari dependencies available hon.
 *
 * 3. Unit Testing mein Dikkat
 * Field injection (@Autowired on field) testing ke waqt kaafi pareshani deti hai.
 *
 * Problem: Agar aap JUnit test likh rahe hain aur Spring container start nahi kar rahe, toh aap private fields mein dependencies manually "inject" nahi kar payenge bina Reflection use kiye. Constructor injection mein aap simply new Car(mockEngine) pass kar sakte hain.
 *
 * 4. Tight Coupling with Spring
 * Field injection aapke code ko Spring framework se bahut zyada "tightly couple" kar deta hai.
 *
 * Problem: Aapka POJO (Plain Old Java Object) bina Spring ke kaam nahi karega kyunki uske dependencies private fields mein chhupi hain. Constructor injection use karne se aapka class ek standard Java class ki tarah behave karta hai jise kahin bhi use kiya ja sakta hai.
 *
 * 5. Circular Dependency Hide Ho Jati Hai
 * Madan sir ne mention kiya hai ki Constructor injection circular dependencies ko startup time par hi pakad leta hai.
 *
 * Problem: Setter ya Field injection ke saath, Spring application start ho jayegi par runtime par jab wo beans ek doosre ko call karenge, tab issue create hoga, jo debug karna mushkil hota hai.
 *
 * Summary: Madan sir suggest karte hain ki Constructor Injection use karna "Best Practice" hai kyunki ye code ko robust, testable, aur thread-safe banata hai.*/