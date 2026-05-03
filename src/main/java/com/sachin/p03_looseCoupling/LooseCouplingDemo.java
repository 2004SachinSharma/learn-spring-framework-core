package com.sachin.p03_looseCoupling;

//Loose coupling describes a scenario where the software
// components are less dependent on each other.

//Importance:
/*1. Easier to maintain and flexibility in modifying
 * 2. Scalability is easier/ easier in adding features, enhancing features
 * 3. Testing is one more imp factor, as we can easily isolate the suspected part of the code, to Test it.
 * etc
 * */

//How to achieve Loose Coupling:
/*1. Interfaces and Abstraction to define contracts,
 * 2. Dependency Injection,(any external source would be passed as a parameter)
 * 3. Event driven architecture (Components will communicate through the events OR messages etc)
 * etc
 * */

public class LooseCouplingDemo {
    public static void main(String[] args) {
//     UserManager user1 = new UserManager();
//        System.out.println(user1.getUserInfo()); //Would not use this now instead we will use:-

        //Go and look into the UserManager class,
        //we have not hardcoded any Database there, it's just the logic there,
        //flexible enough to work at any uniformly defined contract based database class
        //either its webService or Postgres or MySQL or MongoDB or etc.
        //We just have to pass the object of the needed db class implementing the common rules/contract based class.


        UserDataProvider userDatabaseProvider = new UserDatabaseProvider(); // The object creation of the UserDatabaseProvider Class
        UserManager userManager = new UserManager(userDatabaseProvider); //At first my company wanted to keep the UserDatabaseProvider, so I passed the obj of it here to the UserManager, here might be any Local , remote or Cloud database
        System.out.println(userManager.userDataProvider.getUserDetails());

        //Now Company's requirement comes to use any 'remote service' over HTTP/HTTPS.
        //Listen bro That particular service internally talks to its own database to interact with the data

        //Now if it was the tight coupling then we would have to manually change and hardcode the obj in the UserManager.java class! which may result into
        //issue of code disturbance and unintentional developer caused bug(s).

        //Better is use Loose Coupling. Agree!!

//        Just simply create the WebServiceDatabaseProvider obj
        UserDataProvider webServiceDatabaseProvider = new WebServiceDatabaseProvider();

        //Now give the Manager this database class obj.
        UserManager userManager1 = new UserManager(webServiceDatabaseProvider);
        //Now it would perform all what we want with the Remote Service.
        System.out.println(userManager1.userDataProvider.getUserDetails());

//        Done!!

        //ab kaam boht hi asaan h, just ek DB laao aur pass kardo, rest all will be flexibly...That is the power of Loose Coupling

//        let's add one more database obj NewUserDatabaseProvider(for MongoDB);

        UserDataProvider newUserDatabaseProvider = new NewUserDatabaseProvider();
        UserManager userManager2 = new UserManager(newUserDatabaseProvider);
        System.out.println(userManager2.userDataProvider.getUserDetails());

        // dekha, this is that easy to introduce new Database into the application !!
        //observe this, UserManager.java is not tightly coupled with any Specific database, but whichever the database the
        // UserManager want can use at runtime or whichever the database we want the userManager to use we can pass
    }
}
