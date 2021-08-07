package com.service.impl;

import com.dao.BookDao;
import com.dao.OrderDao;
import com.dao.OrderItemDao;
import com.dao.impl.BookDaoImpl;
import com.dao.impl.OrderDaoImpl;
import com.dao.impl.OrderItemDaoImpl;
import com.pojo.*;
import com.service.OrderService;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author Xjm
 * @date 2020/12/2   21:17
 */
public class OrderServiceImpl implements OrderService {
    private OrderDao orderDao = new OrderDaoImpl();
    private OrderItemDao orderItemDao = new OrderItemDaoImpl();
    private BookDao bookDao = new BookDaoImpl();

    @Override
    public List<Order> getMyOrder(Integer userId) {
        return orderDao.getOrderByUserId(userId);
    }

    @Override
    public List<Order> getAllOrder() {
        return orderDao.getOrderList();
    }

    @Override
    public void sendOrder(String orderId, String status) {
        Order order = new Order();
        order.setOrderId(orderId);
        int i = 0;
        try {
            i = Integer.parseInt(status);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        order.setStatus(i);
        orderDao.updateStatus(order);
    }

    @Override
    public String createOrder(Cart cart, Integer userId) {
//        订单唯一性
        String orderId = System.currentTimeMillis() + "" + userId;
//        创建一个订单对象
        Order order = new Order(orderId,new Date(),cart.getTotalPrice(),0,userId);
//        保存订单
        orderDao.saveOrder(order);

//        遍历购物车中每个商品项转成订单项保存到数据库
        for (Map.Entry<Integer, CartItem>entry : cart.getItems().entrySet()){
//            获取每个购物车中的商品项
            CartItem cartItem = entry.getValue();
//            转化为订单项
            OrderItem orderItem = new OrderItem(null,cartItem.getName(),cartItem.getPrice(),cartItem.getTotalPrice(),cartItem.getCount(),orderId);
//            保存订单项到数据库
            orderItemDao.saveOrderItem(orderItem);

//            更新库存和销量
            Book book = bookDao.queryBookId(cartItem.getId());
            book.setSales(book.getSales() + cartItem.getCount());
            book.setStock(book.getStock() - cartItem.getCount());
            bookDao.updateBook(book);
        }
//        清空购物车
        cart.clear();
        return orderId;
    }
}
