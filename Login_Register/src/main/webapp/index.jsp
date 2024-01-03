<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initail-scale=1">
    <title>bootstrap</title>
    <!-- CDN으로 포함시키기 -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<%---
include 지시어는 다른 JSP 페이지를 이 페이지에 포함시킨다.
 --%>

<%---

<jsp:include page="포함시킬 JSP 경로">
    + JSP 액션 태그다
    + 지정된 JSP 페이지를 이 JSP에 포함 시킨다
    + <jsp:param /> 태그를 포함할 수 있다
--%>

<jsp:include page="include/navbar.jsp">
    <jsp:param name="menu" value="home"/>
</jsp:include>

<%--<%@ include file="include/navbar.jsp" %>--%>

<div class="container">
    <div class="row">
        <div class="col-12 bg-light p-5">
            <h1> 샘플 커뮤니티 </h1>
            <p>회원가입 . 로그인 . 로그아웃 .게시판 . 댓글 . 검색 . 첨부파일 - 업로드,다운로드</p>
        </div>
    </div> <!--- <div class="row"> --->

</div> <!-- <div class="container"> -->

</body>
</html>