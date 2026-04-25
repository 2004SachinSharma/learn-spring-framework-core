package com.sachin.Beans_and_Annotations3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class PNBBank extends AbstractBank {
    private final String bank_code = "0322390";
    static final String bank_name = "PNB Bank";
    static final float interest_rate = 7f ;



    @Autowired
    PNBBank (Message m){
        super(m);
        super.bank_name = this.bank_name;
    }



}
