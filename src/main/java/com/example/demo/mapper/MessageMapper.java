package com.example.demo.mapper;

import com.example.demo.domain.Message;

/**
 * @Description
 * @Author wangjiangtao
 * @Date 2018/6/6 13:43
 */
public interface MessageMapper {

    //
    public Message selectMessageByMid(String mid);

    //
    public void saveMessage(Message message);
}
