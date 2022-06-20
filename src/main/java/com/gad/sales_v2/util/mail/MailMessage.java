package com.gad.sales_v2.util.mail;

import com.gad.sales_v2.order.Order;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailMessage {
    public static Message getMessage(Session session, Credentials credentials, Order order) throws MessagingException {
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(credentials.getEmailAddressLiamed()));
        message.setRecipient(javax.mail.Message.RecipientType.TO, new InternetAddress(
                credentials.getEmailAddressClient()
        ));
        message.setSubject(String.format(
                "Liamed - comanda #%s a fost inregistrata",
                order.getId()
        ));
        String html = String.format(
                "Buna ziua, \n\n" +
                        "Comanda #%1$s a fost inregistrata azi: %2$s la ora: %3$s.\n\n" +
                        "Comanda urmeaza sa fie procesata incepand cu ziua de maine: %4$s, ora: %5$s.\n\n" +
                        "Aveti posibilitatea sa anulati comanda pana in momentul in care aceasta devine procesata.",
                order.getId(),
                order.getDateOfOrder().toLocalDate(),
                order.getDateOfOrder().toLocalTime(),
                order.getDateOfSending().toLocalDate(),
                order.getDateOfSending().toLocalTime());
        message.setContent(html, "text/html");
        return message;
    }
}
