package com.sachin.tightcoupling;

//now one day we want to change the database to any other like:
//MongoDB, MySQL, or WebService etc

public class UserDatabase {
    public String userDetails(){
        //We use custom logic to get data from the db
        return "These are the user-details";
    }
}
