package com.example.demo.service.impl;

import com.example.demo.mapper.MercMapper;
import com.example.demo.po.MercChantPo;
import com.example.demo.service.MercService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MercServiceImpl implements MercService {

    @Autowired
    MercMapper mercMapper;

    @Override
    public List<MercChantPo> findAll() {
        return mercMapper.findAll();
    }

    @Override
    public MercChantPo findById(String mid) {

        return mercMapper.findById(mid);
    }

}
