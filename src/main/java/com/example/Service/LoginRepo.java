package com.example.Service;

import java.sql.SQLException;

import com.example.model.Users;

public interface LoginRepo {
    Users login(String email, String password) throws SQLException;
}
