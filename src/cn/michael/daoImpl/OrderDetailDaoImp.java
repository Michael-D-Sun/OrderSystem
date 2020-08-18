package cn.michael.daoImpl;

import cn.michael.dao.OrderDetailDao;
import cn.michael.entity.OrderDetail;
import cn.michael.service.OrderDetailService;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("orderDetailDao")
public class OrderDetailDaoImp extends SqlSessionDaoSupport implements OrderDetailDao {

    @Autowired
    @Override
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }

    @Override
    public List<OrderDetail> listByOrderId(int id) {
        List<OrderDetail> details = getSqlSession().selectList("cn.michael.entity.order.detail.mapper.orderDetail", id);
        return details;
    }

    @Override
    public int delete(int id) {
        return getSqlSession().delete("cn.michael.entity.order.detail.mapper.delete", id);
    }

}
