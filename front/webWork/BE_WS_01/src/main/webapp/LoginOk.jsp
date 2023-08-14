<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
// jsp 영역임.(java 코드 영역)
	String id = request.getParameter("userId");
	String password = request.getParameter("userPwd");
	String name = request.getParameter("userName");
%>
<h3><%=name %> 님 로그인 중</h3>
</body>
</html>