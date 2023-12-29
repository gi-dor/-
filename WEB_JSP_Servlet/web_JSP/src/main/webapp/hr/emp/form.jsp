<%@page import="hr.vo.Department"%>
<%@page import="hr.vo.Job"%>
<%@page import="java.util.List"%>
<%@page import="hr.dao.DepartmentDao"%>
<%@page import="hr.dao.JobDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>직원 등록 폼</title>
</head>
<body>
	<h1>신규 직원 등록폼</h1>
<%

	// 폼입력양식태그에 필요한 데이터를 조회하기
	// 직종정보, 부서정보를 조회해서  select박스의 option을 생성해야한다.
	
	// JOBS 테이블에 대한 CRUD작업이 구현된 JobDao 객체를 생성한다.
	// Departments 테이블에 대한 CRUD 작업이 구현된 DepartmentDao 객체를 생성한다.
	
	JobDao jobDao = new JobDao();
	DepartmentDao departmentDao = new DepartmentDao();
	
	// JobDao객체의 getAllJobs()를 실행해서 모든 직종정보를 조회한다.
	// DepartmentDao 객체의 getAllDepartments()를 실행해서 모든 부서정보를 조회한다.
	List<Job> jobList = jobDao.getAllJobs();
	List<Department> deptList = departmentDao.getAllDepartments();
	
%>
	<form method="post" action="add.jsp">   <!--  어디에 제출할지는 form에 적기 -->
		<div>
			<label>이름</label><br>
			<input type = "text" name ="firstName" > <input type="text" name= "lastName">
		</div>
		<div>
			<label>이메일</label><br>
			<input type = "text" name = "email"> 
		</div>
		<div>
			<label>전화번호</label><br>
			<select name="tel1">
				<option value = "010">010</option>
				<option value = "016">016</option>
				<option value = "017">017</option>
				<option value = "018">018</option>
				<option value = "019">019</option>
			</select>
			<input type = "text" name="tel2"> - <input type = "text" name="tel3">
		</div>
		<div>
			<label>입사일</label><br>
			<input type = "date" name = "hireDate" > 
		</div>
		<div>
			<label>직종</label><br>
			<select name="jobId">
<%
	for(Job job : jobList) {
%>
		<option value = "<%= job.getId()%>"> <%=job.getTitle() %></option>
<%
	}
%>
			
			</select>
		</div>
		<div>
			<label>급여</label><br>
			<input type = "range" name="salary" value="1000" min="1000" max="10000" > 
		</div>
		<div>
			<label>커미션</label><br>
			<input type = "radio" name ="commission" value="0.1" > 0.1
			<input type = "radio" name ="commission" value="0.15" > 0.15
			<input type = "radio" name ="commission" value="0.2" > 0.2
			<input type = "radio" name ="commission" value="0.25" checked > 0.25
			<input type = "radio" name ="commission" value="0.3" > 0.3
			<input type = "radio" name ="commission" value="0.35" > 0.35
			<input type = "radio" name ="commission" value="0.4" > 0.4
		</div>
		<div>
			<label>소속부서</label><br>
			<select name="deptId">
<%
		for(Department dept : deptList) {
%>
		<option value = "<%= dept.getId()%>"> <%=dept.getName() %></option>
<%
		}
%>			

			
			</select>
		</div>
		<button>등록</button>
	</form>
	
</body>
</html>