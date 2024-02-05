<%@ page import="dto.LoginUser" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%
    /*
         세션으로 로그인 여부 체크해서 로그인 되지 않은 사용자가 이 페이지를 이용할수 없게 한다
         HttpSession 에 저장된 로그인된 사용자 정보를 조회한다
         로그인된 사용자 정보가 존재하지 않으면 빠른종료
             localhost/loginform.jsp?error=deny

             * 상대 경로 결정하기
             현재 localhost/board/form.jsp
             기준 localhost/board/

             목적 URL localhost/loginform.jsp
             상대경로   ../loginform.jsp

     */
    LoginUser loginUser = (LoginUser) session.getAttribute("LOGIN_USER");
    if (loginUser == null) {
        response.sendRedirect("../loginform.jsp?error=deny");
        return;
    }
%>
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
    <jsp:param name="menu" value="board"/>
</jsp:include>

<div class="container">
    <div class="row">
        <div class="col-12">
            <h1 class="mt-3">게시글 등록</h1>

            <form class="border- bg-light p-3" method="post" action="insert.jsp">
                <div class="form-group mb-3">
                    <label class="form-label">제목</label>
                    <input type="text" class="form-control" name="title"/>
                </div>
                <div class="form-group mb-3">
                    <label class="form-label">내용</label>
                    <textarea rows="10" class="form-control" name="content"></textarea>
                </div>
                <div class="text-end">
                    <a class="btn btn-secondary" href="list.jsp">취소</a>
                    <button type="submit" class="btn btn-primary">등록</button>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>