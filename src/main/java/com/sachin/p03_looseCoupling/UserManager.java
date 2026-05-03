package com.sachin.p03_looseCoupling;

/*
 * ⚠️ KYU BACHNA CHAHIYE? (The "Ripple Effect" Problem)
 * * 1. N-Number of Changes: Agar aaj 'UserDatabase' class ka naam badal kar 'MongoRepo'
 * rakh diya, toh aapko sirf yahan nahi, balki jahan-jahan 'new UserDatabase()'
 * likha hai (mandi chalo 50 classes mein), har jagah manually change karna padega.
 * * 2. Copy-Paste Pap: Tight coupling ki wajah se hum aksar code copy karne lagte hain,
 * jis se bug fix karna namumkin ho jata hai.
 * * 3. Scalability Zero: Nayi database service add karne ka matlab hai puraane code
 * ko todna-fodna (Refactoring), jo ki risky hai.
 */


//See this the UserManager class, responsible operations on any provided DB, it may be used to getUserName() getUserID() getUserAge() age should not be greater than the 14 etc type DB oriented business logic etc,
//See UserManager Does not care about the Database, but only cares about performing the operations defined, on any Provided DB
public class UserManager {
//    private final UserDatabase userDatabase = new UserDatabase();
//    public String getUserInfo() {
//        return userDatabase.userDetails();
//    } //we will not use this here
    //Instead-

    final UserDataProvider userDataProvider;

    UserManager(UserDataProvider userdataprovider){
       this.userDataProvider = userdataprovider;
    }



    }

