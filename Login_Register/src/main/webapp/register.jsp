<%@ page import="vo.User" %>
<%@ page import="org.apache.commons.codec.digest.DigestUtils" %>
<%@ page import="dao.UserDao" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%

    /*
    요청 URL : localhost/comm/register.jsp
    요청 Parameter : id=XXX&password=XXX&name=xxxx&email=yyyy&tel=xyxyxyxy

    */

    // 1. 요청 parameter 값 조회
    String id = request.getParameter("id");
    String rawPassword = request.getParameter("password");
    String name = request.getParameter("name");
    String email = request.getParameter("email");
    String tel = request.getParameter("tel");

    // 2. COMM_USERS 테이블에 대한 CRUD 작업이 구현된 UserDao 객체생성
    UserDao userDao = new UserDao();

    // 3. 신규아이디로 사용자 정보 조회
    User savedUser = userDao.getUserById(id);

    if (savedUser != null) {
        response.sendRedirect("registerform.jsp?fail=id");
        return;
    }

    // 4. 신규 이메일로 사용자 정보 조회
    savedUser = userDao.getUserByEmail(email);
    if (savedUser != null) {
        response.sendRedirect("registerform.jsp?fail=email");
        return; // 빠른종료
    }

    // 2. 비밀번호를 암호화한다.
    String sha1Password = DigestUtils.sha256Hex(rawPassword);
    // SHA(Secure Hash Algorithm , 암호화된 해시 함수 , 단방향 암호화 알고리즘)

    /*
     해시함수 - 임의의 길이 테이더를 고정된 길이의 데이터로 매핑하는 함수
             - 햄시함수의 실행결과 값을 해시값 , 해시코드 , 해시체크섬 이라고부른다
             - 해시함수는 결과값을 가지고 원래 원본 데이터를 알아내기 힘들다는 특징이 있다.
     */

    /*
    SHA : 단방향 암호화 알고리즘
         MDS 의 취약점을 개선 / 대체하기 위해 개발된 암호화 알고리즘
         원본 데이터의 한글자 , 한비트만 바뀌어도 결과값이 완전히 다른 값이 나온다. ( 눈사태 효과 )
     */

    // 3. User 객체를 생성해서 조회된 값을 저장한다.
    User user = new User();
    user.setId(id);
    user.setPassword(sha1Password);
    user.setName(name);
    user.setEmail(email);
    user.setTel(tel);

    // 5. UserDao 객체의 insertUser(User user) 메서드를 실행
    userDao.insertUser(user);

    // 6. 브라우저에 재요청할 URL 을 응답으로 보낸다.
    response.sendRedirect("register-completed.jsp");

%>