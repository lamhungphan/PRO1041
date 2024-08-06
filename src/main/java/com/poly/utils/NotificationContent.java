package com.poly.utils;

public enum NotificationContent {
    EVENT("Event"),
    MEMBER("Member");

    private final String displayName;

    NotificationContent(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
