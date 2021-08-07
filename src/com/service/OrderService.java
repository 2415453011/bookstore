package com.service;

import com.pojo.Cart;
import com.pojo.Order;

import java.util.List;

/**
 * @author Xjm
 * @date 2020/12/2   21:16
 */
public interface OrderService {
    /**
     * 获取用户的所有订单
     * @param userId
     * @return
     */
    public List<Order> getMyOrder(Integer userId);
    /**
     * 获取所有订单（管理员使用）
     * @return
     */
    public List<Order> getAllOrder();
    /**
     * 发货，修改订单状态
     * @param orderId
     * @param status
     */
    public void sendOrder(String orderId,String status);

    /**
     * 保存订单
     * @param cart
     * @param userId
     * @return
     */
    public String createOrder(Cart cart,Integer userId);

}
