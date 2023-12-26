### 🔸 CSS - Cascading Style Sheets

---------

HTML 혹은 XML과 같은 구조화된 문서를, 화면 이나 종이에 어떻게 렌더링할 것인지를 정의하기위한 언어<br>
CSS는 HTML의 각 요소에 style를 정의해서 화면에 어떻게 렌더링하면 되는지 브라우저에게 설명하기위한 언어다<br><br>
HTML은 정보 (content) 와 구조 (stuructur)를 정의하고<br>
CSS는 스타일 (Styling)을 정의한다

<br>

-----------

#### 🔹 선택자 , Selector

- 스타일을 적용하고자 하는 HTML요소(태그)를 <strong>선택</strong> 하기 위해서 사용하는 것
- Selector (선택자)  : h1 , image-item , box-1

```html
<!--- 태그 선택자-->
<!-------태그에 속하는 모든 요소에 스타일을 적용 시킨다---------->
h1{ color:red; font-size:12px; }
```

````html
<!--- 클래스 선택자-->
<!-----------class속성에  image-item을 포함하고 있는 모든 요소에 스타일이 적용된다 ------------->
<!-------<button class="image-item zzz xxx Btn">------>

.image-item { width:70px; height:100px; opacity:0.5; }
`````

```html
<!--- 아이디 선택자-->
<!--- id = "box-1 인 요소 하나를 찾아서 스타일 적용"------->
#box-1{ border :1px solid #dddd;}
```

<br><br>

-------------

<br>

#### 🔹 HTML과 CSS의 연동

1️⃣ Link Style

- 가장 일반적인 연동방식
- HTML에서 외부에있는 CSS파일을 로드한다

```html

<html>
<head>
    <!---- Link Style ---->
    <Link rel="stylesheet" href="css/style.css">
</head>
<body>
<h1>Embedding Test 연습</h1>
<div class="box">자식</div>
<div class="box">자식</div>
<div class="box">자식</div>
</body>
</html>
```

```css
/*  css/style.css      */
h1 {
    color: beige;
    font-size: 20px;
}

.box-item {
    border: 1px solid #ddd;
    margin: 5px;
}
```

2️⃣ Embedding Style

- HTML 내부에 CSS를 포함시키는 방식
- 매우매우 간단한 웹페이지의 경우 사용을 추천한다 , 일반적으로 Link Style사용
- 매우 간단한 웹페이지의 경우 CSS선언과 HTML이 하나의 문서에 포함되어있기에 한번에 참조할수 있다

```html

<html>
<head>
    <!--Embedding Style---->
    <style>
        h1 {
            color: beige;
            font-size: 20px;
        }

        .box-item {
            border: 1px solid #ddd;
            margin: 5px;
        }
    </style>
</head>
<body>
<h1>Embedding Test 연습</h1>
<div class="box">자식</div>
<div class="box">자식</div>
<div class="box">자식</div>
</body>
</html>
```

3️⃣ Inline Style

- HTML의 모든 요소 Style속성을 활용해 CSS를 기술하는 방식
- HTML의 문서가 복잡해진다.
- 스타일을 변경시 모든 태그의 style 속성을 수정해야 하기에 유지보수가 어렵다
- 비추천

```html
<h1 style="color: burlywood" ; font-size:30px;> Inline Style 테스트 </h1>
```

-------------------------

<br>

#### Reset CSS

- 모든 웹 브라우저마다 HTML요소에 대한 디폴트 스타일을 가지고 있다
- 웹 브라우저마다 디폴트 스타일이 서로 다른부분이 존재한다
- Reset CSS 는 기본적인 HTML 요소의 CSS를 초기화하는 용도로 사용한다.