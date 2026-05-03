package com.sachin.p13_BeanRegistrar_autoBeanRegistry.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(com.sachin.p13_BeanRegistrar_autoBeanRegistry.Config.BeanRegistry.class)
public class ProjectConfig {

}
