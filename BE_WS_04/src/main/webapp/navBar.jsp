<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 2023-08-18
  Time: 오후 4:56
  To change this template use File | Settings | File Templates.
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<script src="js/common.js"/>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
<script type="text/javascript">

    /*
    -WS_04_jQuery 로 변경
     아래의 javaScript기반 코드를  jQuery기반으로 코드로 변경하세요.

     추가 :
         모든 정보가 일치하면
         Back End 에 대한 요청과 결과를 대신하여 제공되는 response.json 를 요청하고 , 결과
         를 받아서 alert() 으로 보여준다.json 의 결과값은 제공된 json 파일을 확인한다
     */



</script>
    <nav id="navbar">
        <!-- 5개의 메뉴생성 -->
        <ul>
            <li class="nav-item logo"><img src="images/logo.jpg" alt="로고입니다." ></li>
            <li class="nav-item"> <a href="personal.html">개인</a></li>
            <li class="nav-item"><a href="busines.html">기업</a></li>
            <c:choose>
                <c:when test="${user eq null}">
                    <li class="nav-item"><a href="login.jsp">로그인</a></li>
                    <li class="nav-item"><a >회원가입</a></li>
                </c:when>
                <c:otherwise>
                    <li class="nav-item" onclick=logout("${pageContext.request.contextPath}")><a href="#" id="logout">로그아웃</a></li>
                </c:otherwise>
            </c:choose>
        </ul>
    </nav>

</body>
</html>
