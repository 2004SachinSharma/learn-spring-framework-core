package com.sachin.Beans_and_Annotations3;

import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class AbstractBank implements BankInterface{
    double total_balance ;
    Date date;
    String bank_name;
    private Message message;

    AbstractBank(Message m){
        this.message = m;
    }

    String getBankOrigin(){
        return BankInterface.origin;
    }

    public String totalBalance(){
        return String.valueOf(total_balance);
    };

    /**
     * Deposits amount, logs a message, returns updated balance
     */
    public String depositAmount(double depositRs){
        date = new Date();
        total_balance += depositRs;
        System.out.println(message.sendDepositMessage(String.valueOf(depositRs),String.valueOf(date),String.valueOf(total_balance),bank_name ));
        return String.valueOf( total_balance);
    };

    /**
     * Withdraws amount, logs a message, returns updated balance
     */
    public String withdrawAmount(double withdrawRs){
        date = new Date();
        total_balance -= withdrawRs;
        System.out.println(message.sendWithdrawMessage(String.valueOf(withdrawRs),String.valueOf(date),String.valueOf(total_balance),bank_name ));
        return String.valueOf(total_balance);
    };

}
