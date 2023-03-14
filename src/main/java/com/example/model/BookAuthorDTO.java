package com.example.model;

public class BookAuthorDTO {
    private String title;
    private float price;
    private int quantity;
    private String image_url;
    private String description;
    private String name_a;
    

    public BookAuthorDTO(String title, float price, int quantity, String image_url, String description, String name_a) {
        this.title = title;
        this.price = price;
        this.quantity = quantity;
        this.image_url = image_url;
        this.description = description;
        this.name_a = name_a;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName_a() {
        return name_a;
    }

    public void setName_a(String name_a) {
        this.name_a = name_a;
    }


   

}
