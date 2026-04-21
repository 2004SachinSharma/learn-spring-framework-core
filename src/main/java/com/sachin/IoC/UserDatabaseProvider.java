package com.sachin.IoC;

// 2. CONCRETE IMPLEMENTATIONS (Pluggable Components) no.1
public class UserDatabaseProvider implements UserDataProvider {
    //We use custom logic here to get data from the db i.e. JDBC Logic,  JPA Hibernate, MySQL or Postgres  some other logic as well
    //could be any local, remote etc

    @Override
    public String getUserDetails() {
        return " From UserDatabaseProvider: These are the user-details after interacting with the DB";
    }


}
