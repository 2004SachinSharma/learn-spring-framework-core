package com.sachin.looseCoupling;

public class WebServiceDatabaseProvider implements UserDataProvider{
    //We use custom logic here to get data from the External API e.g. REST API, microservices

    @Override
    public String getUserDetails() {
        return "From webServiceDatabaseProvider: These are the user-details after interacting with the DB";
    }
}
