package com.service;

import com.pojo.OrderItem;

import java.util.List;

/**
 * @author Xjm
 * @date 2020/12/2   21:16
 */
public interface OrderItemService {
    /**
     * 获取订单所有项
     * @param orderId
     * @return
     */
    public List<OrderItem> getOrderItem(String orderId);

    /**
     * 保存订单项
     * @param orderItem
     */
    public void saveOrderItem(List<OrderItem> orderItem);
}
