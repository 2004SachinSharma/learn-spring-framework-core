package com.sachin.multiple_Config_Files;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    private static ApplicationContext context;

    public static void main(String[] args) {

//        ApplicationContext context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        // we want all the config files to be scanned for getting our Bean defined by @Bean annotation in the Config files, now we Can pass all the Config files here in the constructor

//                ApplicationContext context = new AnnotationConfigApplicationContext(ProjectConfig.class, ProjectConfigA.class, ProjectConfigB.class); //here it takes the varargs of the multiple config files declared with Generic type class varargs


        /*
    * but when the files become too many in no. like 50 to 60 config files or even 15 to 20, it becomes messy and seems not so good to pass in the same constructor
    * Solution-> use @import in the main config file, to import all the config files in the same - one main file
    * */


        Integer date = context.getBean(Integer.class);
        System.out.println(date);

        Integer luckNumber = context.getBean("luckNumber",Integer.class);
        System.out.println(luckNumber);

        String configFileVers = context.getBean(String.class);
        System.out.println(configFileVers);

    }
}
