package com.example.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.model.Users;

public class UserDAOimpl implements UserDAO {

    private Connection connection;

    @Override
    public int add(Users user) throws SQLException {
        String insertSql = "INSERT INTO INFO_BOOK.dbo.Users(id_user, email, pass, full_name, add_ress ,b_role) VALUES (?, ? ,?, ? ,?, ?)";
        
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (Exception e) {
            // TODO: handle exception
        }

        Connection connection = ConnectionManager.getConnection();
            PreparedStatement statement = connection.prepareStatement(insertSql);
            statement.setInt(1, user.getId_user());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getPassword());
            statement.setString(4, user.getFull_name());
            statement.setString(5, user.getAddress());
            statement.setInt(6, user.getRole());
            int result = statement.executeUpdate();
            if(result > 0) {
                return 200; 
            } else {
                return 400;
            }
    }

    @Override
    public int update(Users user) throws SQLException {
        String updateSql = "UPDATE INFO_BOOK.dbo.Users SET email = ? , pass = ? , full_name = ? , add_ress = ? , b_role = ? WHERE id_user = ?";
        
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (Exception e) {
            // TODO: handle exception
        }

        Connection connection = ConnectionManager.getConnection();
            PreparedStatement statement = connection.prepareStatement(updateSql);
            statement.setInt(6, user.getId_user());
            statement.setString(1, user.getEmail());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getFull_name());
            statement.setString(4, user.getAddress());
            statement.setInt(5, user.getRole());
            int result = statement.executeUpdate();
            System.out.println("Cập nhật thông tin users thành công!");
            return result;
        }
    

    @Override
    public int deleted(int id) throws SQLException {
        String deleteSql = "DELETE FROM INFO_BOOK.dbo.Users WHERE id_user = ?";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (Exception e) {
            // TODO: handle exception
        }
        Connection connection = ConnectionManager.getConnection();
            PreparedStatement statement = connection.prepareStatement(deleteSql);
            statement.setInt(1, id);
            int result = statement.executeUpdate();
            System.out.println("Xóa user thành công!");
            return result;
    }

    @Override
    public Users getUsersByEmail(String emailUN) throws SQLException {
        String selectSql = "SELECT * FROM INFO_BOOK.dbo.Users WHERE email = ?";
        Users users = new Users();

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (Exception e) {
            // TODO: handle exception
        }

        Connection connection = ConnectionManager.getConnection();
            PreparedStatement statement = connection.prepareStatement(selectSql);
            statement.setString(1, emailUN);
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                int id_user = result.getInt("id_user");
                String email = result.getString("email");
                String password = result.getString("pass");
                String full_name = result.getString("full_name");
                String address = result.getString("add_ress");
                int role = result.getInt("b_role");
                users = new Users(id_user, email, password, full_name, address, role);
                return users;
            }
            connection.close();
        return null;
    }

    @Override
    public Users getUsersByID(Integer id) {
        String selectSql = "SELECT * FROM INFO_BOOK.dbo.Users WHERE id_user = ?";
        Users users = new Users();
        try (Connection connection = ConnectionManager.getConnection()){
            PreparedStatement statement = connection.prepareStatement(selectSql);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                int id_user = result.getInt("id_user");
                String email = result.getString("email");
                String password = result.getString("pass");
                String full_name = result.getString("full_name");
                String address = result.getString("add_ress");
                int role = result.getInt("b_role");
                users = new Users(id_user, email, password, full_name, address, role);
                return users;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public List<Users> getAllBook() {
        List<Users> list = new ArrayList<Users>();
        String selectSql = "SELECT * FROM INFO_BOOK.dbo.Books";
        try (Connection connection = ConnectionManager.getConnection()){
            PreparedStatement statement = connection.prepareStatement(selectSql);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                int id_user = result.getInt("id_user");
                String email = result.getString("email");
                String password = result.getString("pass");
                String full_name = result.getString("full_name");
                String address = result.getString("address");
                int role = result.getInt("role");
                Users users = new Users(id_user, email, password, full_name, address, role);
                list.add(users);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

}