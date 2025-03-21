package com.farm_management.farm_management.service;

import java.io.File;

public interface emailService {
    void sendEmail(String to, String subject, String message);

    void sendEmail(String [] to, String subject, String message);

    void SendEmailWithFile(String to, String subject, String message, File file );

}
