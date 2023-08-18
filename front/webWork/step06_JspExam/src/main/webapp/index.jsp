<%@ page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1> JSP 문법 TEST</h1>
<%
	// 여기는 jsp 영역
	String name = "나웅기";
	int age = 10; // 지역변수는 사용전 초기화 필수.
	List<String> list;	
%>

<h3>
이름 : <%-- name --%><br>
나이 : <%-- age --%><br>
메소드 호출 : <%= this.test() %>
</h3>

<%!
	// test가 아래에 실행됬음에도 위에 h3에서 잘 출력됨
	// 위에서부터 순서대로 실행되는것이 아님.
	String message="점심메뉴는?";
	public String test() {
		System.out.println("test() 메소드 호츨됨");
		return message + "맛있게 드세요";
	}
%>
</body>
</html>