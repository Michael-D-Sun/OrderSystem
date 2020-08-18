package cn.michael.dao;

import cn.michael.entity.Order;

import java.util.List;

public interface OrderDao {
    List<Order> list();
    int update(Order order);
    Order getById(int id);
}
