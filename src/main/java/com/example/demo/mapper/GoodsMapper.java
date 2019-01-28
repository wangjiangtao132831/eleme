package com.example.demo.mapper;

import com.example.demo.domain.Goods;
import com.example.demo.po.GoodsPo;

import java.util.List;

public interface GoodsMapper {

    public List<Goods> findById(String mid);

    public Goods findNameById(String id);
}
