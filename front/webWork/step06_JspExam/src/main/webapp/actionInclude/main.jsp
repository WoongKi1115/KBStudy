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
	request.setCharacterEncoding("UTF-8");
	String addr="제주도";
	//out.println("enc = " + request.getCharacterEncoding());
%>
<jsp:include page="header.jsp"/>
<h1>메인 영역임.</h1>

<hr color="red">
<jsp:include page="footer.jsp">
	<jsp:param value="<%=addr %>" name="addr"/>
</jsp:include>
</body>
</html>