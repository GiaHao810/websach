package com.example.Controllers;

import java.sql.Connection;
import java.sql.SQLException;

import com.example.Service.UserValidatorRepo;

public class UserValidatorController {
    private UserValidatorRepo userValidatorRepo;

    public UserValidatorController(UserValidatorRepo userValidatorRepo){
        this.userValidatorRepo = userValidatorRepo;
    }

    public String validUser(String email, String password) throws SQLException{
        if(userValidatorRepo.validUser(email, password)){
            return "Valid";
        } else {
            return "Unvalid";
        }
    }
}
