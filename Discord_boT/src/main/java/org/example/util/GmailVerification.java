package org.example.util;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.*;

public class GmailVerification {
    public static void main(String[] args) {
        final String username = "dcbot.jst@gmail.com"; // Your Gmail address
        final String password = "A@@46426764@@a"; // Your Gmail password

        // Set up mail server properties
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        // Create a session with the Gmail server
        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            // Create a new message
            Message message = new MimeMessage(session);

            // Set the sender and recipient addresses
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("weslychan9@gmail.com")); // Replace with the recipient's email address
            message.setSubject("Verification Code");

            // Generate a random verification code (you can replace this with your own logic)
            String verificationCode = generateRandomCode();

            // Set the message content
            message.setText("Your verification code is: " + verificationCode);

            // Send the message
            Transport.send(message);

            System.out.println("Verification code sent successfully!");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    private static String generateRandomCode() {
        Random random = new Random();
        ArrayList<Integer> k = new ArrayList<>();
        while (k.size() < 7) {
            k.add(random.nextInt(0, 10));
        }
        return String.valueOf(k.get(0)) + String.valueOf(k.get(1)) + String.valueOf(k.get(2)) + String.valueOf(k.get(3)) + String.valueOf(k.get(4)) + String.valueOf(k.get(5));
    }
}
