<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>ServletContext = application</h2>
<h3>
application.getRealPath("/") = <%=application.getRealPath("/") %><br>
application.getContextPath() = <%=application.getContextPath() %><br>

<%
	//application 영역에 정보를 저장
	application.setAttribute("addr", "서울시 선릉");
	application.setAttribute("message", "application영역 메시지");
%>

주소 : <%=application.getAttribute("addr") %><br>
메시지 : <%=application.getAttribute("message") %><br>
<!-- 상대적 위치로 찾아오기 -->>
<a href="../session/sessionGet.jsp">확인하러 가기1</a> <br>
<!-- url 결로로 찾아오기. -->
<a href="<%=application.getContextPath() %>/session/sessionGet.jsp">확인하러 가기2</a>
</h3>
</body>
</html>