package cn.michael.daoImpl;

import cn.michael.dao.OrderDao;
import cn.michael.entity.Order;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("orderDao")
public class OrderDaoImp extends SqlSessionDaoSupport implements OrderDao {
    @Autowired
    @Override
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }

    @Override
    public List<Order> list() {
        List<Order> orders = getSqlSession().selectList("cn.michael.entity.order.mapper.order");
        return orders;
    }

    @Override
    public int update(Order order) {

        return getSqlSession().update("cn.michael.entity.order.mapper.update", order);
    }

    @Override
    public Order getById(int id) {
        return getSqlSession().selectOne("cn.michael.entity.order.mapper.getById", id);
    }


}
