package com.sachin.Beans_and_Annotations3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Service: Ye annotation @Component ka hi ek "VVIP" bhai hai.
 * Hum Spring ko bata rahe hain ki ye class "Business Logic" handle karti hai.
 * Real projects mein hum hamesha @Service use karte hain taaki pata chale ki ye 'Service Layer' hai.
 */
@Service
public class UserManager {

    /**
     * BankInterface bank:
     * Dekho yahan asli "Khel" (Abstraction) hai. Humne 'HDFCBank' ya 'PNBBank' nahi likha.
     * Humne sirf 'Socket' (Interface) rakha hai.
     * Isse hamara code "Loose Coupled" ho gaya—matlab ye kisi ek bank ka ghulam nahi hai.
     */
    private final BankInterface bank;

    /**
     * @Autowired Constructor (The Wiring Point):
     * Spring IoC Container se humne bola: "Bhai, koi bhi 'BankInterface' ka bean la kar de do."
     * Chunki HDFC par @Primary laga hai, toh Spring automatically HDFC ka object yahan "Plug" kar dega.
     * Is process ko 'Dependency Injection' (DI) kehte hain.
     */
    @Autowired
    UserManager(BankInterface bank){
        this.bank = bank;
    }

    /**
     * depositMoney: Ye "User" ke liye ek gateway hai.
     * User ko nahi pata ki 'bank.depositAmount' ke andar kya-kya complex calculation ho rahi hai.
     * Humne 'final' isliye lagaya taaki koi is important logic ko override karke badal na sake.
     */
    public final void depositMoney(double amount){
        System.out.println("Depositing..."); // User ko update diya
        bank.depositAmount(amount);         // Asli bank ka method trigger kiya
        System.out.println("Deposit Successful");
    }

    /**
     * withdrawMoney: Paise nikalne ka process manage ho raha hai.
     * Iske andar hum future mein "Security Check" ya "Limit Check" bhi add kar sakte hain.
     */
    public final void withdrawMoney(double amount){
        System.out.println("Withdrawing...");
        bank.withdrawAmount(amount);
        System.out.println("Withdraw Successful");
    }

    /**
     * getTotalBalance: Bank se balance pooch kar dikhana.
     */
    public final void getTotalBalance(){
        bank.totalBalance();
    }
}