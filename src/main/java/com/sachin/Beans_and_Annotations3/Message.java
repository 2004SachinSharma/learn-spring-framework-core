package com.sachin.Beans_and_Annotations3;

public interface Message {
    String sendWithdrawMessage( String withdraw_amount, String date_time, String currbalance, String bank_name);
    String sendDepositMessage( String withdraw_amount, String date_time, String currbalance, String bank_name);

    }
