package com.sachin.p09_Annotation_Primary;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class Main {

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(ProjectConfig.class);

//        Vehicle v2 = context.getBean("vehicle1", Vehicle.class);
//        v2.getName();
//        Vehicle v3 = context.getBean("vehicle2", Vehicle.class);
//        v3.getName();
//        Vehicle v4 = context.getBean("vehicle3", Vehicle.class);
//        v4.getName();

        /**
         * The above is also a solution for resolving the ambuigity but, here lets talk about the another way the
         * @Primary annotation
         * */

        //But what if I want to not to use the method name for getting the bean; and just resolve the ambuiguity by specifying the default Bean
//        Means its like telling IoC , "sir dont get confused by seeing more then one bean of the same type, if you get confused just inject this particular bean"

        Vehicle v2 = (Vehicle) context.getBean( "myvehicle1");
        v2.getName();
        Vehicle v3 =(Vehicle) context.getBean("myvehicle2");
        v3.getName();
        Vehicle v4 = context.getBean( Vehicle.class);
        v4.getName();
        Vehicle v5 = context.getBean( Vehicle.class);
        v5.getName();

        //The above code results in an exception! (noUniqueBeanDefinitionException)
       //Lets resolve it,
        /**
        * @Primary annotation: It is used in Spring to give precedence to a specific bean when multiple beans
        * of the same type are present in the ApplicationContext. It effectively solves the NoUniqueBeanDefinitionException
         * by acting as a "default" choice.*/

        //Let's look Hands-On

//        Look into the ProjectConfig.java, I have specified a bean as @Primary,
//        now the Exception would not come.
//        Run it

    }
}