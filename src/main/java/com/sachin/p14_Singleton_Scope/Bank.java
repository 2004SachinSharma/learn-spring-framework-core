package com.sachin.p14_Singleton_Scope;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@Scope(BeanDefinition.SCOPE_SINGLETON)//(Singleton by default)
//ab ek baar singleton karke output dekhan aur ek baar prototype banake, you will find the
// memory difference in the storage of two Beans/Objects
@ComponentScan("com.sachin.p14_Singleton_Scope")
//Here I have intentionally not created any Config file like we always do as ProjectConfig.java or AppConfig.java,
//just to tell that we can create and Component Scan the Beans without any Specific Configuration file as well.

public class Bank {
    HDFC hdfc;

    @Autowired
     Bank(HDFC hdfc) {
        this.hdfc = hdfc;
    }

    String getBankName(){
        return hdfc.bankName;
    }
}
/**
 * 📌 Singleton: Pattern vs Scope
 * 1. Singleton Pattern (The Class Lock)
 * Definition: Jab Class khud zimmedar hoti hai ki uska sirf ek hi object banega poore JVM mein.
 * Key Property: Private Constructor + Static Instance Variable.
 * Biggest Flaw: Rigid. Isse test karna aur badalna namumkin hai. Ye manual "Ziddi" approach hai.
 * 2. Singleton Scope (The Container Policy)
 * Definition: Ye Spring IoC Container ki setting hai. Class normal rehti hai, par Spring use "ek hi baar" create karke cache mein rakh leta hai.
 * Key Property: @Component (Default). Har baar wahi instance share hota hai.
 * Biggest Benefit: Flexible. Aap jab chahe scope badal kar "Prototype" kar sakte ho bina code chhede.
 * */

/**
 * 🚀 Direct Comparison (The "Dosh" Test)PointSingleton PatternSingleton ScopeKaun banata hai?Aapka Code (Manual)Spring Container (Automated)Kahan
 * tak limit hai?Poora JVM (Application Level)Sirf ApplicationContext level takFlexibilityZero (Locked)High (Configurable)TestingSir dard (Hard to mock)Makkhan (Easy to mock via DI)*/

//💡 Core Reason (Ek Line Mein)
//Singleton Pattern class ko lock karta hai, jabki Singleton Scope sirf object ki lifecycle ko manage karta hai
//        taaki memory bache aur components shared rahein.