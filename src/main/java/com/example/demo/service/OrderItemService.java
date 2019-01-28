package com.example.demo.service;

import com.example.demo.domain.OrderItem;

import java.util.List;

/**
 * @Description
 * @Author wangjiangtao
 * @Date 2018/5/4 09:45
 */
public interface OrderItemService {

    public void saveOrderItem(OrderItem orderItem);

    public List<OrderItem> queryOrder(String uid);

}
