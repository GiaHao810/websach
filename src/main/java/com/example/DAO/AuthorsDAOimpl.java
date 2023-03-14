package com.example.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.example.model.Authors;

public class AuthorsDAOimpl implements AuthorsDAO {

    private Connection connection;

    

    public AuthorsDAOimpl() {
    }

    public AuthorsDAOimpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public int add(Authors authors) {
        String insertSql = " INSERT INTO INFO_BOOK.dbo.Authors(author_id, name_a) VALUES (?, ?)";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            Connection connection = ConnectionManager.getConnection();
            PreparedStatement statement = connection.prepareStatement(insertSql);
            statement.setInt(1, authors.getAuthor_id());
            statement.setString(2, authors.getName_a());
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
    public int update(Authors authors) {
        String updateSql = "UPDATE INFO_BOOK.dbo.Authors SET name_a = ? WHERE author_id = ?";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            Connection connection = ConnectionManager.getConnection();
            PreparedStatement statement = connection.prepareStatement(updateSql);
            statement.setString(1, authors.getName_a());
            statement.setInt(2, authors.getAuthor_id());
            int result = statement.executeUpdate();
            System.out.println("Cập nhật thông tin tác giả thành công!");
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int deleted(int id) {
        String deleteSql = "DELETE FROM INFO_BOOK.dbo.Authors WHERE author_id = ?";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            Connection connection = ConnectionManager.getConnection();
            PreparedStatement statement = connection.prepareStatement(deleteSql);
            statement.setInt(1, id);
            int result = statement.executeUpdate();
            System.out.println("Xóa tác giả thành công!");
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }


    @Override
    public Authors getAuthorsByID(Integer id) {

        String selectSql = "SELECT * FROM INFO_BOOK.dbo.Authors WHERE author_id = ?";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            Connection connection = ConnectionManager.getConnection();
            PreparedStatement statement = connection.prepareStatement(selectSql);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                int authorID = result.getInt("author_id");
                String name = result.getString("name_a");
                Authors authors = new Authors(authorID, name);
                return authors;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Authors> getAllAuthors() {

        List<Authors> list = new ArrayList<Authors>();
        String selectSql = "SELECT * FROM INFO_BOOK.dbo.Authors";
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
                int AuthorsId = result.getInt("author_id");
                String name = result.getString("name_a");
                Authors a = new Authors(AuthorsId, name);
                list.add(a);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}

// Connection conn = null;
// PreparedStatement ps = null;
// ResultSet rs = null;

// public List<Authors> getListAuthors(){
// try {
// String query = "SELECT * FROM Authors " ;
// conn = new SqlServerConnUtils_SQLJDBC().getConnection();
// ps = conn.prepareStatement(query);
// rs = ps.executeQuery();

// List <Authors> list = new ArrayList<>();
// while (rs.next()) {
// Authors author = new Authors(rs.getInt(1) , rs.getString(2));
// list.add(author);
// }
// return list;
// } catch (Exception e) {
// // TODO: handle exception
// }
// return null;

// }

// public static void main(String[] args) {
// AuthorsDAOimpl aDaOimpl = new AuthorsDAOimpl();
// List <Authors> list = aDaOimpl.getListAuthors();

// for (Authors author : list) {
// System.out.println("id: " + author.getAuthor_id() + " name: " +
// author.getName_a());
// }
// }
