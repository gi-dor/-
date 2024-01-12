### 🔸 URI

1. Uniform Resource Identifier 통합 자원 식별자
2. 인터넷에 있는 자원을 나타내는 유일한 **주소**

    - 아래의 주소는 URI
    - 아래 주소 ```web.servlet.DownloadServlet``` 작원의 실행에 요청하는 유일한 식별자 주소다
    - ```web.servlet.DownloadServlet``` 자원의 실제위치를 나타나지 않는다

-

```
http://localhost/comm/file/download   ---->  web.servlet.DownloadServlet
```

### 🔸 URL

1. Uniform Resource Location 통합 자원 지시기
2. 네트워크 상에서 자원이 어디있는지 알려주기 위한 규악
3. URL은 실제 존재하는 자원의 물리적인 위치를 나타낸다

    - 아래의 주소는 URI
    - 아래 주소는 index.jsp자원의 실행을 요청하는 유일한 식별자 주소
    - ```http://localhost/comm/index.jsp```
      <BR><BR>
    - 아래 주소는 UTL
    - 아래 주소는 index.jsp 자원의 서버상의 실체 위치를 나타낸다
    - ```http://localhost/comm/index.jsp```

### 🔹 URI URL 의 구조

- URI나 URL은 scheme , hosts murl-path로 구성되어있다
- ```http://www.shop.com:80/product/detail.jsp?no=10000&page=3```

```html
scheme --> https://
hosts --> www.shop.com:80
url-path --> /product/detail.jsp
query-string  --> no=10000&page=3
```

```http://www.shop.com:80/product/detail.jsp?no=10000&page=3``` 는 URL
```http://www.shop.com:80/product/detail.jsp?no=10000&page=3``` 는 UTL이 아니다

- ?no=1000&page=3이 자원의 위치를 나타내는 저보가 아니기 떄문
- no는 상품번호가 10000이고 페이지번호가 3인 정보를 요청하는 것을 식별하는 용도로 사용되기 때문
- URL은 URI의 부분집합이기 때문에 URL은 전부 URI 라고 할수 있다
-

<img src="https://github.com/gi-dor/HTA_Eclipse/assets/86302876/5a30b2d6-2674-42c7-a73f-54eb242ccd79"/>