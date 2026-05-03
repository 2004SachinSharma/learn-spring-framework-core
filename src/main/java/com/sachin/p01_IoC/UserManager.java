package com.sachin.p01_IoC;

// 3. THE TARGET CLASS (The Dependent)
public class UserManager {
    // INTERVIEW TIP: We use the Interface type here, not the Class type.
    // This allows any implementation to be "injected".
    final UserDataProvider userDataProvider;

    UserManager(UserDataProvider userdataprovider){
       this.userDataProvider = userdataprovider;
    }

    /**
     * 🛠️ CONSTRUCTOR INJECTION: WHY IT'S THE GOLD STANDARD
     * 1. ALL-SET TEMPLATE: As we said, it provides the template with all
     * dependencies forced at the time of birth.
     * 2. IMMUTABILITY: The dependency can be 'final'. It won't change later.
     * 3. SAFETY: Prevents NullPointerException because we CANNOT create a
     * UserManager without a Provider.
     * 4. LESS CODE: With Lombok (@RequiredArgsConstructor), we don't even
     * need to write this boilerplate!
     */


    }

