package com.example.demo.mapper;

import com.example.demo.domain.Order;
import com.sun.tools.corba.se.idl.constExpr.Or;

import java.util.List;

/**
 * @Description
 * @Author wangjiangtao
 * @Date 2018/5/3 22:31
 */
public interface OrderMapper {

    public void saveOrder(Order order);

    public void updateState(String oid);

    public List<Order> queryOrder(String uid);
}
