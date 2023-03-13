package com.example.Controllers;

import java.sql.SQLException;

import com.example.Service.CreateAccountRepo;
import com.example.model.Users;

public class CreateAccountController {
    private CreateAccountRepo createAccountRepo;

    public CreateAccountController(CreateAccountRepo createAccountRepo) {
        this.createAccountRepo = createAccountRepo;
    }

    public boolean createaccount(Users user) throws SQLException{
        if(createAccountRepo.createAccount(user)){
            return true;
        } else {
            return false;
        }
    }
}
