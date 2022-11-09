package com.example.rest;


public class Product {
    private Long productId;
    private String productName;
    private Double salesPrice;

    public Product() {
    }

    public Product(String productName, Double salesPrice) {
        this.productName = productName;
        this.salesPrice = salesPrice;
    }

    public Product(Long productId, String productName, Double salesPrice) {
        this.productId = productId;
        this.productName = productName;
        this.salesPrice = salesPrice;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getSalesPrice() {
        return salesPrice;
    }

    public void setSalesPrice(Double salesPrice) {
        this.salesPrice = salesPrice;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", salesPrice=" + salesPrice +
                '}';
    }
}
