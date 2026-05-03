package com.sachin.p12_Wiring.Auto_Wiring.eg3;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.sachin.p12_Wiring.Auto_Wiring.eg3")
public class ProjectConfig {

//    @Bean
//    Noodles Maggi(){
//        Maggi m = new Maggi(); //Bean gets registered with the same name as Method even if its uppercase as here
//        m.setId(212);
//        return m;
//    }

//----------------------------------------------------------------------------------------------------------------------

    //Also look at @DependsOn() , However rarely used, becuase Spring is smart enough to do what it does
    //  but in some rare cases, we have an option to use this annotation too.

//    @DependsOn ka use karke aap Spring ko force karte hain ki: "Bhai, pehle Bean B  Banao, uske baad hi Bean A
//    Banana."

    /*Code Example
Maan lijiye hume ek Cache System setup karna hai. Hum chahte hain ki DataService tabhi load ho jab CacheManager puri
 tarah setup ho chuka ho.*/

//    @Configuration
//    public class AppConfig {
//
//        // Bean 1: Cache Manager
//        @Bean("cacheMgr")
//        public CacheManager cacheManager() {
//            System.out.println("1. Cache Manager initializing...");
//            return new CacheManager();
//        }
//
//        // Bean 2: Data Service (Depends on Cache Manager)
//        @Bean
//        @DependsOn("cacheMgr") // Ye 'cacheMgr' method ko pehle chalne par majboor karega
//        public DataService dataService() {
//            System.out.println("2. Data Service initializing after Cache is ready.");
//            return new DataService();
//        }
//    }

    /**
     * Key Takeaways:
     * String Value: @DependsOn ke andar wahi naam aayega jo doosre bean ka method name hai (ya jo name attribute mein
     * diya gaya hai).
     * Safety: Ye tab kaam aata hai jab DataService ke constructor mein hum CacheManager pass nahi kar rahe (matlab
     * direct dependency nahi hai),
     * lekin functionality ke liye uska pehle banna zaroori hai*/
}
