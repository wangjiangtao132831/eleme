<%--<%@ page import="java.util.Set" %>--%>
<%--<%@ page import="java.util.Iterator" %>--%>
<%--<%@ page import="java.util.List" %>--%>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%--&lt;%&ndash;--%>
  <%--Created by IntelliJ IDEA.--%>
  <%--User: wangjiangtao--%>
  <%--Date: 2018/3/14--%>
  <%--Time: 11:44--%>
  <%--To change this template use File | Settings | File Templates.--%>
<%--&ndash;%&gt;--%>
<%--<%--%>
    <%--String path = request.getContextPath();--%>
    <%--String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()--%>
            <%--+ path + "/";--%>
<%--%>--%>

<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<html>--%>
<%--<head>--%>
    <%--<title>挑选你的美食</title>--%>
    <%--<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">--%>
    <%--<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>--%>
    <%--<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>--%>
    <%--<!-- 最新版本的 Bootstrap 核心 CSS 文件 -->--%>
    <%--<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">--%>

    <%--<!-- 可选的 Bootstrap 主题文件（一般不用引入） -->--%>
    <%--<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">--%>

    <%--<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->--%>
    <%--<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>--%>
    <%--<script src="<%=basePath%>js/jquery.min.js"></script>--%>

    <%--<!-- Bootstrap Core JavaScript -->--%>
    <%--<script src="<%=basePath%>js/bootstrap.min.js"></script>--%>

    <%--<!-- Metis Menu Plugin JavaScript -->--%>
    <%--<script src="<%=basePath%>js/metisMenu.min.js"></script>--%>

    <%--&lt;%&ndash;<!-- DataTables JavaScript -->&ndash;%&gt;--%>
    <%--<script src="<%=basePath%>js/jquery.dataTables.min.js"></script>--%>
    <%--<script src="<%=basePath%>js/dataTables.bootstrap.min.js"></script>--%>
    <%--<!--引入js  -->--%>
    <%--<script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>--%>
    <%--<!--引入bootstrap -->--%>
    <%--&lt;%&ndash;<script src="${ctx}/static/common/bootstrap/js/${bootsVersion}.js"></script>&ndash;%&gt;--%>
    <%--&lt;%&ndash;<script&ndash;%&gt;--%>
            <%--&lt;%&ndash;src="${ctx}/static/common/bootstrap-fileinpu/js/fileinput.min.js"&ndash;%&gt;--%>
            <%--&lt;%&ndash;type="text/javascript"></script>&ndash;%&gt;--%>
    <%--&lt;%&ndash;<script src="${ctx}/static/common/bootstrap-fileinpu/js/locales/zh.js"&ndash;%&gt;--%>
            <%--&lt;%&ndash;type="text/javascript"></script>&ndash;%&gt;--%>
    <%--<!-- Custom Theme JavaScript -->--%>
    <%--<script src="<%=basePath%>js/sb-admin-2.js"></script>--%>


    <%--<link href="<%=basePath%>css/bootstrap.min.css" rel="stylesheet">--%>

    <%--<!-- MetisMenu CSS -->--%>
    <%--<link href="<%=basePath%>css/metisMenu.min.css" rel="stylesheet">--%>

    <%--<!-- DataTables CSS -->--%>
    <%--<link href="<%=basePath%>css/dataTables.bootstrap.css" rel="stylesheet">--%>

    <%--<!-- Custom CSS -->--%>
    <%--<link href="<%=basePath%>css/sb-admin-2.css" rel="stylesheet">--%>

    <%--<!-- Custom Fonts -->--%>
    <%--<link href="<%=basePath%>css/font-awesome.min.css" rel="stylesheet"--%>
          <%--type="text/css">--%>
    <%--<link href="<%=basePath%>css/boot-crm.css" rel="stylesheet"--%>
          <%--type="text/css">--%>

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>


<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--<%@ taglib prefix="itcast" uri="http://itcast.cn/common/"%>--%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
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
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>
<body style="background-color: rgb(249,249,249);overflow-x:hidden">
<style>
    #daohang{
        position: absolute;
        left: 0%;
        top: 0%;
    }
    #caipin{
        position: absolute;
        left: 10px;
        top: 0px;
        height: 60px;
    }
    .cai{
        background-image: url("../images/caipin7.jpg");

    }
    #shangjia{
        background-color: rgb(255,255,255);
        position: absolute;
        top: 270px;
        left: 100px;
        width: 900px;
        height: 100px;
        border: 1px solid lightgrey;
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
    .xuanfu{
        right: 0px;
        position: fixed;
        bottom: 0px;
        width: 280px;
        height: 100px;
        z-index: 100;
        border: 1px solid black;
        background-color: #FFFFFF;

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


<div class="cai" style="position: absolute;left: 0px;top: 51px;height: 140px;width: 2200px">
    <div style="position: relative;left: 20px;top: 10px;height: 130px;width: 500px">
        <p style="font-size: 25px;position:relative; top: 30px;left: 160px;font-weight: bolder;font-family: '幼圆';">${mercChant.mname}(${mercChant.maddress})</p>

    </div>
    <div style="position: relative;left: 830px;top: -130px;height: 130px;width: 400px">
        <table class="">
        <thead>
        <tr>
            <th width="15%">起送价</th>
            <th width="15%">配送费</th>
            <th width="15%">平均送达速度</th>

        </tr>
        </thead><br><br>
        <tbody>

        <tr>
            <td style="font-size: 25px">${mercChant.startFee}</td>
            <td style="font-size: 25px">${mercChant.postFee}</td>
            <td style="font-size: 25px">${mercChant.postTime}</td>
        </tr>

        </tbody>
        </table>
    </div>

</div>
<div style="position: absolute;top: 191px;left: 80px;height: 55px;width: 1500px;border: 1px solid lightgrey;">
    <div id="caipin">
        <div class="navbar" role="navigation">
            <div class="container-fluid">
                <div style="background-color: white;height: 52px;width: 1500px;position: absolute;left: -11px;">
                    <ul class="nav navbar-nav">
                        <li class="active text-center" style="width: 130px;"><a href="#"><span style="color: rgb(27,115,217);font-size: 17px">所有商品</span></a></li>
                        <li class="text-center" style="width: 130px"><a href="#"><span style="color: rgb(27,115,217);font-size: 17px">评价</span></a></li>
                        <li class="text-center" style="width: 130px"><a href="#"><span style="color: rgb(27,115,217);font-size: 17px">商家资质</span></a></li>
                        <li class="text-center" style="width: 100px;left: 170px"><a href="#"><span style="color: rgb(27,115,217);font-size: 14px">默认排序</span></a></li>
                        <li class="text-center" style="width: 70px;left: 170px"><a href="#"><span style="color: rgb(27,115,217);font-size: 14px">评分</span></a></li>
                        <li class="text-center" style="width: 70px;left: 170px"><a href="#"><span style="color: rgb(27,115,217);font-size: 14px">销量</span></a></li>
                        <li class="text-center" style="width: 70px;left: 170px"><a href="#"><span style="color: rgb(27,115,217);font-size: 14px">价格</span></a></li>
                        <div style="width: 260px; position: absolute;top: 5px; left: 982px;">
                            <form class="bs-example bs-example-form" role="form">
                                <div class="input-group">
                                    <input type="text" class="form-control" placeholder="搜索商家和美食...">
                                    <span class="input-group-addon"><button type="submit">搜索</button></span>

                                </div><br>
                            </form>
                        </div>
                    </ul>
                </div>
            </div>
        </div>
    </div>


</div><br><br>
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

</div>

<div style="position:absolute;left: 100px;top:390px;">
    <span style="font-size: 20px">热销</span>&nbsp;&nbsp;<span style="color: darkgrey;font-size: 12px"> 大家喜欢吃，才叫真好吃。</span><br><br>
<c:forEach items="${goodsList}" var="goodsList">
       <div class="product" style="width: 900px;height: 100px;background-color: rgb(255,255,255);border: 1px solid lightgrey;">
        <div style="position: relative;top: 0;left: 0px;" class="product">
            <img src="<%=basePath%>showImage?fileName=${goodsList.imageName}&suffix=jpg" style="height: 75px;width: 75px;text-align: center;">
        </div>
        <div style="position: relative;top: -55px;left: 90px;width: 550px;height: 60px;">
          <span style="font-size: 16px;font-weight: bolder">${goodsList.gname}</span><br>
           <div style="position: relative;top: 5px;">
            <span style="color: darkgrey;font-size: 13px;">本店保证所有鲜果新鲜，卫生，分量足，让每一位消费者放心~~~</span>
           </div>
        </div>
           <div style="position: relative;top: -97px;left: 550px;width:200px;height: 50px;" >
               <span class="goodsPrice" style="font-weight: bolder" />￥${goodsList.price}
                <%--<div class="num" style="float: right"><input type="button" value="-">--%>
                <%--<span>&nbsp;0&nbsp;&nbsp;</span><input type="button" value="+">--%>
               <%--</div>--%>

           </div>
           <div style="position: relative;top: -150px;left: 780px;width: 90px;height: 50px;text-align: center;">
               <button type="button" class="btn btn-primary addCard" onclick="addGoods(${goodsList.id})">加入购物车</button>
           </div>

       </div>
    <br>
</c:forEach>
</div>

<div style="height: 245px;width: 295px;position: absolute;top: 270px;left:1030px;border: 1px solid lightgrey">
 <div style="background-color: rgb(27,115,217);height: 50px;">
     <span style="color: white;font-size: 20px;position: relative; left: 20px;top: 10px;">商家公告</span>
 </div>
    <div style="height: 80px;text-align: left;background-color: white;">
        <div style="position: relative;top: 5px;left: 20px;width: 260px;">
            本店保证所有鲜果新鲜，卫生，分量足，让每一位消费者放心~~~
        </div>
    </div>
    <div style="background-color: rgb(249,249,249);">
      <span style="font-size: 14px;font-weight: bolder;position: relative; left: 20px;top: 0px;">配送说明:</span><br>
      <span style="position: relative; left: 20px;top: 0px;">配送费${mercChant.postFee}</span>
    </div>
<div style="position: relative;top: 10px; background-color: white;text-align: center;height: 60px;">
     <span style="font-size: 20px;color: darkgrey;position: relative; top: 10px;">
         <a href="#" class="btn btn-primary btn-lm" data-toggle="modal" data-target="#leaveMessage" onclick="leaveMessage(10000)">留言</a>
     </span>

</div>

</div>
<div>
    <tr>
        <td></td>

    </tr>
</div>
<div class="xuanfu">
    <div  style="width: 290px;height: 47px;position:relative;left: 0px;top: 0px;text-align: left;">
        <div  class="shopCard" style="position: absolute;top: 15px;left: 95px;">
            <span>购物车</span>&nbsp;<button type="button"><a href="/clearGoods">[清空]</a></button>
        </div>
    </div>
    <div style="position: relative;width: 190px;height: 53px;background-color: black;">
      <div style="position: absolute;top: 10px;left: 8px;">
          <img src="../images/gouwuche.jpg" width="27px" height="27px">
      </div>
        <div class="price" style="position: absolute;top: 8px;left: 33px;width: 70px;height: 30px;">
            <span style="font-size: 21px;color: #FFFFFF;"></span>
        </div>
        <div style="position: absolute;top: 15px;left: 110px;">
     <span style="font-size: 10px;color: grey;">| 配送费:${mercChant.postFee}</span>
        </div>
    </div>
    <div style="position: absolute;left: 190px;top: 47px;background-color: lightgrey;width: 90px;height: 53px;text-align: center;">
        <div style="position:relative;left: 0px;top: 10px;">
            <button style="font-size: 18px;" type="button" onclick="payment()">去付款</button>
        </div>
    </div>

</div>

<div class="modal fade" id="leaveMessage" tabindex="-1" role="dialog"
     aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title" id="myModalLabel">写下您宝贵的建议</h4>
            </div>
            <div class="modal-body">
                <form action="leaveMessage" method="PUT" class="form-horizontal" id="edit_customer_form">
                    <input type="hidden" id="username" name="username"/>
                    <input type="hidden" id="mid" name="mid"/>


                    <div class="form-group">
                        <label for="message" class="col-sm-2 control-label">留言</label>
                        <div class="col-sm-10">
                            <input type="textarea" style="width: 400px;height: 150px" class="form-control" id="message"  name="message">
                        </div>
                    </div>


                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                        <button type="submit" class="btn btn-primary">提交</button>
                    </div>
                </form>
            </div>

        </div>
    </div>
</div>


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


<script src="http://code.jquery.com/jquery-latest.js"></script>
<script>
    $(function(){
        $('.addCard').on('click',function(){

            var shopCard = $('.shopCard');
            var addImg=$(this).parent().parent('.product').find('img').eq(0);
            //克隆
            var cloneImg=addImg.clone();

            cloneImg.css({
              'width':'80px',
              'height':'80px',
              'position':'absolute',
              'top':addImg.offset().top,
              'left':addImg.offset().left,
                'z-index':'1000',
                'opacity':'.5'
            });

            cloneImg.appendTo($('body')).animate({
                'width':30,
                'height':30,
                'top':shopCard.offset().top,
                'left':shopCard.offset().left,
            },1000,function(){
                cloneImg.animate({
                    'width':0,
                    'height':0
                },function(){
                    var total = $('.price').html();
                    $('.price').var(total);
                    $(this).detach();

                })
            })
        });
    });
    function addGoods(id) {
        $.ajax({
            url: "/addGoods",
            data:{"id":id}
            }
        )
    }
    function payment(){
        window.location.href = "/payment?postFee=${mercChant.postFee}";

    }
    function clear() {

        window.location.href = "/clearGoods";

    }

    function  leaveMessage(mid) {
        $.ajax({
            type:"get",
            url:"<%=basePath%>selectMessageByMid",
            data:{"id":mid},
            success:function(data) {
                console.log('data: ', data);
                $("#message").val(data.message);

            }
        });
    }





</script>




</body>
</html>
