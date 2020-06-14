package com.example.ecommerceapp.pojo;

public class TrendingPojo {
    int productPrice;
    String productName;
    String productDiscription;
    String productCatgoires;

    int productImages;

    public TrendingPojo() {
    }


    public TrendingPojo(int productPrice, String productName, String productDiscription, String productCatgoires, int productImages) {
        this.productPrice = productPrice;
        this.productName = productName;
        this.productDiscription = productDiscription;
        this.productCatgoires = productCatgoires;
        this.productImages = productImages;
    }

    public String getProductCatgoires() {
        return productCatgoires;
    }

    public void setProductCatgoires(String productCatgoires) {
        this.productCatgoires = productCatgoires;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDiscription() {
        return productDiscription;
    }

    public void setProductDiscription(String productDiscription) {
        this.productDiscription = productDiscription;
    }

    public int getProductImages() {
        return productImages;
    }

    public void setProductImages(int productImages) {
        this.productImages = productImages;
    }
}
