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
</head>
<body>
<%@include file="../include/navbar.jsp" %>

<div class="container my-3">
    <div class="row mb-3">
        <div class="col-12">
            <h1 class="border bg-gray fs-4 p-2">신규 상품 등록</h1>
        </div>
    </div>
    <div class="row mb-3">
        <div class="col-12">
            <p> 신규 상품 정보 입력 하세요.</p>

            <form class="border bg-gray p-3" method="post" action="insert.jsp">
                <div class="form-group mb-2">
                    <label class="form-label">상품 이름</label>
                    <input type="text" class="form-control" name="name"/>
                </div>
                <div class="form-group mb-2">
                    <label class="form-label">제조사</label>
                    <input type="text" class="form-control" name="maker"/>
                </div>
                <div class="form-group mb-2">
                    <label class="form-label">입고 수량</label>
                    <input type="text" class="form-control" name="amount"/>
                </div>
                <div class="form-group mb-2">
                    <label class="form-label">상품 가격</label>
                    <input type="text" class="form-control" name="price"/>
                </div>
                <div class="form-group mb-2">
                    <label class="form-label">상품 설명</label>
                    <textarea class="form-control" rows="5" name="description"></textarea>
                </div>
                <div class="text-end mb-2">
                    <button type="submit" class="btn btn-dark btn-sm">등록</button>
                    <button type="reset" class="btn btn-dark btn-sm">취소</button>
                </div>
            </form>
        </div>
    </div>
</div>


</body>
</html>