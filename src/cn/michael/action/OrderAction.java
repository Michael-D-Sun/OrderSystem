package cn.michael.action;

import cn.michael.entity.Order;
import cn.michael.entity.OrderDetail;
import cn.michael.service.OrderDetailService;
import cn.michael.service.OrderService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller("orderAction")
//@Scope("prototype")
public class OrderAction {
    private List<Order> list;
    private List<OrderDetail> orderDetails;
    private int orderId;
    private int orderDetailId;

    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderDetailService orderDetailService;

    public String list(){
        list = orderService.list();
        System.out.println("OrderAction list");
        System.out.println(list);
        return "success";
    }

    @Test
    public void test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        OrderAction orderAction = (OrderAction) context.getBean("orderAction");
        orderAction.setOrderId(1);
        orderAction.detail();
        System.out.println(orderAction.orderDetails);
    }

    public String detail(){
        orderDetails = orderDetailService.listByOrderId(orderId);
        return "success";
    }


    public String delete(){
        System.out.println("oderId " + orderId + " orderDetailId " + orderDetailId );
        orderDetailService.delete(orderId, orderDetailId);
        return "success";
    }


    public OrderService getOrderService() {
        return orderService;
    }

    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }

    public OrderDetailService getOrderDetailService() {
        return orderDetailService;
    }

    public void setOrderDetailService(OrderDetailService orderDetailService) {
        this.orderDetailService = orderDetailService;
    }
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getOrderDetailId() {
        return orderDetailId;
    }

    public void setOrderDetailId(int orderDetailId) {
        this.orderDetailId = orderDetailId;
    }

    public List<Order> getList() {
        return list;
    }

    public void setList(List<Order> list) {
        this.list = list;
    }

    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }
}
