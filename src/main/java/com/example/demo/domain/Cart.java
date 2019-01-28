package com.example.demo.domain;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Cart {

    private Map<String,CartItem> itemMap = new HashMap<String,CartItem>();
    private Double total = 0.0;

    public Collection<CartItem> getCartItems(){
        return itemMap.values();
    }

    public Map<String, CartItem> getItemMap() {
        return itemMap;
    }

    public void setItemMap(Map<String, CartItem> itemMap) {
        this.itemMap = itemMap;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    /**
     * 加入购物车
     */
    public void addCart(CartItem item){
        //获取商品ID
        String id = item.getGoods().getId();

        //判断购物车是否有
        if (itemMap.containsKey(id)){
        // 有
            CartItem oItem = itemMap.get(id);
        // 原来的加上现在的
            oItem.setCount(oItem.getCount()+item.getCount());
        } else {

        itemMap.put(id,item);
        }
        // 修改总金额
        total += item.getSubtotal();
    }

    /**
     *
     * 从购物车移除一个购物项
     */
    public void removeFromCart(String id){
        // 1.移除
        CartItem item = itemMap.remove(id);
        // 2.修改金额
        total -= item.getSubtotal();
    }

    /**
     *
     * 清空购物车
     */
    public void clearCart(){
        // 1.清空map
        itemMap.clear();
        // 2.修改总金额
        total = 0.0;
    }
}
