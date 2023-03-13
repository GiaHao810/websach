package com.example.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import com.example.model.Authors;
import com.example.model.Book;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:sqlserver://localhost:1422;databaseName=INFO_BOOK";
        String user = "sa";
        String password = "123456";
        
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            
            // Tạo đối tượng StudentDAOImpl
            AuthorsDAOimpl authorDAO = new AuthorsDAOimpl(connection);
            
            // Thêm một sinh viên mới vào cơ sở dữ liệu
            Authors authors = new Authors(2, "Nguyen Van C");
            authorDAO.add(authors);
            
            // Lấy thông tin sinh viên theo id
            // Authors author = authorDAO.getAuthorsByID(1);

            // System.out.println("Thông tin authors 1: " + author);
            
            // // Cập nhật thông tin sinh viên
            // author.setName_a("Nguyen Van B");
            // authorDAO.update(author);
            
            // // Xóa sinh viên khỏi cơ sở dữ liệu
            // authorDAO.deleted(1);
            
            // // Lấy danh sách tất cả sinh viên
            // List<Authors> a = authorDAO.getAllAuthors();
            // for (Authors s : a) {
            //     System.out.println(s);
            // }
            
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
