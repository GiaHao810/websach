package com.example.DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.model.Book;

public class BookDAOimpl implements BookDAO {

    
    public BookDAOimpl() {
    }

    private Connection connection;

    public BookDAOimpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public int add(Book book) {

        String insertSql = "INSERT INTO INFO_BOOK.dbo.Books(book_id, title, price, quantity, image_url, dst , author_id ) VALUES (?, ? ,?, ? ,?, ? , ? )";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            connection = ConnectionManager.getConnection();
            PreparedStatement statement = connection.prepareStatement(insertSql);
            statement.setInt(1, book.getBook_id());
            statement.setString(2, book.getTitle());
            statement.setFloat(3, book.getPrice());
            statement.setInt(4, book.getQuantity());
            statement.setBytes(5, book.getImage_url());
            statement.setString(6, book.getDescription());
            statement.setInt(7, book.getAuthor_id());
            int result = statement.executeUpdate();
            if(result > 0) {
                return 200; 
            } else {
                return 400;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return 400;
        }
    }

    @Override
    public int update(Book book) {
        
        String updateSql = "UPDATE INFO_BOOK.dbo.Books SET title = ? , price = ? , quantity = ? , image_url = ?, dst = ? , author_id = ? WHERE book_id = ?";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        try {
            connection = ConnectionManager.getConnection();
            PreparedStatement statement = connection.prepareStatement(updateSql);
            statement.setInt(7, book.getBook_id());
            statement.setString(1, book.getTitle());
            statement.setFloat(2, book.getPrice());
            statement.setInt(3, book.getQuantity());
            statement.setBytes(4, book.getImage_url());
            statement.setString(5, book.getDescription());
            statement.setInt(6, book.getAuthor_id());
            int result = statement.executeUpdate();
            System.out.println("Cập nhật thông tin sách thành công!");
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int deleted(int id) {
        
        String deleteSql = "DELETE FROM INFO_BOOK.dbo.Books WHERE book_id = ?";

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        try {
            connection = ConnectionManager.getConnection();
            PreparedStatement statement = connection.prepareStatement(deleteSql);
            statement.setInt(1, id);
            int result = statement.executeUpdate();
            System.out.println("Xóa thông tin sách thành công!");
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public Book getBookByID(Integer id) {
        String selectSql = "SELECT * FROM INFO_BOOK.dbo.Books WHERE book_id = ?";

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            connection = ConnectionManager.getConnection();
            PreparedStatement statement = connection.prepareStatement(selectSql);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                int book_id = result.getInt("book_id");
                String title = result.getString("title");
                Float price = result.getFloat("price");
                int quantity = result.getInt("quantity");
                byte[] image_url = result.getBytes("image_url");
                String description = result.getString("dst");
                int author_id = result.getInt("author_id");
                Book books = new Book(book_id, title, price, quantity, image_url, description, author_id);
                return books;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Book> getAllBook() {

        List<Book> list = new ArrayList<Book>();
        String selectSql = "SELECT * FROM INFO_BOOK.dbo.Books";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            connection = ConnectionManager.getConnection();
            PreparedStatement statement = connection.prepareStatement(selectSql);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                int book_id = result.getInt("book_id");
                String title = result.getString("title");
                Float price = result.getFloat("price");
                int quantity = result.getInt("quantity");
                byte [] image_url = result.getBytes("image_url");
                String description = result.getString("dst");
                int author_id = result.getInt("author_id");
                Book books = new Book(book_id, title, price, quantity, image_url, description, author_id);
                list.add(books);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

}
