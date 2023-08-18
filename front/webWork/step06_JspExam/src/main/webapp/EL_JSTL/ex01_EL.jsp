<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Express Language = EL (출력)</h1>
<h3>

\${5} = ${5} <br>
\${5*2} = ${5*2} <br>
\${5 gt 2} = ${5 gt 2} <br>
\${5 eq 5} = ${5 eq 5} <br>
\${5 == 5 && 3 < 5} = ${5 == 5 && 3 < 5} <br>

\${ 5>3 ? "크다" : "작다"} = ${ 5>3 ? "크다" : "작다"} <br>

<!-- 만약
	http://localhost:9000/test/EL_JSTL/ex01_EL.jsp?id=jang
 -->
 ${param.id}/<%=request.getParameter("id") %><br>


 <!-- 만약 id가 있으면 id 출력하고 없으면 guest라고 출력. -->
 <!-- 단순 +만 쓰면 에러. +=을 써야 님이 붙어짐. -->
 ${param.id==null ? "Guest" : param.id += "님" } <br>
 ${empty param.id ? "Guest" : param.id.concat("님") } <br>
 
 ${not empty param.id ? param.id : "Guest" } <br>
 
 <%
	//scope 영역에 값을 저장해보기
	request.setAttribute("id", "8253jang");
 	
 session.setAttribute("addr", "서울시 강남구");
 session.setAttribute("message", "session에 있는 데이터");
 
 application.setAttribute("message", "application에 있는 데이터");
 application.setAttribute("hobbys", new String [] {"등산", "수영"});
%> 
<h4>Scope 영역에 출력 (pageContext &lt; request &lt; session &lt; application)</h4>
아이디 : <%=request.getAttribute("id") %> / ${requestScope.id} / ${id} <br>
주소 : <%= session.getAttribute("addr") %> / ${sessionScope.addr} / ${addr} <br>
메시지(session) : <%= session.getAttribute("message") %> / ${sessionScope.message}/ ${message} <br>
메시지(application) : <%= application.getAttribute("message") %> / ${applicationScope.message} / ${message} <br>
취미 : <%=application.getAttribute("hobbys") %> / ${applicationScope.hobbys} / ${hobbys}
</h3>

</body>
</html>