package com.gad.sales_v2.client;

public class ClientDTO {
    private String name;
    private String vatOrIdNumber;
    private String bankName;
    private String bankAccount;
    private String email;
    private String telephoneNumber;
    private String address;

    public ClientDTO() {
    }

    public ClientDTO(String name, String vatOrIdNumber, String bankName, String bankAccount, String email, String telephoneNumber, String address) {
        this.name = name;
        this.vatOrIdNumber = vatOrIdNumber;
        this.bankName = bankName;
        this.bankAccount = bankAccount;
        this.email = email;
        this.telephoneNumber = telephoneNumber;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVatOrIdNumber() {
        return vatOrIdNumber;
    }

    public void setVatOrIdNumber(String vatOrIdNumber) {
        this.vatOrIdNumber = vatOrIdNumber;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "ClientDTO{" +
                "name='" + name + '\'' +
                ", vatOrIdNumber='" + vatOrIdNumber + '\'' +
                ", bankName='" + bankName + '\'' +
                ", bankAccount='" + bankAccount + '\'' +
                ", email='" + email + '\'' +
                ", telephoneNumber='" + telephoneNumber + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
