package com.sachin.Beans_and_Annotations3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class UnionBank extends AbstractBank{
    private final String bank_code = "051230";
    static final String bank_name = "Union Bank";
    static final float interest_rate = 7f ;

    @Autowired
    UnionBank (Message m){
        super(m);
        super.bank_name = this.bank_name;

    }

}
