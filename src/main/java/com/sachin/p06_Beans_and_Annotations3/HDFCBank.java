package com.sachin.p06_Beans_and_Annotations3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Component: Spring ko bata rahe hain ki HDFCBank ek asli "Worker" (Bean) hai.
 * Jab bhi system ko kisi 'BankInterface' ki zaroorat hogi, Spring is class ka object banayega.
 * * @Primary: Ye bahut zaroori annotation hai!
 * Jab tumhare paas SBI, PNB, aur HDFC jaise multiple banks honge, toh Spring confused ho jayega ki kise inject karun.
 * @Primary ka matlab hai: "Agar koi specific naam na liya jaye, toh by default HDFCBank ko hi pick karna."
 */
@Component
public class HDFCBank extends AbstractBank {

    // static final: Ye is bank ki "Identity" hai jo kabhi nahi badlegi.
    static final String bank_code = "090791";
    static final float interest_rate = 10f;
    static final String bank_name = "HDFC Bank";

    /**
     * @Autowired Constructor: Yahan asli "Dependency Injection" ho rahi hai.
     * Spring background mein 'Message' bean (SendSMS) dhundta hai aur is constructor mein la kar "Plug" kar deta hai.
     * * super(m): Hum ye 'Message' object apne Parent (AbstractBank) ko bhej rahe hain,
     * taaki wo deposit/withdraw ke waqt ise use kar sake.
     */
    @Autowired
    HDFCBank(Message m) {
        super(m); // Parent constructor ko dependency handover ki.

        /**
         * super.bank_name = this.bank_name:
         * Parent class (AbstractBank) ko apna naam batana zaroori hai.
         * Humne Parent ke 'bank_name' variable mein "HDFC Bank" value set kar di,
         * taaki jab Parent message print kare, toh wo sahi bank ka naam dikhaye.
         */
        super.bank_name = this.bank_name;
    }
}

/*3 Points to note:
The Implementer (Asli Kaam Karne Wala): AbstractBank sirf ek dhancha (structure) tha, lekin HDFCBank woh asli object hai jiske paas apni properties (bank_code, interest_rate) hain.

Resolution of Confusion (@Primary): Spring IoC container mein jab ek interface ke bahut saare bacche (implementations) hote hain, toh @Primary ek "Default Choice" ki tarah kaam karta hai taaki application crash na ho.

Super Power (Handover): Constructor mein super(m) likhna ye dikhata hai ki aapne DI ka use karke dependency ko hierarchal level par manage kiya hai.*/