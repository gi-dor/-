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
			<h1> 엘리먼트의 텍스트 컨텐츠 조회 / 변경하기</h1>
		
		
			<p id="e-1"> 첫번째 택</p>
			<p id ="el-3"> 두번째 텍</p>
		</div>
		
	</div>
		<script type="text/javascript">
		// 첫번째 p 일레
		let el1 = document.getElementById("e-1");
		let el2 = document.querySelector("#e-1")
		let el3 = document.querySelector("p");
		
		let el4 = document.getElementsByTadName("p");
		let el5 = document.querySelectorAll("p");
		
		let text1 = el1.textContent;
		let text2 = el2.textContent;
		let text3 = el3.textCOntste;
		let text4 = el3.textCOntste; // NodeList. 객체는 textContent 프로퍼티가 없다 indedefined
		
		console.log(text1,text2,text3,text4,text5);
		
		// 두번쨰 p 엘리먼트의 텍스트 컨텐츠르 변경
		let el6 = document.getElementById("e-2");
		let el7 = document.querySelector("#e-2");
		
		el6.texContent = "텍스트 변경하기";
		el7.texContent = "텍스트 변경하기";
		</script>
</body>
</html>