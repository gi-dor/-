<%@page import="utils.DateUtils" %>
<%@page import="java.util.List" %>
<%@page import="vo.FileBoard" %>
<%@page import="dao.FileBoardDao" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initail-scale=1">
    <title>커뮤니티:: 파일등록</title>
    <!-- CDN으로 포함시키기 -->
    <!-- 부트스트랩 CSS와 JavaScript 라이브러리  -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
    <!-- jQuery 라이브러리  -->
    <script src="jquery-3.7.1.min.js"></script>
</head>
<body>
<jsp:include page="../include/navbar.jsp">
    <jsp:param name="file" value="menu"/>
</jsp:include>

<div class="container">
    <div class="row">
        <div class="col-12">
            <h1> 파일 게시판</h1>
        </div>
    </div>

    <%
        FileBoardDao fileBoardDao = new FileBoardDao();

        // 모든 파일 게시글 정보 조회
        List<FileBoard> fileBoardList = fileBoardDao.getFileBoards();

    %>
    <table class="table">
        <colgroup>
            <col width="10%">
            <col width="*">
            <col width="15%">
            <col width="15%">
            <col width="20%">
        </colgroup>
        <thead>
        <tr>
            <th>번호</th>
            <th>제목</th>
            <th>작성자</th>
            <th>등록일</th>
            <th>파일명</th>
        </tr>
        </thead>

        <tbody>
        <%
            for (FileBoard fb : fileBoardList) {
        %>
        <tr>
            <td><%=fb.getNo() %>
            </td>
            <td><%=fb.getTitle() %>
            </td>
            <td><%=fb.getUser().getName() %>
            </td>
            <td><%=DateUtils.toText(fb.getCreatedDate()) %>
            </td>
            <td>
                <a href="download?no=<%=fb.getNo()%>"><%=fb.getRealFileName() %>
                </a>
            </td>
        </tr>

        <%
            }
        %>

        </tbody>
    </table>

    <div class="text-end">
        <a href="form.jsp" class="btn btn-dark">새 파일 등록</a>
    </div>

</div>


</body>
</html>