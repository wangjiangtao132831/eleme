package com.example.demo.service.impl;

import com.example.demo.domain.Order;
import com.example.demo.mapper.OrderMapper;
import com.example.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description
 * @Author wangjiangtao
 * @Date 2018/5/3 22:27
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderMapper orderMapper;

    @Override
    public void saveOrder(Order order) {
        orderMapper.saveOrder(order);
    }

    @Override
    public void updateState(String oid) {
        orderMapper.updateState(oid);
    }

    @Override
    public List<Order> queryOrder(String uid) {
        return orderMapper.queryOrder(uid);
    }
}
