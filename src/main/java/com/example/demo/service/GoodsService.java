package com.example.demo.service;

import com.example.demo.domain.Goods;
import com.example.demo.po.GoodsPo;

import java.util.List;

public interface GoodsService {

    public List<Goods> findById(String mid);

    //根据ID 查找商品名字添加到session
    public Goods findNameById(String id);
}
