<%@ page language="java" contentType="text/html; charset=UTF-8"  
    pageEncoding="UTF-8"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">  
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>josn传值测试</title>
<script src="static/js/jquery.min.js"></script>
<script type="text/javascript">
  function savepro(){
    var saveData = {"username":"josn","password":"josn"}; //发送给服务器的JSON  
    console.log("要传输的对象---->"+saveData);
    $.ajax({
      type : "POST",
      url : "${pageContext.request.contextPath}/testjosn/update",
      data:JSON.stringify(saveData),//stringify()用于从一个对象解析出字符串
      contentType:"application/json",  //发送至服务器的类型
      dataType : "json",     //预期服务器返回类型
      success: function(data){
        alert(data.message);
        console.log("返回的data----->"+data);
        console.log(data.user.username);
      }

    })
  }
</script>
</head>

<body>
<div>
  <input type="button" value="保存" onclick="savepro()"/>
</div>
</body>
</html>