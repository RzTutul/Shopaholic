package com.example.ecommerceapp.pojo;

class SliderImagePojo {
    private String imageUrl;
    private String imageTitl;

    public SliderImagePojo() {
    }

    public SliderImagePojo(String imageUrl, String imageTitl) {
        this.imageUrl = imageUrl;
        this.imageTitl = imageTitl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getImageTitl() {
        return imageTitl;
    }

    public void setImageTitl(String imageTitl) {
        this.imageTitl = imageTitl;
    }
}
