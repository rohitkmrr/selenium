package com.example.demo.controller.MailSender;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;


/**
 * Created by zemoso on 4/10/17.
 */

@Component
public class MockMailSender implements SendMail{

    private static Log log = LogFactory.getLog( MockMailSender.class );

    @Override
    public void send(String to, String subject, String body){
        log.info( "Sending to " + to );
        log.info( "Sending subject " + subject );
        log.info( "Sending body " + body );

    }
}
