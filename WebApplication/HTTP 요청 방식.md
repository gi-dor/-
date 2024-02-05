### 🔸 HTTP 요청방식

<img src="https://github.com/eungsu/documents/assets/86302876/8159e2af-bf76-456c-b2ab-0b8e0b506841">


<br>

#### 🔹 GET

- 클라이언트가 서버로 데이터를 요청하기 위해 사용하는 요청방식
- 데이터 흐름 : 클라이언트 ⬅⬅⬅ 서버
- GET 방식 요청의 예시
    + 웹 브라우저의 주소창에 주소를 입력하고 요청하는 경우
    + 링크를 클릭해서 다른주소를 요청하는 경우
    + ```<form method="get">``` 으로 설정되어 있고 submit 버튼을 클릭해 값을 제출하는 경우 <br>
      (폼의 입력양식의 값들이 검색조건으로 사용되는경우)

+ 요청 파라미터 값의 전송
    - URL에 쿼리스트링을 붙여서 서버에전송
    - 요청 메세지의 헤더부에 데이터를 포핳해서 서버로 전송
    - URL에 정보가 그대로 노출되기 때문에 상대적으로 보안에 취약하다


+ 서버로 전송하는 데이터의 크기에 제한이 있음

#### 🔹 POST

- 클라이언트가 서버로 데이터를 전송해서 리소스를 추가하거나 생성하기 위해 사용하는 요청방식
- 데이터 흐름 : 클라이언트 ➡➡➡ 서버
- POST 방식 요청의 예시
    + ```<form method=post>``` 로 설정되어 있고 , submit 버튼을 클릭해서 값을 제출
        + (폼의 입력값들이 리소스를 추가하거나 생성하기 위해서 사용되는경우)

+ 요청 파라미터 값의전송
    * 요청 메세지의 바디부에 데이터가 포함되어 전달되기에 상대적으로 보안이 우수하다
    * 서버로 전송하는 데이터의 크리에 제한이 없다
    * enctype 에 따라 서버로 보내는 데이터의 형식이 달라진다
    * ``` <form method="post" enctype="application/x-www-urlencodede">```
        + enctype 을 설정하지 않으면 기본값이 ```enctype="application/x-www-form-urlencoded"```
        + 요청 메세지의 바디부에 포함되어 새로운 서버로 전달디는 값이
            + ``` name=value&name=value&name=valu```
        + 첨부파일을 업로드 하지 않는 경우 사용

    * ```<form method="post" enctype="multipart/form-data">```
        - 첨부 파일을 업로드 하는경우 사용하는 데이터의 전달형식
        - 요청 메세지의 바디부에 포함되어 서버로 전달되는 값
        - 서버로 전달된 요청 파라미터 값 , 첨부파일을 처리하기 위해 멀티파트 요청을 처리하는 API 혹은 라이브러리 사용

```
            ------WebKitFormBoundaryNHRNFTOBhiYA2zcQ
            Content-Disposition: form-data; name="title"

            aaa
            ------WebKitFormBoundaryNHRNFTOBhiYA2zcQ
            Content-Disposition: form-data; name="description"

            bbb
            ------WebKitFormBoundaryNHRNFTOBhiYA2zcQ
            Content-Disposition: form-data; name="upfiles"; filename="sql-map-2.dtd"
            Content-Type: application/octet-stream


            ------WebKitFormBoundaryNHRNFTOBhiYA2zcQ

```

### 🔹 MIME Type (multipurpose internet main extensions)

- 문서 파일 바이트 집합의 성격과 형식을 나타내는 정보
- MIME 타입에 따라 브라우저가 보여주는게 다름

#### MIME 타입의 구조

- ```type / subtype```

    + MIME 타입의 슬래시(/) 로 구분된 type 과 subtype으로 구성된다
    + type은 text , image , video 와 같은 데이터 타입이 속하는 일반적인 카테고리
    + subtype은 MIME 타입이 나타내는 지정된 타입의 정확한 데이터 종류를 식별한다
        + ```text/plain , text/html , text/css```
        + ```image/jpg , image/png , image/gif```

- type 의 종류

    + ```application```
        + 모든 종류의 바이너리 데이터
        + 데이터를 어떤 방식으로든 실행하거나 해석되기 위해서는 특정 애플리케이션을 사용해야한다
        + 예시
            + ```application/octet-stream```
            + ```application/pdf```
            + ```application/zip```
    + ```text```
        + 사람이 읽을수 있는 텍스트 컨텐츠 , 소스코드 또는 쉼표로 구분된 CSV형태의 데이터와 같은 텍스트 형식의 데이터
        + 예시
          +```text/plain```
            + ```text/csv```
            + ```text/html```
    + ```image```
        + 비트맵과 벡터 이미지를 모두 포함하는 이미지 또는 그래픽 애니메이션 데이터
        + 예시
            + ```text/jpeg```
            + ```image/png```
            + ```image/svg + xml```
    + ```audio```
    + ```video```

#### 주요 MIME 타입

- ```application/octet-stream```
    + 바이너리 파일을 위한 기본값
    + '알려지지 않은' 바이너리 파일을 의미 , 파일 다운로드 할 때 응답 컨텐츠의 타입으로 설정할 수 있다
    + 타입이 알려지지 않은 첨부파일을 다운로드 할 때 응답 컨텐츠의 타입으로 설정할 수 있다.

- ```application/x-www-form-urlencoded```
    + 브라우저에서 서버로 폼입력 값을 전송할 때 요청 메세지의 바디부에 포함된 데이터의 형식을 지정할 때 사용
    + 폼 입력 값이 ```name=value&name=value``` 와 같은 형식으로 변환되어 포함된다

- ```multipart/form-data```
    + 브라우저에서 서버로 폼입력 값을 전송할 때 요청 메세지의 바디부에 포함된 데이터의 형식을 지정할 때 사용
    + ```           
           ------WebKitFormBoundaryNHRNFTOBhiYA2zcQ
            Content-Disposition: form-data; name="title"

            aaa
            ------WebKitFormBoundaryNHRNFTOBhiYA2zcQ
            Content-Disposition: form-data; name="description"

            bbb
            ------WebKitFormBoundaryNHRNFTOBhiYA2zcQ
            Content-Disposition: form-data; name="upfiles"; filename="sql-map-2.dtd"
            Content-Type: application/octet-stream


            ------WebKitFormBoundaryNHRNFTOBhiYA2zcQ
         ```

- ``` text/plain```
    + 텍스트 파일에 대한 기본 값
- ```text/css```
    + 웹 페이지의 스타일을 지정하는 css 파일은 text/css 타입으로 지정되야한다
- ```text/html```
    + 모든 HTML 컨텐츠 타입을 나타낸다
- ```text/javascript```
    + 자바스크립트를 나타낸다
- ```text/xml```
    + 모든 xml 컨텐츠 타입을 나타낸다
    + XML은 다른 시스템간의 데이터 교환용 문서를 만들 때 사용하되는 데이터 표현형식
- ```application/json```
    + JSON 컨텐츠 타입을 나타낸다
    + JSON은 서로 다른 시스템간의 데이터 교환용 문서를 만들 때 사용되는 데이터 표현형식
    + JSON은 XML에 비해 경량의 데이터 교환 형식이다