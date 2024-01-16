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
    <!-- jQuery 라이브러리  -->
    <script src="jquery-3.7.1.min.js"></script>
</head>
<body>

<div class="container">
    <div class="row">
        <div class="col-12">

            <h2>엘리먼트 추가 / 삭제</h2>

            <div class="border bg-light p-3 mb-3">
                <div id="box-1" class="border p-3 mb-3">

                </div>
                <div>
                    <button class="btn btn-primary btn-sm" onclick="append()">엘리먼트
                        추가
                    </button>
                </div>
            </div>

            <div class="border bg-light p-3 mb-3">
                <div id="box-2" class="border p-3 mb-3">

                </div>
                <div>
                    <button class="btn btn-primary btn-sm" onclick="appendUsingInnerHTML()">엘리먼트
                        추가
                    </button>
                </div>
            </div>


            <div class="border bg-light p-3 mb-3">
                <div id="box-3" class="border p-3 mb-3">
                    <table id="table-1" class="table">
                        <thead>
                        <tr>
                            <th><input onchange="toggleCheckBox()" type="checkbox" id="checkbox-toggle"></th>
                            <th>번호</th>
                            <th>이름</th>
                            <th>이메일</th>
                            <th></th>
                        </tr>
                        </thead>
                        <tbody id="tbody-users">
                        <tr id="tr-100">
                            <td><input onchange="changeCheckbox()" type="checkbox" name="ck" value="100">
                            <td>100</td>
                            <td>한신</td>
                            <td>hansin@gmail.com</td>
                            <td>
                                <button onclick="deleteTr(100)" class="btn btn-danger btn-sm">삭제</button>
                            </td>
                        </tr>
                        <tr id="tr-101">
                            <td><input onchange="changeCheckbox()" type="checkbox" name="ck" value="101">
                            <td>101</td>
                            <td>치우</td>
                            <td>chiWoo@gmail.com</td>
                            <td>
                                <button onclick="deleteTr(101)" class="btn btn-danger btn-sm">삭제</button>
                            </td>
                        </tr>
                        <tr id="tr-102">
                            <td><input onchange="changeCheckbox()" type="checkbox" name="ck" value="102">
                            <td>102</td>
                            <td>황제</td>
                            <td>Hwang@gmail.com</td>
                            <td>
                                <button onclick="deleteTr(102)" class="btn btn-danger btn-sm">삭제</button>
                            </td>
                        </tr>

                        </tbody>
                    </table>

                </div>
                <div>
                    <button class="btn btn-primary btn-sm" onclick="deleteAll()">전체삭제</button>
                    <button class="btn btn-primary btn-sm" onclick="deleteSelectedTr()">선택삭제</button>
                </div>
            </div>


        </div>
    </div>
</div>
<script type="text/javascript">


    // DOM API를 사용해서 엘리먼트생성/속상값추가/엘리먼트추가 하기
    function append() {
        // 	1. 엘리먼트를 추가할 부모 엘리먼트를 선택
        let parent = document.getElementById("box-1");

        // 2. 새로 추가할 자식 엘리먼트를 생성한다
        let child = document.createElement("input"); // <input> 엘리먼트 (태그) 생성
        child.setAttribute("type", "ntext");			// <input type="text"> 속성 추가
        child.setAttribute("name", "username"); 		// <input type="text" name="username"> 속성 추가
        child.value = "헌원";							// input 엘리먼트의 value 프로퍼티 값 설정

        // 3. 부모 엘리먼트에 자식 엘리먼트 추가
        parent.appendChild(child);
    }


    function appendUsingInnerHTML() {

        // 1. 자식 엘리먼트를 추가할 부모 엘리먼트 선택
        let parent = document.getElementById("box-2");

        // 2. 새로 추가할 HTML 컨텐츠 생성
        let html = `
				<input type="text" name="username" value="치우">
			`;

        // 3. 부모 엘리먼트에 자식 엘리먼트를 추가한다

//		parent.innerHTML = html;
        parent.innerHTML += html;


    }


    function deleteAll() {

        // 1. 삭제할 엘리먼트 , 혹은 그 엘리먼트들을 포함하고 있는 부모 엘리먼트 선택
        let tbody = document.querySelector("#tbody-users");

        // 2. 선택한 tbody 엘리먼트의 html 컨텐츠를 전부 삭제하기
        tbody.innerHTML = "";
    }

    function deleteTr(no) {
        // 1. 삭제할 엘리먼트 선택하기
        let tr = document.getElementById("tr-" + no);

        tr.remove();
    }

    function deleteSelectedTr() {

        // 1. 체크상태인 체크 박스 전화조회
        let checkedCheckboxes = document.querySelectorAll("input[name=ck]:checked");

        // checkedCheckboxes ->

        // 2. 체크된 체크 박스의 갯수를 조회해서 갯수가 0 개ㅇ면 경고창을 표시 하고 종료한다
        if (checkedCheckboxes.length === 0) {
            alert("체크된 체크 박스가 없습니다");
            return; // 빠른종료
        }

        for (let index = 0; index < checkedCheckboxes.length; index++) {
            let checkbox = checkedCheckboxes[index];
            let no = checkbox.value;

            console.log(no);
            deleteTr(no);
        }

    }

    function toggleCheckBox() {
        // 1. 전체선택 / 전체해제 체크박스를 선택한다
        let toggleCheckbox = document.getElementById("checkbox-toggle");

        // 2. 데이터 행의 체크박스를 전부 선택
        let checkboxes = document.querySelectorAll("input[name=ck]");

        // 3. 전체선택 / 전체해제 체크박스의 체크 상태 조회
        let currentChecked = toggleCheckbox.checked;

        // 4. 데이터 행의 체크박스를 전체선택 / 전체해제 체크박스의 현재 체크상태와 같은 상태로 변경

        for (let index = 0; index < checkboxes.length; index++) {
            let checkbox = checkboxes[index];
            checkbox.checked = currentChecked;
        }
    }


    function changeCheckbox() {

        // 1. 전체선택 / 전체해제 체크박스를 선택한다
        let toggleCheckbox = document.getElementById("checkbox-toggle");

        // 2. 데이터 행의 체크박스를 전부 선택
        let checkboxes = document.querySelectorAll("input[name=ck]");

        // 3. 체크된 데이터행의 체크박스를 전부 석택
        let checkedCheckboxes = document.querySelectorAll("input[name=ck]:checked");

        // 4. 전체 체크박스의 갯수와 체크된 체크박스의 갯수를 비교해서  전체선택/전체해제 체크박스의 상태를 변경한다
        toggleCheckbox.checked = (checkboxes.length === checkedCheckboxes.length);
    }

</script>
</body>
</html>