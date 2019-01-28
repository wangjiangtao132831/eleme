$(document).ready(function(){

	var str = ""
	$.each(req,function(i,v){
		str += '<tr>';

		$.each(req[i],function(key,value){
			if(key=="3"){
				str += '<td class="blue">'+req[i][key]+'</td>';
			}else{
				str += '<td>'+req[i][key]+'</td>';
			}
			
		})
		str += '</tr>';

		$("#req table").append(str);
		str = "";
	})
	
	var str2 = "";
	$.each(use,function(i,v){
		str2 += '<tr>';

		$.each(use[i],function(key,value){
			str2 += '<td>'+use[i][key]+'</td>';
		})

		str2 += '<td><a href="javascript:;">查看</a><a href="javascript:;">修改</a></td></tr>'

		$("#use table").append(str2);
		str2 = "";
	})

	$(".nav a:first").click(function(){
		$(".nav li").removeClass("click");
		$(".task li").css("display","none");
		$(".position").html('&nbsp;&nbsp;当前位置：/需求管理系统/');
		$(".tj").css("display","none");
		$(".create").css("display","none")
	});

	$(".nav li").click(function(){
		var index = $(".nav li").index(this);

		$(".nav li").removeClass("click");
		$(".tj").css("z-index","9");


		$(this).addClass("click");
		$(".task li").eq(index).css("display","block");
		$(".tj").eq(index).css("display","block");
		$(".tj").eq(index).css("z-index","99");
		$(".position").html('&nbsp;&nbsp;当前位置：/需求管理系统/'+$(this).text());
	});

	$(".task span").click(function(){
		var index = $(".task span").index(this);
		$(".tj").eq(index).css("z-index","9");
		$(".tj").eq(index).css("display","none");
		$(".task li").eq(index).css("display","none");
		$(".nav li").eq(index).removeClass("click");
		$(".position").html('&nbsp;&nbsp;当前位置：/需求管理系统/');
	});

	$(".cb").click(function(){
		$(".create").css("display","block");
	});

	$(".ct tfoot a").click(function(){
		$(".create").css("display","none")
	});
	
});