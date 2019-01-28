<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: wangjiangtao
  Date: 2018/2/27
  Time: 11:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Bootstrap 实例 - 默认的导航栏</title>
    <link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
    <script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body style="background-color: rgb(249,249,249);overflow-x:hidden">

<style>
    #daohang{
        position: absolute;
        left: 0%;
        top: 0%;
    }
    .address{
        position: absolute;
        top: 70px;
        left: 20px;
    }
    #shangjia{
        background-color: rgb(255,255,255);
        position: absolute;
        top: 175px;
        left: 75px;
        width: 1170px;
        height: 100px;
        border: 1px solid gray;
    }
    #merc{
        background-color: rgb(255,255,255);
        position: absolute;
        top: 300px;
        left: 75px;
        width: 1170px;
        height: 1000px;
        border: 1px solid gray;
    }
    .fenlei{
        margin: 6px;
        color: yellowgreen;
        font-size: 14px;
        width: 80px;
        height: 20px;
        float: left;
        text-align:center;
    }

    a:visited {
        color:black;
        text-decoration:none;
    }
    a:hover {
        color:deepskyblue;
        text-decoration:none;
    }
    a:active {
        color:#FFFFFF;
        text-decoration:none;
    }
</style>
<div id="daohang">
<div class="navbar" role="navigation">
    <div class="container-fluid">
        <div style="background-color: rgb(27,115,217);height: 51px;width: 2200px;">
            <ul class="nav navbar-nav">
                <li class="active text-center" style="width: 150px;"><a href="/newOrder"><span style="color: white;font-size: 16px">首页</span></a></li>
                <li class="text-center" style="width: 150px"><a href="/myOrderList?pageNum=1"><span style="color: white;font-size: 16px">我的订单</span></a></li>
                <li class="text-center" style="width: 150px"><a href="/addMerc"><span style="color: white;font-size: 16px">加盟合作</span></a></li>
                <li class="text-center" style="width: 150px"><a href="/first"><span style="color: white;font-size: 16px">登录/注册</span></a></li>
            </ul>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <span class="text-center" style="height: 51px;width: 2200px;font-family: '幼圆';color: white;font-weight: bolder;font-size: 30px">饿了就上饿了么</span>
        </div>
    </div>
</div>
</div>

<div class="address">
    <span style="color: gray">当前位置:</span><span>沈阳理工大学...</span>&nbsp;&nbsp;&nbsp;<a><span style="color: deepskyblue;">[切换地址]</span></a>
</div>
<div style="width: 260px; position: absolute;top: 70px; right: 60px;">
    <form class="bs-example bs-example-form" role="form">
        <div class="input-group">
            <input type="text" class="form-control" placeholder="搜索商家和美食...">
            <span class="input-group-addon"><button type="submit">搜索</button></span>

        </div><br>
    </form>
</div>

 <div id="shangjia"><br>&nbsp;&nbsp;&nbsp;

     <div class="fenlei"><span style="color: gray">商家分类:</span></div>
     <div class="fenlei"><a style="color: black">全部商家</a></div>
     <div class="fenlei"><a style="color: black">美食</a></div>
     <div class="fenlei"><a style="color: black">快餐便当</a></div>
     <div class="fenlei"><a style="color: black">特色体系</a></div>
     <div class="fenlei"><a style="color: black">异国料理</a></div>
     <div class="fenlei"><a style="color: black">小吃夜宵</a></div>
     <div class="fenlei"><a style="color: black">甜品饮品</a></div>
     <div class="fenlei"><a style="color: black">果蔬生鲜</a></div>
     <div class="fenlei"><a style="color: black">商店超市</a></div>
     <div class="fenlei"><a style="color: black">烟花绿植</a></div>
     <div class="fenlei"><a style="color: black">医药健康</a></div>
     <div class="fenlei"><a style="color: black">早餐</a></div>
     <div class="fenlei"><a style="color: black">午餐</a></div>
     <div class="fenlei"><a style="color: black">下午茶</a></div>
     <div class="fenlei"><a style="color: black">晚餐</a></div>
     <div class="fenlei"><a style="color: black">夜宵</a></div>
 </div><br>
 <div id="merc">

         <c:forEach items="${merc}" var="merc" varStatus="mc">
            <a href="/goodsMessage?mid=${merc.mid}" >
             <div style="width: 292px;height: 180px;float: left;text-align:center;border: 1px solid lightgrey">
                 <td>
                    <div style="text-align: center;width: 140px;height:130px;margin-left: 7px;margin-top: 7px">
                     <%--<img src="../images/kfc.jpg">--%>
                        <img src="/showImage?fileName=${merc.imageName}&suffix=jpg" style="width: 140px;height:130px;">
                    </div>
                 </td>
                 <div style="position: relative;top: -110px;left: 73px;">
                 <td><span style="font-size: 18px;font-weight: bolder;text-align: center">${merc.mname}</span></td><br>
                 <td>${merc.maddress}</td><br>
                 <td>
                         ${merc.evaluate}


                 </td><br>
                     <td><span style="font-size: 12px;color: darkgrey">配送费:</span><span style="color: darkgrey">${merc.postFee}</span></td><br>
                 </div>

                 <div  style="position: relative;top: -80px;left: -60px;color: darkgrey">
                 <td>${merc.postTime}</td><br>
                 </div>
                 </tr>
             </div>
            </a>
         </c:forEach>

 </div>

</body>
</html>