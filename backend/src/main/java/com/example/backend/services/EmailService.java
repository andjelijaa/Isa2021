package com.example.backend.services;

import org.springframework.stereotype.Service;
import javax.mail.*;
import javax.mail.internet.*;
import java.nio.charset.Charset;
import java.util.Random;
import java.util.Date;
import java.util.Properties;

@Service
public class EmailService {

    private Session session;
    private final String username = "";
    private final String password = "";

    public EmailService() {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(
                        username,
                        password
                );
            }
        });
    }

    public static String generateActivationCode(){
        byte[] array = new byte[7]; // length is bounded by 7
        new Random().nextBytes(array);
        String generatedString = new String(array, Charset.forName("UTF-8"));
        return generatedString;
    }

    public void sendEmailActivationLinkToUser(String email, String link) throws MessagingException {
        System.out.println("posalje se mejl");

        Message msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress(username, false));

        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
        msg.setSubject("Activation link");
        msg.setContent("This is you activation link: " + link, "text/html");
        msg.setSentDate(new Date());

        MimeBodyPart messageBodyPart = new MimeBodyPart();
        messageBodyPart.setContent("This is you activation link: " + link, "text/html");

        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(messageBodyPart);

        Transport.send(msg);
    }

}
