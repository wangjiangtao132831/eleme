package com.example.demo.utils;

import com.oracle.javafx.jmx.json.JSONException;

import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;

import com.alibaba.fastjson.JSONObject;
import org.jsoup.Connection;
import org.jsoup.Jsoup;


public class IpServiceUtil {

    /**
     * 得到本机的外网ip，出现异常时返回空串""
     * @return
     */
    public static String getPublicIP() {
        String ip = "";

        org.jsoup.nodes.Document doc = null;
        Connection con = null;

        con = Jsoup.connect("http://www.ip138.com/ip2city.asp").timeout(10000);

        try {
            doc = con.get();

// 获得包含本机ip的文本串：您的IP是：[xxx.xxx.xxx.xxx]
            org.jsoup.select.Elements els = doc.body().select("center");
            for (org.jsoup.nodes.Element el : els) {
                ip = el.text();
            }
// 从文本串过滤出ip，用正则表达式将非数字和.替换成空串""
            ip = ip.replaceAll("[^0-9.]", "");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ip;
    }

    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
        InputStream is = null;
        try {
            is = new URL(url).openStream();
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            JSONObject json = JSONObject.parseObject(jsonText);
            return json;
        } finally {
            //关闭输入流
            is.close();
        }
    }

    public static String getAddrName() throws JSONException, IOException{
        //这里调用百度的ip定位api服务 详见 http://api.map.baidu.com/lbsapi/cloud/ip-location-api.htm
        JSONObject json = readJsonFromUrl("http://api.map.baidu.com/location/ip?ak=2qRwcejcWw6AyCf8Nt8jI7u6y6eq24s8&ip="+getPublicIP());

        /* 获取到的json对象：
         *         {"address":"CN|河北|保定|None|UNICOM|0|0",
         *        "content":{"address_detail":{"province":"河北省","city":"保定市","street":"","district":"","street_number":"","city_code":307},
         *        "address":"河北省保定市","point":{"x":"12856963.35","y":"4678360.5"}},
         *        "status":0}
         */
         //这里我们可以输出json看一下具体格式
         System.out.println(json.toString());

        JSONObject content=json.getJSONObject("content");              //获取json对象里的content对象
        JSONObject addr_detail=content.getJSONObject("address_detail");//从content对象里获取address_detail
        String city=addr_detail.get("city").toString();                //获取市名，可以根据具体需求更改，如果需要获取省份的名字，可以把“city”改成“province”...
        return city;
    }
    public static void main(String[] args) {
        try {
            System.out.println(getAddrName());
        } catch (Exception e) {
        }
    }
}
