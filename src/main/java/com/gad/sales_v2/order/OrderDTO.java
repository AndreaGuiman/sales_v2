package com.gad.sales_v2.order;

import com.gad.sales_v2.agent.Agent;
import com.gad.sales_v2.client.Client;
import com.gad.sales_v2.product.Product;
import com.gad.sales_v2.product_quantity.ProductQuantity;

import java.time.LocalDateTime;
import java.util.*;

public class OrderDTO {
    private Long id;
    private Long agentId;
    private Long clientId;
    private List<Long> productsId = new ArrayList<>();
    private List<Integer> quantities = new ArrayList<>();
    private String status;
    private double price;
    private LocalDateTime dateOfOrder;
    private LocalDateTime dateOfSending;

    private Agent agent;
    private Client client;
    private List<Product> products = new ArrayList<>();

    private List<ProductQuantity> productQuantities = new ArrayList<>();

    public OrderDTO() {
    }

    public OrderDTO(Long agentId, Long clientId, List<Long> productsId, List<Integer> quantities, String status, double price, LocalDateTime dateOfOrder) {
        this.agentId = agentId;
        this.clientId = clientId;
        this.productsId = productsId;
        this.quantities = quantities;
        this.status = status;
        this.price = price;
        this.dateOfOrder = dateOfOrder;
    }

    public OrderDTO(Long id, Agent agent, Client client, List<Product> products, List<Integer> quantities, String status, double price, LocalDateTime dateOfOrder, LocalDateTime dateOfSending) {
        this.id = id;
        this.status = status;
        this.dateOfOrder = dateOfOrder;
        this.agent = agent;
        this.client = client;
        this.price = price;
        this.products = products;
        this.dateOfSending = dateOfSending;
        this.quantities = quantities;
    }

    public OrderDTO(Long id, Long agentId, Long clientId, String status, double price, LocalDateTime dateOfOrder,
                    LocalDateTime dateOfSending, List<ProductQuantity> productQuantities) {
        this.id = id;
        this.agentId = agentId;
        this.clientId = clientId;
        this.status = status;
        this.price = price;
        this.dateOfOrder = dateOfOrder;
        this.dateOfSending = dateOfSending;
        this.productQuantities = productQuantities;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAgentId() {
        return agentId;
    }

    public void setAgentId(Long agentId) {
        this.agentId = agentId;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public List<Long> getProductsId() {
        return productsId;
    }

    public void setProductsId(List<Long> productsId) {
        this.productsId = productsId;
    }

    public List<Integer> getQuantities() {
        return quantities;
    }

    public void setQuantities(List<Integer> quantities) {
        this.quantities = quantities;
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

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public List<ProductQuantity> getProductQuantities() {
        return productQuantities;
    }

    public void setProductQuantities(List<ProductQuantity> productQuantities) {
        this.productQuantities = productQuantities;
    }

    @Override
    public String toString() {
        return "OrderDTO{" +
                "id=" + id +
                ", agentId=" + agentId +
                ", clientId=" + clientId +
                ", productsId=" + productsId +
                ", quantities=" + quantities +
                ", status='" + status + '\'' +
                ", price=" + price +
                ", dateOfOrder=" + dateOfOrder +
                ", dateOfSending=" + dateOfSending +
                ", agent=" + agent +
                ", client=" + client +
                ", products=" + products +
                '}';
    }
}
