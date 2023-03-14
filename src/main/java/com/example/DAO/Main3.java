package com.example.DAO;

import java.sql.SQLException;

import com.example.Controllers.CreateAccountController;
import com.example.Controllers.UserValidatorController;
import com.example.Service.CreateAccountRepo;
import com.example.Service.UserService;
import com.example.Service.UserValidatorByMailRepo;
import com.example.model.Users;

public class Main3 {
    public static void main(String[] args) throws SQLException {
        CreateAccountRepo createAccountRepo = new UserService();
        CreateAccountController createAccountController = new CreateAccountController(createAccountRepo);
        UserValidatorByMailRepo userValidatorMailRepo = new UserService();
        UserValidatorController userValidatorController = new UserValidatorController(userValidatorMailRepo);
        String email = "a@gmail.com";
        Users user = new Users(0, email, "123", "Nguyen Van A", "Binh Thanh", 0);

        try {
            if(userValidatorController.validUserByMail(email)) {
                System.out.println("Email da bi trung");
            } else {
                if(createAccountController.createaccount(user)) {
                    System.out.println("Tao tai khoan thanh cong");
                } else {
                    System.out.println("Tao tai khoan that bai");
                }
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}

