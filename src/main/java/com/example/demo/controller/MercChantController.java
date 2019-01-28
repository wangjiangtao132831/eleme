package com.example.demo.controller;

import com.example.demo.po.MercChantPo;
import com.example.demo.service.impl.MercServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class MercChantController {

    @Autowired
    MercServiceImpl mercService;

    public ModelAndView MercView(){
        ModelAndView model = new ModelAndView();
        List<MercChantPo> merc = mercService.findAll();
        model.addObject(merc);
        model.setViewName("welcome");
        return model;
    }


}
