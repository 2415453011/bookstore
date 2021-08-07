package com.test;

import com.dao.OrderItemDao;
import com.dao.impl.OrderItemDaoImpl;
import com.pojo.OrderItem;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * @author Xjm
 * @date 2020/12/2   20:16
 */
public class OrderItemDaoTest {

    @Test
    public void saveOrderItem() {

        OrderItemDao orderItemDao = new OrderItemDaoImpl();

        orderItemDao.saveOrderItem(new OrderItem(null,"abd",new BigDecimal(100),new BigDecimal(99),99,"1234"));
    }
    @Test
    public void ggetOrderItems(){
        OrderItemDao orderItemDao = new OrderItemDaoImpl();
        System.out.println(orderItemDao.getOrderItems("16069161792431"));
    }
}