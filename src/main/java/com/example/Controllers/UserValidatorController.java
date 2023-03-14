package com.example.Controllers;

import java.sql.SQLException;

import com.example.Service.UserValidatorByMailRepo;
import com.example.Service.UserValidatorRepo;

public class UserValidatorController {
    private UserValidatorRepo userValidatorRepo;
    private UserValidatorByMailRepo userValidatorByMailRepo;

    public UserValidatorController(UserValidatorRepo userValidatorRepo){
        this.userValidatorRepo = userValidatorRepo;
    }

    public UserValidatorController(UserValidatorByMailRepo userValidatorByMailRepo) {
        this.userValidatorByMailRepo = userValidatorByMailRepo;
    }

    public boolean validUser(String email, String password) throws SQLException{
        if(userValidatorRepo.validUser(email, password)){
            return true;
        } else {
            return false;
        }
    }

    public boolean validUserByMail(String email) throws SQLException {
        if(userValidatorByMailRepo.validUserByMail(email)){
            return true;
        }else {
            return false;
        }
    }
}
