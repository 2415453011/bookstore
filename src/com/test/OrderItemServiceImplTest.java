package com.test;

import com.service.OrderItemService;
import com.service.impl.OrderItemServiceImpl;
import org.junit.Test;

/**
 * @author Xjm
 * @date 2020/12/12   21:36
 */
public class OrderItemServiceImplTest {

    @Test
    public void getOrderItem() {
        OrderItemService orderItemService = new OrderItemServiceImpl();
        System.out.println(orderItemService.getOrderItem("16077722729231"));

    }

    @Test
    public void saveOrderItem() {
    }
}