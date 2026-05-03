package com.sachin.p11_Annotation_PostConstruct_and_PreDestroy;

// CustomConfig.java

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProjectConfig {
        @Bean(initMethod = "myStart", destroyMethod = "myStop")
        public CustomBean projectConfig() {
            return new CustomBean();
        }

        //    The above way is also not generally recommended to set value,
        //  even the pattern to create the Bean is something we will rarely see to create the Beans,
        //    but Stereotypes annotations are the modern and common practices in the real world work.

//    @Bean(initMethod = "myStart", destroyMethod = "myStop")
//    public CustomBean projectConfig() {
//        Custom Bean bean = new CustomBean();
//          bean.myStart()
//          bean.myStop()  <--If in the direct method body with the obj ref I can call method then
//          why to put above in the  @Bean(initMethod = "myStart", destroyMethod = "myStop")
//        return bean;
//    }

//    This is the reason, why this way is also not recommended to use to run any method right after the setup of the bean.

    //Overall the jakarta way is the final and recommended way!
}
