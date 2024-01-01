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

<!-- .card
			+ 카드는 유연하고 확장이 가능한 컨테이너다
			+ Header , Body, Footer를 포함한다
			+ 카드의 Body 는 다양한 컨텐츠를 포함할 수 있다.
			+ 
	 -->
<div class="container">
	<div class="row">
		<div class="col-3">
			<div class="card">
				<img src="resources/img/냉동방어.jpg"  class="card-img-top" alt="일본산">
			<div class="card-body">
				<h5 class="card-title">일본산 냉동방어</h5>
				<p class="card-text">2.3kg  5.07pound</p>
				<div>
					<span class="badge text-bg-primary">무료배송</span>
					<span class="badge text-bg-success">포인트 적립</span>
				</div>
				<a href="" class="btn btn-secondary">상세정보</a>
			</div>
			</div>
		</div>
		<div class="col-3">
			<div class="card">
				<div class="card-body">
						Tmax 그룹을 소개드리자면 총 11개의 계열사로 구성되어 있으며 Super APP을 만들기위해 노력하고 있으며 내년에 서비스 런칭 예정입니다. 
						또한 국내 유일한 AWS 플래티넘 스폰서로 CLAS란 서비스로 글로벌 시장 진출을 앞두고 있습니다.
						2023년 AWS re:Invent 에서 발표한 영상 링크 공유드립니다😊
				</div>
			</div>
		</div>
		
		<div class="col-6">
			<div class="card">
				<div class="card-header">
					교육 내용
				</div>
				<div class="card-body">
					<h5 class="card-title">2023년 4분기 교육내용</h5>
					<p class="card-text">
						국내 유일한 AWS 플래티넘 스폰서로 CLAS란 서비스로 글로벌 시장 진출을 앞두고 있습니다.<br>
						총 11개의 계열사로 구성되어 있으며 Super APP을 만들기위해 노력하고 있으며 내년에 서비스 런칭 예정입니다. <br>
						2023년 AWS re:Invent 에서 발표한 영상 링크 공유드립니다😊
					</p>			
				</div>
				
				<div class="card-footer">
					<a href="" class="btn btn-outline-primary btn-sm">추가정보</a>
				</div>
			</div>
		</div>
		
		<div class="row mt-3">
		<div class="col-6">
			<div class="card">
				<div class ="card-header">직원 현황표</div>
					<table class="table">
						<thead>
							<tr>
								<th>번호</th>
								<th>이름</th>
								<th>연락처</th>
								<th>이메일</th>
								<th>부서명</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>1</td>
								<td>헌원</td>
								<td>010-1234-9876</td>
								<td>gjsdnjs@gmail.com</td>
								<td>구매부</td>
							</tr>
							<tr>
								<td>1</td>
								<td>헌원</td>
								<td>010-1234-9876</td>
								<td>gjsdnjs@gmail.com</td>
								<td>구매부</td>
							</tr>
							<tr>
								<td>1</td>
								<td>헌원</td>
								<td>010-1234-9876</td>
								<td>gjsdnjs@gmail.com</td>
								<td>구매부</td>
							</tr>
							<tr>
								<td>1</td>
								<td>헌원</td>
								<td>010-1234-9876</td>
								<td>gjsdnjs@gmail.com</td>
								<td>구매부</td>
							</tr>
							<tr>
								<td>1</td>
								<td>헌원</td>
								<td>010-1234-9876</td>
								<td>gjsdnjs@gmail.com</td>
								<td>구매부</td>
							</tr>
						</tbody>
					</table>
			
			</div>
			</div>
		</div>
		
		
		
		
		
	</div>
</div>

</body>
</html>
