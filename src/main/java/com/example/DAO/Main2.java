package com.example.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import com.example.model.Authors;
import com.example.model.Book;

public class Main2 {
    private static Connection getConnection() throws SQLException {
        String url = "jdbc:sqlserver://LAPTOP-VV7DQ0EU:1433;databaseName=INFO_BOOK;";
        String user = "sa";
        String password = "123";
        return DriverManager.getConnection(url, user, password);
    }
    
    private static void addNewAuthor(Connection connection) {
        AuthorsDAOimpl authorDAO = new AuthorsDAOimpl(connection);
        Authors author = new Authors(4, "Nguyen Van C");
        authorDAO.add(author);
    }
    
    private static void getbook(Connection connection, int id) {

        BookDAOimpl a = new BookDAOimpl(connection);
        Book author = a.getBookByID(id);
        String title = author.getTitle();

        System.out.println("Thông tin sinh viên có id " + id + ": " + title);
    }
    
    private static void updateAuthor(Connection connection, Authors author) {
        AuthorsDAOimpl authorDAO = new AuthorsDAOimpl(connection);
        authorDAO.update(author);
    }
    
    private static void deleteAuthor(Connection connection, int id) {
        AuthorsDAOimpl authorDAO = new AuthorsDAOimpl(connection);
        authorDAO.deleted(id);
    }
    
    private static void getAllAuthors(Connection connection) {
        AuthorsDAOimpl authorDAO = new AuthorsDAOimpl(connection);
        List<Authors> authors = authorDAO.getAllAuthors();
        for (Authors author : authors) {
            System.out.println(author);
        }
    }

    public static void main(String[] args) {
        try (Connection connection = getConnection()) {
            getbook(connection, 1);
            // Authors author = new Authors(4, "Nguyen Van B");
            // updateAuthor(connection, author);
            // deleteAuthor(connection, 1);
            // getAllAuthors(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
