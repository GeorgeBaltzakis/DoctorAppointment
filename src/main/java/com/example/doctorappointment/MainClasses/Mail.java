package com.example.doctorappointment.MainClasses;

import java.sql.*;
import java.util.Properties;

import javax.mail.*;
import javax.mail.internet.*;

public class Mail {
    Session newSession = null;
    MimeMessage mimeMessage;
    public static void main(String[] args) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException, MessagingException {
        Mail mail = new Mail();
        mail.setupServerProperties();
        mail.draftEmail();
        mail.sendEmail();
    }

    private void sendEmail() throws MessagingException {
        String fromUser = "iasfaleia@gmail.com";  //Enter sender email id
        String fromUserPassword = "georgebal2608";  //Enter sender gmail password , this will be authenticated by gmail smtp server
        String emailHost = "smtp.gmail.com";
        Transport transport = newSession.getTransport("smtp");
        transport.connect(emailHost, fromUser, fromUserPassword);
        transport.sendMessage(mimeMessage, mimeMessage.getAllRecipients());
        transport.close();
        System.out.println("Email successfully sent!!!");
    }

    private void draftEmail() throws MessagingException {
        String[] emailReceipients = {"george-baltzakis@hotmail.gr"};  //Enter list of email recepients
        String emailSubject = "Test Mail";
        String emailBody = "Test Body of my email";
        mimeMessage = new MimeMessage(newSession);

        for (String emailReceipient : emailReceipients) {
            mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(emailReceipient));
        }
        mimeMessage.setSubject(emailSubject);

        MimeBodyPart bodyPart = new MimeBodyPart();
        bodyPart.setContent(emailBody,"html/text");
        MimeMultipart multiPart = new MimeMultipart();
        multiPart.addBodyPart(bodyPart);
        mimeMessage.setContent(multiPart);
    }

    private void setupServerProperties(){
        Properties properties = System.getProperties();
        properties.put("mail.smtp.port", "547");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        newSession = Session.getDefaultInstance(properties, null);
    }
}
