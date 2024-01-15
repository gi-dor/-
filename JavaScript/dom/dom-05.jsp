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
    <div class="col-12">
        <h2> 폼 요소 </h2>

        <form>
            <div class="form-group">
                <label class="form-label">카테고리</label>
                <select class="form-select" name="catNo">
                    <option value="100">가구</option>
                    <option value="101">가전</option>
                    <option value="102" selected>디지털</option>
                    <option value="103">주방</option>
                    <option value="104">기타</option>
                </select>
            </div>

            <div class="form-group">
                <label class="form-label">이름</label>
                <input type="text" class="form-control" name="username">
            </div>

            <div class="form-group">
                <label class="form-label"> 닉네임 </label>
                <input type="text" class="form-control" name="buddy" value="버디">
            </div>

            <div class="form-group">
                <label class="form-label"> 메모 </label>
                <textarea class="form-control" rows="4" name="memo">부디 오래 걸리지 않게 , cause i'm a ribbon </textarea>
            </div>


        </form>
    </div>
</div>

<script type="text/javascript">

    /*
   폼 입력양식 (intput ,select , textarea)의 값 조회하기
   let x = element.value;
    * x 에 해당 엘리먼트의 값이 대입된다

    폼입력양식 (input,select , textarea) 의 값 변경하기
        element.value = '값';

    */

    // selectbox의 선택된 옵션값 조회하기

    // document.getElementById(); // select 내에 id가 존재하지 않음
    // document.getElementsByTagName(); // NodeList를 반환함 여러개 찾을때 사용
    // document.getElementsByClassName();
    let el1 = document.querySelector("select[name='catNo']");
    let value1 = el1.value;
    console.log("카테고리 번호 : " + value1)
    // document.querySelectorAll();


    // selectbox 의 선택된 값 변경
    el1.value = "104";


    // 이름 입력필드 (input)의 값을 변경하기
    let el2 = document.querySelector("input[name='username']");
    el2.value = "TestName";

    // 닉네임 입력 필드의 값 조회
    let el3 = document.querySelector("input[name='buddy']");
    let value3 = el3.value;
    console.log(value3);

    let el4 = document.querySelector("textarea[name='memo']");
</script>
</body>
</html>