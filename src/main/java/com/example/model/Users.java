package com.example.model;

public class Users {
    private int id_user;
    private String email;
    private String password;
    private String full_name;
    private String address;
    private int role;

    public Users() {

    }

    public Users(int id_user, String email, String password, String full_name, String address, int role) {
        this.id_user = id_user;
        this.email = email;
        this.password = password;
        this.full_name = full_name;
        this.address = address;
        this.role = role;

    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }
    
}
