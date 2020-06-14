package com.example.ecommerceapp.pojo;

public class HotDealsPojo {
    private int productImage;
    private String productName;
    private String productCatagories;
    private int productPrice;
    private String offerPercent;

    public HotDealsPojo() {
    }

    public HotDealsPojo(int productImage, String productName, String productCatagories, int productPrice, String offerPercent) {
        this.productImage = productImage;
        this.productName = productName;
        this.productCatagories = productCatagories;
        this.productPrice = productPrice;
        this.offerPercent = offerPercent;
    }

    public int getProductImage() {
        return productImage;
    }

    public void setProductImage(int productImage) {
        this.productImage = productImage;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductCatagories() {
        return productCatagories;
    }

    public void setProductCatagories(String productCatagories) {
        this.productCatagories = productCatagories;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }

    public String getOfferPercent() {
        return offerPercent;
    }

    public void setOfferPercent(String offerPercent) {
        this.offerPercent = offerPercent;
    }
}
