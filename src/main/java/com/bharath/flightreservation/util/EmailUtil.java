package com.bharath.flightreservation.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Component
public class EmailUtil {

    @Autowired
    private JavaMailSender sender;

    @Value("${com.bharath.flightreservation.itinerary.email.subject}")
    private String EMAIL_UTIL_SUBJECT;

    @Value("${com.bharath.flightreservation.itinerary.email.body}")
    private String EMAIL_BODY_UTIL = "please find your Itinerary attached";

    public void SendItinerary(String toAddres, String filePath){
        MimeMessage message = sender.createMimeMessage();

        try {
            MimeMessageHelper messageHelper = new MimeMessageHelper(message,true);
            messageHelper.setTo(toAddres);
            messageHelper.setSubject("Itinerary for your flight");
            messageHelper.setText("please find your Itinerary attached");
            messageHelper.addAttachment("Itinerary", new File(filePath));
            sender.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

}
