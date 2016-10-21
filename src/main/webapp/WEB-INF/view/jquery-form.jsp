<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<!-- <link rel="icon" href="./fa.ico" type="image/x-icon" /> -->
<link type="image/x-icon" rel="shortcut icon" href="./fa.ico" />
<!-- 引入bootstrap -->
<link href="static/css/bootstrap.min.css" rel="stylesheet">
<script src="static/js/jquery.min.js"></script>
<script src="static/js/bootstrap.min.js"></script>

<title>jquery-form传值</title>
</head>

<script>
	$(document).ready(function() {
		console.log($("#form1").serialize()); // FirstName=Bill&LastName=Gates
	});

	var options = {
		target : '#output1',
		data : {
			param1 : "我自己的第一个额外的参数"
		},
		//这个参数是指通过ajax来给服务器提交除了form内部input的参数
		//在后台中使用String param1=req.getParameter("param1");获取。
		// dataType: null,
		dataType : 'json',
		//这个参数值的是服务器返回的数据类型，默认的是null
		//也就是服务器可以默认返回字符串，然后将这些字符串放在target内部
		//当然还有json、xml，其中最常用的便是null和json
		//对于json的使用，我们会稍后讲解到
		beforeSubmit : showRequest,
		success : showRequest,
		type : 'POST',
	//提交方式，默认是自己在form标签上指定的method
	//如果没有指定，则使用get。
	// url:''
	//重新提交的url，即url可以在form中配置
	//也可以在这里配置。
	};

	$(document).ready(function() {
		var options = {
			target : '#output1',
			// 从服务传过来的数据显示在这个div内部
			//也就是ajax局部刷新
			beforeSubmit : showRequest,
			// ajax提交之前的处理
			success : showResponse
		// 处理之后的处理
		};
		$('#showDataForm').submit(function() {
			$(this).ajaxSubmit(options);
			return false;
			//非常重要，如果是false，则表明是不跳转
			//在本页上处理，也就是ajax，如果是非false，则传统的form跳转。
		});
	});
	function showResponse(responseText, statusText, xhr, $form) {
		alert(xhr.responseText + "==" + $form.attr("method") + 'status: '
				+ statusText + '\n\nresponseText: \n' + responseText);
		//xhr：说明你可以用ajax来自己再次发出请求
		//$form：是那个form对象，是一个jquery对象
		//statusText：状态，成功则为success
		//responseText，服务器返回的是字符串（当然包括html，不包括json）
	}
	function showRequest(formData, jqForm, options) {
		//formData是数组，就是各个input的键值map数组
		//通过这个方法来进行处理出来拼凑出来字符串。
		//formData：拼凑出来的form字符串，比如name=hera&password，
		//其实就是各个表单中的input的键值对，
		//如果加上method=XXXX，那也就是相当于ajax内的data。
		var queryString = $.param(formData);
		alert(queryString + "======" + formData.length);
		for (var i = 0; i < formData.length; i++) {
			alert(formData[i].value + "===============" + formData[i].name);
		}
		//jqForm，jquery form对象
		var formElement = jqForm[0];
		alert($(formElement).attr("method"));
		alert($(jqForm[0].name).attr("maxlength"));
		//非常重要，返回true则说明在提交ajax之前你验证
		//成功，则提交ajax form
		//如果验证不成功，则返回非true，不提交
		return true;
	}
</script>

<body>
	<p>此处控制台输出${FirstName}</p>
	<form id="form1">
		First name: <input type="text" name="FirstName" value="Bill" /><br />
		Last name: <input type="text" name="LastName" value="Gates" /><br />
	</form>
	<div>
		<form id="showDataForm"
			action="${pageContext.request.contextPath}/jquery-form" method="post">
			<input type="text" value="" name="name" maxlength="2" /> <input
				type="password" value="" name="password" maxlength="2" /> <input
				type="submit" value="提交" />
		</form>
		<div id="output1"
			style="width: 1000px; height: 200px; background-color: #eee;"></div>

	</div>

	<div>
		<input type="text" name="name" id="name" /> 
		<input type="submit" value="登录" onclick="ajaxTest();" />
	</div>
	
	<div id="result" style="width: 1000px; height: 200px; background-color: #eee;"></div>  
	
	<script type="text/javascript">  
    function ajaxTest(){  
        $.ajax({  
        data:"name="+$("#name").val(),  
        type:"GET",  
        dataType: 'json',  
        url:"${pageContext.request.contextPath}/jtest/ajax",  
       
        success:function(data){  
            alert("处理结果:"+data.msg);  
            $("#result").html(data.msg) ;  
        } ,
        error:function(data){  
            alert("出错了！！:"+data.msg);  
        }
        });  
    }  
</script> 


</body>
</html>