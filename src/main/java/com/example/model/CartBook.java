package com.example.model;

public class CartBook {
    private int id;
    private float unitPrice;
	private int quantity;
	private OrderDetails OrderDetails;
	private Book book;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public float getUnitPrice() {
        return unitPrice;
    }
    public void setUnitPrice(float unitPrice) {
        this.unitPrice = unitPrice;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public OrderDetails getOrderDetails() {
        return OrderDetails;
    }
    public void setOrderDetails(OrderDetails orderDetails) {
        OrderDetails = orderDetails;
    }
    public Book getBook() {
        return book;
    }
    public void setBook(Book book) {
        this.book = book;
    }
}
