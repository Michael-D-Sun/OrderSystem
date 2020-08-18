package cn.michael.servicImp;

import cn.michael.dao.OrderDao;
import cn.michael.entity.Order;
import cn.michael.service.OrderService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("orderService")
public class OrderServiceImp implements OrderService {
    @Autowired
    private OrderDao orderDao;

    public OrderDao getOrderDao() {
        return orderDao;
    }

    public void setOrderDao(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    @Override
    public List<Order> list() {
        System.out.println("OrderService Implement list");
        List<Order> orders = orderDao.list();
        System.out.println(orders);
        return orders;
    }

    @Override
    public int update(Order order) {
        return orderDao.update(order);
    }

}
