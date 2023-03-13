package com.example.DAO;

import java.sql.SQLException;

import com.example.Controllers.CreateAccountController;
import com.example.Controllers.UserValidatorController;
import com.example.Service.CreateAccountRepo;
import com.example.Service.UserService;
import com.example.Service.UserValidatorRepo;
import com.example.model.Users;

public class Main3 {
    public static void main(String[] args) throws SQLException {
        CreateAccountRepo createAccountRepo = new UserService();
        CreateAccountController accountController = new CreateAccountController(createAccountRepo);

        Users user = new Users(4,"d@gmail.com", "123", "Nguyen Van D","Binh Tien", 0);
        String result = accountController.createaccount(user);
        System.out.println(result);
    }
}
