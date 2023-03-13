package com.example.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.example.DAO.UserDAOimpl;
import com.example.model.Users;

public class UserService implements UserValidatorRepo, CreateAccountRepo, LoginRepo, ChangepassRepo {     
    private UserDAOimpl db = new UserDAOimpl();

    @Override
    public boolean validUser(String email, String password) throws SQLException {
        Users userDB =  db.getUsersByEmail(email);
        
        if(userDB == null) {
            return false;
        }

        String dbEmail = userDB.getEmail();
        String dbPassword = userDB.getPassword();

        if(dbEmail.equals(email) && dbPassword.equals(password)) {
            return true;
        } else { 
            return false;
        }
    }

    @Override
    public boolean createAccount(Users user) throws SQLException {
        int result = db.add(user);

        if(result == 200) {
            return true;
        } else if(result == 400) {
            return false;
        } else {
            return false;
        }
    }

    @Override
    public Users login(String username, String password) {
        Users userDB =  null;
        // db.getUsersByEmail(username);
        // Neu khong dung thi tra ve user Null
        return userDB;
    }

    @Override
    public void changepass(String email, String oldP, String newP) throws SQLException {
        Users userDB = db.getUsersByEmail(email);

        userDB.setPassword(newP); //Đổi Pass

        db.update(userDB); //Update lại Users
    }
}
