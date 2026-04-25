package com.sachin.Beans_and_Annotations3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserManager {
    private final BankInterface bank;

    @Autowired

    UserManager(BankInterface bank){
        this.bank = bank ;
    }

    public final void depositMoney(double amount){
        System.out.println("Depositing...");
        bank.depositAmount(amount);
        System.out.println("Deposit Successful");
    }

    public final void withdrawMoney(double amount){
        System.out.println("Withdrawing...");
        bank.withdrawAmount(amount);
        System.out.println("Withdraw Successful");
    }

    public final void getTotalBalance(){
        bank.totalBalance();
    }

}
