package com.example.demo.controller;

import com.example.demo.domain.Goods;
import com.example.demo.domain.Message;
import com.example.demo.domain.Users;
import com.example.demo.po.MercChantPo;
import com.example.demo.service.impl.GoodsServiceImpl;
import com.example.demo.service.impl.MercServiceImpl;
import com.example.demo.service.impl.MessageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

/**
 * @Description
 * @Author wangjiangtao
 * @Date 2018/6/6 13:42
 */
@Controller
public class MessageController {

    @Autowired
    MessageServiceImpl messageService;

    @Autowired
    MercServiceImpl mercService;

    @Autowired
    GoodsServiceImpl goodsService;

    @RequestMapping(value = "selectMessageByMid",method = RequestMethod.GET)
    @ResponseBody
    public Message selectMessageByMid(@RequestParam String id){
        Message message = new Message();
        message = messageService.selectMessageByMid(id);
        return message;
    }

    @RequestMapping("leaveMessage")
    public ModelAndView leaveMessage(HttpServletRequest request,Message message){
        Users users = (Users) request.getSession().getAttribute("users");
        String mid = (String) request.getSession().getAttribute("mid");

        message.setMid(mid);
        message.setUid(users.getUsername());
        messageService.saveMessage(message);

        ModelAndView modelAndView = new ModelAndView();
        List<Goods> goodsList = goodsService.findById(mid);
        MercChantPo mercChant = mercService.findById(mid);
        Users user = (Users) request.getSession().getAttribute("users");
        request.getSession().setAttribute("mid",mercChant.getMid());
        modelAndView.addObject("goodsList",goodsList).addObject("mercChant",mercChant);

        modelAndView.setViewName("goods");

        return modelAndView;

    }

    @RequestMapping("showImage")
    public void showImage(HttpServletRequest request,HttpServletResponse response, @RequestParam String fileName,@RequestParam String suffix){

        String path = "/Users/wangjiangtao/xiangmu/images/";
        String realFileName = fileName;

//       path = ServletActionContext.getServletContext().getRealPath(path);

        try {
            fileName = java.net.URLEncoder.encode(fileName+"."+suffix, "utf-8"); //ie 中文不兼容问题
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        }
        response.setHeader("Content-Disposition", "attachment;filename="
                + fileName);

        OutputStream os = null;
        FileInputStream fis = null;
        byte[] buffer = new byte[1024];
        path = path+"//"+realFileName+"."+suffix;
        int len = 0;
        try {

            fis = new FileInputStream(new File(path));
            os = response.getOutputStream();
            while ((len = fis.read(buffer)) > 0) {
                os.write(buffer, 0, len);
            }

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            try {
                os.close();
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        return ;

    }



}

