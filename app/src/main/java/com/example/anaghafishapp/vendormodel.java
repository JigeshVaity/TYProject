package com.example.anaghafishapp;

import java.util.Map;

public class vendormodel {
    String image_url, phone_number, price, product_name, vendor_name;
    Map<String, String> vendors;
    public vendormodel() {
    }

    public vendormodel(String image_url, String phone_number, String price, String product_name, String vendor_name,Map<String, String> vendors) {
        this.image_url = image_url;
        this.phone_number = phone_number;
        this.price = price;
        this.product_name = product_name;
        this.vendor_name = vendor_name;
        this.vendors = vendors;
    }
    public Map<String, String> getVendors() {
        return vendors;
    }

    public void setVendors(Map<String, String> vendors) {
        this.vendors = vendors;
    }
    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getVendor_name() {
        return vendor_name;
    }

    public void setVendor_name(String vendor_name) {
        this.vendor_name = vendor_name;
    }
}
