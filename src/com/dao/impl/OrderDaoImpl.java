package com.dao.impl;

import com.dao.OrderDao;
import com.pojo.Order;

import java.util.List;

/**
 * @author Xjm
 * @date 2020/12/2   19:55
 */
public class OrderDaoImpl extends BaseDao implements OrderDao {
    @Override
    public int saveOrder(Order order) {
        String sql = "insert into t_order(`order_id`,`create_time`,`price`,`status`,`user_id`) values(?,?,?,?,?)";

        return update(sql,order.getOrderId(),order.getCreateTime(),order.getPrice(),order.getStatus(),order.getUserId());
    }

    @Override
    public int updateStatus(Order order) {
        String sql = "update t_order set status=? where order_id=?";
        return update(sql,order.getStatus(),order.getOrderId());
    }

    @Override
    public List<Order> getOrderList() {
        String sql = "select `order_id` orderId,`create_time` createTime,`price` price,`status` status,`user_id` userId" +
                " from t_order";
        return queryForList(Order.class,sql);
    }

    @Override
    public List<Order> getOrderByUserId(Integer userId) {
        String sql = "select `order_id` orderId,`create_time` createTime,`price` price,`status` status,`user_id` userId" +
                " from t_order where user_id=?";
        return queryForList(Order.class,sql,userId);
    }
}
