package com.sachin.p05_Beans_and_Annotations2.repository;

import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {
    public String getUser() {
        return "Sachin";
    }
}
