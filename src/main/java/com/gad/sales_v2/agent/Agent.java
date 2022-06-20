package com.gad.sales_v2.agent;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.gad.sales_v2.order.Order;
import com.gad.sales_v2.user.User;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity(name = "agent")
@Table(name = "agent")

public class Agent {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "telephone_number")
    private String telephoneNumber;
    @Column(name = "active")
    private boolean active;

    @Column(name = "photo")
    private String photo;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_user")
    @JsonManagedReference
    private User user;

    @OneToMany(mappedBy = "agent")
    @JsonIgnore
    private List<Order> orders = new ArrayList<>();

    public Agent() {
    }

    public Agent(String firstName, String lastName, String telephoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.telephoneNumber = telephoneNumber;
    }

    public Agent(Long id, String firstName, String lastName, String telephoneNumber) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.telephoneNumber = telephoneNumber;
    }

    public Agent(String firstName, String lastName, String telephoneNumber, boolean active, String photo, User user) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.telephoneNumber = telephoneNumber;
        this.active = active;
        this.photo = photo;
        this.user = user;
    }

    public Agent(String firstName, String lastName, String telephoneNumber, boolean active, User user) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.telephoneNumber = telephoneNumber;
        this.active = active;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public void setOrder(List<Order> orders) {
        this.orders = orders;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Override
    public String toString() {
        return "Agent{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", telephoneNumber='" + telephoneNumber + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Agent agent = (Agent) o;
        return id.equals(agent.id) && firstName.equals(agent.firstName) && lastName.equals(agent.lastName) && telephoneNumber.equals(agent.telephoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, telephoneNumber);
    }
}
