package com.poly.utils;

public enum NotificationTitle {
    THEM("Thêm"),
    XOA("Xoá"),
    SUA("Sửa");

    private final String displayName;

    NotificationTitle(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
