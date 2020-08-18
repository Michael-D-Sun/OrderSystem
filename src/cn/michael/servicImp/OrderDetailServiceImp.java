package cn.michael.servicImp;

import cn.michael.dao.OrderDao;
import cn.michael.dao.OrderDetailDao;
import cn.michael.entity.Order;
import cn.michael.entity.OrderDetail;
import cn.michael.service.OrderDetailService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("orderDetailService")
public class OrderDetailServiceImp implements OrderDetailService {

    @Autowired
    private OrderDetailDao orderDetailDao;

    @Autowired
    private OrderDao orderDao;


    @Override
    public List<OrderDetail> listByOrderId(int orderId) {
        return orderDetailDao.listByOrderId(orderId);
    }

    @Override
    public int delete(int orderId, int orderDetailId) {
        if(orderDetailDao.delete(orderDetailId) > 0){
            Order order = orderDao.getById(orderId);
            List<OrderDetail> details = orderDetailDao.listByOrderId(orderId);
            order.setTotalPrice(calculatePrice(details));
            if(orderDao.update(order)>0){
               return 1;
            }
        }
        return 0;
    }
    private int calculatePrice(List<OrderDetail> list){
        int sum = 0;
        System.out.println(list.size());;
        for(OrderDetail detail: list){
            sum += detail.getMenu().getPrice()*detail.getNum();
        }
        return sum;
    }

}
