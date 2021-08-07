package com.pojo;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Xjm
 * @date 2020/12/2   19:31
 */
public class Order {
    private String orderId;
    private Date createTime;
    private BigDecimal price;
//    0表示未发货,1表示已发货，2表示已签收
    private Integer status = 0;
    private Integer userId;

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", creatTime=" + createTime +
                ", price=" + price +
                ", status=" + status +
                ", userId=" + userId +
                '}';
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date creatTime) {
        this.createTime = creatTime;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Order(String orderId, Date creatTime, BigDecimal price, Integer status, Integer userId) {
        this.orderId = orderId;
        this.createTime = creatTime;
        this.price = price;
        this.status = status;
        this.userId = userId;
    }

    public Order() {
    }
}
