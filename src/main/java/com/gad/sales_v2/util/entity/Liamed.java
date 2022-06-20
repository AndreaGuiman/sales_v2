package com.gad.sales_v2.util.entity;

public class Liamed {
    private final String fullName = "AGmed S.R.L.";
    private final String address = "Brasov, Strada Grivitei";
    private final String vatNumber = "RO10188800";
    private final String registerNumber = "J08/100/1900";
    private final String bankAccount = "RO13BTRLRONCRT0305294701";
    private final String bank = "Banca Transilvania";
    private final String email = "office@agmed.ro";
    private final String telephoneNumber = "+4(0)744 / 306 554";

    public String getFullName() {
        return fullName;
    }

    public String getAddress() {
        return address;
    }

    public String getVatNumber() {
        return vatNumber;
    }

    public String getRegisterNumber() {
        return registerNumber;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public String getBank() {
        return bank;
    }

    public String getEmail() {
        return email;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    @Override
    public String toString() {
        return "Liamed{" +
                "fullName='" + fullName + '\'' +
                ", address='" + address + '\'' +
                ", vatNumber='" + vatNumber + '\'' +
                ", registerNumber='" + registerNumber + '\'' +
                ", bankAccount='" + bankAccount + '\'' +
                ", bank='" + bank + '\'' +
                ", email='" + email + '\'' +
                ", telephoneNumber='" + telephoneNumber + '\'' +
                '}';
    }
}
