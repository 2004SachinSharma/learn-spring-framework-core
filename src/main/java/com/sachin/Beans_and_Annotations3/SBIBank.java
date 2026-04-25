package com.sachin.Beans_and_Annotations3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Component: Spring ko bata rahe hain ki "Bhai, list mein ek aur bank add kar lo."
 * Iska object bhi Spring IoC Container khud manage karega.
 *
 */
@Component

public class SBIBank extends AbstractBank {

    // SBI ki apni unique values jo bank-to-bank vary karti hain.
    private final String bank_code = "12390";
    static final String bank_name = "SBI Bank";
    static final float interest_rate = 9.8f;

    /**
     * @Autowired Constructor:
     * Spring se 'Message' (SendSMS) service maangi.
     *
     */
    @Autowired
    SBIBank(Message m) {
        /**
         * super(m): Parent (AbstractBank) ko 'Message' ka object pass kar diya.
         * Kyunki parent ko hi pata hai ki SMS kab aur kaise bhejni hai.
         *
         */
        super(m);

        /**
         * super.bank_name = this.bank_name:
         * Parent ke common variable mein SBI ka naam set kar diya.
         * Ab jab bhi 'AbstractBank' se koi message jayega, wo "SBI Bank" ke naam se jayega.
         *
         */
        super.bank_name = this.bank_name;
    }
}