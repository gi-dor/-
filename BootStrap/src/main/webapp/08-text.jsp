<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang ="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content = "width=device-width, initail-scale=1">
<title>bootstrap</title>
<!-- CDN으로 포함시키기 -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<div class="container">
	<div class="row">
		<div class="col-6">
			<h3> 텍스트의 정렬 </h3>
			
			<p class="text-start">왼쪽 정렬</p> 
			<p class="text-center">가운데 정렬</p> 
			<p class="text-end">오른쪽 정렬</p> 
		</div>
		<div class="col-6">
			<h3>버튼의 정렬</h3>
			
			<div class="text-start">
				<button class="btn btn-primary">
				button
				</button>
			</div>
			<div class="text-center">
				<button class="btn btn-primary">
				button
				</button>
			</div>
			<div class="text-end">
				<button class="btn btn-primary">
				button
				</button>
			</div>	
		</div>
	</div>
	
	<div class="row">
		<div class="col-4">
			<h3>텍스트 포매팅</h3>
			<p class="text-decoration-underline">텍스트입니다</p>
			<p class="text-decoration-line-through">텍스트입니다</p>
			<p class="fw-bold">텍스트입니다</p>
		</div>
		<div class="col-4">
			<h3>일반 텍스트 사이즈</h3>
			<p class="fs-1">텍스트입다</p>
			<p class="fs-2">텍스트입다</p>
			<p class="fs-3">텍스트입다</p>
			<p class="fs-4">텍스트입다</p>
			<p class="fs-5">텍스트입다</p>
			<p class="fs-6">텍스트입다</p>
		</div>
		<div class="col-4">
			<h3>제목 텍스트 사이즈</h3>
			<h1 class="display-1">제목</h1>
			<h1 class="display-2">제목</h1>
			<h1 class="display-3">제목</h1>
			<h1 class="display-4">제목</h1>
			<h1 class="display-5">제목</h1>
			<h1 class="display-6">제목</h1>
		</div>
	
	</div>
	
</div>

</body>
</html>