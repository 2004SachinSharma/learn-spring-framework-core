package com.sachin.p16_Prototype_Scope;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.UUID;


@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class UserSession {
    private static String sessionID  ;

    UserSession() {
        this.sessionID = UUID.randomUUID().toString();

    }

    public String getSessionID() {
        return sessionID;
    }
}