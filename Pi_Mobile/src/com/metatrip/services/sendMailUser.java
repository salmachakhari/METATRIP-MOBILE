/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metatrip.services;

import com.metatrip.entities.user;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


/**
 *
 * @author medal
 */
public class sendMailUser {
    public static void sendMail(user u) throws Exception {
        String mailContent = "bonjour voici  votre compte metatrip   avec les corrdonees suivantes :"+u.getEmail() +"password:"+u.getPassword();
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

        Message message = prepareMessage(session, myAccountEmail,"bensaid.mohamedali@esprit.tn", mailContent);
try{
        Transport.send(message);
}catch(Exception e){
    System.out.println(e.getMessage());}
System.out.println("Message sent successfully");

    }

    private static Message prepareMessage(Session session, String myAccountEmail, String recipient , String mailContent) {
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myAccountEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
            message.setSubject("Welcome ");
            message.setContent(mailContent, "text/html");
            return message;
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
        return null;
    }
}