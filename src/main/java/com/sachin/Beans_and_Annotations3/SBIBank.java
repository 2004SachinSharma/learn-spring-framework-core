package com.sachin.Beans_and_Annotations3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class SBIBank extends AbstractBank{
    private final String bank_code = "12390";
    static final String bank_name = "SBI Bank";
    static final float interest_rate = 9.8f ;

@Autowired
SBIBank (Message m){
    super(m);
    super.bank_name = this.bank_name;

}
}
