<%@ page import="dao.UserDao" %>
<%@ page import="vo.User" %>
<%@ page import="org.apache.commons.codec.digest.DigestUtils" %>
<%@ page import="dto.LoginUser" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%
    /*
               요청 URL
                   localhost/login.jsp
               요청 파라미터
                   요청메세지의 바디 - id=xxxx&password=xxxxx
     */


    /*
     로그인 처리
    1. 요청 파라미터로 전달받은 id와 password 조회
    2. id로 사용자 정보 조회
        2-1. 사용자 정보가 존재하지 않는다 - > 회원가입 하지 않음 loginform.jsp?error=fail
        2-2. 사용자 정보가 존재하지만 탈퇴한 사원이다  - loginform.jsp?error=deleted
        2-3. 사용자 정보는 존재하지만 비밀번호가 일치하지 않는다 - loginform.jsp?error=fail
    3. 사용자 정보가 존재하고 비밀번호도 일치하기 때문에 로그인 처리한다
     */

    // 1. 요청 파라미터 값 조회 id , password
    String id = request.getParameter("id");
    String rawPassword = request.getParameter("password");

    // 2. COMM_USERS 테이블에 대한 CRUD 기능이 구현된 UserDao 객체 생성
    UserDao userDao = new UserDao();

    // 3. UserDao 객체의 getUserById(String id)를 실행해 아이디에 해당하는 사용자 정보 조회
    User savedUser = userDao.getUserById(id);

    // 4. 아이디에 해당하는 사용자 정보가 존재 하는지 체크
    if (savedUser == null) {
        response.sendRedirect("loginform.jsp?error=fail");
        return;
    }

    // 5. 탈퇴한 사용자인지 체크
    if ("Y".equals(savedUser.getDeleted())) {
        response.sendRedirect("loginform.jsp?error=deleted");
        return;
    }

    // 6. 사용자 정보는 존재하지만 비밀번호가 일치하는지
    String shaPassword = DigestUtils.sha256Hex(rawPassword);
    System.out.println("비밀번호 확인");
    System.out.println(shaPassword);
    if (!savedUser.getPassword().equals(shaPassword)) { // 비밀번호가 다를 때
        response.sendRedirect("loginform.jsp?error=fail");
        return;
    }

    // 7. 사용자 인증 작업이 완료된 사용자 정보를 세션객체에 속성으로 저장
    LoginUser loginUser = new LoginUser();
    loginUser.setName(savedUser.getName());
    loginUser.setNo(savedUser.getNo());
    loginUser.setId(savedUser.getId());

    session.setAttribute("LOGIN_USER", loginUser);

    // 8. index.jsp 를 재요청하는 응답을 보낸다
    response.sendRedirect("index.jsp");
%>