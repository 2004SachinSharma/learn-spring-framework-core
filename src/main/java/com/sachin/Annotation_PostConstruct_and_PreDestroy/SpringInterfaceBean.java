package com.sachin.Annotation_PostConstruct_and_PreDestroy;

// SpringInterfaceBean.java

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class SpringInterfaceBean implements InitializingBean, DisposableBean {
    public SpringInterfaceBean() {
        System.out.println("1. Constructor: Spring Interface Bean created");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("2. afterPropertiesSet: Spring Interface init logic");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("3. destroy: Spring Interface cleanup logic");
    }
}
