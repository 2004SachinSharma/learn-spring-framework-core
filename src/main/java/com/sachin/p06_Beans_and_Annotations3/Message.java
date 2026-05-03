package com.sachin.p06_Beans_and_Annotations3;

/**
 * Message Interface: Ye hamare notification system ka "Blue-print" hai.
 * Humne yahan 'What to do' (Kya karna hai) define kiya hai, 'How to do' (Kaise karna hai) nahi.
 *
 */
public interface Message {

    /**
     * sendWithdrawMessage: Jab bhi paise nikalenge (Withdraw), ye method trigger hoga.
     * Isne ek rule set kar diya hai ki message bhejne ke liye ye 4 cheezein zaroori hain:
     * 1. withdraw_amount (Kitne nikale)
     * 2. date_time (Kab nikale)
     * 3. currbalance (Ab kitne bache)
     * 4. bank_name (Kaunse bank se nikale)
     *
     */
    String sendWithdrawMessage(String withdraw_amount, String date_time, String currbalance, String bank_name);

    /**
     * sendDepositMessage: Jab paise jama honge (Deposit), ye method use hoga.
     * Interface hone ka fayda ye hai ki 'AbstractBank' ko pata hai ki ye methods
     * use karne hi hain, chahe piche implementation koi bhi ho.
     *
     */
    String sendDepositMessage(String withdraw_amount, String date_time, String currbalance, String bank_name);

}

/* 3 points to note on:
Loose Coupling ka Jariya: AbstractBank class direct SendSMS class se baat nahi karti. Woh sirf is Message interface se baat karti hai. Iska fayda ye hai ki kal ko agar tum SendEmail class banao, toh tumhe AbstractBank ka code change nahi karna padega.

Spring DI ka Socket: Spring IoC container mein ye interface ek "Socket" ki tarah kaam karta hai. Aapne AbstractBank mein private final Message message; likha hai, jo ki is socket ka reference hai. Spring isme automatically koi bhi "Plug" (Implementation class jaise SendSMS) fit kar deta hai.

Consistency (Ek Jaisa Behavior): Chahe HDFC Bank ho ya SBI Bank, sabhi ek hi tarah ka message format use karenge kyunki sab isi interface ke "Contract" se bandhe hue hain.*/