<%@ page import="dto.LoginUser" %>
<%@ page import="vo.Board" %>
<%@ page import="dao.BoardDao" %>
<%@ page import="vo.Reply" %>
<%@ page import="dao.ReplyDao" %>
<%@ page import="vo.User" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<%
    LoginUser loginUser = (LoginUser) session.getAttribute("LOGIN_USER");

    if (loginUser == null) {
        response.sendRedirect("/loginform.jsp?error=deny");
        return;
    }

    /*
    요청 URL
        localhost/board/insertReply.jsp

    요청 파라미터
        no=xxxx&content=XXXXX
            요청 메세지의 바디부에 포함되어 있다.
     */

    // 1. 요청 메세지 조회
    int boardNo = Integer.valueOf(request.getParameter("boardNo"));
    int currentPage = Integer.valueOf(request.getParameter("page"));
    String content = request.getParameter("content");

    // 2. DTO 작성 - Mapper 작성 - DAO 작성  - insertReply.jsp
    // 2-1 객체를 생성해서 요청파라미터 정보 저장

    Reply reply = new Reply();
    reply.setContent(content);

    Board board = new Board();
    board.setNo(boardNo);
    reply.setBoard(board);

    User user = new User();
    user.setNo(loginUser.getNo());
    reply.setUser(user);

    // 3. BoardDao 와 ReplyDao 객체생성

    ReplyDao replyDao = new ReplyDao();
    BoardDao boardDao = new BoardDao();

    // 4. ReplyDao의 insertReply(Reply reply) 실행해서 댓글 등록하기
    replyDao.insertReply(reply);

    // 5. 게시글의 댓글 갯수 증가시키기
    // 6. BoardDao의 getBoardByNo(int no)를 실행해서 게시글 정보 조회하기
    Board savedBoard = boardDao.getBoardByNo(boardNo);

    // 7.조회된 게시글 정보의 댓글 갯수 증가
    savedBoard.setReplyCnt(savedBoard.getReplyCnt() + 1);

    // 8.BoardDao의 updatedBoard(Board board)를 실행 시켜서 변경된 내용 반영시키기
    boardDao.updateBoard(savedBoard);

    // 9. 게시글 상세정보를 재요청하는 URL을 응답으로 보내기
    response.sendRedirect("detail.jsp?no=" + boardNo + "&page=" + currentPage);
%>

