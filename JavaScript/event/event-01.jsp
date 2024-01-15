<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang ="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content = "width=device-width, initail-scale=1">
<title>          </title>
<!-- CDN으로 포함시키기 -->
<!-- 부트스트랩 CSS와 JavaScript 라이브러리  -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
</head>
<body>
<div class="container">
	<div class="row">
		<div class="col-12">
			<h1>자바스크립트 이벤트</h1>
			
			<h3> click 이벤트</h3>
			<div class="border bg-light p-3">
			<!-- 
			인라인 이벤트 핸들러 방식
				+ 태그에 직접 이벤트 핸들러를 등록하는 방식이다
				  <태그명 이벤트이름="이벤트핸드러 함수()"> 컨텐츠 </태그명>
				+ 요즘 웹페이지에서는 잘 사용하징 않는 방식이다
				Angular/React/Vue.js 와 같은 컴포넌트 기반 개발방식에서는
				인라인 이벤트 핸들러 방식으로 이벤트를 처리한다
			
			 -->
				<button onclick="handler1()">버튼1</button>
				<button onclick="handler2()">버튼2</button>
				<button onclick="handler2()">버튼3</button>
			</div>
			<div class="border bg-dark p-3">
				<button onclick="handler1()">버튼1</button>
				<button onclick="handler2()">버튼2</button>
				<button onclick="handler2()">버튼3</button>
			</div>
			
			
		</div>
	</div>
</div>
<script type ="text/javascript">
	//  요소 이벤트 발생시 실행할 이벤트 핸들러 함수 정의하기
	function handler1() {
		// console은 Console 객체를 참조하는 참조변수다
		console.log('첫번째 이벤트 핸들러 함수가 실행됨');
	}
	
	function handler2() {
		console.log('두번째 이벤트 핸드러 함수가 실행됨');
	}
	
	
</script>
</body>
</html>