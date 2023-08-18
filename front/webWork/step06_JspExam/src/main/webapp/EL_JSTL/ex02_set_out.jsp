<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3> &lt;c:set> and &lt;c:out></h3>
<!-- set: 변수 선언 scope에 올 수 있는 건 page | request | session | application-->
<!-- scope은 변수 위치. scope 이 없으면 현재 위치에서 가져옴.
	: session.setAttribute()과 동일. -->
<c:set var="message" value="안녕" scope="session"/>

<!--  out : 출력 -->
<c:out value="힘들다.."/> <br>
<c:out value="${message}"/> <br>

<c:out value="<h3>곧 쉬어요<h3>"/> <br>
<c:out value="<h3>곧 쉬어요<h3>" escapeXml="true"/> <br>
<c:out value="<h3>곧 쉬어요<h3>" escapeXml="false"/> 
<br>
${"<h3>곧 쉬어요!</h3>"}


</body>
</html>