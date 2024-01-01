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
			<h3>badge</h3>
			<div>
				<button class="btn btn-primary">
				좋아요 <span class="badge text-bg-dark">4</span>
				</button>
				<button class="btn btn-primary position-relative">
					메일함 
					<span class="position-absolute top-0 start-100 translate-middle badge rounded-pill bg-danger">
					300
					</span>
				</button>
			</div>
		</div>
		<div class="col-6">
			<h3>BADGE</h3>
			<table class="table">
				<thead>
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>작성자</th>
						<th>상태</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>1</td>
						<td>4분기 매출 요약본</td>
						<td>나타</td>
						<td><span class="badge text-bg-primary">결제 대기중</span></td>
					</tr>
					<tr>
						<td>1</td>
						<td>4분기 매출 요약본</td>
						<td>나타</td>
						<td><span class="badge text-bg-danger">결제 완료</span></td>
					</tr>
					<tr>
						<td>1</td>
						<td>4분기 매출 요약본</td>
						<td>나타</td>
						<td><span class="badge text-bg-secondary">결제 취소</span></td>
					</tr>
					<tr>
						<td>1</td>
						<td>4분기 매출 요약본</td>
						<td>나타</td>
						<td><span class="badge text-bg-success">반려</span></td>
					</tr>
				</tbody>
			</table>
		</div>
		
		
	</div>

</div>

</body>
</html>