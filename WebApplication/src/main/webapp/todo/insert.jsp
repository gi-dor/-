<%@ page import="vo.TodoCategory" %>
<%@ page import="vo.User" %>
<%@ page import="dto.LoginUser" %>
<%@ page import="vo.Todo" %>
<%@ page import="dao.TodoDao" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>


<%
    /*
               일정 등록하기
                   comm_todos 테이블에 신규일정 등록시 필요한 값 파악하기
                       + Todo_no ,  -- 시퀀스 값 nextval
                       category_no -- 폼입력
                       Todo_title, -- 폼입력
                       user_no ,  - 로그인한 사용자 번호 (세션에서 획득)
                       todo_expected_date, -- 폼입력
                       todo_content , -- 폼임력
                       + category_no , todo_status , todo_deleted , todo_updated_dat,todo_created_date

                   1. TodoDao 에 새 일정 정보를 전달받아 저장시키는 메서드 정의
                   2. form.jsp 가 insert.jsp 로 제출
                       1) 로그인 여부 체크
                           + 세션에서 로그인된 사용자 정보를 조회 , 사용자 정보가 존재하지 않으면 로그인폼 재여청할것

                       2)폼에서 제출하는 요청 파라미터 파악하기
                       categoryNo=111
                       &title=제목제목
                       &expecteddㅇ  20204-24-04

                       3) 요청 파라미터 조회하기

                       4) VO(Todo) 객체 생성하고 요청파라미터값 저장
                        로그이된 사용자 정보에서 사용자 번호를 조회하고 VO객체에 저장

                        5) DAO 객체 생성 , 일정 등록시키는 메서드 실햄
                        일정 목록을 재요청하는 URL을 응답으로 보낸다
         */

    // 2)폼에서 제출하는 요청 파라미터 파악하기
    Todo todo = new Todo();

    int category = Integer.valueOf(request.getParameter("categoryNo"));
    String title = request.getParameter("title");
    String expectedDate = request.getParameter("expectedDate");
    String content = request.getParameter("content");

    TodoCategory todoCategory = new TodoCategory();
    todoCategory.setNo(category);

    LoginUser loginUser = (LoginUser) session.getAttribute("LOGIN_USER");
    User user = new User();
    user.setNo(loginUser.getNo());

    todo.setCategory(todoCategory);
    todo.setTitle(title);
    todo.setUser(user);
    todo.setExpectedDate(expectedDate);
    todo.setContent(content);

    // DAO 객체 생성 , 일정 등록시키는 메서드 실햄
    TodoDao todoDao = new TodoDao();
    todoDao.insertTodo(todo);
    System.out.println(todoDao);

    //목록을 재요청하는 URL을 응답
    response.sendRedirect("list.jsp");


%>










