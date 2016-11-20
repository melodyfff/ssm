<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- 加入标题图片 -->
<!-- <link rel="icon" href="./fa.ico" type="image/x-icon" /> -->
<link type="image/x-icon" rel="shortcut icon" href="./fa.ico" />
<!-- 加入bootstrap -->
<link href="static/css/bootstrap.min.css" rel="stylesheet">
<script src="static/js/jquery.min.js"></script>
<script src="static/js/bootstrap.min.js"></script>

<title>view/index</title>
</head>
<body>
	<div class="container">
		<div class="row">
			pageContext.request.contextPath:${pageContext.request.contextPath} 
			<a href="${pageContext.request.contextPath}/user/showUser">显示所有用户</a>
		</div>
		<!-- add user -->
		<div class="row">
			<form action="${pageContext.request.contextPath}/user/add" class="form-inline" method="post">
				<div class="form-group " >
					<label for="exampleInputEmail3">username</label> 
					<input type="text" class="form-control" id="username" name="userName"
						placeholder="username">
				</div>
				<div class="form-group ">
					<label for="exampleInputEmail3">password</label> 
					<input type="text" class="form-control" id="password" name="password"
						placeholder="password">
				</div>
				<input type="submit" class="btn btn-default" value="新增">
			</form>
		</div>
		<!-- update user -->
		<div class="row">
			<form action="user/update" class="form-inline" method="post">
				<div class="form-group " >
					<label for="exampleInputEmail3">username</label> 
					<input type="text" class="form-control" id="userName" name="userName"
						placeholder="username">
				</div>
				<div class="form-group ">
					<label for="exampleInputEmail3">password</label> 
					<input type="text" class="form-control" id="password" name="password"
						placeholder="password">
				</div>
				<input type="submit" class="btn btn-default" value="修改">
			</form>
		</div>
		
		<!-- delete user -->
		<div class="row">
			<form action="user/delete" class="form-inline" method="post">
				<div class="form-group " >
					<label for="exampleInputEmail3">username</label> 
					<input type="text" class="form-control" id="username" name="userName"
						placeholder="username">
				</div>

				<input type="submit" class="btn btn-default" value="删除">
			</form>
		</div>
		
		<!-- 查找用户 -->
		<div class="row">
			<form action="user/find" class="form-inline" method="post">
				<div class="form-group " >
					<label for="exampleInputEmail3">username</label> 
					<input type="text" class="form-control" id="username" name="userName"
						placeholder="username">
				</div>

				<input type="submit" class="btn btn-default" value="查找">
			</form>
		</div>	

	</div>

</body>
</html>