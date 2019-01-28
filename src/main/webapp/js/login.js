window.onload = function(){

	var arr = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R','S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'];
    var len = 4;


	var oSub = document.getElementById("sub");//提交按钮
	var oRe = document.getElementById("re");//重置按钮
	var iusername = document.getElementById("id");//用户名文本框
	var iuserpassword = document.getElementById("password");//密码文本框
	var oCode = document.getElementById("code");//验证码
	var icode = document.getElementById("codeinp");//验证码输入框
	var oA = document.getElementById("aa");//换一张
	var oTip = document.getElementById("tip");
	
	//打开页面自动创建验证码
	createCodes();
	//点击刷新验证码
	oA.onclick = createCodes;

	//点击重置
	oRe.onclick = re;

	//所有内容重置
	function re(){
		iusername.value = "";
		iuserpassword.value = "";
		icode.value = "";

		createCodes();
	};

	//创建验证码
    function createCodes(){
        var code0 = "";
        var num = 0;

        for(var i=0;i<len;i++){
            num = Math.floor(Math.random()*36);
            code0 += arr[num];
        }
        oCode.innerHTML = code0;
    }

    //点击登录，验证信息
	oSub.onclick = function(){

		//清空提示信息
		oTip.innerHTML = "";

		//用来定位用户在数据中位值
		var num = -1;

		//只要三个输入框有一个为空，提示，并且不再执行后面的代码
		if(iusername.value==""||iuserpassword.value==""||icode.value==""){
			oTip.style.display = "block";
			if(iusername.value==""){
				oTip.innerHTML += "必须输入用户名！<br>";
			}
			if(iuserpassword.value==""){
				oTip.innerHTML += "必须输入密码！<br>";
			}
			if(icode.value==""){
				oTip.innerHTML += "验证码不能为空！<br>";
			}
			return false;
		}


		//验证码错误
		if(icode.value.toUpperCase() != oCode.innerHTML){
			oTip.innerHTML = "验证码错误！";
			oTip.style.display = "block";
			createCodes();
			return false;
		}
		$("#login").submit();
		//隐藏提示信息，重置输入框
		oTip.style.display = "none";
		re();

		//跳转页面
		//open("system.html");
	};

};

$(document).ready(function(){
	$(".forget a").click(function(){
		var $div = $(this).closest("div");
		$div.css("display","none");;
		$div.find("input").value = "";
	});

	$(".btn a").click(function(){
		var index = $(".btn a").index(this);
		$(".forget").eq(index).css("display","block");
	});

	$("#change").click(function(){
		if($('input[name="newpassword1"]').value!=$('input[name="newpassword2"]').value){
			alert("两次输入的密码不同！")
		}
	});
});