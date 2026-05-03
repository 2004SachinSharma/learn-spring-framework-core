package com.sachin.p05_Beans_and_Annotations2.service;

import com.sachin.p05_Beans_and_Annotations2.notification.NotificationService;
import com.sachin.p05_Beans_and_Annotations2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {
    private final UserRepository userRepository;
    private final NotificationService notificationService;

    @Autowired
    public UserService(UserRepository userRepository,
                       NotificationService notificationService) {
        this.userRepository = userRepository;
        this.notificationService = notificationService;
    }

    public void processUser() {
        String user = userRepository.getUser();
        System.out.println("Processing user: " + user);
        notificationService.notifyUser(user);
    }
}
