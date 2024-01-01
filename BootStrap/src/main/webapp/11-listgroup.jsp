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
		<div class="col-3">
			<ul class="list-group">
				<li class="list-group-item">국내도서</li>
				<li class="list-group-item active">외국도서</li>
				<li class="list-group-item">전자책</li>
				<li class="list-group-item">음반/티켓</li>
				<li class="list-group-item">기프트</li>
			</ul>
		</div> <!-- col-3 끝 -->
		<div class="col-3">
			<h4>링크가 포함된 리스트 그룹</h4>
			
			<div class="list-group">
				<a href="" class="list-group-item list-group-item-action">링크1</a>
				<a href="" class="list-group-item list-group-item-action">링크2</a>
				<a href="" class="list-group-item list-group-item-action">링크3</a>
				<a href="" class="list-group-item list-group-item-action">링크4</a>
				<a href="" class="list-group-item list-group-item-action">링크5</a>
			</div>
		</div> <!-- col-3 끝 -->
		
		<div class="col-4">
			<h3> 뱃지가 포함된 리스트 그룹</h3>
				<ul class="list-group">
					<li class="list-group-item d-flex justify-content-between">
						기술부
						<span class="badge bg-primary rounded-pill">11명</span>
					</li>
					<li class="list-group-item d-flex justify-content-between">
						기술부
						<span class="badge bg-primary rounded-pill">11명</span>
					</li>
					<li class="list-group-item d-flex justify-content-between align-items-center">
						기술부
						<span class="badge bg-primary rounded-pill">11명</span>
					</li>
					<li class="list-group-item d-flex justify-content-between align-items-center">
						기술부
						<span class="badge bg-primary rounded-pill">11명</span>
					</li>
					<li class="list-group-item d-flex justify-content-between align-items-center">
						기술부
						<span class="badge bg-primary rounded-pill">11명</span>
					</li>
					
				</ul>
		</div>
	</div>
</div>

</body>
</html>