package com.sachin.p06_Beans_and_Annotations3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Component: Spring ko bata rahe hain ki "Bhai, list mein ek aur bank add kar lo."
 * UnionBank ab Spring ke 'IoC Container' ka hissa hai.
 * Jab bhi system ko 'BankInterface' chahiye hoga, Spring ke paas ye bhi ek option hoga.
 */
@Component
public class UnionBank extends AbstractBank {

    /**
     * Unique Identity:
     * Har bank ka apna code aur interest rate hota hai.
     * Inhe humne 'private' aur 'static final' rakha hai taaki ye secure rahein.
     */
    private final String bank_code = "051230";
    static final String bank_name = "Union Bank";
    static final float interest_rate = 7f;

    /**
     * @Autowired Constructor (Dependency Injection):
     * Spring se humne 'Message' (SendSMS) maanga.
     * Spring check karega ki @Bean ya @Component mein kaunsa Message bean available hai
     * aur use yahan "Inject" (Plug) kar dega.
     */
    @Autowired
    UnionBank(Message m) {
        /**
         * super(m):
         * Asli "Plugging" yahan ho rahi hai! Humne apna 'Message' ka object parent
         * class (AbstractBank) ko handover kar diya.
         * Kyunki saara deposit/withdraw ka logic parent ke paas hai,
         * toh SMS bhejne ka tool bhi use hi chahiye.
         */
        super(m);

        /**
         * super.bank_name = this.bank_name:
         * Humne Parent ko bataya ki "Main Union Bank hoon".
         * Isse jab SMS jayega, toh wo automatically "Union Bank" ke naam se jayega.
         */
        super.bank_name = this.bank_name;
    }
}