package com.example.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.domain.*;
import com.example.demo.po.MercChantPo;
import com.example.demo.service.OrderService;
import com.example.demo.service.impl.GoodsServiceImpl;
import com.example.demo.service.impl.MercServiceImpl;
import com.example.demo.service.impl.OrderItemServiceImpl;
import com.example.demo.service.impl.OrderServiceImpl;
import com.example.demo.utils.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.jar.JarEntry;

/**
 * @Description
 * @Author wangjiangtao
 * @Date 2018/5/3 22:25
 */
@Controller
public class OrderController {

    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    GoodsController goodsController;

    @Autowired
    OrderServiceImpl orderService;

    @Autowired
    OrderItemServiceImpl orderItemService;

    @Autowired
    MercServiceImpl mercService;

    @Autowired
    GoodsServiceImpl goodsService;

    public static String  mercNo = Configuration.getInstance().getValue("mercNo");
    public static String  mercPrivateKey = Configuration.getInstance().getValue("mercPrivateKey");
    public static String  sxfPublic = Configuration.getInstance().getValue("sxfPublic");
    public static String  payUrl = Configuration.getInstance().getValue("payUrl");
    public static String  ip = "192.168.31.244";
    public static String  payQueryUrl = Configuration.getInstance().getValue("payQueryUrl");

    @RequestMapping("saveOrder")
    public ModelAndView saveOrder(HttpServletRequest request, HttpServletResponse response,@RequestParam String payChannel){
        ModelAndView modelAndView = new ModelAndView();

        //-1 从session 获取users
        Users users = (Users) request.getSession().getAttribute("users");
        if (users == null){
            logger.info("请您重新登录");
            modelAndView.setViewName("index");
            return modelAndView;
        }

        //获取购物车
        Cart cart =goodsController.getCart(request);

        //封装订单对象
        // 创建对象
        Order order = new Order();
        String orderNo = DateUtils.getCurrentDate() + new Random().nextInt(100000);
        //1.设置oid
        order.setOid(orderNo);
        request.getSession().setAttribute("orderNo",orderNo);
        //2.设置ordertime
        Date date = new Date();
        String dateStr = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
        order.setOrdertime(dateStr);
        //3.设置total 在购物车中
        order.setTotal(cart.getTotal());
        //4.
        order.setState(Constants.ORDER_WEIFUKUAN);
        //5.
        order.setUid(users.getUsername());
        String mid = (String) request.getSession().getAttribute("mid");
        order.setMid(mid);
        order.setOrderState("0");
        String name = (String) request.getSession().getAttribute("name");
        if (name == null){
            order.setName(users.getUname());
        }else{
            order.setName(name);
        }
        String address = (String) request.getSession().getAttribute("address");
        String telephone = (String) request.getSession().getAttribute("telephone");
        if (telephone == null){
            order.setTelephone(users.getPhone());
        }else{
            order.setTelephone(telephone);
        }
        order.setAddress(address);
        order.setPayChannel(payChannel);
        logger.info("订单详情:"+order.getPayChannel());
        orderService.saveOrder(order);
        // 设置items 遍历购物项列表
        for (CartItem ci :cart.getCartItems()) {
            // 封装成orderitem
            OrderItem orderItem = new OrderItem();
            orderItem.setItemid(DateUtils.getCurrentDate() + new Random().nextInt(100000));
            orderItem.setCount(ci.getCount());
            orderItem.setSubtotal(ci.getSubtotal());
            orderItem.setGid(ci.getGoods().getId());
            orderItem.setOid(order.getOid());
            orderItem.setUid(order.getUid());
            //将orderitem 加入 order的items 中
            order.getItems().add(orderItem);
        }
        for (OrderItem oi:order.getItems()) {
        orderItemService.saveOrderItem(oi);
        }

        //向随行付发送请求
        String url = sendPost(order);
        if (null == url){
            modelAndView.setViewName("error");
            return modelAndView;
        }
        modelAndView.setViewName("payImage");
        modelAndView.addObject("url",url);
        return modelAndView;
    }

    @RequestMapping("addAddress")
    public ModelAndView addAddress(HttpServletRequest request,Order order){

        request.getSession().setAttribute("name",order.getName());
        request.getSession().setAttribute("address",order.getAddress());
        request.getSession().setAttribute("telephone",order.getTelephone());
        String postFee = (String) request.getSession().getAttribute("postFee");

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("name",order.getName())
                .addObject("address",order.getAddress())
                .addObject("telephone",order.getTelephone()).addObject("postFee",postFee);

        modelAndView.setViewName("order");

        return modelAndView;

    }

    @RequestMapping("queryOrder")
    public ModelAndView queryOrder(HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView();
        net.sf.json.JSONObject req = new net.sf.json.JSONObject();
        String orderNo = (String) request.getSession().getAttribute("orderNo");
        req.put("orderNo",orderNo);
        String res = null;
        try {
            res = encrypt("RSA#RSA",req.toString(),sxfPublic);
        } catch (Exception e) {
            e.printStackTrace();
        }
        net.sf.json.JSONObject params = new net.sf.json.JSONObject();
        params.put("mercNo",mercNo);
        params.put("tranCd","1002");
        params.put("version","3.0");
        params.put("reqData",res);
        params.put("ip", ip);
        //生成签名
        String sign = PaymentUtils.sign(getSortSign(params),mercPrivateKey);
        net.sf.json.JSONObject post = new net.sf.json.JSONObject();
        post.put("mercNo",mercNo);
        post.put("tranCd","1002");
        post.put("version","3.0");
        post.put("reqData",res);
        post.put("ip",ip);
        post.put("encodeType","RSA#RSA");
        post.put("sign",sign);
        String _t=post.toString();
        Map<String,String> map = new HashMap<>();
        map.put("_t",_t);
        /**
         *
         * 每隔4S 去查询一次
         */
        String respBody = null;
        JSONObject jsonObject = null;
        for (int i = 0;i<8;i++){
            respBody = Util.connectPostUrl(payQueryUrl,map);
            jsonObject = JSONObject.parseObject(respBody);
            String code = jsonObject.getString("resCode");
            if ("000000".equals(code)){
                String data = callBack(respBody,mercNo,orderNo,"1002",res);
                data=data.replace("[","");
                data=data.replace("]","");
                JSONObject json = JSONObject.parseObject(data);

                String status = json.getString("tranSts");
                logger.info("访问随行付查询支付结果:"+jsonObject);
                if ("S".equals(status)){
                    request.getSession().removeAttribute("cart");
                    //支付完成 更新订单的状态
                    orderService.updateState(orderNo);
                    logger.info("订单支付成功");
                    modelAndView.setViewName("paySuccess");
                    return modelAndView;
                }
                } else {
                logger.info("查询订单结果失败或未支付成功,请重新下单");
            }
            try {
                Thread.sleep(4*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        request.getSession().removeAttribute("cart");
        logger.info("支付超时或异常请重新下单");
        List<MercChantPo> merc = mercService.findAll();
        modelAndView.addObject("merc",merc);
        modelAndView.setViewName("welcome");
        return modelAndView;
    }

    public String sendPost(Order order){
        net.sf.json.JSONObject req = new net.sf.json.JSONObject();
        req.put("orderNo",order.getOid());
        req.put("tranAmt",order.getTotal().toString());
        req.put("ccy","CNY");
        req.put("pname","1");
        req.put("pnum","1");
        req.put("pdesc","1");
        req.put("retUrl","http://www.baidu.com");
        req.put("notifyUrl","http:172.16.40.155:8080/success");
        req.put("userId",order.getUid());
        req.put("payWay","2");
        req.put("payChannel",order.getPayChannel());
        String res = null;
        try {
            res = encrypt("RSA#RSA",req.toString(),sxfPublic);
        } catch (Exception e) {
            e.printStackTrace();
        }
        net.sf.json.JSONObject params = new net.sf.json.JSONObject();
        params.put("mercNo",mercNo);
        params.put("tranCd","1001");
        params.put("version","3.0");
        params.put("reqData",res);
        params.put("ip", ip);
        //生成签名
        String sign = PaymentUtils.sign(getSortSign(params),mercPrivateKey);
        Map<String, String> post = new HashMap<>();
        post.put("mercNo",mercNo);
        post.put("tranCd","1001");
        post.put("version","3.0");
        post.put("reqData",res);
        post.put("ip",ip);
        post.put("encodeType","RSA#RSA");
        post.put("sign",sign);
        post.put("type","2");
        String respBody = Util.connectPostUrl(payUrl,post);
        JSONObject jsonObject = JSONObject.parseObject(respBody);
        if (null == jsonObject){
            return null;
        }
        String code = jsonObject.getString("resCode");
        String url = null;
        if ("000000".equals(code)){
               url = jsonObject.getString("payUrl");
        } else {
            return "error";
        }
        return url;
    }

    public static String getSortSign(Map<String, Object> map) {
        ArrayList<String> list = new ArrayList<String>();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            if (entry.getValue() != null) {
                list.add(entry.getKey() + "=" + entry.getValue() + "&");
            }
        }
        int size = list.size();
        String[] arrayToSort = list.toArray(new String[size]);
        Arrays.sort(arrayToSort, String.CASE_INSENSITIVE_ORDER);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append(arrayToSort[i]);
        }
        if(sb.length()>0){
            sb.deleteCharAt(sb.length()-1);
        }
        return sb.toString();
    }

    /**
     * 验签、解密
     * @param str
     * @return
     */
    public String callBack(String str,String mercNo,String orderNo,String tranCd,String res){
        if (!StringUtils.isNotBlank(str)){
            return null;
        }

       //获取商户密钥
        String mercPrivateKey=Configuration.getInstance().getValue("mercPrivateKey");
        String sxfPublic=Configuration.getInstance().getValue("sxfPublic");

        JSONObject jsonObject = JSONObject.parseObject(str);
        String sign = jsonObject.getString("sign");
        String resData = jsonObject.getString("resData");
        JSONObject main = new JSONObject();
        //注意签名顺序
        main.put("mercNo", mercNo);
        main.put("orderNo", orderNo);
        main.put("tranCd", tranCd);
        main.put("resData", res);

        //验签
//        boolean check=PaymentUtils.doCheck(main.toString(), sign, sxfPublic);
//
//        if(!check){
//            System.out.print("验签失败");
//            return null;
//        }else {
//
//            //验签失败，对应业务逻辑
//        }

        //解密
        String data= null;
        try {
            data = PaymentUtils.decrypt(resData, mercPrivateKey);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        System.out.println("result:"+data);
        return data;
    }

    public String encrypt(String encodeType,String json, String sxfPublic) throws Exception {
        String resData="";
        if("".equals(encodeType)||"RSA#RSA".equals(encodeType)){
            resData = PaymentUtils.encrypt(json, sxfPublic);
        }else {
            throw new Exception("加密错误");
        }
        return resData;
    }

    @RequestMapping("/payImage")
    public ModelAndView payImage(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("payImage");
        return modelAndView;
    }

    @RequestMapping("/success")
    public ModelAndView success(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("success");

        return modelAndView;
    }

    @RequestMapping("waitSuccess")
    public void waitSuccess(){


    }

    @RequestMapping("newOrder")
    public ModelAndView newOrder(){
        ModelAndView model = new ModelAndView();
        List<MercChantPo> merc = mercService.findAll();
        model.addObject("merc",merc);
        model.setViewName("welcome");
        return model;

    }

    @RequestMapping("myOrderList")
    public ModelAndView myOrderList(HttpServletRequest request,@RequestParam Integer pageNum){

        ModelAndView modelAndView = new ModelAndView();
        Users users = (Users) request.getSession().getAttribute("users");
        if (users == null){
            logger.info("请您重新登录");
            modelAndView.setViewName("index");
            return modelAndView;
        }

        String uid = users.getUsername();
        PageHelper.startPage(pageNum,3);
        List<Order> order = orderService.queryOrder(uid);
        PageInfo<Order> oi = new PageInfo<>(order,5);
        List<Order> list = oi.getList();
        for (int i=0;i<list.size();i++){
            List<OrderItem> map = orderItemService.queryOrder(list.get(i).getOid());
            for (int j=0;j<map.size();j++) {
                Goods goods = goodsService.findNameById(map.get(j).getGid());
                map.get(j).setGid(goods.getGname());
                list.get(i).getItems().add(map.get(j));
            }

        }
        modelAndView.addObject("orders",list);
        modelAndView.setViewName("orderList");
        return modelAndView;
    }

     @RequestMapping("changePayWay")
     public ModelAndView changePayWay(@RequestParam String payChannel,HttpServletRequest request){

        ModelAndView modelAndView = new ModelAndView();
        String postFee = (String) request.getSession().getAttribute("postFee");
        modelAndView.addObject("payChannel",payChannel).addObject("postFee",postFee);
        modelAndView.setViewName("order");
        return modelAndView;

     }



}
