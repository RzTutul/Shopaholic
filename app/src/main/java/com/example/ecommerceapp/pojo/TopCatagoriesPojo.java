package com.example.ecommerceapp.pojo;

public class TopCatagoriesPojo {
    String topCatagoriesName;
    int topCatagoriesImage;

    public TopCatagoriesPojo() {
    }

    public TopCatagoriesPojo(String topCatagoriesName, int topCatagoriesImage) {
        this.topCatagoriesName = topCatagoriesName;
        this.topCatagoriesImage = topCatagoriesImage;
    }

    public String getTopCatagoriesName() {
        return topCatagoriesName;
    }

    public void setTopCatagoriesName(String topCatagoriesName) {
        this.topCatagoriesName = topCatagoriesName;
    }

    public int getTopCatagoriesImage() {
        return topCatagoriesImage;
    }

    public void setTopCatagoriesImage(int topCatagoriesImage) {
        this.topCatagoriesImage = topCatagoriesImage;
    }
}
