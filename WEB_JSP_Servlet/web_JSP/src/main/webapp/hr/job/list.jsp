
<%@page import="hr.vo.Job"%>
<%@page import="hr.dao.JobDao"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>직종 목록</h1>
	<%

	// 요청 URL : http://localhost/sample/hr/job/list.jsp

	//JOBS 테이블에 대한 CRUD기능이 구현된 JOBDao객체를 생성한다.
	JobDao dao = new JobDao();

	// 모든 직종 정보를 반환하는 getAllJObs()메서드를 실행한다.
	
	List<Job> jobs = dao.getAllJobs();
%>

	<ul>
		<%
	for (Job job : jobs) {
%>
		<li><a href="detail.jsp?id=<%=job.getId() %>"><%=job.getTitle() %></a></li>
		<%
	}
%>
	</ul>
	
	<div>
		<a href = "form.jsp"> 신규 직종 등록 </a>
	</div>
</body>
</html>