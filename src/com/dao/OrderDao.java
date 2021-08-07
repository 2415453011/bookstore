package com.dao;

import com.pojo.Order;

import java.util.List;

/**
 * @author Xjm
 * @date 2020/12/2   19:39
 */
public interface OrderDao {

//    保存订单
    public int saveOrder(Order order);

//    修改订单状态
    public int updateStatus(Order order);

//    查出所有订单（管理员）
    public List<Order> getOrderList();

//    查出某个用户的所有订单
    public List<Order> getOrderByUserId(Integer userId);

}
