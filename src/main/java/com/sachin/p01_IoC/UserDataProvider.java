package com.sachin.p01_IoC;

// 1. THE INTERFACE (The Contract for Loose Coupling)
// Essence: UserManager doesn't know WHO provides data, only WHAT it looks like.
public interface UserDataProvider {
    String getUserDetails();
}
