package com.farm_management.farm_management.service.serviceImpl;

import com.farm_management.farm_management.service.emailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class emailServiceImpl implements emailService {


    private JavaMailSender javaMailSender;

    public emailServiceImpl(JavaMailSender javaMailSender){
        this.javaMailSender=javaMailSender;
    }
    @Override
    public void sendEmail(String to, String subject, String message) {
    }

    @Override
    public void sendEmail(String[] to, String subject, String message) {

    }

    @Override
    public void SendEmailWithFile(String to, String subject, String message, File file) {

    }
}
