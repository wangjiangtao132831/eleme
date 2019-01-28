package com.example.demo.domain;

import com.example.demo.po.OrderPo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * 订单
 */
public class Order extends OrderPo{

    private static String gname;

    public static String getGname() {
        return gname;
    }

    public static void setGname(String gname) {
        Order.gname = gname;
    }

    //表示当前订单包含的订单项
    private List<OrderItem> items = new ArrayList<>();


    public List<OrderItem> getItems() {
        return items;
    }

    public void setItems(List<OrderItem> items) {
        this.items = items;
    }
}
