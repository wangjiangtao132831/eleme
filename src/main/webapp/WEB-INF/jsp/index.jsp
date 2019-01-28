<%--
  Created by IntelliJ IDEA.
  User: wangjiangtao
  Date: 2018/2/26
  Time: 11:26
  To change this template use File | Settings | File Templates.
--%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>Bootstrap 实例 - 标签式的导航菜单</title>
    <link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
    <script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <style>
        .a{
            width: 300px;
            height: 700px;
            position: absolute;
            top: 13%;
            left:40%;
        }

    </style>
</head>
<body>

<form role="form" action="/login" method="post">

<div class="a">
    <div class="text-center">
        <img src="../images/ele.jpg">
    </div><br>
<ul id="myTab" class="nav nav-tabs nav-justified">
    <li class="active"><a href="#home" data-toggle="tab">
        密码登录</a>
    </li>
    <li><a href="#ios" data-toggle="tab">注册</a></li>
</ul><br>
<div class="form-group">
<div id="myTabContent" class="tab-content">
    <div class="tab-pane fade in active" id="home">
        <div class="col-lg-13">
            <input type="text" placeholder="手机/邮箱/用户名" class="form-control" name="username" style="height: 45px">
        </div><br>
        <div class="col-lg-13">
        <input type="password" placeholder="密码" class="form-control" name="password" style="height: 45px">
            <input type="hidden" name="biaoshi" value="1">
        </div>
    </div>

    <div class="tab-pane fade" id="ios">
        <div class="col-lg-13">
            <input type="text" placeholder="账号" class="form-control" name="user" style="height: 45px">
        </div><br>
        <div class="col-lg-13">
            <input type="password" placeholder="密码" class="form-control" style="height: 45px">
            <input type="hidden" name="biao" value="2">
        </div>
    </div>
</div>
</div>
    <div class="btn-group">
        <button class="btn btn-default" type="submit" style="background-color: limegreen;width: 300px;height: 45px;">确认</button>
    </div>
</div>
</form>

</body>
</html>
