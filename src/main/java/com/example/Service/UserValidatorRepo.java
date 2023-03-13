package com.example.Service;

import java.sql.Connection;
import java.sql.SQLException;

public interface UserValidatorRepo {
    boolean validUser(String email, String password) throws SQLException;
}
