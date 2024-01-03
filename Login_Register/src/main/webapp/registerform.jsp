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
<%--<%@include file="include/navbar.jsp" %>--%>
<jsp:include page="include/navbar.jsp">
    <jsp:param name="menu" value="register"/>
</jsp:include>

<div class="container">
    <div class="row">
        <h1>회원 가입</h1>

        <%
            /*
             * 요청 URL
             *  회원가입 링크를 클릭한 경우
             *          localhost/registerform.jsp
             *  회원가입 실패로 재요청한 경우
             *          localhost/registerform.jsp?fail=id
             *          localhost/registerform.jsp?fail=email
             *
             * 요청 parameter
             *      fail=xxxx
             *      정상적인 요청인 경우 parameter 값을 조회 했을 때 null이다
             *      가입 실패로 인한 재요청인 경우 fail 의 요청 파라미터값은 id 혹은 eamil이다
             */
            String fail = request.getParameter("fail");
        %>

        <%
            if ("id".equals(fail)) {
        %>
        <div class="alert alert-danger">
            <strong>회원가입 오류</strong> 이미 사용중인 아이디 입니다.
        </div>
        <%
            }
        %>

        <%
            if ("email".equals(fail)) {
        %>
        <div class="alert alert-danger">
            <strong>회원가입 오류</strong> 이미 사용중인 이메일 입니다.
        </div>
        <%
            }
        %>


        <form class="border bg-light p-3" method="post" action="register.jsp">
            <div class="form-group mb-3">
                <label class="form-label">ID</label>
                <input type="text" class="form-control" name="id"/>
            </div>
            <div class="form-group mb-3">
                <label class="form-label">PW</label>
                <input type="text" class="form-control" name="password"/>
            </div>
            <div class="form-group mb-3">
                <label class="form-label">Name</label>
                <input type="text" class="form-control" name="name"/>
            </div>
            <div class="form-group mb-3">
                <label class="form-label">Email</label>
                <input type="text" class="form-control" name="email"/>
            </div>
            <div class="form-group mb-3">
                <label class="form-label">Phone_Number</label>
                <input type="text" class="form-control" name="tel">
            </div>
            <div class="text-end">
                <a href="" class="btn btn-secondary">취소</a>
                <button type="submit" class="btn btn-primary">가입</button>
            </div>
        </form>
    </div>
</div> <!-- <div class="container"> -->
</body>
</html>