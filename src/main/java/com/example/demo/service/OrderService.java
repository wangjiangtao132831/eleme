package com.example.demo.service;

import com.example.demo.domain.Order;

import java.util.List;

/**
 * @Description
 * @Author wangjiangtao
 * @Date 2018/5/3 22:27
 */
public interface OrderService {

    public void saveOrder(Order order);

    public void updateState(String oid);

    public List<Order> queryOrder(String uid);
}
