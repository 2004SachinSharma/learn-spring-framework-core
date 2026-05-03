package com.sachin.p01_IoC;
// 2. CONCRETE IMPLEMENTATIONS (Pluggable Components) no.3
public class NewUserDatabaseProvider implements UserDataProvider {

    @Override
    public String getUserDetails() {
        return "NewUserDatabaseProvider: These are the user-details after interacting with the DB";
    }

}
