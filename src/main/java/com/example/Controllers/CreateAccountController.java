package com.example.Controllers;

import java.sql.SQLException;

import com.example.Service.CreateAccountRepo;
import com.example.model.Users;

public class CreateAccountController {
    private CreateAccountRepo createAccountRepo;

    public CreateAccountController(CreateAccountRepo createAccountRepo) {
        this.createAccountRepo = createAccountRepo;
    }

    public String createaccount(Users user) throws SQLException{
        if(createAccountRepo.createAccount(user)){
            return "Added User";
        } else {
            return "Failed to Add User";
        }
    }
}
