package com.sachin.p05_Beans_and_Annotations2.notification;

import com.sachin.p05_Beans_and_Annotations2.external.EmailClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {
    private final EmailClient emailClient;

    @Autowired
    public NotificationService(EmailClient emailClient) {
        this.emailClient = emailClient;
    }

    public void notifyUser(String user) {
        emailClient.sendEmail("Hello " + user);
    }
}
