package com.sachin.p11_Annotation_PostConstruct_and_PreDestroy;

// CustomBean.java

public class CustomBean {
    public void myStart() {
        System.out.println("2. Custom Init: Defined in @Bean(initMethod=...)");
    }
    public void myStop() {
        System.out.println("3. Custom Cleanup: Defined in @Bean(destroyMethod=...)");
    }
}
