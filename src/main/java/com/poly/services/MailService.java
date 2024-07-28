package com.poly.services;

public interface MailService {
    void sendEmailsToUsersAndAdmin(String from, String username, String password, String host, String subject, String content);
}
