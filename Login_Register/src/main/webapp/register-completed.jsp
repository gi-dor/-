<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initail-scale=1">
    <title>커뮤니티 ::: 회원가입 완료</title>
    <!-- CDN으로 포함시키기 -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<%--<%@include file="include/navbar.jsp" %>--%>
<jsp:include page="include/navbar.jsp">
    <jsp:param name="menu" value="register"/>
</jsp:include>

<div class="container">
    <div class="row">
        <div class="col-12">
            <div class="border p-3 bg-light">
                <h1> 회원 가입 완료</h1>
                <p> 회원 가입이 완료 되었습니다.</p>
            </div> <!--<div class="border p-3 bg-light">--->
        </div>
    </div> <!--  <div class="row">   --->
</div>
</body>
</html>