package org.example.CloudXact.Email_T;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class main {
    public static void main(String[] args) throws AddressException {
        // 邮件配置
        String host = "smtp.gmail.com"; // 邮件服务器主机名
        String username = "snowball87.231@gmail.comm"; // 发件人邮箱账号
        String password = "vubc fhlr tpnx okey"; // 发件人邮箱密码

        // 收件人和发件人电子邮件地址
        String toAddress = "weslychan9@gmail.com"; // 收件人邮箱地址
        String fromAddress = "snowball87.231@gmail.com"; // 发件人邮箱地址

        // 邮件内容
        String subject = "Hello from JavaMail"; // 邮件主题
        String body = "This is a test email from JavaMail"; // 邮件正文

        // 配置邮件服务器属性
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "587");

        // 创建会话
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
                return new javax.mail.PasswordAuthentication(username, password);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(fromAddress));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toAddress));
            message.setSubject(subject);
            message.setText(body);

            Transport.send(message);

            System.out.println("Email sent successfully.");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
