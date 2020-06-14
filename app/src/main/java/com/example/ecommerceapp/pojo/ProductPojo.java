package com.example.ecommerceapp.pojo;

public class ProductPojo {
    private int productImage;
    private String productName;
    private int productPrice;


    public ProductPojo() {
    }

    public ProductPojo(int productImage, String productName, int productPrice) {

        this.productImage = productImage;
        this.productName = productName;
        this.productPrice = productPrice;
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

    public int getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }
}
