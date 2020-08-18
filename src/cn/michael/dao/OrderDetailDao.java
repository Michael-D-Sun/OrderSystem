package cn.michael.dao;

import cn.michael.entity.OrderDetail;

import java.util.List;

public interface OrderDetailDao {
     public List<OrderDetail> listByOrderId(int id);
     public int delete(int id);
}
