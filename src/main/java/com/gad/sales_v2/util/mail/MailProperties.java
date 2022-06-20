package com.gad.sales_v2.util.mail;

import java.util.Properties;

public class MailProperties {
    public static Properties getProperties(){
        Properties properties = new java.util.Properties();
        properties.put("mail.debug", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.host", "smtp.mail.yahoo.com");
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.socketFactory.port", "465");
        properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        properties.put("mail.smtp.socketFactory.fallback", "false");
        return properties;
    }
}
