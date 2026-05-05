package com.sachin.p16_Prototype_Scope;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {

        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        String user1 = context.getBean(UserSession.class).getSessionID();
        String user2 = context.getBean(UserSession.class).getSessionID();
        String user3 = context.getBean(UserSession.class).getSessionID();

        System.out.println(user1);
        System.out.println(user2);
        System.out.println(user3);


        //with by-default singleton Scope of class loading, the same object/Bean is used across multiple times.Hence, the same sessionID is being returned each time for every user.
         //But Brothers&Sisters, the sessionIDs are never meant to be the same for two users or multiple.

          //Now the situation has started screaming to use Prototype Scope.
          //Now go to the UserSession Class and see the output on toggling between the by-default Singleton and the Prototype Scope.

    }
}
