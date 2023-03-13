package com.example.DAO;

import java.util.List;

import com.example.model.OrderDetails;

public interface OrderDetailsDAO {

    public int add(OrderDetails od);

    public int update(OrderDetails od);

    public int deleted(int id);

    public OrderDetails getOrderDetailsByID(Integer id);

    public List<OrderDetails> getAllOrderDetails();
}
