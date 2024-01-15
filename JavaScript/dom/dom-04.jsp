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
	<div class="col-12">
		<h1>HTML 컨텐츠 조회/변경</h1>
	
		<div id="box-1" class="border bg-light p-3 mb-3">
		
			<h3>메뉴</h3>
			<ul>
				<li>커피</li>
				<li>음료</li>
				<li>탄산수</li>
			</ul>
		</div>
		
		<div id="box-2" class="border bg-light p-3 mb-3">
		</div>
		
		<div id="box-3" class="border bg-light p-3 mb-3">
		</div>
		
		
	</div>
	
</div>

<script type="text/javascript">

// 엘리먼트 HTML 컨텐츠 조회
let el1 = document.getElementById("box-1");
let content1 = el1.innerHTML;	// innerHTML 프로퍼티값 조회하기
console.log(content1);


let content2 = el1.textContent;	// textContent 프로퍼티 값 조회하기
console.log(content2);

let el2 = document.getElementById("box-2");
let content3 = `
		<h3> 영화 정보 <h3>
		<dl>
			<dt>제목</dt> <dd>ET</dd>
			<dt>감독</dt> <dd>김감독</dd>
			<dt>배우</dt> <dd>김배우</dd><dd>한배우</dd><dd>박배우</dd>
		</dl>
	`;
	
	el2.innerHTML = content3;

	let el3 = document.getElementById("box-3");
	
	let names = ['나타','헌원','황제'];
	let content4 = "<ul>";
	for(let index = 0; index < names.length; index++) {
		content4 += "<li>"+names[index]+"</li>"
	} 
	content4 += "</ul>";
	
	el3.innerHTML = content4;
	

</script>
</body>
</html>