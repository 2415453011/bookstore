package com.test;

import com.pojo.Cart;
import com.pojo.CartItem;
import com.service.OrderService;
import com.service.impl.OrderServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * @author Xjm
 * @date 2020/12/2   21:32
 */
public class OrderServiceTest {

    @Test
    public void createOrder() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1,"hy1",99,new BigDecimal(999),new BigDecimal(9999)));
        cart.addItem(new CartItem(1,"hy1",99,new BigDecimal(999),new BigDecimal(9999)));
        cart.addItem(new CartItem(2,"hy2",999,new BigDecimal(999),new BigDecimal(9999)));
        cart.addItem(new CartItem(3,"hy3",9999,new BigDecimal(999),new BigDecimal(9999)));
        cart.addItem(new CartItem(4,"hy4",9999,new BigDecimal(999),new BigDecimal(9999)));
        OrderService orderService = new OrderServiceImpl();
        System.out.println(orderService.createOrder(cart,1));
    }
}