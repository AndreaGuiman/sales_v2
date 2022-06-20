package com.gad.sales_v2.client;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gad.sales_v2.order.Order;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity(name = "client")
@Table(name = "client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(
            name = "vat_or_id_number",
            unique = true
    )
    private String vatOrIdNumber;
    @Column(name = "bankName")
    private String bankName;
    @Column(name = "bank_account")
    private String bankAccount;
    @Column(name = "email")
    private String email;
    @Column(name = "telephone_number")
    private String telephoneNumber;

    @Column(name = "adress")
    private String address;
    @Column(name = "active")
    private boolean active;

    @OneToMany(mappedBy = "client")
    @JsonIgnore
    private List<Order> orders = new ArrayList<>();

    public Client() {
    }

    public Client(String name, String vatOrIdNumber, String bankName, String bankAccount, String email, String telephoneNumber, boolean active, String address) {
        this.name = name;
        this.vatOrIdNumber = vatOrIdNumber;
        this.bankName = bankName;
        this.bankAccount = bankAccount;
        this.email = email;
        this.telephoneNumber = telephoneNumber;
        this.active = active;
        this.address = address;
    }

    public Client(Long id, String name, String vatOrIdNumber, String bankName, String bankAccount, String email, String telephoneNumber, String address) {
        this.id = id;
        this.name = name;
        this.vatOrIdNumber = vatOrIdNumber;
        this.bankName = bankName;
        this.bankAccount = bankAccount;
        this.email = email;
        this.telephoneNumber = telephoneNumber;
        this.address = address;
    }

    public Long getId() {
        return id;
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

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrder(List<Order> order) {
        this.orders = order;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", vatOrIdNumber='" + vatOrIdNumber + '\'' +
                ", bankName='" + bankName + '\'' +
                ", bankAccount='" + bankAccount + '\'' +
                ", email='" + email + '\'' +
                ", telephoneNumber='" + telephoneNumber + '\'' +
                ", address='" + address + '\'' +
                ", active=" + active +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return active == client.active && id.equals(client.id) && name.equals(client.name) && vatOrIdNumber.equals(client.vatOrIdNumber) && bankName.equals(client.bankName) && bankAccount.equals(client.bankAccount) && email.equals(client.email) && telephoneNumber.equals(client.telephoneNumber) && address.equals(client.address) && orders.equals(client.orders);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, vatOrIdNumber, bankName, bankAccount, email, telephoneNumber, address, active, orders);
    }
}
