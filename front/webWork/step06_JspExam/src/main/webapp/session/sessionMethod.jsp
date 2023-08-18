<%@ page import="java.util.Arrays" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>httpSession - session</h1>
<h3>
	session.isNew() = <%= session.isNew() %><br>
	session.getId() = <%= session.getId() %><br>
	session.getMaxinactiveinterval() = <%= session.getMaxInactiveInterval() %><br>
	session.getLastAccessedTime() = <%=session.getLastAccessedTime() %><br>
	session.getCreationTime() = <%= session.getCreationTime() %><br>

<%
	session.setAttribute("id", "Na");
	session.setAttribute("hobby", Arrays.asList("등산", "수영", "낚시"));
	session.setAttribute("age", 29);
	
	request.setAttribute("message","request");
%>

	저장된 정보 확인<p>
	아이디 : <%= session.getAttribute("id") %><br>
	취미 : <%= session.getAttribute("hobby") %><br>
	나이 : <%= session.getAttribute("age") %><br>
	메시지 : <%=request.getAttribute("message") %>
	<a href="sessionGet.jsp">확인하러 가기</a>
	
</h3>
</body>
</html>