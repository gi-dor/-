### 🔸 Selector

----------

#### 🔹 Selector 선택자

- Style을 적용하고자 하는 HTML 요소를 지정하는 것

#### 🔹 Selector 선택자의 종류

1. 전체 선택자 <br>
   패턴 : * <br>
   설명 : HTML의 모든 요소를 선택
   <br><br>
2. 태그 선택자
   패턴 : 태그명 <br>
   설명 : 지정된 , 같은 태그명을 가지는 요소를 선택한다

```css
  p {
    color: red;
}
```    

<br>
3. 클래스 선택자 <br>
   패턴 : .class {속성값} <br>
   설명 : class 속성값을 지정해 일치하는 요소를 선택  ,  class 속성값에 지정된 값을 가지는 모든 요소를 선택

```css
/* class 속성 값에 container를 포함하고 있는 모든 요소를 선택*/
.container {
    color: red;
}
```

   <br>
4. 아이디 선택자 <br>
   패턴 : #id {속성값} <br>
   설명 : id 속성값을 지정해 일치하는 요소를 선택 , id속성값은 중복될 수 없는 유일한 값이므로 요소 하나만 선택

```css
#image-box {
    border: 1px solid #ddd;
}
```

   <br>
5. 속성 선택자 <br>
   패턴 : 

- 선택자[속성]          - 지정된 속성을 갖는 모든요소 선택
- 선택자[속성 = "속성값"]  - 지정된 속성값과 일치하는 값을 가지는 모든요소
- 선택자[속성 ^= "속성값"] - 지정된 속성값으로 시작하는 모든요소
- 선택자[속성 $= "속성값"] - 지정된 속성값으로 끝나는 모든요소
- 선택자[속성 *= "속성값"] - 지정된 속성값을 포함 하고 있는 모든요소
- 선택자[속성 ~= "속성값"] - 지정된 속성값을 공백으로 구분된 단어로 포함하는 모든요소

설명 : 지정된 속성을 갖는 모든 요소를 선택한다

```css
/* a 태그 중에 hreef 속성을 가지는 모든 요소 선택 */
a[href] {
    border: 3px solid #ddd;
    padding: 1px;
}

/* a 태그 중에서 href 속성의 값이 www로 시작하는 모든 요소 */
a[href^="www"] {
    background-color: skyblue;
}

/* a 태그 중에서 href 속성의 값이 pdf로 끝나는 모든 요소 */
a[href$="pdf"] {
    background-color: yellowgreen;
    color: red;
}

/* a 태그 중에서 title 속성값이 "shopping"이라는 글자를 포함하고 있는 모든요소 */
a[title*="shopping"] {
    background-color: darkkhaki;
}

/* a 태그 중에서 title 속성값이 "shopping"을 공백으로 구분된 단어로 포함 */
a[title~="shopping"] {
    background-color: blueviolet;
}

/* input 태그 중에서 name 속성값이 username인 요소를 선택 */
input[name=username] {
    border: 2px solid lightcoral;
}

a[href ~= "test"] {
    color: blue;
}


.image-item[alt="그림"] {
    display: none;
}
```

```html
<img src="sample.jpg" clas="image-item" alt="그림">
<p>
    <a href="">링크 1</a>
    <a href="">링크 1</a>
    <a href="">링크 1</a>
</p>

<P>
    <a href="www.daumnet">링크1</a>
    <a href="www.naver.ocm">링크1</a>
    <a href="www.playNc.com">링크1</a>
</P>

<P>
    <a href="sample.pdf">링크1</a>
    <a href="sample.docx">링크1</a>
    <a href="sample.xml">링크1</a>
</P>

<p>
    <a href="xxx.html" title="shopping-site">링크1</a>
    <a href="xxx.html" title="shopping">링크1</a>
    <a href="xxx.html" title="Internet site">링크1</a>
</p>

<p>
    <input type="text" name="username" placeholder="이름을 입력하세요">
    <input type="password" name="userpwd" placeholder="비밀번호를 입력하세요">
</p>
```

   <br>
6. 복합 선택자 <br>
   설명 : 2개 이상의 요소를 선택하는 것 <br>

- 후손 (하위요소) 선택자<br>
    + 패턴 : 선택자1 선택자2
    + 설명 : 선택자1의 후손 중에서 선택자2와 일치하는 요소를 선택한다

```css
/*div 안에 있는 모든 P태그*/
div p {
    color: red;
}

/*id값이 image-box인 요소의 하위에있는 모든 것*/
#image-box img {
    display: none;
}

#loginform input[type="text"] {
    border: 1px solid blue;
}

/* 후손 선택자 */
클래스 선택자 .container인 요소의 모든 하위요소 중에서 요소를 선택
.container p {
    border: 1px solid red;
    padding: 3px;
}
```

<br>

- 자식(자식요소)선택자
    + 패턴 : 선택자1 > 선택자2
    + 선택 : 선택자1의 자식 중에서

```css
div > p {
    color: red;
}

#image-box > button {
    display: none;
}

.navigation > a {
    background-color: lightskyblue;
}

/* 자식 선택자 */
/* 클래스 선택자 container인 요소의 자식중에서 p인요소 */
.container > p {
    background-color: yellow;
}

.container div p {
    background-color: grey;
}
```

   <br>

- 인접 형제 선택자
    + 패턴 : 선택자1 + 선택자2

```html

<div>
    <h3 id="heading">제목1</h3>
    <div></div>
    <p>네번째 단락</p>
    <p>네번째 단락</p>
    <p>네번째 단락</p>
</div>
```

```css
 /* 아이디 속성 값이 heading인 요소와 바로 인접한 (바로 다음 등장하는) p 요소를선택 */
/* 네번째 단락중 첫번째가 선택 */
#heading + p {
    border: 2px solid magenta;
}
```    

   <br>

- 일반 형제 선택자
    + 패턴 : 선택자1 ~ 선택자2
    + 설명 :  선택자1의 형제중에서 선택자1의 뒤에 위치하는 선택자2 요소를 모두 선택

```css
   /* 아이디 속성값이 heading인 요소의 뒤에 위치하는  모든 p요소를 선택 
    네번째 단락이 전부 선택된다. */
#heading ~ p {
    background-color: aqua;
}   
```

<br><br>

7. 가상 클래스 선택자 <br>

구조 가상 클래스 선택자 <br>
패턴 :

- 선택자:first-child 선택자로 선택된 요소 중에서 모든 첫번째 자식인 요소를 선택한다<br>
- 선택자:last-child 선택자로 선택된 요소 중에서 모든 마지막번째 자식인 요소를 선택한다 <br>
- 선택자:nth-child(n) 선택자로 선택된 요소중에서 모든 n번째 자식인 요소를 선택

가상 링크 선택자 , 가상 동적 선택자<br>

- a:link
    + a 태그 중에서 방문하지 않은 링크를 선택
- a:visited
    + a 태그 중에서 방문한 링크를 선택
- 선택자:hover
    + 선택자에 해당하는 요소 중에서 마우스가 올라와 있는 요소를 선택
- 선택자:active
    + 선택자에 해당하는 요소중에서 클릭된 요소를 선택
- 선택자:focus
    + 선택자에 해당하는 요소중에서 포커스가 들어와 있는 요소를 선택
- 선택자:checked
- 선택자:enabled
- 선택자:disabled

```html

<style>


    /* 가상클래스 선택자 */
    /* 클래스 속성값이 container의 하위 요소중에서 모든 P를 선택한 뒤에 
    선택된 P 중에 첫번째 자식인   요소를 선택 */
    .container p:first-child {
        background-color: yellow;
    }

    /* 클래스 속성값이 container의 하위 요소중에서 모든 P를 선택한 뒤에 
    선택된 P 중에 마지막 자식인  요소를 선택 */
    .container p:last-child {
        background-color: magenta;
    }


    /* 클래스 속성값이 container의 하위 요소중에서 모든 P를 선택한 뒤에 
    선택된 P 중에 3번째 자식인 요소를 선택 */
    .container p:nth-child(3) {
        background-color: red;
    }

    /*tbody의 하위 요소중에 모든 tr을 선택하고
    선택된 tr중에서 3n+1번째 자식 요소를 선택한다
                 n은 0,1,2,3,4,5.... */
    tbody tr:nth-child(3n+1) {
        background-color: #ddd;
    }

</style>


```