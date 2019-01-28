package com.example.demo.mapper;

import com.example.demo.domain.MercChant;
import com.example.demo.po.MercChantPo;

import java.util.List;

public interface MercMapper {

    public List<MercChantPo> findAll();

    public MercChantPo findById(String mid);

}
