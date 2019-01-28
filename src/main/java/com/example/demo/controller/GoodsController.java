package com.example.demo.controller;

 import com.example.demo.domain.Cart;
import com.example.demo.domain.CartItem;
import com.example.demo.domain.Goods;
import com.example.demo.domain.Users;
import com.example.demo.po.MercChantPo;
import com.example.demo.service.impl.GoodsServiceImpl;
import com.example.demo.service.impl.MercServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class GoodsController {

    @Autowired
    GoodsServiceImpl goodsService;

    @Autowired
    MercServiceImpl mercService;




    @RequestMapping("/goodsMessage")
    public ModelAndView mercMessage(@RequestParam String mid,HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView();
        List<Goods> goodsList = goodsService.findById(mid);
        MercChantPo mercChant = mercService.findById(mid);
        Users user = (Users) request.getSession().getAttribute("users");
        request.getSession().setAttribute("mid",mercChant.getMid());
        modelAndView.addObject("goodsList",goodsList).addObject("mercChant",mercChant)
        .addObject("users",user);
        modelAndView.setViewName("goods");

        return modelAndView;
    }

    @RequestMapping("/addGoods")
    public ModelAndView addGoods(HttpServletRequest request,String id){
        ModelAndView modelAndView = new ModelAndView();

        Goods goods = goodsService.findNameById(id);

        //创建cartItem
        CartItem cartItem = new CartItem(goods,1);
        
        //将 cartItem 加入到购物车
        //获取购物车
        Cart cart = getCart(request);

        //
        cart.addCart(cartItem);

        modelAndView.setViewName("order");

        return modelAndView;
    }

    public Cart getCart(HttpServletRequest request) {
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        if (cart == null){
            cart = new Cart();
            //将cart放到session
            request.getSession().setAttribute("cart",cart);
        }
        return cart;
    }


    @RequestMapping(value = "/payment",method = RequestMethod.GET)
    public ModelAndView payment(@RequestParam String postFee,HttpServletRequest request){

        ModelAndView modelAndView = new ModelAndView();
        request.getSession().setAttribute("postFee",postFee);
        modelAndView.addObject("postFee",postFee);
        modelAndView.setViewName("order");

        return modelAndView;
    }

    @RequestMapping("/removeFromCart")
    public ModelAndView removeFromCart(HttpServletRequest request,String id){

        System.out.print(id);
        Cart cart = getCart(request);

        cart.removeFromCart(id);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("order");

        return modelAndView;

        }

    @RequestMapping("/clearFromCart")
    public ModelAndView clearFromCart(HttpServletRequest request){
        Cart cart = getCart(request);
        cart.clearCart();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("order");
        return modelAndView;
    }


    @RequestMapping("/clearGoods")
    public ModelAndView clearGoods(HttpServletRequest request){
        Cart cart = getCart(request);
        cart.clearCart();
        ModelAndView modelAndView = new ModelAndView();
        String mid = (String) request.getSession().getAttribute("mid");
        List<Goods> goodsList = goodsService.findById(mid);
        MercChantPo mercChant = mercService.findById(mid);
        modelAndView.addObject("goodsList",goodsList).addObject("mercChant",mercChant);
        modelAndView.setViewName("goods");
        return modelAndView;
    }


}
