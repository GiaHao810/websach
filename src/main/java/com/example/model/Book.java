package com.example.model;

public class Book {
    private int book_id;
    private String title;
    private float price;
    private int quantity;
    private byte[] image_url;
    private String description;
    private int author_id;

    public Book(){
    }

    public Book(int book_id, String title, float price, int quantity, byte[] image_url, String description,
            int author_id) {
        this.book_id = book_id;
        this.title = title;
        this.price = price;
        this.quantity = quantity;
        this.image_url = image_url;
        this.description = description;
        this.author_id = author_id;
    }

    public byte[] getImage_url() {
        return image_url;
    }

    public void setImage_url(byte[] image_url) {
        this.image_url = image_url;
    }


    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(int author_id) {
        this.author_id = author_id;
    }

}
