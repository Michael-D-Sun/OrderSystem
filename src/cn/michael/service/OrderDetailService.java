package cn.michael.service;

import cn.michael.entity.OrderDetail;

import java.util.List;

public interface OrderDetailService {
    List<OrderDetail> listByOrderId(int orderId);
    int delete(int orderId, int orderDetailId);

}
