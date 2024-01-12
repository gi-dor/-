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
        <div class="col12">
            <h1> 파일 게시판 등록폼</h1>

            <form class="border bg-light p-3"
                  method="post"
                  action="insert"
                  enctype="multipart/form-data">
                <div class="form-group mb-3">
                    <label class="form-label">제목</label>
                    <input type="text" class="form-control" name="title">
                </div>
                <div class="form-group mb-3">
                    <label class="form-label">설명</label>
                    <textarea rows="5" class="form-control" name="description"></textarea>
                </div>
                <div class="form-group mb-3">
                    <label class="form-label">첨부파일</label>
                    <input type="file" class="form-control" name="upfile">
                </div>


                <div class="text-end">
                    <button type="submit" class="btn btn-dark">등록</button>
                    <%--                    <a href="list.jsp" class="btn btn-dark">목록</a>--%>
                </div>


            </form>
        </div>
    </div>

</div>


</body>
</html>