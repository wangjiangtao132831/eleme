package com.example.demo.mapper;

import com.example.demo.domain.OrderItem;

import java.util.List;

/**
 * @Description
 * @Author wangjiangtao
 * @Date 2018/5/4 09:44
 */
public interface OrderItemMapper {

    public void saveorderItem(OrderItem orderItem);

    public List<OrderItem> queryOrder(String uid);
}
