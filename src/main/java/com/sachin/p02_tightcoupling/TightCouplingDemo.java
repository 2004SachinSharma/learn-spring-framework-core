package com.sachin.p02_tightcoupling;

//Tight coupling describes a scenario where the software component are 'highly dependent' on each other


public class TightCouplingDemo {
    public static void main(String[] args) {
        UserManager userManager = new UserManager();
        System.out.println(userManager.getUserInfo());
    }
}
