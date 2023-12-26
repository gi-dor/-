#### 🔸 박스모델

- 모든 HTML 요소는 Box 형태의 영역을 가지고있다
- Box는 컨텐츠(content) , 안쪽여백 (Padding) , 테두리 (Border) , 바깥여백 (Margin)

<br>

--------
<br>

- Content
    + 요소의 텍스트나 이미지 등의 실제 내용이 위치하는 영역 Width , height 프로퍼티르 갖는다
    + width , height 프로퍼리를 갖는다

- Padding
    + 테두리 안쪽에 위치하는 내부 여백영역
    + Padding의 프로퍼티는 Padding 영역의 두께를 의미

- Border
    + 요소의 테두리 영역
    + Border 프로퍼티는 테두리의 두께를 의미

- Margin
    + 요소의 외부 여백 영역
    + Magrin 프로퍼티는 Margin영역의 두께를 의미

```css
/*4개 방향에 대해 각각 지정하기*/

div {
    margin-top: 40px;
    margint-right: 30px;
    margin-bottom: 20px;
    margin-left: 10px
}

/*방향을 지정하지 않고 4방향의 프로퍼티 한번에 지정하기*/
/*4개의 값을 지정*/
div {
    margin: 40px 30px 20px 10px;
    margin-top: 40px;
    margin-right: 30px;
    margin-bottom: 20px;
    margin-left: 10px;
}

/*3개의 값을 지정*/

div {
    margin: 10px 20px 30px;
    margin-top: 10px;
    margint-right: 20px;
    margint-left: 20px;
    margin-bottom: 30px;
}

/*2개의 값을 정자할 때 */

div {
    margin: 10px 20px
    margin-top: 10px;
    margin-bottom: 10px;
    margint-right: 20px;
    margint-left: 20px;
}

/*1개의 값을 맞이 지정 */
div {
    margin: 20px;
}

```

---------------------------------------------------

#### 🔹 Box Sizing 프로퍼티

- box-sizing 프로퍼티는 width , height 프로퍼티의 대상 영역을 지정한다
- box-sizing 프로퍼티의 기본 값은 context-box다
    + context-box : width , height , 프로퍼티의 값은 content 영역을 의미
    + border-box : width , height , 프로퍼티의 값은 content + padding + border 영역을 의미
    + margin을 제외한 박스 모델 전체를 width , height 대상영역으로 지정할수 있어서
    + CSS Layout을 직관적으로 사용할수 있다

------

<br>

#### 🔹 Display 프로퍼티

- display 프로퍼티는 HTML요소를
    + 어떤식 ( block, inline , inline-block , none ) 으로 화면에 표현할지 지정한다
- display 프로퍼티
    + block : block 특성을 가지는 요소로 표시 (지정)한다
    + inline : inline 특성을 가지는 요소로 표시(지정)한다
    + inline-block : inline-block 특성을 가지는 요소로 표시(지정)한다
    + none : 해당 요소를 화면에 표시하지 않는다 (공간 조차 사라짐)

  <br><br>

#### 📌 block

- 항상 새로운 라인에서 시작
- 화면 크기 전체의 가로폭을 차지
- width , height , margin , padding 을 지정
- block 엘리먼트는 inline 엘리먼트를 포함 할 수 있다

<br>

#### 📌 Inline

- 새로운 라인에서 시작하지 않으면 라인의 중간에 들어갈 수 있다
- 줄을 바꾸지 않고 다른 요소와 같은 행에 위치 시킬 수 있다
- content 너비만큼 가로폭을 차지한다
- width , height , margin-top , maring-botton을 지정할 수 없다
- inline 엘리먼트는 block 엘리먼트를 포함 할 수 없다
- 일반적으로 Inline 엘리먼트는 block 엘리먼트에 포함되어 사용한다

<br>

#### 📌 Inline - block

- block 과 inline 의 특성을 모두 가지고 있다
- inline 처럼 한줄에 여러개 표현 될 수 있다
- width , height , margin을 모두 지정 할수 있다

<br>

#### 📌 visibility 프로퍼티

- 요소를 보이게 할것인지 보이지 않게 할것인지 정의한다
    + hidden : 해당요소를 보이지 않게한다, 해당요소가 차지 했던 공간은 유지된다.
    + visible : 해당요소를 화면에 표시한다 (기본값)

<br>

#### 📌 position 프로퍼티

- 요소(태그)의 위치를 지정한다
- top , bottom , right , left 프로퍼티와 함께 사용해 위치를 지정한다

    + static
        * position 프로퍼티의 기본 값
        * 요소의 배치 순서에 따라 위에서 아래로 왼쪽에서 오른쪽으로 순서에 따라 배치된다
        * 좌표 프로퍼티 ( top , bottom , left , right )를 사용 할 수 없다

        <br>
    + relative
        * 기본위치( static으로 지정했을 때 위치 )를 기준으로 좌표 프로퍼티를 이용해서 위치를 이동시킨다

    <br>

    + absolute
        * 부모 또는 조상 요소의 position 프로퍼티가 satitc 이면
        * 페이지의 최상단 원점을 기준으로 좌표 값 만큼 이동해서 위치한다
        * 부모 또는 가장 가까운 조상 ( static은 제외 ) 을 기준으로 지정된 좌표 값만큼 이동한다.
        * relative , absolute , fixed 프로퍼티가 선언된 부모 또는 조상 요소를 기준으로 위치가 결정된다.

        <br>

    + fixed
        * 부모요소와 관계없이 브라우저의 viewport를 기준으로 좌표 값 만큼 위치를 이동시킨다
        * 스크롤이 되더라도 화면에서 사라지지 않고 항상같은 곳에 위치한다

#### 📌 Z-Index 프로퍼티

- z- Index 프로퍼티 값이 클 수록 화면 전면에 출력된다
- position 프로퍼티가 static이 아닌 요소에만 적용된다,