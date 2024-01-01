<%@page import="hr.dto.DepartDetailDto"%>
<%@page import="hr.dao.DepartmentDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>부서 상세 정보</h1>

<%
// 이 jsp를 요청하는 요청 URL
// http ://localhost/sample/hr/dept/detail.jsp?deptId=xxx

//1.요청파라미터값 조회하기
int deptId = Integer.valueOf(request.getParameter("deptId"));

//2. 부서 상세정보 조회하기
DepartmentDao dao = new DepartmentDao();
DepartDetailDto dto = dao.getDepartmentDetail(deptId);

//3. 조회된 부서정보를 응답컨텐츠에 포함시켜서 응답으로 보내기
%>



	<table border="1" style="width: 100%;">
		<tbody>
			<tr>
				<th>부서 아이디</th>
				<td><%= dto.getId() %></td>
				<th>부서 이름</th>
				<td><%= dto.getName() %></td>
			</tr>
			<tr>
				<th>관리자 아이디</th>
				<td><%= dto.getManagerId() %></td>
				<th>관리자이름</th>
				<td><%= dto.getManagerName() %></td>
			</tr>
			<tr>
				<th>도시명</th>
				<td><%= dto.getCity() %></td>
				<th>주소</th>
				<td><%= dto.getStreetAddress() %></td>
			</tr>
		</tbody>
	</table>
</body>
</html>