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

    public void sendRezervacijaEmail(String email) throws MessagingException {
        System.out.println("posalje se mejl");

        Message msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress(username, false));

        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
        msg.setSubject("Rezervacija");
        msg.setContent("Uspesno ste rezervisali uslugu", "text/html");
        msg.setSentDate(new Date());

        MimeBodyPart messageBodyPart = new MimeBodyPart();
        messageBodyPart.setContent("Uspesno ste rezervisali uslugu", "text/html");

        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(messageBodyPart);

        Transport.send(msg);
    }

    public void sendEmailForZalba(String korisnik, String vlasnik, String opis, String odgovor) throws MessagingException {
        System.out.println("posalje se mejl za zalbe");

        StringBuilder sb = new StringBuilder();
        sb.append("Zalba:\n");
        sb.append(opis);
        sb.append("Odgovor:\n");
        sb.append(odgovor);


        Message msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress("admin@admin.com", false));

        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(korisnik));
        msg.setSubject("Odgovor na zalbu");
        msg.setContent(sb.toString(), "text/html");
        msg.setSentDate(new Date());

        MimeBodyPart messageBodyPart = new MimeBodyPart();
        messageBodyPart.setContent(sb.toString(), "text/html");

        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(messageBodyPart);

        Transport.send(msg);

        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(vlasnik));
        msg.setSubject("Odgovor na zalbu");
        msg.setContent(sb.toString(), "text/html");
        msg.setSentDate(new Date());

        messageBodyPart = new MimeBodyPart();
        messageBodyPart.setContent(sb.toString(), "text/html");

        multipart = new MimeMultipart();
        multipart.addBodyPart(messageBodyPart);

        Transport.send(msg);
    }

}
