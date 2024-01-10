### 📌 쇼핑몰 관리자 기능구현

<br>

#### 🔸 상품관리

#### 🔹 상품 목록조회

```html
product/list.jsp
```

- 요청 파라미터 조회
- 업무로직 수행 - 전체상품 목록조회
- 조회된 상품 목록 정보로 html 컨텐츠 생성

```xml

<select id="getProducts">
    SELECT *
    FROM web_product
    order by product_no desc;
</select>

```

DAO

```java
public List<Product> getProducts(){

        }
```

<br><br>

#### 🔹 상품 상세정보 조회

```html
product/detail.jsp
```

#### 🔹 신규상품추가

```html
product/form.jsp ,  product/insert.jsp
```

- form 태그 method=post action=insert.jsp
- 입력하는 양식 필드에 name 속성 추가하기

insert.jsp

- form.jsp 에서 제출한 값 처리하기
- 요청 파라미터에서 form 입력값 조회
- Product 객체를 생성해서 조회된 form 입력값을 저장
- 업무로직 수행 - 신규상품 등록
- 상품 목록을 요청하는 list.jsp를 재요청 URL 응답으로 보낸다

#### 🔹 상품정보 변경

```html
product/modify.jsp   , product/update.jsp
```

#### 🔹 상품정보 삭제

```html
product/delete.jsp
```

<br>
<hr>
<br>





