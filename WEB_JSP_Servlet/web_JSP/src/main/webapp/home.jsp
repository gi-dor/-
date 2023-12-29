<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1> 샘플 폼페이지</h1>

	<h3>요청객체 연습</h3>
	
	<ul>
	<li><a href = "req1.jsp">요청객체 연습1</a>
	

	<li> 요청 객체연습 2
		<ul>
			<li><a href="req2.jsp?keyword=java&sort=date&page=1">연습1</a> </li>
            <li><a href="req2.jsp?keyword=게임&sort=price&page=2">연습2</a> </li>
            <li><a href="req2.jsp?keyword=영화&sort=review&page=3">연습3</a> </li>
		</ul>
	</li>
	
	<br><br>
	
	<li> 요청 객체 연습3
		<form action = "req3.jsp">
			검색어 : <input type = "text" name="keyword" /><br>
			정렬기준 : <input type = "radio" name = "sort" value = "date" checked> 날짜순
					<input type = "radio" name = "sort" value = "review"> 평점순
					<input type = "radio" name = "sort" value = "read"> 조회순 <br>
			<button>검색</button>
		</form>
	</li>
	
	<br><br>
	
	<li>요청객체 연습4
		<form  method = "post" action = "req4.jsp">
			아이디 : <input type="text" name = "id"/><br>
			비밀번호 : <input type = "password" name ="pwd" /> <br>
			<button>로그인</button>
		</form>
	</li>
	
	</ul>
</body>
</html>

