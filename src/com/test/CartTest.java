package com.test;

import com.pojo.Cart;
import com.pojo.CartItem;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * @author
 * @Package com.test
 * @date 2020/11/4 18:42
 */
public class CartTest {

    @Test
    public void addItem() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1,"hy1",99,new BigDecimal(999),new BigDecimal(9999)));
        cart.addItem(new CartItem(1,"hy1",99,new BigDecimal(999),new BigDecimal(9999)));
        cart.addItem(new CartItem(2,"hy2",999,new BigDecimal(999),new BigDecimal(9999)));
        cart.addItem(new CartItem(3,"hy3",9999,new BigDecimal(999),new BigDecimal(9999)));
        cart.addItem(new CartItem(4,"hy4",9999,new BigDecimal(999),new BigDecimal(9999)));
        System.out.println(cart);
    }

    @Test
    public void deleteItem() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1,"hy1",1,new BigDecimal(999),new BigDecimal(9999)));
        cart.addItem(new CartItem(1,"hy1",1,new BigDecimal(999),new BigDecimal(9999)));
        cart.addItem(new CartItem(2,"hy2",1,new BigDecimal(999),new BigDecimal(9999)));
        cart.addItem(new CartItem(3,"hy3",1,new BigDecimal(999),new BigDecimal(9999)));
        cart.addItem(new CartItem(4,"hy4",1,new BigDecimal(999),new BigDecimal(9999)));
        cart.deleteItem(1);
        System.out.println(cart);
    }

    @Test
    public void clear() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1,"hy1",1,new BigDecimal(999),new BigDecimal(9999)));
        cart.addItem(new CartItem(1,"hy1",1,new BigDecimal(999),new BigDecimal(9999)));
        cart.addItem(new CartItem(2,"hy2",1,new BigDecimal(999),new BigDecimal(9999)));
        cart.addItem(new CartItem(3,"hy3",1,new BigDecimal(999),new BigDecimal(9999)));
        cart.addItem(new CartItem(4,"hy4",1,new BigDecimal(999),new BigDecimal(9999)));
        cart.clear();
        System.out.println(cart);
    }

    @Test
    public void updateItem() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1,"hy1",1,new BigDecimal(999),new BigDecimal(9999)));
        cart.addItem(new CartItem(1,"hy1",1,new BigDecimal(999),new BigDecimal(9999)));
        cart.addItem(new CartItem(2,"hy2",1,new BigDecimal(999),new BigDecimal(9999)));
        cart.addItem(new CartItem(3,"hy3",1,new BigDecimal(999),new BigDecimal(9999)));
        cart.addItem(new CartItem(4,"hy4",1,new BigDecimal(999),new BigDecimal(9999)));
        System.out.println(cart);
        cart.updateItem(3, 3);
        System.out.println(cart);
    }
}