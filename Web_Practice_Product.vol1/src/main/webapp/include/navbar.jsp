<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initail-scale=1">
    <title></title>
    <!-- CDN으로 포함시키기 -->
    <!-- 부트스트랩 CSS와 JavaScript 라이브러리  -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"></script>
    <!-- jQuery 라이브러리  -->
    <script src="jquery-3.7.1.min.js"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
</head>
<body>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
    <div class="container-fluid">
        <ul class="navbar-nav me-auto">
            <li class="nav-item"><a class="nav-link active" href="/pr/home.jsp">HTA 인사관리 게시판</a>
            </li>
        </ul>
        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="nav-link" href="/pr/home.jsp"> HOME </a>
            </li>

            <li class="nav-item"><a class="nav-link" href="/pr/product/list.jsp"> 상품 관리</a>
            </li>

            <li class="nav-item"><a class="nav-link" href=""> 사원 관리</a>
            </li>

            <li class="nav-item"><a class="nav-link" href=""> 로그인</a>
            </li>

            <li class="nav-item"><a class="nav-link" href="/logout.jsp"> 로그아웃</a>
            </li>

            <li class="nav-item"><a class="nav-link" href="/user/info.jsp"> 마이 페이지</a>
            </li>

        </ul>
    </div>
</nav>

<div class="container">

</div>


</body>
</html>