package com.gad.sales_v2.util.mail;

import com.gad.sales_v2.order.Order;
import com.gad.sales_v2.util.pdf.PDFService;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class MailService {
    public static void sendMail(Credentials credentials, Order order) throws Exception {
        Properties properties = MailProperties.getProperties();
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(
                        credentials.getEmailAddressLiamed(),
                        credentials.getPassword()
                );
            }
        });
        Message message = MailMessage.getMessage(session, credentials, order);
        try {
            Transport.send(message);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public static void sendMailWithPDF(Credentials credentials, Order order) throws Exception {
        Properties properties = MailProperties.getProperties();
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(
                        credentials.getEmailAddressLiamed(),
                        credentials.getPassword()
                );
            }
        });
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(credentials.getEmailAddressLiamed()));
        message.setRecipient(javax.mail.Message.RecipientType.TO, new InternetAddress(
                credentials.getEmailAddressClient()
        ));
        message.setSubject(String.format(
                "AGMed - comanda #%s a fost înregistrată",
                order.getId()
        ));

        Multipart multipart = new MimeMultipart();
        MimeBodyPart messageBodyPart = new MimeBodyPart();
        String html = String.format(
                "Bună ziua, \n" +
                        "Comanda #%1$s a fost înregistrată azi: %2$s la ora: %3$s.\n\n" +
                        "Comanda urmează să fie procesată începând cu ziua de mâine: %4$s, ora: %5$s.\n\n" +
                        "Aveți posibilitatea să anulați comanda până în momentul în care aceasta devine procesată.",
                order.getId(),
                order.getDateOfOrder().toLocalDate(),
                order.getDateOfOrder().toLocalTime(),
                order.getDateOfSending().toLocalDate(),
                order.getDateOfSending().toLocalTime());
        messageBodyPart.setText(html, "utf-8", "html");
        multipart.addBodyPart(messageBodyPart);

        MimeBodyPart pdfBodyPart = new MimeBodyPart();
        String path = PDFService.getPathToPDF(order.getId());
        pdfBodyPart.attachFile(new File(path), "application/pdf", null);
        multipart.addBodyPart(pdfBodyPart);
        message.setContent(multipart);
        try {
            Transport.send(message);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public static void sendSyncMail(Credentials credentials, List<Order> orders) throws Exception {
        Properties properties = MailProperties.getProperties();
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(
                        credentials.getEmailAddressLiamed(),
                        credentials.getPassword()
                );
            }
        });

        List<Message> messages = new ArrayList<>();
        orders.forEach(order -> {
            Message message = new MimeMessage(session);
            try {
                message.setFrom(new InternetAddress(credentials.getEmailAddressLiamed()));
                message.setRecipient(Message.RecipientType.TO, new InternetAddress(
                        credentials.getEmailAddressClient()
                ));
                message.setSubject(String.format(
                        "AGMed - sincronizare comanda #%s", order.getId()));
                Multipart multipart = new MimeMultipart();
                MimeBodyPart pdfBodyPart = new MimeBodyPart();
                String path = PDFService.getPathToPDF(order.getId());
                pdfBodyPart.attachFile(new File(path), "application/pdf", null);
                multipart.addBodyPart(pdfBodyPart);
                message.setContent(multipart);
                messages.add(message);
            } catch (MessagingException | IOException e) {
                throw new RuntimeException(e);
            }
        });

        messages.forEach(message -> {
            try {
                Transport.send(message);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
    }
}
