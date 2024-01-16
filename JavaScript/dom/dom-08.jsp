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
            <h2> 이벤트 버블링</h2>

            <div onclick="handler1()" class="border p-3">
                첫번째 박스
                <div class="border p-3 mt-3" onclick="handler2()">
                    두번쨰 박스
                    <div class="border p-3 mt-3" onclick="handler3()">
                        세번쨰 박스
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<script type="text/javascript">

    function handler1() {
        console.log("1번박스가 클릭되었습니다");
        event.stopImmediatePropagation();
    }

    function handler2() {
        console.log("2번박스가 클릭되었습니다");
        event.stopImmediatePropagation();
    }

    function handler3() {
        console.log("3번 박스가 클릭되었습니다");
        event.stopImmediatePropagation();
    }
</script>
</body>
</html>