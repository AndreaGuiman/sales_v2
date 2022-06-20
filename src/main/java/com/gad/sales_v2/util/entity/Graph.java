package com.gad.sales_v2.util.entity;

public class Graph {
    private String productOrCategoryName;
    private Integer soldQuantity;
    private double priceOfSoldProducts;

    public Graph() {
    }

    public Graph(String productOrCategoryName, Integer soldQuantity, double priceOfSoldProducts) {
        this.productOrCategoryName = productOrCategoryName;
        this.soldQuantity = soldQuantity;
        this.priceOfSoldProducts = priceOfSoldProducts;
    }

    public String getProductOrCategoryName() {
        return productOrCategoryName;
    }

    public void setProductOrCategoryName(String productOrCategoryName) {
        this.productOrCategoryName = productOrCategoryName;
    }

    public Integer getSoldQuantity() {
        return soldQuantity;
    }

    public void setSoldQuantity(Integer soldQuantity) {
        this.soldQuantity = soldQuantity;
    }

    public double getPriceOfSoldProducts() {
        return priceOfSoldProducts;
    }

    public void setPriceOfSoldProducts(double priceOfSoldProducts) {
        this.priceOfSoldProducts = priceOfSoldProducts;
    }

    @Override
    public String toString() {
        return "Graph{" +
                "productName='" + productOrCategoryName + '\'' +
                ", soldQuantity=" + soldQuantity +
                ", priceOfSoldProducts=" + priceOfSoldProducts +
                '}';
    }
}
