package com.example.DAO;

import java.sql.SQLException;

import com.example.Controllers.CreateAccountController;
import com.example.Service.CreateAccountRepo;
import com.example.Service.UserService;
import com.example.model.Users;

public class Main3 {
    public static void main(String[] args) throws SQLException {
        CreateAccountRepo createAccountRepo = new UserService();
        CreateAccountController createAccountController = new CreateAccountController(createAccountRepo);

        Users user = new Users(7, "j@gmail.com", "123"," Nguyen Van J", "Binh Thanh", 0);

        boolean result = createAccountController.createaccount(user);

        if(result) {
            System.out.println("Thanh cong");
        } else {
            System.out.println("That bai");
        }
    }
}
