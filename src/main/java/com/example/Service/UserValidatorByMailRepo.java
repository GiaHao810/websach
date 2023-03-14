package com.example.Service;

import java.sql.SQLException;

public interface UserValidatorByMailRepo {
    boolean validUserByMail(String email) throws SQLException;
}
