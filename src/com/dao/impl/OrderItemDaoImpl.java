package com.dao.impl;

import com.dao.OrderItemDao;
import com.pojo.OrderItem;

import java.util.List;

/**
 * @author Xjm
 * @date 2020/12/2   19:56
 */
public class OrderItemDaoImpl extends BaseDao implements OrderItemDao {
    /**
     * 批量保存订单项
     * @param params
     * @return
     */
    @Override
    public int saveBatchOrderItem(List<OrderItem> params) {
        String sql = "insert into t_order_item(`name`,`price`,`total_money`,`count`,`order_id`) " +
                "values(?,?,?,?,?)";
        Object[][] item = new Object[params.size()][5];
        int count = 0;
        for (OrderItem orderItem : params) {
            item[count++] = new Object[]{orderItem.getName(),orderItem.getPrice(),orderItem.getTotalMoney()
                                        ,orderItem.getCount(),orderItem.getOrderId()};
        }
        batch(item,sql);
        return 0;
    }

    @Override
    public int saveOrderItem(OrderItem orderItem) {
        String sql = "insert into t_order_item(`name`,`price`,`total_money`,`count`,`order_id`) values(?,?,?,?,?)";
        return update(sql,orderItem.getName(),orderItem.getPrice(),orderItem.getTotalMoney(),orderItem.getCount(),orderItem.getOrderId());
    }

    @Override
    public List<OrderItem> getOrderItems(String orderId) {
        String sql = "select `id` id,`name` name,`price` price,`total_money` totalMoney,`count` count,`order_id` orderId " +
                "from t_order_item where order_id=?";
        return queryForList(OrderItem.class,sql,orderId);
    }
}
