<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %><%--
  Created by IntelliJ IDEA.
  User: wangjiangtao
  Date: 2018/4/13
  Time: 10:36
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
    <%--<meta charset="utf-8">--%>
    <%--<meta http-equiv="X-UA-Compatible" content="IE=edge">--%>
    <%--<meta name="viewport" content="width=device-width, initial-scale=1">--%>
    <%--<meta name="description" content="">--%>
    <%--<meta name="author" content="">--%>
    <%--<title>购物车结算</title>--%>
    <%--<script src="<%=basePath%>js/jquery.min.js"></script>--%>

    <%--<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">--%>
    <%--<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>--%>
    <%--<!-- 最新版本的 Bootstrap 核心 CSS 文件 -->--%>
    <%--<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">--%>

    <%--<!-- 可选的 Bootstrap 主题文件（一般不用引入） -->--%>
    <%--<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">--%>

    <%--<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->--%>
    <%--<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>--%>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">
        <!-- jQuery -->
        <script src="<%=basePath%>js/jquery.min.js"></script>

        <!-- Bootstrap Core JavaScript -->
        <script src="<%=basePath%>js/bootstrap.min.js"></script>

        <!-- Metis Menu Plugin JavaScript -->
        <script src="<%=basePath%>js/metisMenu.min.js"></script>

        <%--<!-- DataTables JavaScript -->--%>
        <script src="<%=basePath%>js/jquery.dataTables.min.js"></script>
        <script src="<%=basePath%>js/dataTables.bootstrap.min.js"></script>
        <!--引入js  -->
        <script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
        <!--引入bootstrap -->

        <!-- Custom Theme JavaScript -->
        <script src="<%=basePath%>js/sb-admin-2.js"></script>
        <title>客户列表-BootCRM</title>


        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->

        <link rel="stylesheet" href="${ctx}/fileinput/css/fileinput.min.css">
        <script type="text/javascript" src="${ctx}/fileinput/js/fileinput.min.js"></script>
        <script type="text/javascript" src="${ctx}/fileinput/js/locales/zh.js"></script>



        <!-- Bootstrap Core CSS -->
        <link href="<%=basePath%>css/bootstrap.min.css" rel="stylesheet">

        <!-- MetisMenu CSS -->
        <link href="<%=basePath%>css/metisMenu.min.css" rel="stylesheet">

        <!-- DataTables CSS -->
        <link href="<%=basePath%>css/dataTables.bootstrap.css" rel="stylesheet">

        <!-- Custom CSS -->
        <link href="<%=basePath%>css/sb-admin-2.css" rel="stylesheet">

        <!-- Custom Fonts -->
        <link href="<%=basePath%>css/font-awesome.min.css" rel="stylesheet"
              type="text/css">
        <link href="<%=basePath%>css/boot-crm.css" rel="stylesheet"
              type="text/css">
    <style type="text/css">
        a:focus{
            border: 2px solid white;
        }
        a:hover {
            color:deepskyblue;
            text-decoration:none;
        }
        #daohang{
            position: absolute;
            left: 0%;
            top: 0%;
        }

    </style>

</head>
<body style="background-color: rgb(249,249,249)">
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

    <div style="height: 550px;width: 420px;border: 1px solid lightgrey;position:relative;left: 67px;top: 121px;background-color: #FFFFFF">

        <div style="position: relative;left: 20px;top: 16px;">
            <span style="font-size: 20px;color: black;font-weight: bold">订单详情</span>
        </div>

        <div style="position: relative;left: 5px;top: 50px;">
            <table style="text-align: center">
        <thead class="table table-hover" >

         <tr>
             <th width="15%">商品</th>
             <th width="10%">单价</th>
             <th width="10%">数量</th>
             <th width="10%">价格</th>
             <th width="10%">操作</th>
         </tr>
        </thead>
        <tbody>
        <c:forEach items="${cart.cartItems}" var="ci">

        <tr>
          <td>
             ${ci.goods.gname}
          </td>
          <td>
             ${ci.goods.price}
          </td>
          <td>
             ${ci.count}
          </td>
         <td>
             ${ci.subtotal}
         </td>
         <td>
           <a href="javascript:void(0);" onclick="removeFromCart('${ci.goods.id}')" >删除</a>
         </td>
        </tr>
        </c:forEach>

        </tbody>
        <div style="position:relative;top: 370px;left: 130px;">
            <span style="font-size: 30px;color: #FF0000;">￥</span><span style="color: #FF0000;font-size: 40px"><c:if test="${empty cart.cartItems}">0.00</c:if><c:if test="${not empty cart.cartItems}">${cart.total+postFee}</c:if></span>
        </div>

        <a href="/clearFromCart" style="position:relative;top: 335px;left: 275px;font-size: 20px;">清空购物车</a>

        </table>
        </div>
        <br>


    </div>

    <div style="height: 750px;width: 750px;border: 1px solid lightgrey;position:relative;left: 523px;top: -428px;background-color: #FFFFFF">

        <div style="position:relative;top: 30px;left: 30px;font-weight: bold;font-size: 20px">
            收货信息
        </div>

        <a href="#" class="btn btn-primary btn-xs" data-toggle="modal" data-target="#customerEditDialog"  style="position:relative;left: 600px;top: 12px;">添加新地址</a>

        <div style="position:relative;left: 30px;top: 25px;height: 130px;width: 450px">
            <div class="form-group">
                <label class="col-sm-2 control-label">姓名</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control"  name="uname" value="${name}" readonly="readonly" >
                </div>
            </div><br>
            <div class="form-group">
                <label class="col-sm-2 control-label">地址</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" name="address" value="${address}" readonly="readonly">
                </div>
            </div><br>

            <div class="form-group">
                <label  class="col-sm-2 control-label">手机号</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control"  name="phone" value="${telephone}" readonly="readonly">
                </div>
            </div>

        </div>

        <div style="position: relative;top: 60px;left: 30px;height: 160px;width: 700px;font-weight: bold;font-size: 20px">
            付款方式<br>
         <div style="position:relative;top:15px;border: 1px solid gainsboro;width: 143px;height: 65px;">
             <a href="/changePayWay?payChannel=5"><img src="../images/zhifubao.png" width="140px" height="63px"></a>
         </div>

            <div style="position:relative;top: -50px;left: 180px;border: 1px solid gainsboro;width: 143px;height: 65px;">
                <a href="/changePayWay?payChannel=6"><img src="../images/weixin.png" width="140px" height="63px"></a>
            </div>
        </div>

        <a href="/saveOrder?payChannel=${payChannel}"><button style="position:relative;top: 80px;left: 30px; background-color: red;height: 40px;width: 124px;"><span style="font-size: 16px;color: #FFFFFF">确认下单</span></button></a>

    </div>



    <!-- 客户编辑对话框 -->
    <div class="modal fade" id="customerEditDialog" tabindex="-1" role="dialog"
         aria-labelledby="myModalLabel" >
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                    <h4 class="modal-title" id="myModalLabel">添加新的地址</h4>
                </div>
                <div class="modal-body">
                    <form action="/addAddress" method="POST" class="form-horizontal" id="edit_customer_form">

                        <div class="form-group">
                            <label for="uname" class="col-sm-2 control-label">姓名</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="uname" placeholder="姓名" name="name">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="address" class="col-sm-2 control-label">地址</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="address" placeholder="地址" name="address">
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="phone" class="col-sm-2 control-label">手机号</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="phone" placeholder="手机号" name="telephone">
                            </div>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                            <button type="submit" class="btn btn-primary">保存修改</button>
                        </div>
                    </form>
                </div>

            </div>
        </div>
    </div>


</body>
<script type="text/javascript">
    function removeFromCart(id){
        if (confirm("你忍心删除我吗")){
            location.href="/removeFromCart?id="+id;
        }
    }

</script>
</html>
