package com.gad.sales_v2.product_quantity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.gad.sales_v2.category.Category;
import com.gad.sales_v2.order.Order;
import com.gad.sales_v2.product.Product;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity(name = "product_quantity")
@Table(name = "product_quantity")
public class ProductQuantity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @OneToOne(cascade = { CascadeType.MERGE })
    @JoinColumn(name = "id_product", referencedColumnName = "id")
    @JsonManagedReference
    private Product product;
    @Column(name = "quantity")
    private int quantity;

    @Column(name = "price")
    private double price;

    @ManyToMany(mappedBy = "productQuantities")
    @JsonIgnore
    private List<Order> orders = new ArrayList<>();

    public ProductQuantity() {
    }

    public ProductQuantity(Product product, int quantity, double price) {
        this.product = product;
        this.quantity = quantity;
        this.price = price;
    }

    public ProductQuantity(Long id, Product product, int quantity) {
        this.id = id;
        this.product = product;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "ProductQuantity{" +
                "id=" + id +
                ", product=" + product +
                ", quantity=" + quantity +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductQuantity that = (ProductQuantity) o;
        return quantity == that.quantity && id.equals(that.id) && product.equals(that.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, product, quantity);
    }
}
