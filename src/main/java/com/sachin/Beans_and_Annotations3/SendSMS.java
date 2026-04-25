package com.sachin.Beans_and_Annotations3;


public class SendSMS implements Message{
   public  String sendWithdrawMessage(String withdraw_amount, String date_time, String currbalance, String bank_name) {

        return "Hello "+ "! \namount of " + withdraw_amount + "\n is withdrawn from your account\n on " + date_time + ". \n Your current balance is now "+ currbalance +" \n\t"+ "Thanks and regards from " + bank_name +".";


    }

   public String sendDepositMessage( String deposit_amount, String date_time, String currbalance, String bank_name) {

        return "Hello " + "! \namount of " + deposit_amount + "\n is deposited to your account\n on " + date_time+ ". \n Your current balance is now "+ currbalance +" \n\t"+ "Thanks and regards from " + bank_name +".";

    }

}
