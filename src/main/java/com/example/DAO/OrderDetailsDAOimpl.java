package com.example.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.model.OrderDetails;

public class OrderDetailsDAOimpl implements OrderDetailsDAO{
    private Connection connection;

    public OrderDetailsDAOimpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public int add(OrderDetails od) {
        String insertSql = " INSERT INTO INFO_BOOK.dbo.OrderDetails(order_detail_id, id_user, book_id , quantity , total_price) VALUES (?, ?, ?, ?, ?)";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            connection = ConnectionManager.getConnection();
            PreparedStatement statement = connection.prepareStatement(insertSql);
            statement.setInt(1, od.getOrder_details_id());
            statement.setInt(2, od.getId_user());
            statement.setInt(3, od.getBook_id());
            statement.setInt(4, od.getQuantity());
            statement.setFloat(5, od.getTotal_price());
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
    public int update(OrderDetails od) {
        String updateSql = "UPDATE INFO_BOOK.dbo.OrderDetails SET id_user = ?, book_id , quantity = ? , total_price = ? WHERE order_detail_id = ?";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            connection = ConnectionManager.getConnection();
            PreparedStatement statement = connection.prepareStatement(updateSql);
            statement.setInt(1, od.getId_user());
            statement.setInt(2, od.getBook_id());
            statement.setInt(3, od.getQuantity());
            statement.setFloat(4, od.getTotal_price());
            statement.setInt(5, od.getOrder_details_id());
            int result = statement.executeUpdate();
            System.out.println("Cập nhật thông tin orderdetails thành công!");
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int deleted(int id) {
        String deleteSql = "DELETE FROM INFO_BOOK.dbo.OrderDetails WHERE order_detail_id = ?";
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
            System.out.println("Xóa OrderDetails thành công!");
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public OrderDetails getOrderDetailsByID(Integer id) {
        String selectSql = "SELECT * FROM INFO_BOOK.dbo.OrderDetails WHERE order_detail_id = ?";
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
                int order_details_id = result.getInt("order_details_id");
                int id_user = result.getInt("id_user");
                int book_id = result.getInt("book_id");
                int quantity = result.getInt("quantity");
                float total_price = result.getFloat("total_price");
                OrderDetails ord = new OrderDetails(order_details_id, id_user ,book_id, quantity,total_price);
                return ord;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<OrderDetails> getAllOrderDetails() {
        List <OrderDetails> list = new ArrayList <OrderDetails>();
        String selectSql = "SELECT * FROM INFO_BOOK.dbo.Authors";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            Connection connection = ConnectionManager.getConnection();
            PreparedStatement statement = connection.prepareStatement(selectSql);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                int order_details_id = result.getInt("order_details_id");
                int id_user = result.getInt("id_user");
                int book_id = result.getInt("book_id");
                int quantity = result.getInt("quantity");
                float total_price = result.getFloat("total_price");
                OrderDetails ord = new OrderDetails(order_details_id, id_user ,book_id, quantity,total_price);
                list.add(ord);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    
}
