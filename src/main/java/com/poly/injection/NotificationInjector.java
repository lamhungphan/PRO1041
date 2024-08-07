package com.poly.injection;

import com.poly.repository.NotificationRepository;
import com.poly.repository.impl.NotificationRepoImpl;
import com.poly.services.NotificationService;
import com.poly.services.impl.NotificationServiceImpl;

public class NotificationInjector {

    private static NotificationInjector instance;

    private final NotificationRepository notificationRepository;
    
    private final NotificationService notificationService;

    private NotificationInjector() {
        this.notificationRepository = new NotificationRepoImpl();
        this.notificationService = new NotificationServiceImpl(notificationRepository);
    }

    public static NotificationInjector getInstance() {
        if (instance == null) {
            synchronized (NotificationInjector.class) {
                if (instance == null) {
                    instance = new NotificationInjector();
                }
            }
        }
        return instance;
    }

    public NotificationRepository getNotificationRepository(){
        return notificationRepository;
    }
    
    public NotificationService getNotificationService(){
         return notificationService;
    }
}
