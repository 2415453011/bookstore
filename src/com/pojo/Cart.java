package com.pojo;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author
 * @Package com.pojo
 * @date 2020/11/4 18:24
 */
public class Cart {
    /**
     * 购物车对象
     */
//    private Integer totalCount;
//    private BigDecimal totalPrice;
    /**
     * key为商品编号
     * value为商品信息
     */
    private Map<Integer,CartItem> items = new LinkedHashMap<Integer, CartItem>();


    public Map<Integer, CartItem> getItems() {
        return items;
    }

    /**
     * 添加商品项
     * @param cartItem
     */
    public void addItem(CartItem cartItem){
//        先查看购物车中是否已经添加此商品，如果已经添加则数量增加，反之直接放入集合中
        CartItem item = items.get(cartItem.getId());

        if (item == null){
//            之前没添加过
            items.put(cartItem.getId(),cartItem);
        }else {
//            已经添加
            item.setCount(item.getCount() + 1);//数量累加
            item.setTotalPrice(item.getPrice().multiply(new BigDecimal(item.getCount())));//更新总金额
        }

    }

    /**
     * 删除商品项
     * @return
     */
    public void deleteItem(Integer id){
        items.remove(id);
    }

    /**
     * 清空购物车
     * @return
     */
    public void clear(){
        items.clear();
    }

    /**
     * 修改商品数量
     * @return
     */
    public void updateItem(Integer id,Integer count){
//        先查看购物车中是否有此商品，如果有，则修改数量，更新总金额
        CartItem cartItem = items.get(id);
        if (cartItem != null){
            cartItem.setCount(count);
            cartItem.setTotalPrice(cartItem.getPrice().multiply(new BigDecimal(cartItem.getCount())));//更新总金额
        }
    }


    public Integer getTotalCount() {
        Integer totalCount = 0;
        for (Map.Entry<Integer,CartItem>entry : items.entrySet()){
            totalCount += entry.getValue().getCount();
        }
        return totalCount;
    }

    public BigDecimal getTotalPrice() {
        BigDecimal totalPrice = new BigDecimal(0);
        for (Map.Entry<Integer,CartItem>entry : items.entrySet()){
            totalPrice = totalPrice.add(entry.getValue().getTotalPrice());
        }
        return totalPrice;
    }


    public void setItems(Map<Integer, CartItem> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "totalCount=" + getTotalCount() +
                ", totalPrice=" + getTotalPrice() +
                ", items=" + items +
                '}';
    }
}
