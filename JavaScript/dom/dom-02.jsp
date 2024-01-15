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
				<h1> 엘리먼트 선택하기 </h1>
				
				<div id="box" class="p">
					<p id="intro" class="box-text">첫번째 엘리먼트</p>
					<p class="box-text">두번째 엘리먼트</p>
					<p>네번째 엘리먼트</p>
					<p>다섯번째 엘리먼트</p>
				 </div>
				 
				 <div class="border p-3 mt-3">
				 	<button onclick="handler1()">아이디로 선택</button>
				 	<button onclick="handler2()">태그명으로 선택</button>
				 	<button onclick="handler3()">클래스명으로 선택</button>
				 	<button onclick="handler4()"> css 선택자로 엘리먼트 하나  선택</button>
				 	<button onclick="handler5()"> css 선택자로 엘리먼트 여러 개 선택</button>
				 </div>
			</div>
		</div>
	</div>

<script type="text/javascript">
/*
 	엘리먼트 선택하기 
 		Element  		getElementById(id)
 		NodeList 		getElementsByTagName(tagName)
 		NodeList		getElemtntsByClassName(className)
		
		Element			querySelector(css 선택자)
		NodeList		querySelectorAll(css 선택자)
		
		* NodeList 배열과 유사한 객체다

 */

	 function handler1() {
		let el = document.getElementById("intro");
		// 선택된 엘리먼트의 스타일을 변경하기
		el.style.color = 'yellow';
	}

	function handler2() {
		let nodeList = document.getElementsByTagName("p");
		for (let index = 0; index < nodeList.length; index++) {
			let el = nodeList[index];
			// display 스타일 속성을 none 으로 지정하면 엘리먼트가 화면에서 사라진다
			// 엘리먼트가 삭제되지는 않음,
			el.style.display ='none';
		}
	}
 
	function handler3() {
		let nodeList = document.getElementsByClassName("box-text");
		
		for(let index = 0; index < nodeList.length; index++){
			let el = nodeList[index];
			// display 스타일 속성을 ""으로 지정하면 엘리먼트가 화면에 표시된다
			el.style.display = '';
		} 
	}
	
	function handler4() {
		 // 엘리먼트 하나찾기
		 let el1 = document.querySelector('#intro');
   		 let el2 = document.querySelector("p");
  		 let el3 = document.querySelector('.box-text');
		
		el1.style.color = "blue";
	    el2.style.color = "green";
	    el3.style.backgroundColor = "#eee";
	}
	
	function handler5() {
		// 엘리먼트 전부찾기
		
		// p엘리먼트 5개사 선택된다
		let nodeList1 = document.querySelectorAll("p");
		// p 엘리먼트 2개가 선택된다
		let nodeList2 = document.querySelectorAll(".box-text");
	
	for(let index = 0; index < nodeList1.length; index++) {
		let el = nodeList1[index];
		el.style.border = '1px solid red';		
		}
	
	for(let index = 0 ; index < nodeList2.length; index++) {
		let el = nodeList2[index];
		el.style.backgroundColor = '#eee';
		}
	}
	
</script>

</body>
</html>