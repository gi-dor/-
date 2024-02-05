<%@ page import="dto.LoginUser" %>
<%@ page import="vo.Todo" %>
<%@ page import="dao.TodoDao" %>
<%@ page import="utils.NumberUtils" %>
<%@ page import="dto.Pagination" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.List" %>
<%@ page import="utils.DateUtils" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"></script>
    <title>커뮤니티::일정 목록</title>
</head>
<body>
<jsp:include page="../include/navbar.jsp">
    <jsp:param value="todo" name="menu"/>
</jsp:include>

<%
    // 1) 로그인 체크
    LoginUser loginUser = (LoginUser) session.getAttribute("LOGIN_USER");

    if (loginUser == null) {
        response.sendRedirect("../loginform.jsp?error=deny");
        return;
    }
%>

<%
    /*
     int no;                -- 일정번호
     TodoCategory category; -- 카테고리 번호
     String title;          -- 일정 제목
     User user;             -- 작성자 정보
     String expectedDate;   -- 예정일자
     String content;        -- 일정 내용
    */

                /*
                  일정 조회하기 (페이징처리)
                  1)   todos.xml에 SQL 구문 작성

                         모든 행의 갯수를 조회하는 SQL
                       <select id="getTotalRows" resultClass="int">
                                select count(*)
                                from comm_todos
                                where todo_deleted = 'N'
                        </select>

                        현재 요청한 페이지 번호의 조회범위에 맞는 일정 목록을 조회하는 SQL
                select A.todo_no                as no,
                       A.category_no            as "category.no",
                       B.category_name          as "category.name",
                       A.todo_title             as title,
                       A.todo_expected_date     as expectedDate,
                       A.todo_status,
                       A.todo_created_Date
                from
                    (select
                            ROW_NUMBER() over (order by  todo_no desc) num,
                                    todo_no ,
                                    CATEGORY_NO,
                                    todo_title,
                                    todo_expected_date,
                                    todo_status,
                                    todo_created_date
                        from
                            COMM_TODOS
                        where
                            todo_deleted = 'N') A , COMM_TODO_CATEGORIES B

                where num between 1 and 10
                and A.category_no = B.category_no
                order by A.todo_no desc;


                   2) TodoDao 클래스에 메서드 만들기
                            2-1 ) 모든 행의 갯수를 반환하는 메서드


                            2-2 ) 조회범위를 전달받아서 범위에맞는 일정목록을 반환하는 메서드

                   3) list.jsp에 요청 처리하기
                        3-1 )  클라이언트가 요청한 페이지 조회하기
                                int currentPage = NumberUtils.toInt(request.getParameter(("page"),1);
                        3-2 )  전체 행의 갯수 조회
                                int totalRolws = todoDao.getTotalRows();
                        3-3 ) 페이징처리에 필요한 데이터를 제공
                                Pagination pagination = new Pagination(currentPage, totalPage);
                                    조회범위 : begin , end
                                    페이지 표시범위 :beginPage , endPage
                                    요청한 현재 페이지가 첫페이지 인지 , 마지막 페이지 여부  : isFirst , isEnt

                4) 요청한 페이지번호에 맞는 일정목록 조회하기 <-- begin , end 값 사용


                5) 요청한 페이지 번호에 맞는 페이지 내비게이션 출력  <-- beginPage , endPage , isFirst , isLast

                 */

// 요청 처리하기
    // 1) 클라이언트가 요청한 페이지 조회하기
    int currentPage = NumberUtils.toInt(request.getParameter("page"), 1);

    // 2) 전체 게시글 갯수 조회 CRUD 기능이 구현된 TodaoDao 객체 생성
    TodoDao todoDao = new TodoDao();
    int totalRaws = todoDao.getTotalRows();

    // 3) 페이징 처리에 필요한 데이터를 제공한 Pagination 객체 만들기
    Pagination pagination = new Pagination(currentPage, totalRaws);

    // 조회범위 : begin , end
    // 페이지 표시 범위 :beginPage , endPage
    // 요청한 현재 페이지가 첫번째페이지 , 마지막페이지 : isFirst , isEnd

// 요청한 페이지 번호에 맞는 일정 목록 조회하기
    Map<String, Object> param = new HashMap<>();
    param.put("begin", pagination.getBegin());
    param.put("end", pagination.getEnd());

    List<Todo> todoList = todoDao.getTodos(param);

%>

<div class="container">
    <div class="row">
        <div class="col-12">
            <h1>일정 목록</h1>

            <table class="table">
                <colgroup>
                    <col width="10%">
                    <col width="20%">
                    <col width="*">
                    <col width="15%">
                    <col width="15%">
                </colgroup>
                <thead>
                <tr>
                    <th>구분</th>
                    <th>처리예정일</th>
                    <th>제목</th>
                    <th>처리상태</th>
                    <th>등록일</th>
                </tr>
                </thead>
                <tbody class="table-group-divider">
                <%
                    if (todoList.isEmpty()) {
                %>
                <tr>
                    <td colspan="5" class="text-center">등록된 일정이 없습니다.</td>
                </tr>

                <%
                } else {
                    for (Todo todo : todoList) {
                %>
                <tr>
                    <td><%=todo.getCategory().getName()%>
                    </td>
                    <td><%=todo.getExpectedDate()%>
                    </td>
                    <td><%=todo.getTitle()%>
                    </td>
                    <td><%=todo.getStatus()%>
                    </td>
                    <td><%=DateUtils.toText(todo.getCreatedDate())%>
                    </td>
                </tr>
                <%
                        }
                    }
                %>


                </tbody>
            </table>

            <%
                /*
                    3-3 ) 페이징처리에 필요한 데이터를 제공
                                Pagination pagination = new Pagination(currentPage, totalPage);
                                    조회범위 : begin , end
                                    페이지 표시범위 :beginPage , endPage
                                    요청한 현재 페이지가 첫페이지 인지 , 마지막 페이지 여부  : isFirst , isEnt

                     4) 요청한 페이지번호에 맞는 일정목록 조회하기 <-- begin , end 값 사용


                     5) 요청한 페이지 번호에 맞는 페이지 내비게이션 출력  <-- beginPage , endPage , isFirst , isLast


                       페이지 내비게이션 생성하기
                         1. 시작페이지번호와 끝페이지 번호를 조회해서 해당 범위만큼 표시하기
                         2. 현재 요청한 페이지가 첫 페이지 인지 , 마지막 페이지 인지에 따라  이전 / 다음 링크를 활성화 비활성화 한다
                    */

                int beginPage = pagination.getBeginPage();
                int endPage = pagination.getEndPage();

                boolean isFirst = pagination.isFirst();
                boolean isLast = pagination.isLast();


            %>


            <nav>
                <ul class="pagination justify-content-center">
                    <%
                        if (isFirst) {
                    %>
                    <li class="page-item disabled">
                        <a class="page-link">
                            이전
                        </a>
                    </li>
                    <%
                    } else {
                    %>
                    <li class="page-item ">
                        <a class="page-link" href="list.jsp?page=<%=currentPage - 1%>">이전</a>
                    </li>
                    <%
                        }
                    %>

                    <%
                        for (int num = beginPage; num <= endPage; num++) {
                    %>
                    <li class="page-item <%=currentPage == num ? "active" : ""%>">
                        <a class="page-link" href="list.jsp?page=<%=num%>"><%=num%>
                        </a>
                    </li>

                    <%
                        }
                    %>

                    <%
                        if (isLast) {
                    %>
                    <li class="page-item disabled">
                        <a class="page-link" href="">다음</a>
                    </li>
                    <%
                    } else {
                    %>
                    <li class="page-item">
                        <a class="page-link" href="list.jsp?page=<%=currentPage + 1 %>"> 다음</a>
                    </li>
                    <%
                        }
                    %>

                </ul>
            </nav>

            <div class="text-end">
                <a class="btn btn-outline-primary" href="form.jsp">새 일정</a>
            </div>
        </div>
    </div>
</div>
</body>
</html>