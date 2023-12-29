<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1> 요청 객체 연습</h1>


<%
String id = request.getParameter("id");
String pw = request.getParameter("pwd"); 

%>


<p> 아이디: <%=id %> </p>
<p> 비밀번호: <%=pw %></p>

</body>
</html>