package com.gad.sales_v2.category;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.gad.sales_v2.product.Product;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity(name = "category")
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;

    @Column(name = "categoryPhoto")
    private String categoryPhoto;

    @Column(name = "active")
    private boolean active;

    @OneToMany(mappedBy = "category")
    @JsonManagedReference
    private List<Product> products = new ArrayList<>();

    public Category() {
    }

    public Category(String name) {
        this.name = name;
    }

    public Category(String name, boolean active) {
        this.name = name;
        this.active = active;
    }

    public Category(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Category(String name, String categoryPhoto) {
        this.name = name;
        this.categoryPhoto = categoryPhoto;
    }

    public Category(String name, String categoryPhoto, boolean active) {
        this.name = name;
        this.categoryPhoto = categoryPhoto;
        this.active = active;
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

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getCategoryPhoto() {
        return categoryPhoto;
    }

    public void setCategoryPhoto(String categoryPhoto) {
        this.categoryPhoto = categoryPhoto;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return id.equals(category.id) && name.equals(category.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
