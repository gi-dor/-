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
		<div class="col-12">
			<h3> button </h3>
			<div class="mb-4">
				<button class="btn btn-primary">button</button>
				<button class="btn btn-secondary">button</button>
				<button class="btn btn-success">button</button>
				<button class="btn btn-danger">button</button>
				<button class="btn btn-warning">button</button>
				<button class="btn btn-info">button</button>
				<button class="btn btn-light">button</button>
				<button class="btn btn-dark">button</button>
			</div>
		
			<div class="mb-3">
				<button class="btn btn-primary btn-lg">button</button>
				<button class="btn btn-secondary btn-lg">button</button>
				<button class="btn btn-success btn-lg">button</button>
				<button class="btn btn-danger btn-lg">button</button>
				<button class="btn btn-warning btn-lg">button</button>
				<button class="btn btn-info btn-lg">button</button>
				<button class="btn btn-light btn-lg">button</button>
				<button class="btn btn-dark btn-lg">button</button>
			</div>
			
			<div class="mb-3">
				<button class="btn btn-primary btn-sm">button</button>
				<button class="btn btn-secondary btn-sm">button</button>
				<button class="btn btn-success btn-sm">button</button>
				<button class="btn btn-danger btn-sm">button</button>
				<button class="btn btn-warning btn-sm">button</button>
				<button class="btn btn-info btn-sm">button</button>
				<button class="btn btn-light btn-sm">button</button>
				<button class="btn btn-dark btn-sm">button</button>
			</div>

			<div class="mb-3">
				<a class="btn btn-secondary btn-lg" href="">주문</a>
				<a class="btn btn-success btn-lg" href="">삭제</a>
				<a class="btn btn-warning btn-lg" href="">수정</a>
				<input type ="button" class ="btn btn-danger btn-sm" value="Button">
				<input type ="reset" class ="btn btn-light btn-sm" value="Button">
				<input type ="submit" class="btn btn-info btn-sm" value="Button">
			</div>
			<div class="mb-3">
			
			<!-- --
					+ <button>과 <input type="button"> 의 비활성화
						<button disabled>Button</button>
						<input type="button" disabled/>
						
					+ <a> 링크의 비활성화
			 			<a href="" class="btn btn-primary disbled">링크</a>
			 -->
				<button class="btn btn-primary" disabled>BUTTON</button>
				<a href="" class="btn btn-primary disabled">링크</a>
			</div>
		</div>
	</div>


</div>

</body>
</html>