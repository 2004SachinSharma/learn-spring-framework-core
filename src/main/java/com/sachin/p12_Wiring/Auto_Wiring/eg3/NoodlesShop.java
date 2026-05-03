package com.sachin.p12_Wiring.Auto_Wiring.eg3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class NoodlesShop {

    final private Noodles noodle;

    @Autowired
    NoodlesShop( @Qualifier("maggi") Noodles noodle) { /** {@Qualifier} ki Specificity is always zada than {@Primary}*/
        this.noodle = noodle;
    }

    Noodles getNoodle(){
        return noodle;
    }

    /**
     * Understand this:
     * {@code @Primary} is used to tell IoC:
     * "Hey IoC! Inject this bean by default when multiple beans of the same type are available."
     *
     * {@code @Qualifier} is used to tell IoC:
     * "Hey IoC! Do not guess. Inject this specific bean only."
     *
     * If both {@code @Primary} and {@code @Qualifier} are used,
     * {@code @Qualifier} has higher priority because it is more specific.
     */


}
