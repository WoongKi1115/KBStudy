<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h1>O.jsp 입니다.</h1>

<%
// jsp 영역임.(java 코드 영역)
	String name = request.getParameter("name");
	String blood = request.getParameter("blood");
	out.println("<h3>이름 : " + name + "</h3>");
	out.println("<h3>혈액형 : " + blood + "</h3>");
%>
<h4>
<!-- jsp 영역에서 선언한 변수를 가져다 쓸 수 있음. -->
	<%= name %>님 혈액형은 <%= blood %>이고 성격이 좋습니다.
</h4>

</body>
</html>