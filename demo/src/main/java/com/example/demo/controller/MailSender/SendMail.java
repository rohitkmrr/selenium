package com.example.demo.controller.MailSender;

/**
 * Created by zemoso on 4/10/17.
 */
public interface SendMail{
    void send(String to, String subject, String body);
}
