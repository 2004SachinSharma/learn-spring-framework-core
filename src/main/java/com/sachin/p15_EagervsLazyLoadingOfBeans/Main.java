package com.sachin.p15_EagervsLazyLoadingOfBeans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.lang.annotation.Annotation;

public class Main {
    public static void main(String[] args)
    {
        ApplicationContext context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        context.getBean("demo2");



    }
}
/**
 * Eager Initialization (Default)
 * Spring default mein saare Singleton beans ko application start hote waqt hi create kar deta hai.
 * Kyu use karein? (Reasons):
 * Early Error Detection: Agar bean creation mein koi issue hai (jaise missing dependency), toh application startup par hi crash ho jayegi. Isse runtime par surprises nahi milte.
 * Better Runtime Performance: Kyunki beans pehle se ready hain, jab user request aati hai toh response fast milta hai kyunki bean creation mein time waste nahi hota.
 * Commonly Used Beans: Jo beans poore app mein baar-baar use hone waale hain, unhe eager rakhna hi sahi hai.

 * Lazy Initialization (@Lazy)
 * Bean tabhi create hota hai jab use pehli baar access ya request kiya jata hai.
 * Kyu use karein? (Reasons):
 * Faster Startup Time: Agar aapke app mein 1000+ beans hain, toh eager startup bahut slow ho sakta hai. Lazy use karne se app jaldi start ho jata hai.
 * Memory Efficiency: Jo beans kabhi-kabhi ya bahut "remote scenarios" mein use hote hain, unhe startup par memory dena waste hai. Lazy initialization memory save karta hai.
 * Testing: Unit testing ke waqt aap sirf zaroori beans load karke time bacha sakte hain.*/

////Ecommerce ka case lelo, agar jese Item view karna, add to cart karna, buy now karna, ye saare frequent actions h, toh inhe eager rakhna chahiye
//while some actions like Account delete, Complaint, Order cancellation, Profile change, ye saare comparatively less frequent actions h
//so we can Lazyfy the loading of such Beans, to avoid Memory performance and a bit smooth performance of IoC eager bean loading