<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="http://libs.baidu.com/jquery/2.1.1/jquery.min.js"></script>
<title>Insert title here</title>
<script type="text/javascript">
	$(function() {
		$("#btn").click(function() {
			$.post("getPerson", {
				name : $("#name").val()
			}, function(data) {
				alert(data);
			});
		});
	});
</script>
</head>
<body>
	
	<input id="name" value="sam">
	<button id="btn">click</button>
</body>
</html>