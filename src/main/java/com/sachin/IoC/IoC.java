package com.sachin.IoC;

public class IoC {
    /**
     * 📘 THE MASTER CLASS: FROM SERVLETS TO SPRING IoC
     * --------------------------------------------------------------------------------
     * PRE-REQUISITE KNOWLEDGE:
     * We already know how 'Catalina' (Tomcat) manages Servlets. Just as Catalina
     * instantiates our Servlet and calls init(), the Spring 'ApplicationContext'
     * manages our Beans. This "Giving up control to the Framework" is IoC.
     * --------------------------------------------------------------------------------
     */

    public static void main(String[] args) {

        /*
        * The Pattern: DI is a design pattern where an object receives its dependencies from an external source rather than creating them itself.

The Goal: To achieve Loose Coupling.

The Action: Instead of using the new keyword inside a class (e.g., Engine e = new Engine()), the dependency is "injected" via a Constructor or Setter.

2. Inversion of Control (IoC)
The Principle: IoC is the broader concept where the control of the program flow or object creation is handed over to a framework or container.

The Shift: In traditional programming, you (the developer) control the lifecycle. In IoC, the framework (Spring/Tomcat) controls the lifecycle.*/

        /**
         * 🛑 PHASE 1: MANUAL DEPENDENCY INJECTION (the Code Below)
         * DEFINITION: we are manually passing objects (Injection) but we
         * are still the boss. we manage the lifecycle with 'new'.
         */

        // Step A: Create Dependency (Manual)
        UserDataProvider userDatabaseProvider = new UserDatabaseProvider();
        // Step B: Inject it (Manual)
        UserManager userManager = new UserManager(userDatabaseProvider);
        System.out.println(userManager.userDataProvider.getUserDetails());

        UserDataProvider webServiceDatabaseProvider = new WebServiceDatabaseProvider();
        UserManager userManager1 = new UserManager(webServiceDatabaseProvider);
        System.out.println(userManager1.userDataProvider.getUserDetails());

        UserDataProvider newUserDatabaseProvider = new NewUserDatabaseProvider();
        UserManager userManager2 = new UserManager(newUserDatabaseProvider);
        System.out.println(userManager2.userDataProvider.getUserDetails());

        /**
         * 🚀 PHASE 2: INVERSION OF CONTROL (The Spring Way)
         * DEFINITION: Spring Container (IoC) replaces the 'main' method.
         * * ANALOGY TO SERVLETS:
         * - In Servlets: Catalina creates the Servlet object.
         * - In Spring: ApplicationContext creates the UserDataProvider & UserManager.
         * * THE "INVERSION":
         * Instead of we writing "new UserDatabaseProvider()", we just put
         * @Component on the class. Spring finds it, creates it, and injects
         * it into UserManager automatically. we stop being the "Assembler".
         */
    }
}

/**
 * FINAL SUMMARY FOR INTERVIEW & DEV:
 * --------------------------------------------------------------------------------
 * | Concept      | Definition                                | Who is the Boss?   |
 * |--------------|-------------------------------------------|--------------------|
 * | Tight Couple | Class A creates Class B inside itself.    | Hard-coded Logic   |
 * | Manual DI    | we pass Class B to Class A via Constr.   | we (Developer)    |
 * | Spring IoC   | Spring creates B and passes it to A.      | Spring Container   |
 * --------------------------------------------------------------------------------
 */