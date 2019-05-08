package com.example.resumegeneratorbackend.service;

import com.example.resumegeneratorbackend.model.EmailData;
import com.example.resumegeneratorbackend.model.Users;

public interface SendGridService {
    public String sendMail(EmailData emailData);
}
