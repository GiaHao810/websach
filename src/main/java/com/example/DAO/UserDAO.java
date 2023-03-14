package com.example.DAO;

import java.sql.SQLException;
import java.util.List;

import com.example.model.Users;

public interface UserDAO {

    public int add(Users user) throws SQLException;

    public int update(Users user) throws SQLException;

    public int deleted(int id) throws SQLException;

    public Users getUsersByID(Integer id);

    public Users getUsersByEmail(String email) throws SQLException;

    public List<Users> getAllBook();
}
