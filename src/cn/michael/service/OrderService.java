package cn.michael.service;

import cn.michael.entity.Order;

import java.util.List;

public interface OrderService {

    List<Order> list();
    int update(Order order);

}
