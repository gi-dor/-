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
		<h1> 폼 이벤트</h1>
			<form class="border bg-light p-3" method="post" action=""
			onsubmit="handler3()">
				<div class="form-group mb-3">
				<label class="form-label" onchange="handler1()">카테고리</label>
				<select class="form-select" name="cat" onchange="handler1()">
					<option value="1000">가구</option>
					<option value="1001">전자</option>
					<option value="1002">디지털</option>
					<option value="1003">주방</option>
				</select>
				</div>
				
				<div class="form-group mb-3">
					<label class="form-label">상태</label>
						<div class="form-check">
							<input type="radio" class="form-check-input" name="status" value="1000" onchange="handler2()">
							<label class="form-check-label">입고예정</label>
						</div>
						<div class="form-check">
							<input type="radio" class="form-check-input" name="status" value="1001" onchange="handler2()">
							<label class="form-check-label">판매중</label>
						</div>
						<div class="form-check">
							<input type="radio" class="form-check-input" name="status" value="1002" onchange="handler2()">
							<label class="form-check-label">재고 없음</label>
						</div>
				</div>
				<div class="text-end">
				<input type="submit" value="제출" class="btn btn-dark">
				<button type="submit" class="btn btn-dark">제출</button>
				<button class="btn btn-dark">제출</button>
				<button type="button" class="btn btn-dark">제출이안됨</button>
				</div>
				
			</form>
	</div>
</div>
<script type="text/javascript">
	function handler1() {
		console.log("카테고리 변경됨")
	}
	
	function handler2() {
		console.log("상태가 변경됨")
	}
	
	function handler3() {
		console.log("폼에서 submit 이벤트가 발생함")
	}
</script>

</body>
</html>