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
            <h2>이벤트에 대한 엘리먼트의 기본동작 막기</h2>
            <!--
                a 태그의 click 이벤트에 대한 기본동작
                        - click 이벤트가 발생하면 href 에 지정된 링크로 페이지를 이동시킨다
                form 태그 submit 이벤트에 대한 기본동작
                         - submit 이벤트가 발생하면 폼에 입력한 값을 서버로 제출한다
             -->

            <h3> form 태그의 submit 이벤트에 대한 기본동작 막기</h3>
            <div id="div-keyword-alert" class="alert alert-danger d-none">
                <strong>경고</strong>
            </div>

            <form method="get" action="search.jsp" onsubmit="checkForm(event)">
                <label> 검색어 : </label>
                <input type="text" name="keyword">
                <button type="submit">검색</button>
            </form>
        </div>
    </div>
</div>

<script type="text/javascript">

    /*
     클래스 속성값 조회/변경하기

    <div id="abc" class="alert alert-danger d-none"></div>

    // 1. 클래스 속성값을 변경할 엘리먼트를 조회한다
     let element = document.getElementById(id);

    // 2. 조회된 속성값을 변경할 엘리먼트를 조회한다
    let list = element.classList;
       + element.classList 프로퍼티에는 DOMTokenList 객체가 담겨있다
       + DOMTokenList 객체는 문자열을 여러개 저장하고 있는 객체다
               주요메서드
                   add("텍스트")
                   지정된 텍스트를 DOMTokenList 객체에 추가
                remove("텍스트")
                지정된 텍스트를 DOMTokenList 객체에 삭제
                   toggle("텍스트")
                   지정된 텍스트를 DOMTokenList 객체에 토글 시킨다
                   contains("텍스트")
                   DOMTokenList 객체에 텍스트가 존재하면 true , 존재하지 않으면 false 반환한다.
    */

    function checkForm(event) {

        // 1. 검색어를 입력하는 입력필드 엘리먼트를 선택한다
        let input = document.querySelector("input[name=keyword]");

        // 2. 입력필드 엘리먼트의 입력값을 조회한다
        let keyword = input.value;

        // 3. 입력 플디의 값을 체크해서 경고창을 표시하더나 폼 입력값을 서버로 제출
        if (keyword === "") {

            //4. 경고메세지 엘리먼트를 선택한다
            let div = document.getElementById("div-keyword-alert");

            // 5. class 속성값에서 "d-none" 삭제
            let list = div.classList;
            list.remove("d-none");

            // submit 이벤트가 발생했을때 form 입력값이 서버로 제출되는것을 막는다
            event.preventDefault();
        }
    }
</script>
</body>
</html>