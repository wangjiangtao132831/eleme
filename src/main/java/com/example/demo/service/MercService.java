package com.example.demo.service;

import com.example.demo.po.MercChantPo;

import java.util.List;

public interface MercService{

    public List<MercChantPo> findAll();

    public MercChantPo findById(String mid);
}
