package com.example.anaghafishapp.retrieve;

public class Product {
    private String productName;
    private String vendorName;
    private String imageUrl;
    private String phoneNumber;
    private String price;

    public Product() {
        // Default constructor required for Firebase
    }

    public Product(String productName, String vendorName, String imageUrl, String phoneNumber, String price) {
        this.productName = productName;
        this.vendorName = vendorName;
        this.imageUrl = imageUrl;
        this.phoneNumber = phoneNumber;
        this.price = price;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}

