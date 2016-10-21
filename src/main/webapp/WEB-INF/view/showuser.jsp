<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<!-- 加入标题图片 -->
<!-- <link rel="icon" href="./fa.ico" type="image/x-icon" /> -->
<link type="image/x-icon" rel="shortcut icon" href="${pageContext.request.contextPath}/fa.ico" />
<!-- 加入bootstrap -->
<link href="${pageContext.request.contextPath}/static/css/bootstrap.min.css" rel="stylesheet">
<script src="${pageContext.request.contextPath}/static/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/static/js/bootstrap.min.js"></script>

<title>显示所有用户</title>

<body>
<div class="container">
 <div class="row">
 <div class="col-md-6">
 <p>第一种没有dao的impl的写法,直接用接口的写法</p>
        <table class="table table-hover">
            <tr>
            	<th>id</th>
                <th>用户名</th>
                <th>密码</th>
            </tr>
            <c:forEach items="${users}" var="user">
                <tr>
                	<td>${user.id}</td>
                    <td>${user.username }</td>
                    <td>${user.password }</td>
                </tr>
            </c:forEach>
        </table>
 </div>
 <div class="col-md-6">
	<p>第二种有dao的impl的写法</p>
        <table class="table table-hover">
            <tr>
            	<th>id</th>
                <th>用户名</th>
                <th>密码</th>
            </tr>
            <c:forEach items="${users2}" var="user1">
                <tr>
                	<td>${user1.id}</td>
                    <td>${user1.username }</td>
                    <td>${user1.password }</td>
                </tr>
            </c:forEach>
        </table>
</div>
</div> 
<div class="row">
<p><p>${find_user.id}</p></p>
<p>${find_user.username}</p>
<p>${find_user.password}</p>
</div>
</div>
    </body>
</html>