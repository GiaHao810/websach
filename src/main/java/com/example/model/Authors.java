package com.example.model;

public class Authors {
    
    private int author_id;
    private String name_a;
    
    public int getAuthor_id() {
        return author_id;
    }
    public void setAuthor_id(int author_id) {
        this.author_id = author_id;
    }
    public String getName_a() {
        return name_a;
    }
    public void setName_a(String name_a) {
        this.name_a = name_a;
    }
    public Authors(int author_id, String name_a) {
        this.author_id = author_id;
        this.name_a = name_a;
    }
    public Authors() {
    } 
}
