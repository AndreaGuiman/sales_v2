package com.gad.sales_v2.order;

import java.time.LocalDateTime;
import java.util.List;

public class Cart {
    private Long id;
    private Long idAgent;
    private Long idClient;
    private List<Long> productIds;
    private List<Integer> quantities;
    private String status;
    private LocalDateTime dateOfOrder;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdAgent() {
        return idAgent;
    }

    public void setIdAgent(Long idAgent) {
        this.idAgent = idAgent;
    }

    public Long getIdClient() {
        return idClient;
    }

    public void setIdClient(Long idClient) {
        this.idClient = idClient;
    }

    public List<Long> getProductIds() {
        return productIds;
    }

    public void setProductIds(List<Long> productIds) {
        this.productIds = productIds;
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

    public LocalDateTime getDateOfOrder() {
        return dateOfOrder;
    }

    public void setDateOfOrder(LocalDateTime dateOfOrder) {
        this.dateOfOrder = dateOfOrder;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", idAgent=" + idAgent +
                ", idClient=" + idClient +
                ", productIds=" + productIds +
                ", quantities=" + quantities +
                ", status='" + status + '\'' +
                ", dateOfOrder=" + dateOfOrder +
                '}';
    }
}
