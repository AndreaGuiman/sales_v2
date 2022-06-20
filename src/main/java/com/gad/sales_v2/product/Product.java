package com.gad.sales_v2.product;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gad.sales_v2.category.Category;

import javax.persistence.*;
import java.util.Objects;

@Entity(name = "product")
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "product_image", unique = true)
    private String productImage;
    @Column(name = "name")
    private String name;
    @Column(name = "price")
    private double price;
    @Column(name = "stock")
    private int stock;
    @Column(name = "description", length = 1256)
    private String description;
    @Column(name = "active")
    private boolean active;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JsonIgnore
    @JoinColumn(name = "id_category")
    private Category category;

    public Product() {
    }

    public Product(String productImage, String name, double price, int stock, String description, boolean active, Category category) {
        this.productImage = productImage;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.description = description;
        this.active = active;
        this.category = category;
    }

    public Product(Long id, String productImage, String name, double price, int stock, String description, Category category) {
        this.id = id;
        this.productImage = productImage;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.description = description;
        this.category = category;
    }

    public Product(Product product) {
        this.active = product.active;
        this.category = product.category;
        this.description = product.description;
        this.id = product.id;
        this.name = product.name;
        this.price = product.price;
        this.productImage = product.productImage;
        this.stock = product.stock;
    }


    public Long getId() {
        return id;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productImage='" + productImage + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Double.compare(product.price, price) == 0 && stock == product.stock && Objects.equals(id, product.id) &&
                Objects.equals(productImage, product.productImage) && Objects.equals(name, product.name) &&
                Objects.equals(description, product.description) && Objects.equals(category, product.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, productImage, name, price, stock, description, category);
    }
}
