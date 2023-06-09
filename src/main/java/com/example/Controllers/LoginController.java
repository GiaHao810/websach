package com.example.Controllers;

import java.sql.SQLException;

import com.example.Service.LoginRepo;
import com.example.model.Users;

public class LoginController{
    private LoginRepo loginRepo;

    public LoginController(LoginRepo loginRepo) {
        this.loginRepo = loginRepo;
    }
    public Users login(String email, String password) throws SQLException{
        Users resultUser = loginRepo.login(email, password);

        return resultUser;
    }
}
