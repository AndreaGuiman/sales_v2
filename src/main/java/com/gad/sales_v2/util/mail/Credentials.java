package com.gad.sales_v2.util.mail;

public class Credentials {

    private String emailAddressLiamed;
    private String password;
    private String emailAddressClient;

    public Credentials() {
    }

    public Credentials(String emailAddressLiamed, String password, String emailAddressClient) {
        this.emailAddressLiamed = emailAddressLiamed;
        this.password = password;
        this.emailAddressClient = emailAddressClient;
    }

    public String getEmailAddressLiamed() {
        return emailAddressLiamed;
    }

    public void setEmailAddressLiamed(String emailAddressLiamed) {
        this.emailAddressLiamed = emailAddressLiamed;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmailAddressClient() {
        return emailAddressClient;
    }

    public void setEmailAddressClient(String emailAddressClient) {
        this.emailAddressClient = emailAddressClient;
    }

    @Override
    public String toString() {
        return "Credentials{" +
                "emailAddressLiamed='" + emailAddressLiamed + '\'' +
                ", password='" + password + '\'' +
                ", emailAddressClient='" + emailAddressClient + '\'' +
                '}';
    }
}
