<%@ page import="dao.BoardDao" %>
<%@ page import="vo.Board" %>
<%@ page import="java.util.Date" %>
<%@ page import="utils.DateUtils" %>
<%@ page import="utils.StringUtils" %>
<%@ page import="dto.LoginUser" %>
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
    <div class="row mb-5">
        <div class="col-12">

            <h1 class="mt-3"> 게시글 상세 페이지</h1>

            <%
                /*
                요청 URL
                localhost.com/board/detail.jsp?no=100071&page=1

                요청 파라미터
                no=xxxx&page=xxxx
                 */

                // 1. 요청 파라미터 조회
                int no = Integer.valueOf(request.getParameter("no"));
                int currentPage = Integer.valueOf(request.getParameter("page"));

                // 2. mapper 작성 ,DAO 작성
                // 3. COMM_BOARD 테이블에 대한 CRUD 기능을 제공하는 BoardDao 객체 생성
                BoardDao boardDao = new BoardDao();

                // BoardDao 객체의 getBoardByNo(int no) 를 실행해서 게시글 상세정보를 조회한다
                Board board = boardDao.getBoardByNo(no);

                // HttpSession 객체에 "LOGIN_USER" 라는 속성명으로 저장된 인증이 완료된 사용자 정보 조회
                LoginUser loginUser = (LoginUser) session.getAttribute("LOGIN_USER");

            %>
            <table class="table">
                <colgroup>
                    <col width="15%">
                    <col width="35%">
                    <col width="15%">
                    <col width="35%">
                </colgroup>
                <tbody>
                <tr>
                    <th>번호</th>
                    <td><%=board.getNo()%>
                    </td>
                    <th>댓글 갯수</th>
                    <td><%=board.getReplyCnt()%>
                    </td>
                </tr>
                <tr>
                    <th>제목</th>
                    <td><%=board.getTitle()%>
                    </td>
                    <th>작성자</th>
                    <td><%=board.getUser().getName()%>
                    </td>
                </tr>
                <tr>
                    <th>등록일</th>
                    <td><%=DateUtils.toText(board.getCreatedDate())%>
                    </td>
                    <th>수정일</th>
                    <td><%=DateUtils.toText(board.getUpdatedDate())%>
                    </td>
                </tr>
                <tr>
                    <th>내용</th>
                    <td colspan="3"><%=StringUtils.withBr(board.getContent())%>
                    </td>
                </tr>
                </tbody>
            </table>

            <div class="d-flex justify-content-between">

                <%
                    if (loginUser == null || loginUser.getNo() != board.getUser().getNo()) {
                %>
                <div>
                    <a href="" class="btn btn-warning disabled">수정</a>
                    <a href="" class="btn btn-danger disabled">삭제</a>
                </div>
                <%
                    }
                %>

                <%
                    if (loginUser != null && loginUser.getNo() == board.getUser().getNo()) {
                %>
                <div>
                    <a href="" class="btn btn-warning ">수정</a>
                    <a href="" class="btn btn-danger ">삭제</a>
                </div>
                <%
                    }
                %>
                <a href="list.jsp?page=<%=currentPage%>" class="btn btn-dark">목록</a>
            </div>

        </div>
    </div>
    <%--    <div class="row mb-5">--%>

    <div class="row">
        <div class="col-12">
            <form class="border bg-light p-3" method="post" action="insertReply.jsp">
                <input type="hidden" name="boardNo" value="<%=no%>">
                <input type="hidden" name="page" value="<%=currentPage%>">

                <div class="row mb-3">
                    <div class="col-11">
                        <textarea rows="3" class="form-control"></textarea>
                    </div>
                    <!--- <div class="col-10"> --->

                    <div class="col-sm-1">

                        <button type="submit" class="btn btn-outline-primary"
                                <%=loginUser == null ? "disabled" : ""%>>등록
                        </button>
                    </div>

                </div>
                <!----   <div class="row mb-3"> ---->
            </form>
        </div>
    </div>


</div>
</body>
</html>