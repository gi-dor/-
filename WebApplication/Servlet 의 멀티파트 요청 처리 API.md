### 🔸 서블릿의 멀티 파트 요청 처리 API

#### HttpServletRequest

- 요청 메세지 정보를 표현하는 객체다


- 주요 메서드

- ```Part getPart(String name)```
    + 지정된 입력 필드 이름에 해당하는 입력 필드 정보를 표현하는 객체를반환
    + 첨부파일 업로드 필드의 필드명이 서로 다를 때 이 메서드를 이용해서 첨부파일 정보를 표현하는 Part 객체를 하나씩 획득할 수 있다

- Collection<Part> getParts();
    + 모든 입력필드에 대해서 Part 객체를 하나씩 생성하고 Collection 객체에 담아서 반환한다
    + 첨부파일 업로드 필드의 필드명이 모두 동일 할 때 이 메서드를 이용해서 모든 입력필드를 표현하는
    + Part 객체를 전부 조회한 다음 , 실제 첨부파일 업로드 필드를 표현하는 Part 객체만 선별해서 처리한다

#### 🔹 Part

- 서버로 전달된 입력 필드 정보를 표현하는 개체
- 주로 , 서버로 업로드된 첨부파일을 다루는 메서드를 제공
- 입력 폼의 모든 입력 필드에 대해서 Part 객체가 생성


- 주요 메서드

- ```String getName ()```
    + 첨부파일 입력필드의 name 값 반환

- ```String getSubmittedFileName()```
    + 업로드된 첨부파일의 파일명을 반환

- ```String getContentType()```
    + 업로드된 첨부파일의 컨텐츠 타입을 MIME 타입형식의 문자열로 반환

- ```long getSize()```
    + 업로드된 첨부파일의 크기를 byte 단위의 정수값으로 반환

- ```ImputStream getInputStream()```
    + 업로드된 첨부파일을 읽어오는 읽기전용 스트림을 반환