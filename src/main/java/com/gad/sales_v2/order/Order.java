package com.gad.sales_v2.order;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.gad.sales_v2.agent.Agent;
import com.gad.sales_v2.client.Client;
import com.gad.sales_v2.product_quantity.ProductQuantity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "order_table")
@Table(name = "order_table")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "id_agent", nullable = false)
    @JsonManagedReference
    private Agent agent;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_client", nullable = false)
    @JsonManagedReference
    private Client client;
    @Column(name = "status")
    private String status;
    @Column(name = "price")
    private double price;
    @Column(name = "dateOfOrder")
    private LocalDateTime dateOfOrder;
    @Column(name = "dateOfSending")
    private LocalDateTime dateOfSending;
    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(name = "order_table_product_quantity",
        joinColumns = @JoinColumn(name = "id_order"),
        inverseJoinColumns = @JoinColumn(name = "id_product_quantity"))
    private List<ProductQuantity> productQuantities = new ArrayList<>();

    public Order() {
    }

    public Order(Agent agent, Client client) {
        this.agent = agent;
        this.client = client;
    }

    public Order(Long id, Agent agent, Client client) {
        this.id = id;
        this.agent = agent;
        this.client = client;
    }

    public Order(Agent agent, Client client, String status, double price, LocalDateTime dateOfOrder, LocalDateTime dateOfSending,
                 List<ProductQuantity> productQuantities) {
        this.agent = agent;
        this.client = client;
        this.status = status;
        this.price = price;
        this.dateOfOrder = dateOfOrder;
        this.dateOfSending = dateOfSending;
        this.productQuantities = productQuantities;
    }

    public Order(Long id, Agent agent, Client client, String status, double price, LocalDateTime dateOfOrder, LocalDateTime dateOfSending,
                 List<ProductQuantity> productQuantities) {
        this.id = id;
        this.agent = agent;
        this.client = client;
        this.status = status;
        this.price = price;
        this.dateOfOrder = dateOfOrder;
        this.dateOfSending = dateOfSending;
        this.productQuantities = productQuantities;
    }

    public Long getId() {
        return id;
    }

    public Agent getAgent() {
        return agent;
    }

    public void setAgent(Agent agent) {
        this.agent = agent;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<ProductQuantity> getProductQuantities() {
        return productQuantities;
    }

    public void setProductQuantities(List<ProductQuantity> productQuantities) {
        this.productQuantities = productQuantities;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    public LocalDateTime getDateOfOrder() {
        return dateOfOrder;
    }

    public void setDateOfOrder(LocalDateTime dateOfOrder) {
        this.dateOfOrder = dateOfOrder;
    }

    public LocalDateTime getDateOfSending() {
        return dateOfSending;
    }

    public void setDateOfSending(LocalDateTime dateOfSending) {
        this.dateOfSending = dateOfSending;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", agent=" + agent +
                ", status='" + status + '\'' +
                ", price=" + price +
                ", dateOfOrder=" + dateOfOrder +
                ", dateOfSending=" + dateOfSending +
                ", productQuantities=" + productQuantities +
                '}';
    }
}
