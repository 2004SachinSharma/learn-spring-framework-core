package com.sachin.p06_Beans_and_Annotations3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Component: Spring ko ek aur "Option" de rahe hain hum.
 * Iska matlab hai: "Bhai, PNB Bank bhi ek managed bean hai."
 * Jab @ComponentScan is package par chalega, toh Spring iska object banakar
 * apne 'IoC Container' (Gala/Bucket) mein rakh lega.
 */
@Component
public class PNBBank extends AbstractBank {

    /**
     * Unique Bank Details:
     * Har bank ka apna code aur interest rate hota hai.
     * Inhe humne 'private' aur 'static final' rakha hai taaki ye secure rahein
     * aur sirf isi class se belong karein.
     */
    private final String bank_code = "0322390";
    static final String bank_name = "PNB Bank";
    static final float interest_rate = 7f;

    /**
     * @Autowired Constructor (Dependency Injection):
     * Spring se humne 'Message' interface ka object maanga.
     * Spring check karega ki @Bean ya @Component mein kaunsa Message bean
     * (jaise SendSMS) available hai aur use yahan "Inject" kar dega.
     */
    @Autowired
    PNBBank(Message m) {
        /**
         * super(m):
         * Ye line bahut zaroori hai! Hum apna 'Message' ka plug parent class
         * (AbstractBank) ko handover kar rahe hain.
         * Kyunki asli deposit/withdraw ka logic wahan likha hai, toh use
         * message bhejne ke liye ye object chahiye hoga.
         */
        super(m);

        /**
         * super.bank_name = this.bank_name:
         * Humne Parent ko bataya ki "Main PNB hoon".
         * Taaki jab parent class 'depositAmount' method chalaye, toh SMS mein
         * "HDFC" ki jagah "PNB Bank" print ho. Ye 'Dynamic Naming' hai.
         */
        super.bank_name = this.bank_name;
    }
}

/*Is File ke 3 Bade Logic (Simplified):
Multiple Implementations (Options): Tumhare paas ab PNB, HDFC aur Union teeno banks hain. Spring ke paas ab options ki "List" hai. Agar Main mein kisi ko specifically PNB chahiye, toh Spring ke paas ye object ready pada hai.

State vs Identity: AbstractBank ek "Design" tha, lekin PNBBank us design ka ek asli "Instance" hai jiske paas apni identity (bank_code) hai.

The "No Primary" Factor: Yaad rakhna, HDFC par @Primary laga hai, isliye jab tum UserManager mein sirf BankInterface mangoge, toh Spring HDFC hi dega. Agar tumhe PNB chahiye, toh tumhe @Qualifier("PNBBank") use karna padega.*/