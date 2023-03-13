package com.example.Service;

import java.sql.SQLException;

public interface ChangepassRepo {
    void changepass(String email, String oldP, String newP) throws SQLException;
}
