package com.sachin.p06_Beans_and_Annotations3;

/**
 * SendSMS: Ye class 'Message' interface ka asli "Bodyguard" hai.
 * Interface ne sirf vaada kiya tha, ye class us vaade ko poora kar rahi hai.
 *
 */
public class SendSMS implements Message {

    /**
     * sendWithdrawMessage: Jab bhi AbstractBank se paise niklenge,
     * ye method ek professional SMS format taiyar karke return karega.
     * Isme saari details (amount, time, balance) ko String concatenation se joda gaya hai.
     *
     */
    @Override
    public  String sendWithdrawMessage(String withdraw_amount, String date_time, String currbalance, String bank_name) {
        // Asli SMS format jo user ke screen par dikhega.
        return "Hello "+ "! \namount of " + withdraw_amount +
                "\n is withdrawn from your account\n on " + date_time +
                ". \n Your current balance is now "+ currbalance +
                " \n\t"+ "Thanks and regards from " + bank_name +".";
    }

    /**
     * sendDepositMessage: Jab paise jama honge, ye SMS format use hoga.
     * Note: Aapne notice kiya hoga ki is class par @Component nahi laga hai.
     * Kyunki humne 'ProjectConfig' mein @Bean use karke iska object manually banaya hai.
     *
     */
    @Override
    public String sendDepositMessage( String deposit_amount, String date_time, String currbalance, String bank_name) {
        return "Hello " + "! \namount of " + deposit_amount +
                "\n is deposited to your account\n on " + date_time+
                ". \n Your current balance is now "+ currbalance +
                " \n\t"+ "Thanks and regards from " + bank_name +".";
    }
}