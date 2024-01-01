<%@page import="hr.dao.JobDao"%>
<%@page import="hr.vo.Job"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

	<%
		// 요청 URL : http://localhost/sample/hr/job.add.jsp
		// 요청 파라미터(요청 메시지의 바디부)
		// 		id=xxx&title=xxx&minSalary=xxx&maxSalary=xxx
		
		// 요청파라미터값 조회하기
		String id = request.getParameter("id");	
		String title = request.getParameter("title");	
		int minSalary = Integer.valueOf(request.getParameter("minSalary"));
		int maxSalary = Integer.valueOf(request.getParameter("maxSalary"));	
	
		// Job객체를 생성해서 조회된 요청파라미터값을 저장하기
		Job job = new Job();
		job.setId(id);
		job.setTitle(title);
		job.setMinSalary(minSalary);
		job.setMaxSalary(maxSalary);
		
		
		// Jobs 테이블에 대한  CRUD 작업이 구현된 JobDao객체를 생성한다.
		JobDao jobDao = new JobDao();
		
		// 신규 직종정보를 전달받아서 데이터베이스에 저장시키는 insertJob(Job job)을 실행시킨다.
		jobDao.insertJob(job);
		
		// 모든 직종목록을 확인할 수 있는 list.jsp 를 재요청하게 하는 응답을 보낸다.(=서버가 클라이언트에게 새로운 url("list.jsp")로 이동하라는 지시를 보낸다)
		response.sendRedirect("list.jsp"); 
		
	%>

	<!-- html 태그를 지워도 되는 이유
	리다이렉션은 클라이언트에게 새로운 URL로 이동하라는 요청을 보내는 것이므로, 
	클라이언트에게 전송되는 것은 HTTP 헤더이며, 이에 대한 별도의 HTML 코드는 필요하지 않다.
	
	 
	리다이렉트 :  클라이언트의 요청을 받은 서버가 클라이언트에게 새로운 URL로 이동하라는 지시를 주는 것
			  리다이렉트가 발생하면 클라이언트는 새로운 URL로 다시 요청을 보낸다. 
			  이후에는 해당 페이지의 내용이 클라이언트에게 보여지므로 현재 페이지에 더 이상의 렌더링이 필요하지 않다.
	
	렌더링 : 웹 페이지를 생성하고 화면에 표시하는 과정
		   서버 측에서 클라이언트 측으로 HTML, CSS, JavaScript 등의 웹 페이지 구성 요소를 생성하여 보내고, 클라이언트에서는 이를 해석하여 화면에 표시하는것
			  
	  -->
	