package com.sachin.p03_looseCoupling;

public class NewUserDatabaseProvider implements UserDataProvider{

    @Override
    public String getUserDetails() {
        return "NewUserDatabaseProvider: These are the user-details after interacting with the DB";
    }

}
