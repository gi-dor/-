<%@page import="vo.Department" %>
<%@page import="java.util.List" %>
<%@page import="dao.HrDao" %>
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
<jsp:include page="../include/navbar.jsp">
    <jsp:param value="hr" name="menu"/>
</jsp:include>

<div class="container">
    <div class="row">
        <div class="col-12">
            <h2>부서 관리</h2>
            <div class="row">
                <div class="col-3 mt-3">

                    <%
                        HrDao hrDao = new HrDao();
                        List<Department> deptList = hrDao.getAllDepartments();
                    %>
                    <h3> 부서 목록 </h3>
                    <div class="list-group mt-3">

                        <%
                            for (Department dept : deptList) {
                        %>
                        <a href="aaaa.jsp" class="list-group-item list-group-item-action"
                           onclick="getEmployees(<%=dept.getId()%>, event)"><%=dept.getName() %>
                        </a>
                        <%
                            }
                        %>

                    </div>
                </div>

                <div class="col-9">
                    <h3>사원목록</h3>
                    <table class="table" id="table-employees">
                        <thead>
                        <tr>
                            <th>아이디</th>
                            <th>이름</th>
                            <th>입사일</th>
                            <th>직종</th>
                            <th>급여</th>
                        </tr>
                        </thead>
                        <tbody>

                        </tbody>
                    </table>
                </div>
            </div>

        </div>
    </div>
</div>

<script type="text/javascript">

    function getEmployees(id, event) {
        event.preventDefault();


        let prevElement = document.querySelector(".list-group-item.active");

        if (prevElement) {
            prevElement.classList.remove("active");
        }

        let element = event.target;
        element.classList.add("active");

        let xhr = new XMLHttpRequest();			// xhr 객체 생성
        xhr.onreadystatechange = function () {	// 이벤트 핸들러 등록

            if (xhr.readyState == 4 && xhr.status == 200) {
                /*
                    jsonText
                    [
                     {"id":100 , "firstName":"홍" ,"lastName":"길동",
                          "hireDate":"2023-01-20","jobId": "IT_PROG" , "salary":4000.0},

                      {"id":100 , "firstName":"홍" ,"lastName":"길동",
                          "hireDate":"2023-01-20","jobId": "IT_PROG" , "salary":4000.0},

                      {"id":100 , "firstName":"홍" ,"lastName":"길동",
                          "hireDate":"2023-01-20","jobId": "IT_PROG" , "salary":4000.0}
                    ]
                */
                let jsonText = xhr.responseText;

                // arr 에는 jsonText가 자바객체배열로 변환되어 돼입되어 버린다
                let arr = JSON.parse(jsonText);

                let htmlContent = "";

                for (let index = 0; index < arr.length; index++) {
                    // emp ->  {"id":100 , "firstNam":"홍","lastName":"길동",.....}
                    let emp = arr[index];

                    let tr = `
								<tr>
									<td>\${emp.id}</td>
									<td>\${emp.firstName} \${emp.lastName}</td>
									<td>\${emp.hireDate}</td>
									<td>\${emp.jobId}</td>
									<td>\${emp.salary}</td>
								</tr>
							`;

                    htmlContent += tr;

                }
                document.querySelector("#table-employees tbody").innerHTML = htmlContent;
            }
        };

        xhr.open("GET", "employees.jsp?deptId=" + id); 	// xhr 초기화
        xhr.send();								// 서버로 요청 보내기
    }


</script>

</body>
</html>