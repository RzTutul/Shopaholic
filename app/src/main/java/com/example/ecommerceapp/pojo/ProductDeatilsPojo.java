package com.example.ecommerceapp.pojo;

public class ProductDeatilsPojo {
    String product_id;
    String productName;
    int productPrice;
    String productCatagories;
    int productImages;
    String productSize;
    String productColor;
    int prodcutQyt;

    public ProductDeatilsPojo() {
    }

    public ProductDeatilsPojo(String productName, int productPrice, String productCatagories, int productImages, String productSize, String productColor, int prodcutQyt) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.productCatagories = productCatagories;
        this.productImages = productImages;
        this.productSize = productSize;
        this.productColor = productColor;
        this.prodcutQyt = prodcutQyt;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
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

    public String getProductCatagories() {
        return productCatagories;
    }

    public void setProductCatagories(String productCatagories) {
        this.productCatagories = productCatagories;
    }

    public int getProductImages() {
        return productImages;
    }

    public void setProductImages(int productImages) {
        this.productImages = productImages;
    }

    public String getProductSize() {
        return productSize;
    }

    public void setProductSize(String productSize) {
        this.productSize = productSize;
    }

    public String getProductColor() {
        return productColor;
    }

    public void setProductColor(String productColor) {
        this.productColor = productColor;
    }

    public int getProdcutQyt() {
        return prodcutQyt;
    }

    public void setProdcutQyt(int prodcutQyt) {
        this.prodcutQyt = prodcutQyt;
    }
}
