/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.metatrip.services;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;


/**
 *
 * @author Achref
 */
public class MailerService {
    public static void sendMail(String v) throws Exception {
        String mailContent = "bonjour admin un voyage a etet crÃ©e avec les corrdonees suivantes :"+v;
        String myAccountEmail = "solidev.3a18@gmail.com";
        String password = "NEXUS123.";
        System.out.println("Preparing to send email");
        Properties p = new Properties();

     
        p.put("mail.smtp.auth", "true");
        p.put("mail.smtp.starttls.enable", "true");
        p.put("mail.smtp.host", "smtp.gmail.com");
        p.put("mail.smtp.port", "587");
        p.put("mail.smtp.ssl.trust", "smtp.gmail.com");
       p.put("mail.smtp.starttls.enable", "true");
        Session session = Session.getInstance(p, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(myAccountEmail, password);
            }
        });

        Message message = prepareMessage(session, myAccountEmail, "fares.lamloum@esprit.tn" , mailContent);

        Transport.send(message);
        System.out.println("Message sent successfully");

    }

    private static Message prepareMessage(Session session, String myAccountEmail, String recipient , String mailContent) {
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myAccountEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
            message.setSubject("Welcome Admin");
            message.setContent(mailContent, "text/html");
        /*
               Multipart mp = new MimeMultipart("related");

               MimeBodyPart pixPart = new MimeBodyPart();
   pixPart.attachFile("C:\\Users\\medal\\OneDrive\\Bureau\\demo.png");
   pixPart.setContentID("<" + "QR CODE " + ">");
   pixPart.setDisposition(MimeBodyPart.INLINE);
            
    mp.addBodyPart(pixPart);

   // Setting message content
   message.setContent(mp);*/
            
            return message;
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
        return null;
    }
}