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

<div class="container">
    <div class="row">
        <div class="col-6"></div>
        <h3> 테이블 만들어보기</h3>
        <table class="table table-light">
            <thead>
            <tr>
                <th>번호</th>
                <th>이름</th>
                <th>학년</th>
                <th>학과</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>100</td>
                <td>헌원</td>
                <td>1학년</td>
                <td>조리학과 - 양식</td>
            </tr>
            <tr>
                <td>101</td>
                <td>여화</td>
                <td>2학년</td>
                <td>조리학과 - 일식</td>
            </tr>
            <tr>
                <td>102</td>
                <td>달기</td>
                <td>3학년</td>
                <td>조리학과 - 프랑스</td>
            </tr>
            </tbody>
        </table>
        <div class="col-6"></div>
    </div>
</div>
</body>
</html>