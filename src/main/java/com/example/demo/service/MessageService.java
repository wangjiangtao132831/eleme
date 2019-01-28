package com.example.demo.service;

import com.example.demo.domain.Message;
import sun.util.resources.cldr.sg.CurrencyNames_sg;

import java.util.List;

/**
 * @Description
 * @Author wangjiangtao
 * @Date 2018/6/6 13:44
 */
public interface MessageService {

    //
    public Message selectMessageByMid(String mid);

    //
    public void saveMessage(Message message);
}
