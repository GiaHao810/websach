package com.example.Controllers;

import java.sql.SQLException;

import com.example.Service.ChangepassRepo;

public class ChangepassController  {
    private ChangepassRepo changepassRepo;

    public ChangepassController(ChangepassRepo changepassRepo) {
        this.changepassRepo = changepassRepo;
    }

    public void changepassword(String email, String oldP, String newP) throws SQLException{
        changepassRepo.changepass(email, oldP, newP);
    }
}
