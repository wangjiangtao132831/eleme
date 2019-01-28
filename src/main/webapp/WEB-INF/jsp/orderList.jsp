<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: wangjiangtao
  Date: 2018/5/17
  Time: 10:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>我的订单</title>
    <link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
    <script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

    <!-- 可选的 Bootstrap 主题文件（一般不用引入） -->
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    <style type="text/css" media="screen">

        #pagination-digg li { border:0; margin:0; padding:0; font-size:25px; list-style:none; /* savers */ float:left; }

        #pagination-digg a { border:solid 1px #9aafe5; margin-right:8px; }

        #pagination-digg .previous-off,#pagination-digg .next-off  { border:solid 1px #DEDEDE; color:#888888;

            display:block; float:left; font-weight:bold; margin-right:2px; padding:3px 4px; }

        #pagination-digg .next a,#pagination-digg .previous a { font-weight:bold; }

        #pagination-digg .active { background:#2e6ab1; color:#FFFFFF; font-weight:bold; display:block; float:left;

            padding:4px 6px; /* savers */ margin-right:2px; }

        #pagination-digg a:link,#pagination-digg a:visited { color:#0e509e; display:block; float:left; padding:3px 6px;

            text-decoration:none; }

        #pagination-digg a:hover { border:solid 1px #0e509e; }

        body { font-family:Arial, Helvetica, sans-serif; font-size:20px; }

        h2{ clear:both; border:0; margin:0; padding-top:30px; font-size:15px; }

        p{ border:0; margin:0; padding:0; padding-bottom:30px; }

        ul{ border:0; margin:0; padding:0; }

    </style>
</head>
<body style="background-color: rgb(249,249,249);overflow-x:hidden">

<style>
    #daohang{
        position: absolute;
        left: 0%;
        top: 0%;
    }

    a:link {
        color:#FF0000;
        text-decoration:underline;
    }
    a:visited {
        color:#00FF00;
        text-decoration:none;
    }
    ul li a:hover {
        color:blue;
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
<div style="position: relative;top: 100px;left: 200px;">
     <table style="width:1000px;height: 300px;" >
     <c:forEach items="${orders}" var="orders">
         <tbody style="">
         <tr style="background-color: lightgrey">
             <th>订单编号:${orders.oid}</th>
             <%--<th>下单时间:<fmt:formatDate value="${orders.ordertime}" pattern="yyyy-MM-dd HH:mm:ss" ></fmt:formatDate>--%>
             <th>下单时间:${orders.ordertime}
             </th>
             <th>支付状态:
                 <c:if test="${orders.state=='0'}">未支付</c:if>
                 <c:if test="${orders.state=='1'}">支付成功</c:if>
             </th>
             <th>
                 总价:${orders.total}
             </th>
         </tr>
         <tr><th><br></th></tr>
         <tr>
             <th width="25%">商品</th>
             <th width="25%">数量</th>
             <th width="20%">价格</th>
         </tr>
       <c:forEach items="${orders.items}" var="oi">

           <tr>
               <td>
                       ${oi.gid}
               </td>
               <td>
                       ${oi.count}
               </td>
               <td>
                       ${oi.subtotal}
               </td>

           </tr>
        </c:forEach>
        <tr>
            <th><hr style=" height:1px;border:none;border-top:2px dotted lightgrey;" /></th>
            <th><hr style=" height:1px;border:none;border-top:2px dotted lightgrey;" /></th>
            <th><hr style=" height:1px;border:none;border-top:2px dotted lightgrey;" /></th>
            <th><hr style=" height:1px;border:none;border-top:2px dotted lightgrey;" /></th>

        </tr>
       </tbody>
     </c:forEach>
     </table>
</div>
<div style="position: fixed;bottom: 50px;left: 450px;z-index: 100">

    <ul id="pagination-digg">


        <li class="active" href="myOrderList?pageNum=1">1</li>

        <li><a href="myOrderList?pageNum=2">2</a></li>

        <li><a href="myOrderList?pageNum=3">3</a></li>

        <li><a href="myOrderList?pageNum=4">4</a></li>

        <li><a href="myOrderList?pageNum=5">5</a></li>

        <li><a href="myOrderList?pageNum=6">6</a></li>

        <li><a href="myOrderList?pageNum=7">7</a></li>

       <li>
           <form action="/myOrderList">
               第<input type="number" name="pageNum" style="width: 70px;height: 40px;" min="1">页
               <button type="submit" class="btn btn-primary">跳转</button>

           </form>
       </li>

    </ul>

</div>



</body>

<style type="text/css">
    th{
        text-align: center;
    }
    td{
        text-align: center;
    }



</style>
</html>
