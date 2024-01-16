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
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
</head>
<body>

<div class="container">
    <div class="row">
        <div class="col-12">
            <h2> 엘리먼트 속성 조회/변경</h2>
        </div>
        <div class="mb-3">
            <img src="../resources/images/1.jpeg" style="widows: 400px;height: 520px;">
        </div>

        <div>
            <img id="img-big" onclick="changeImage(event)" src="../resources/images/1.jpeg"
                 style="width: 64px; height: 84px;">
            <img onclick="changeImage(event)" src="../resources/images/2.jpeg" style="width: 64px; height: 84px;">
            <img onclick="changeImage(event)" src="../resources/images/3.jpeg" style="width: 64px; height: 84px;">
            <img onclick="changeImage(event)" src="../resources/images/4.jpeg" style="width: 64px; height: 84px;">
            <img onclick="changeImage(event)" src="../resources/images/5.jpeg" style="width: 64px; height: 84px;">
            <img onclick="changeImage(event)" src="../resources/images/6.jpeg" style="width: 64px; height: 84px;">
        </div>

    </div>
</div>

<script type="text/javascript">
    // 발생한 이벤트 객체 전달받기
    function changeImage(event, x, y, z) {

        // 1. 이벤트가 발생한 엘리먼트를 조회한다
        let img = event.target;

        // 2. 큰 이미지가 표시될 img 엘리먼트를 조회
        let bigImg = document.querySelector("#img-big");

        // 3. 클릭한 img의 src 속성값을 조회하기
        let attrValue = img.getAttribute("src");
    }
</script>

</body>
</html>