package com.sachin.Beans_and_Annotations3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    /**
     * main method: Hamari application ka entry point (Starting point).
     */
    public static void main(String[] args) {

        /**
         * ApplicationContext: Ye hamara IoC Container (Kitchen/Hall) hai.
         * Humne Spring ko bola: "Bhai, 'ProjectConfig.class' ki instructions padho aur
         * saare Beans (Objects) ko paida (Instantiate) karke apne paas rakh lo."
         */
        ApplicationContext context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        /**
         * context.getBean(AbstractBank.class):
         * Yahan tum Spring se keh rahe ho: "MERE PAAS AbstractBank TYPE KA KOI PLUG HAI KYA?"
         * * Asli Logic:
         * Kyuniki HDFCBank ne AbstractBank ko EXTEND kiya hai, isliye Spring 'HDFCBank'
         * ka object nikal kar tumhe de dega (Polymorphism ka use karke).
         * Agar @Primary laga hai, toh bina confusion ke default wala mil jayega.
         */
        UserManager u = context.getBean(UserManager.class);
//        System.out.println("Bankk ka naam "+u.bank_name);
        /**
         * u.depositAmount(1000):
         * 'u' ke socket mein HDFCBank ka plug laga hai. Jab tumne 'deposit' call kiya,
         * toh AbstractBank ka method chala, lekin 'bank_name' HDFC ka use hua.
         * Isi ko 'Inversion of Control' kehte hain—Object manage Spring kar raha hai,
         * hum toh bas use use kar rahe hain.
         */
        u.depositMoney(1000);

        // Ek rupee nikala taaki check karein ki logic sahi kaam kar raha hai ya nahi.
        u.withdrawMoney(1);
    }
}

/*3 Points to note:
Dependency Lookup: context.getBean() ka matlab hai hum container ke andar jhaank rahe hain (Lookup kar rahe hain) ki hamara "Object" kahan hai.

Parent Type Injection: Aapne u ka type AbstractBank rakha hai. Yeh bahut acchi practice hai kyunki aapko farq nahi padta ki piche HDFC hai ya SBI, jab tak wo AbstractBank ka beta (subclass) hai, code chalta rahega.

The "No New" Rule: Aapne poore code mein kahin bhi new HDFCBank() nahi likha. Saare objects Spring ne "Hawa se" (IoC Container se) laakar diye hain.

Ek Choti si Cheez Jo Tumhe Pata Honi Chahiye:
Abhi tum AbstractBank.class se bean mang rahe ho. Agar tumne HDFCBank se @Primary hata diya aur PNBBank bhi banaya, toh Spring Exception de dega: "Bhai, mere paas do-do banks hain, main kise doon?".
 Tab tumhe @Qualifier ya @Primary ka use karke Spring ko guide karna padega.*/