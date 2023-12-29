#<%--
  Created by IntelliJ IDEA.
  User: Han
  Date: 2023-12-27
  Time: 오전 11:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>요청 파라미터 연습</h1>

<%
// 쿼리 스트링으로 전달된 요청 파라미터값 조회하기
String value1 = request.getParameter("keyword");
String value2 = request.getParameter("sort");
String value3 = request.getParameter("page");

%>

<h3>요청 파라미터 정보</h3>
    <dl>
        <dt>검색어</dt><dd><%=value1%></dd>
        <dt>검색어</dt><dd><%=value2%></dd>
        <dt>검색어</dt><dd><%=value3%></dd>
    </dl>

</body>
</html>
