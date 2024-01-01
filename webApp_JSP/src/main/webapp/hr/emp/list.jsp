<%@page import="hr.dto.EmpListDto"%>
<%@page import="java.util.List"%>
<%@page import="hr.dao.EmployeeDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>직원 목록</title>
	<style type = "text/css">
	a:link, a:visited{
			color : black;
	}
	
	a:link.active, a:visited.active {
		font_weight : bold;
		color: red;
	}
	</style>



</head>
<body>
	<h1>직원 목록</h1>
	
	<div>
		<a href="form.jsp">신규 직원 등록</a> 
		<!--  
		기준주소가 http://localhost/sample/hr/emp/ 가 있기때문에
		링크의 상대주소 : <a href="form.jsp> 만 적으면 된다. 
		 -->
	</div>

	
<%

	//요청 URL : http://localhost/sample/hr/emp/list.jsp?page=1
	
	// 한 화면에 표시할 데이터행의 개수를 결정한다.
	final int ROWS = 10;

	// 요청파라미터 값을 조회한다.
	int currentPage = Integer.valueOf(request.getParameter("page"));

	// 페이지번호에 맞는 조회범위 계산하기
	int start = (currentPage-1)*ROWS +1;
	int end = currentPage*ROWS;
	
	// EMPLOYEES테이블에 대한 CRUD작업이 구현된 EmployeeDao 객체를 생성한다.
	EmployeeDao employeeDao = new EmployeeDao();

	// 모든 직원정보를 조회하는 getEmployees() 메서드를 실행한다.
	List<EmpListDto> dtoList = employeeDao.getEmployees(start, end);
%>
	<table border="1" style="width: 100%;">
		<thead>
			<tr>
				<th>아이디</th>
				<th>이름</th>
				<th>전화번호</th>
				<th>입사일</th>
				<th>직종아이디</th>
				<th>소속부서명</th>
			</tr>
		</thead>
		<tbody>
<%
	for(EmpListDto dto : dtoList) {
%>
		
			<tr>
				<td><%=dto.getId() %></td>
				<td><%=dto.getFirstName() %></td>
				<td><%=dto.getPhoneNumber() %></td>
				<td><%=dto.getHireDate() %></td>
				<td><%=dto.getJobId() %></td>
				<td><%=dto.getDepartmentName() %></td>
				<td><a href="detail.jsp?id=100">상세보기</a></td>
			</tr>
<%
	}
%>
		</tbody>
	</table>

<%
	// 한 화면에 표시할 페이지 갯수 결정
	final int PAGES = 5;

	// 현재 요청한 페이지가 포함된 블럭 번호 계산
	int currentBlock = (int) Math.ceil((double)currentPage / PAGES);


	// 총 직원수를 조회하기
	int totalRows = employeeDao.getTotalRows();

	// ceil값 :페이지 수를 계산할 때, 일반적으로는 전체 항목 수를 한 페이지 당 표시할 항목 수로 나눈 뒤 올림(ceil)을 사용
	// 소수점 아래에 항목이 있는 경우 다음 페이지로 넘어가야 함을 의미
	// 총 페이지 갯수 계산
	int totalPages = (int) Math.ceil((double) totalRows / PAGES);

	// 총 블럭 갯수 계산
	int totalBlocks = (int)Math.ceil((double)totalPages / PAGES);

	// 화면에 표시할 페이지 범위 계산
	int beginPage = (currentBlock - 1) * PAGES +1;
	int endPages = ( currentBlock == totalBlocks ? totalPages : currentBlock * PAGES);

%>
 <p>
<%
	if(currentPage > 1) {
%>
	<a href="list.jsp?page=<%=currentPage - 1%>"> 이전 </a>
<%
	} else {
%>
	<span> 이전 </span>
<%
	}
%>


<%
	for (int num = beginPage; num <= endPages; num++) {
%>
  	<a href="list.jsp?page=<%= num %>" 
  	 class="<%= currentPage== num ? "active" : "" %>"><%=num %></a>
<%
  	}
%>

	 <%
	 	if(currentPage < totalPages ) {
	 %>
			 <a href="list.jsp?page=<%=currentPage + 1%>"> 다음 </a>
	<%
		} else {
	%>
		<span> 다음 </span>
	 <%
		 }
	 %>

	</p>

</body>
</html>