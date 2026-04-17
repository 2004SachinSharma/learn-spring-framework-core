package com.sachin.tightcoupling;

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

public class UserManager {

    // ❌ TIGHT COUPLING (Risk Factor):
    // Agar kal humein "MySQL" se "PostgreSQL" pe shift hona hai,
    // toh ye line 'UserManager' ke saath-saath 50 aur classes mein change karni padegi.
    private final UserDatabase userDatabase = new UserDatabase();

    public String getUserInfo() {
        return userDatabase.userDetails();
    }
}

/*
 * REASONING IN SHORT NOTES:
 * -------------------------
 * - Dependency: UserManager is fully dependent on UserDatabase implementation.
 * - Change Management: 1 change in Database = N changes in dependent classes.
 * - Result: High Maintenance Cost & more bugs.
 */

//Solution is Loose Coupling