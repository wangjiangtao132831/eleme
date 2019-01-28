package com.example.demo.service.impl;

import com.example.demo.domain.Goods;
import com.example.demo.mapper.GoodsMapper;
import com.example.demo.po.GoodsPo;
import com.example.demo.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService{

    @Autowired
    GoodsMapper goodsMapper;

    @Override
    public List<Goods> findById(String mid) {
        return goodsMapper.findById(mid);
    }

    @Override
    public  Goods findNameById(String id) {

        return goodsMapper.findNameById(id);
    }


}
