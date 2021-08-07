package com.test;

import com.dao.OrderDao;
import com.dao.impl.OrderDaoImpl;
import com.pojo.Order;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Xjm
 * @date 2020/12/2   20:06
 */
public class OrderDaoTest {

    @Test
    public void saveOrder() {
        OrderDao orderDao = new OrderDaoImpl();
        orderDao.saveOrder(new Order("12345",new Date(),new BigDecimal(100),0, 1));
    }
}