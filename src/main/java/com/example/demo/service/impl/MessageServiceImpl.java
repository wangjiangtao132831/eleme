package com.example.demo.service.impl;

import com.example.demo.domain.Message;
import com.example.demo.mapper.MessageMapper;
import com.example.demo.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @Author wangjiangtao
 * @Date 2018/6/6 13:44
 */
@Service
public class MessageServiceImpl implements MessageService{

    @Autowired
    MessageMapper messageMapper;

    @Override
    public Message selectMessageByMid(String mid) {
        return messageMapper.selectMessageByMid(mid);
    }

    @Override
    public void saveMessage(Message message) {
        messageMapper.saveMessage(message);
    }
}
