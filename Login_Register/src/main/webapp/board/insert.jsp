<%@ page import="dto.LoginUser" %>
<%@ page import="vo.Board" %>
<%@ page import="vo.User" %>
<%@ page import="dao.BoardDao" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%
    LoginUser loginUser = (LoginUser) session.getAttribute("LOGIN_USER");
    if (loginUser == null) {
        response.sendRedirect("../loginform.jsp?error=deny");
        return;
    }

    /*
    요청 URL
        localhost/board/insert.jsp
    요청 파라미터
        title=xxxx&contetnt=xxxx
     */
    // 1. 요청 파라미터값 조회
    String title = request.getParameter("title");
    String content = request.getParameter("content");

    // 2. 게시글 정보를 저장할 Board 객체를 생성
    Board board = new Board();

    // 3.생성된 Board 객체에 조회된 요청 파라미터 값 저장
    board.setTitle(title);
    board.setContent(content);

    // 4. 작서자 정보를 조회해서 Board객체에 저장한다

    User user = new User();
    user.setNo(loginUser.getNo());

    board.setUser(user);

    // 5. COMM_BOARDS 테이블에 대한 CRUD 작업이 구현된 BoardDao 객체 생성
    BoardDao boardDao = new BoardDao();

    // 6. BoardDao 객체의 insertBoard(Board board) 메서드를 실행시켜 테이블에 저장
    boardDao.insertBoard(board);

    // 7. 게시글 목록을 요청하는 list.jsp 를 재요청하게 하는 응답을 보낸다
    response.sendRedirect("list.jsp");
%>