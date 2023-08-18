<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	저장된 정보 확인<p>
	아이디 : <%= session.getAttribute("id") %><br>
	취미 : <%= session.getAttribute("hobby") %><br>
	나이 : <%= session.getAttribute("age") %><br>
		메시지 : <%=request.getAttribute("message") %>
		
		주소 : <%=application.getAttribute("addr") %><br>
메시지 : <%=application.getAttribute("message") %><br>
	
</body>
</html>