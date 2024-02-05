<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%
    /*
            요청 URL
                localhost/logout.jsp
     */

    /*
        로그아웃시키지
        - 요청 메시지로 전달받은 세션아이디에 해당하는 세션객체를 찾아서 그 세션객체를 무효화시킨다 (폐기)
        - HttpSession 객체를 폐기시키면 HttpSession 객체에 저장되었던 모든 속성도 삭제된다
            즉 login.jsp에서 인증된 사용자 정보를 유지 시키기 위해 HttpSession 객체에 "LOGIN_USER"라는 속성명을
            저장한 속성 (이름: "LOGIN_USER" , 값: LoginUser 객체)도 삭제된다.
     */

    // HttpSession 객체를 무효화 시킨다.
    session.invalidate();

    // index.jsp를 재요청하는 응답을 보낸다
    response.sendRedirect("index.jsp");
%>