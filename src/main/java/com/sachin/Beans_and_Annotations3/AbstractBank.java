package com.sachin.Beans_and_Annotations3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import java.util.Date;

/**
 * @Component: Bhai, Spring ko ek "Signal" bhej rahe hain hum.
 * Iska matlab hai: "Oye Spring! Is class ka khayal tum rakhna."
 * Spring ise scan karega aur jab bhi iski zaroorat hogi, iska object (Bean) khud banayega.
 * Ye IoC (Inversion of Control) ka pehla step hai—Control humne Spring ko de diya.
 */
@Component
@Primary
public abstract class AbstractBank implements BankInterface {

    // 'total_balance': Ispe 'final' nahi lagaya kyunki paise toh aate-jaate rahenge.
    // Ye variable har transaction ke baad update hoga.
    double total_balance;

    // 'date': Har baar naya timestamp chahiye transaction ke liye, isliye re-assign hoga.
    Date date;

    // 'bank_name': Parent ko nahi pata uska naam kya hai, ye "Child" (HDFC, SBI) batayenge.
    String bank_name;

    /**
     * 'message': Ispe 'final' lagaya hai (Best Practice!).
     * Ek baar Spring ne isme SMS ya Email ka "Plug" (Dependency) laga diya,
     * toh hum nahi chahte ki runtime pe koi usey badal sake.
     */
    private final Message message;

    /**
     * Constructor (The DI Point):
     * Yahan asli "Plugging" ho rahi hai. Hum Spring se bol rahe hain:
     * "Mujhe nahi pata 'Message' ka object kaise banta hai, tum bas mujhe ek la kar de do."
     * Dependency Injection (DI) isi ko kehte hain—Dependencies bahar se (Spring se) aa rahi hain.
     * Isse 'Tight Coupling' khatam hoti hai kyunki humne 'new SendSMS()' nahi likha.
     */

    //Here I have not used @Autowired because, post-Spring 4.3, @Autowired for a single Constructor in a class for DI is optional to put, Spring automatically gets that @Autowired signal without writing...
   //but if we have more than one, then explicit annotation is needed
    AbstractBank(Message m) {
        this.message = m;
    }

    // Sirf dikhane ke liye ki Interface se static constants kaise uthate hain.
    String getBankOrigin() {
        return BankInterface.origin;
    }

    // Simple getter jo current balance ko String mein convert karke deta hai.
    public String totalBalance() {
        return String.valueOf(total_balance);
    }

    /**
     * depositAmount: Paisa jama karne ka core logic.
     */
    public String depositAmount(double depositRs) {
        date = new Date(); // Time note kiya.
        total_balance += depositRs; // Balance update kiya.

        /**
         * DI ka Jalwa:
         * Hum 'message' object ko call kar rahe hain message bhejne ke liye.
         * Yaad rahe, ye object humne nahi banaya, Spring ne "Inject" kiya hai.
         */
        System.out.println(message.sendDepositMessage(
                String.valueOf(depositRs),
                String.valueOf(date),
                String.valueOf(total_balance),
                bank_name
        ));
        return String.valueOf(total_balance);
    }

    /**
     * withdrawAmount: Paisa nikalne ka logic.
     * Bilkul deposit jaisa—DI use karke notification bhej rahe hain.
     */
    public String withdrawAmount(double withdrawRs) {
        date = new Date();
        total_balance -= withdrawRs;

        System.out.println(message.sendWithdrawMessage(
                String.valueOf(withdrawRs),
                String.valueOf(date),
                String.valueOf(total_balance),
                bank_name
        ));
        return String.valueOf(total_balance);
    }
}