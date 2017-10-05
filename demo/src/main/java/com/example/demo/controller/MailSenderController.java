package com.example.demo.controller;

import com.example.demo.controller.MailSender.MockMailSender;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zemoso on 4/10/17.
 */
@RestController
public class MailSenderController{

    private static Log log =LogFactory.getLog( MailSenderController.class );
    @Autowired
    private MockMailSender mockMailSender;
//    private SendMail sendMail =new MockMailSender();

    @RequestMapping("/mail")
    public String send(){
        log.info( "Starting Controller Function" );
        mockMailSender.send( "rohit@zemosolabs.com", "Mock Mail", "Here is my mock mail, see the attachment" );
        return "Mail Sent Successfully";
    }
}
