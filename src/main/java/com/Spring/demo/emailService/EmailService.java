package com.Spring.demo.emailService;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
@Service
public class EmailService {

    public void sendMail(String to, String Subject, String email) {

        String host = ("smtp.gmail.com");
        Properties properties = System.getProperties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("akash.chouhan9546@gmail.com", "***********");
            }
            //	return new PasswordAuthentication("hrms1.user@gmail.com","ljjszomjlqfzcdhv");

        });
        try {
            MimeMessage mimeMessage = new MimeMessage(session);
            mimeMessage.setSubject(Subject);
            mimeMessage.setText(email);
            mimeMessage.setContent(email, "text/html");
            mimeMessage.addRecipients(Message.RecipientType.TO, new InternetAddress[]{new InternetAddress(to)});
            mimeMessage.setFrom("hrms1.user@gmail.com");
            Transport.send(mimeMessage);
        } catch (Exception e) {
            e.printStackTrace();
            throw new IllegalStateException("Failed to send email");
        }
    }
}
