<%--
  Created by IntelliJ IDEA.
  User: Han
  Date: 2023-12-27
  Time: 오전 11:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>샘플 홈페이지</h1>
<h3>요청 객체 연습</h3>

<ul>
    <li><a href="req1.jsp">요청 객체 연습1</a> </li>
    <li>요청객체 연습2
        <ul>
            <li><a href="req2.jsp?keyword=java&sort=date&page=1">연습1</a> </li>
            <li><a href="req2.jsp?keyword=게임&sort=price&page=2">연습2</a> </li>
            <li><a href="req2.jsp?keyword=영화&sort=review&page=3">연습3</a> </li>
        </ul>

    </li>
</ul>
</body>
</html>
