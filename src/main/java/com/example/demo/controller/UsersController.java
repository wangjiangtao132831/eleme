package com.example.demo.controller;

import com.example.demo.domain.Cart;
import com.example.demo.domain.Users;
import com.example.demo.po.MercChantPo;
import com.example.demo.po.UsersPo;
import com.example.demo.service.impl.MercServiceImpl;
import com.example.demo.service.impl.UsersServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Controller
public class UsersController {

    @Autowired
    private UsersServiceImpl usersService;

    @Autowired
    MercServiceImpl mercService;

    @RequestMapping("/first")
    public String run(){
        return "index";
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public ModelAndView login (@RequestParam String username,String password,HttpServletRequest request){
        ModelAndView model = new ModelAndView();
        String biaoshi = request.getParameter("biaoshi");
        if ("1".equals(biaoshi)){
            List<MercChantPo> merc = mercService.findAll();
            model.addObject("merc",merc);
            Users users = new Users();
            users.setUsername(username);
            users.setPassword(password);
            boolean b =  0 == usersService.checkLogin(users);
            if (b == false){
                Users u = (Users) request.getSession().getAttribute("users");
                if (u == null){
                    u = new Users();
                    //将users放到session
                    u.setUsername(username);
                    u.setPassword(password);
                    request.getSession().setAttribute("users",u);
                }
                model.setViewName("welcome");
            } else{
                model.setViewName("index");
            }
        }else{
            Users users = new Users();
            users.setUsername(username);
            users.setPassword(password);
            usersService.save(users);
            model.setViewName("index");
        }

        return model;


    }

    @RequestMapping(value = "/addMerc",method = RequestMethod.GET)
    public ModelAndView addMerc(){
        ModelAndView model = new ModelAndView();
        model.setViewName("addMerc");

            return model;
    }



}
