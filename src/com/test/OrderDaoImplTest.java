package com.test;

import com.dao.OrderDao;
import com.dao.impl.OrderDaoImpl;
import com.pojo.Order;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Xjm
 * @date 2020/12/11   21:51
 */
public class OrderDaoImplTest {

    @Test
    public void saveOrder() {
        OrderDao orderDao = new OrderDaoImpl();
        orderDao.saveOrder(new Order("10132",new Date(),new BigDecimal(12123),123,2));
    }

    @Test
    public void updateStatus() {

    }

    @Test
    public void getOrderList() {
    }

    @Test
    public void getOrderByUserId() {
    }
}