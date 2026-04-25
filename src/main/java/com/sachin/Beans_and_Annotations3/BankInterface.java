package com.sachin.Beans_and_Annotations3;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
public interface BankInterface {
    public static final String origin = "India";

     String totalBalance();
     String withdrawAmount(double withdrawRs);
     String depositAmount(double depositRs);


}
