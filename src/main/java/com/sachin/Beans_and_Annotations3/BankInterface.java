package com.sachin.Beans_and_Annotations3;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/**
 * @Component: Interface par @Component lagana Spring ko batata hai ki
 * ye hamare system ka ek "Core Part" hai.
 * * Asli "Inversion of Control (IoC)" yahi se shuru hoti hai. Humne 'Main' class ko
 * bola hai ki tum specific bank (SBI/PNB) se matlab mat rakho, tum bas is
 * 'BankInterface' ke contract par bharosa karo.
 */
@Component
@Primary
public interface BankInterface {

    /**
     * static final variable: Interface mein variables by default constants hote hain.
     * 'origin = India' ka matlab hai ki chahe koi bhi bank ho (HDFC ya SBI),
     * sabka base origin India hi rahega. Ye shared knowledge hai.
     */
    public static final String origin = "India";

    /**
     * abstract methods: Interface mein hum sirf "Kya karna hai" (What to do) batate hain,
     * "Kaise karna hai" (How to do) nahi.
     * * Inhe hum 'Contract Methods' kehte hain. Jo bhi class (HDFCBank, PNBBank)
     * is interface ko implement karegi, use ye teeno kaam karne hi padenge.
     */

    // 1. totalBalance: Sirf ye batayega ki kitna paisa bacha hai.
    String totalBalance();

    // 2. withdrawAmount: Paise nikalne ka standard rasta.
    // Isse farq nahi padta ki bank PNB hai ya HDFC, method ka naam yahi rahega.
    String withdrawAmount(double withdrawRs);

    // 3. depositAmount: Paise jama karne ka standard rasta.
    String depositAmount(double depositRs);

}

/* 3 Points to note:
The Contract (Wada): Interface ek vaada hai. Agar Main class BankInterface use kar rahi hai, toh use tension lene ki zaroorat nahi hai ki piche kaunsa bank hai—use pata hai ki ye teeno methods toh milenge hi milenge.

Loose Coupling (Dosti, par Door se): UserManager ko humne BankInterface ka socket diya hai. Kal ko agar naya bank "AxisBank" aata hai, toh humein UserManager ka code touch bhi nahi karna padega kyunki AxisBank bhi isi contract (Interface) ko follow karega.

Abstraction (Parda): Interface complex logic ko parde ke piche rakhta hai. Main class ko sirf methods ke naam dikhte hain, unke andar ki 100 lines ka code nahi.*/