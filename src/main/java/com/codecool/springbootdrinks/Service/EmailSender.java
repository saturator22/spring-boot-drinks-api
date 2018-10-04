package com.codecool.springbootdrinks.Service;

import com.google.common.collect.Lists;
import it.ozimov.springboot.mail.model.Email;
import it.ozimov.springboot.mail.model.defaultimpl.DefaultEmail;
import it.ozimov.springboot.mail.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import java.io.UnsupportedEncodingException;

@Service
public class EmailSender {
    @Autowired
    public EmailService emailService;

    public EmailSender() {}

    public EmailSender(EmailService emailService) {
        this.emailService = emailService;
    }

    public void sendEmailWithoutTemplating(String subject, String body) {

        try {
            final Email email = DefaultEmail.builder()
                    .from(new InternetAddress("noreplydemo847@gmail.com"))
                    .to(Lists.newArrayList(new InternetAddress("noreplydemo847@gmail.com", "Our suppa admin")))
                    .subject(subject)
                    .body(body)
                    .encoding("UTF-8").build();
            emailService.send(email);
        } catch (AddressException ae) {
            ae.printStackTrace();
        } catch (UnsupportedEncodingException ue) {
            ue.printStackTrace();
        }
    }
}
