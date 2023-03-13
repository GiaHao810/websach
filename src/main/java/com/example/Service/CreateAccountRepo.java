package com.example.Service;

import java.sql.SQLException;

import com.example.model.Users;

public interface CreateAccountRepo {
    boolean createAccount(Users user) throws SQLException;
}
