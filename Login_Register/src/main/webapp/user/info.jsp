<%@ page import="dto.LoginUser" %>
<%@ page import="vo.User" %>
<%@ page import="dao.UserDao" %>
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
<jsp:include page="../include/navbar.jsp">
    <jsp:param name="menu" value="user"/>
</jsp:include>

<div class="container">
    <div class="row">
        <div class="col-12">
            <h1 class="mt-3">사용자 상제 정보</h1>
        </div>

        <%
            /*
            로그인 정보를 활용해 사용자 정보 조회하기
                로그인이 완료된 사용자의 HttpSession 객체에는 속성이 저장되어 있다
                    - 속성 명 : "LOGIN_USER"
                    - 속성 값 : LoginUser 객체 (DTO)
             */

            // HttpSession 객체에서 속성 조회하기
            LoginUser loginUser = (LoginUser) session.getAttribute("LOGIN_USER");

            // 사용자 아이디 조회하기
            String userId = loginUser.getId();

            // COMM_USER 테이블에 대한 CRUD 기능이 구현된 UserDao 객체 생성
            UserDao userDao = new UserDao();

            // UserDao 객체의 getUserById(String userId) 메서드를 실행해 사용자 상세정보 조회
            User savedUser = userDao.getUserById(userId);

        %>
        <table class="table table-bordered">
            <tbody>
            <tr>
                <th style="width: 15%;">사용자 번호</th>
                <td style="width: 35%;"><%=savedUser.getNo()%>
                </td>
                <th style="width: 15%;">사용자 아이디</th>
                <td style="width: 35%;"><%=savedUser.getId()%>
                </td>
            </tr>
            <tr>
                <th style="width: 15%;">사용자 이름</th>
                <td style="width: 35%;"><%=savedUser.getName()%>
                </td>
                <th style="width: 15%;">탈퇴 여부</th>
                <td style="width: 35%;"><%=savedUser.getDeleted()%>
                </td>
            </tr>
            <tr>
                <th style="width: 15%;">이메일</th>
                <td style="width: 35%;"><%=savedUser.getEmail()%>
                </td>
                <th style="width: 15%;">전화 번호</th>
                <td style="width: 35%;"><%=savedUser.getTel()%>
                </td>
            </tr>
            <tr>
                <th style="width: 15%;">가입 일자</th>
                <td style="width: 35%;"><%=savedUser.getCreatedDate()%>></td>
                <th style="width: 15%;">최종 수정 일자</th>
                <td style="width: 35%;"><%=savedUser.getUpdatedDate()%>
                </td>
            </tr>
            </tbody>
        </table>


    </div>
</div>

</body>
</html>