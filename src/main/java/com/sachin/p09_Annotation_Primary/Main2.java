package com.sachin.p09_Annotation_Primary;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main2 {
    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(ProjectConfig.class, ProjectConfigA.class);

        /**
         * CASE 1:
         * SAME NAME beans present in multiple config files
         */

        String value = context.getBean("commonBean", String.class);
        System.out.println(value);

        /**
         * CASE 2:
         * SAME TYPE but DIFFERENT NAME → @Primary works
         */

        Integer num = context.getBean(Integer.class);
        System.out.println(num);

    }
}
/**
 * ===================== IMPORTANT ADDITION (VERY IMPORTANT CONCEPT) =====================
 *
 * 👉 @Primary works ONLY when:
 *    - Multiple beans of SAME TYPE exist
 *    - AND they have DIFFERENT NAMES
 *
 * 👉 If you create MULTIPLE BEANS with SAME NAME:
 *
 *    ❌ @Primary WILL NOT WORK
 *
 *    Because Spring does NOT even reach the stage of choosing between beans.
 *
 * 👉 What happens then?
 *
 *    1. By default (modern Spring / Spring Boot):
 *       - Application will FAIL at startup
 *       - Exception: BeanDefinitionOverrideException
 *
 *    2. If overriding is ENABLED:
 *       - The LAST bean definition overrides the previous one
 *       - Only ONE bean remains in the context
 *
 *       👉 In this case also:
 *          @Primary becomes USELESS
 *          (because now there is no ambiguity at all)
 *
 * 👉 So remember:
 *
 *    SAME TYPE + DIFFERENT NAMES  → @Primary works ✅
 *    SAME NAME                   → Conflict / Override ❌
 *
 * 👉 Conclusion:
 *    Never rely on @Primary for same-name beans.
 *    Always keep bean names unique.
 *
 * ============================================================================
 */

