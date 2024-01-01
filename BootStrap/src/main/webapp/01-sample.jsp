<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<!-- 
	반응형 meta 태그를 추가한다
		+ 부트스트랩은 모바일 기기를 우선으로 개발하기 때문에 모바일 기기에 최적화하기 위해 
		+ 모든 모바일 장치에 화면이 올바르게 렌더링 되고 터치 확대 조절을 보장하기 위해 
		<head> 태그에 <meta> 태그로 viewport 메타태그를 추가 한다
 -->
<meta name="viewport" content = "width=device-width, initail-scale=1">
<!-- 
	부트스트랩 CSS 파일을 이 페이지에 포함시킨다
	+ bootstrap.css와 bootstrap.min.css중 하나를 포함시킨다
	+ bootstrap.css와 bootstrap.min.css은 내용이 동일한 파일이다
	+ bootstrap.min.css 는 bootstrap.css 에서 불필요한 빈줄 공백을 제거한 파일
	+ bootstrap.min.css 가 bootstrap.css 보다 파일의 사이즈가 더 작다
		( 네트워크로 더 빠르게 내려 받을 수 있고 , 통신요금도 절약된다 )
 -->

<link rel="stylesheet" href ="resources/bootstrap-5.2.3-dist/css/bootstrap.min.css">
<script type="text/javascript" src="resources/bootstrap-5.2.3-dist/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body>

<!-- 
	컨테이너 (.container 혹은 .container-flud) 
		+ 부트스트랩에서 모든 컨텐츠를 포함하는 요소
		+ 부스트스탭으로 구성된 화면에는 항상 최외각에
			.container 혹은 .container-flud가 클래스 속성이 적용된 div가 위치해야한다.
		+ 부트 스트랩에서 제공하는 그리드 시스템(레이아웃 구성을 지원)이 정상적을 적용되기 위해 필요하다

 -->
	<div class="container">
		Bootstrap을 다운로드하여 컴파일된 CSS 및 JavaScript, 소스 코드를 얻거나 npm, RubyGems 등과 같은 즐겨쓰는 패키지 관리자를 사용해서 포함시키세요.
		Sass, JavaScript, 그리고 문서 소스를 다운로드해서 고유 자산 파이프라인을 통해서 BootStrap를 컴파일할 수 있습니다. 이를 위해서는 다음 도구들이 필요합니다:)
		
		jsDelivr를 사용해서 다운로드하지 않고 Bootstrap의 컴파일된 CSS와 JS의 캐시 버전을 프로젝트에 전달하세요.
		컴파일된 JavaScript를 사용하고 있고 Popper를 개별적으로 포함하는 것을 선호한다면 Bootstrap의 JS 이전에 CDN을 통해서 Popper를 추가하세요.
		Bootstrap Icons
1,800여개의 아이콘이 있는 무료 고품질 오픈 소스 아이콘 라이브러리입니다. SVG, SVG 스프라이트 또는 웹 폰트 등 원하는 대로 사용할 수 있습니다. Bootstrap을 사용하지 않는 프로젝트에서도 사용할 수 있습니다.
	</div>
	
	<div class="">
		Bootstrap을 다운로드하여 컴파일된 CSS 및 JavaScript, 소스 코드를 얻거나 npm, RubyGems 등과 같은 즐겨쓰는 패키지 관리자를 사용해서 포함시키세요.
		Sass, JavaScript, 그리고 문서 소스를 다운로드해서 고유 자산 파이프라인을 통해서 BootStrap를 컴파일할 수 있습니다. 이를 위해서는 다음 도구들이 필요합니다:)
		
		jsDelivr를 사용해서 다운로드하지 않고 Bootstrap의 컴파일된 CSS와 JS의 캐시 버전을 프로젝트에 전달하세요.
		컴파일된 JavaScript를 사용하고 있고 Popper를 개별적으로 포함하는 것을 선호한다면 Bootstrap의 JS 이전에 CDN을 통해서 Popper를 추가하세요.
	</div>

</body>
</html>