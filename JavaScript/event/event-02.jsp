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
		<div class=col-12>
			<h1> mouse Event - mouseenter/mouseleave 이벤트</h1>
			
			<div class="border bg-light p-3"
				onmouseenter="handler1()"
				onmouseleave="handler2()">
				부모
				<div class="border bg-light p-3">자식</div>
			</div>
			
			<h3>mouseover와 mouseout</h3>
			<div class="border bg-light p-3 my-3"
				onmouseover="handler1()"
				onmouseout="handler2()">
				부모
				<div class="border bg-light p-3">자식</div>
			</div>
		</div>
	</div>
</div>
<script type="text/javascript">
	function handler1(){
		console.log("요소 안으로 들어왔다");
	}
	
	function handler2(){
		console.log("요소 밖으로 나갔다.")
	}
</script>
</body>
</html>