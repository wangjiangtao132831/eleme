package com.example.demo.service.impl;

import com.example.demo.domain.OrderItem;
import com.example.demo.mapper.OrderItemMapper;
import com.example.demo.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description
 * @Author wangjiangtao
 * @Date 2018/5/4 09:46
 */
@Service
public class OrderItemServiceImpl implements OrderItemService{

    @Autowired
    OrderItemMapper orderItemMapper;


    @Override
    public void saveOrderItem(OrderItem orderItem) {
        orderItemMapper.saveorderItem(orderItem);
    }

    @Override
    public List<OrderItem> queryOrder(String uid) {
        return orderItemMapper.queryOrder(uid);
    }

}
