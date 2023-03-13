package com.example.model;

public class OrderDetails {
    private int order_details_id;
    private int id_user;
    private int book_id;
    private int quantity;
    private float total_price;

    public OrderDetails() {
    }

    public OrderDetails(int order_details_id, int id_user, int book_id, int quantity, float total_price) {
        this.order_details_id = order_details_id;
        this.id_user = id_user;
        this.book_id = book_id;
        this.quantity = quantity;
        this.total_price = total_price;
    }

    public int getOrder_details_id() {
        return order_details_id;
    }

    public void setOrder_details_id(int order_details_id) {
        this.order_details_id = order_details_id;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getTotal_price() {
        return total_price;
    }

    public void setTotal_price(float total_price) {
        this.total_price = total_price;
    }

}
