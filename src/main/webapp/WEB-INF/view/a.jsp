<%@ page language="java" contentType="text/html; charset=utf-8"  
    pageEncoding="utf-8"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">  
<html>  
<head>  
<!-- <link rel="icon" href="./fa.ico" type="image/x-icon" /> -->
<link type="image/x-icon" rel="shortcut icon" href="./fa.ico" />
<!-- 引入bootstrap -->
<link href="static/css/bootstrap.min.css" rel="stylesheet">
<script src="static/js/jquery.min.js"></script>
<script src="static/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=utf8">  
<title>Insert title here</title>  
<script type="text/javascript">  
    function ajaxTest(){
    	var data = $("#test").serialize();
    	console.info(data);
        $.ajax({  
        type:"GET",  
        data: $("#test").serialize(),
       
        url:"${pageContext.request.contextPath}/jtest/a",  
       
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
</head>  
<body>  
    <form id="test">
    <input type="text" name="name" />
    <input type="password" name="password">
    <input type="submit" value="登录" onclick="ajaxTest();">
    </form> 
 
    <div id="result"></div>  
</body>  
</html>  