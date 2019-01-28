<%--
  Created by IntelliJ IDEA.
  User: wangjiangtao
  Date: 2018/5/7
  Time: 17:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.js"></script>
    <script src="https://cdn.bootcss.com/jquery.qrcode/1.0/jquery.qrcode.min.js"></script>
</head>
<body>
<div id="qrcode"></div>



<form action="/queryOrder">

</form>
<script>

    var isFirst = true;

    jQuery(function(){
        if (isFirst){
            jQuery('#qrcode').qrcode("${url}");
            isFirst = false;
        }
    })

    $(function(){
        $("form").submit();
    });

</script>
</body>
