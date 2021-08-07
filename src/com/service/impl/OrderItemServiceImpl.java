package com.service.impl;

import com.dao.OrderItemDao;
import com.dao.impl.OrderItemDaoImpl;
import com.pojo.OrderItem;
import com.service.OrderItemService;

import java.util.List;

/**
 * @author Xjm
 * @date 2020/12/11   22:22
 */
public class OrderItemServiceImpl implements OrderItemService {
    OrderItemDao itemDao = new OrderItemDaoImpl();
    @Override
    public List<OrderItem> getOrderItem(String orderId) {
        return itemDao.getOrderItems(orderId );
    }

    @Override
    public void saveOrderItem(List<OrderItem> orderItem) {
//        for (OrderItem orderItem1 : orderItem){
//            itemDao.saveOrderItem(orderItem1);}
        itemDao.saveBatchOrderItem(orderItem);
        }
    }

