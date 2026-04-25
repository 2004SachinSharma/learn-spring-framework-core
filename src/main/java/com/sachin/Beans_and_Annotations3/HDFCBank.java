package com.sachin.Beans_and_Annotations3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.Date;

@Component
@Primary
public class HDFCBank extends AbstractBank{
    static final String bank_code = "090791";
    static final float interest_rate = 10f;
    static final String bank_name = "HDFC Bank";

    @Autowired
    HDFCBank(Message m) {
        super(m);
        super.bank_name = this.bank_name;

    }


}
