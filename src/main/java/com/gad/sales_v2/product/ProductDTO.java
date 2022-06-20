package com.gad.sales_v2.product;

public class ProductDTO {
    private Long id;
    private String productImage;
    private String name;
    private double price;
    private int stock;
    private String description;
    private String categoryName;

    public ProductDTO() {
    }

    public ProductDTO(Long id, String categoryName) {
        this.id = id;
        this.categoryName = categoryName;
    }

    public ProductDTO(String productImage, String name, double price, int stock, String description, String categoryName) {
        this.productImage = productImage;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.description = description;
        this.categoryName = categoryName;
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

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "ProductDTO{" +
                "id=" + id +
                ", productImage='" + productImage + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                ", description='" + description + '\'' +
                ", categoryName='" + categoryName + '\'' +
                '}';
    }
}
