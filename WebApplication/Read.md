### 🔸 Login_Register

- Spring 프레임워크가 아니라면 MyBatis는 설정이 복잡
- MyBatis 가 아닌 iBatis 사용

<br>

#### 🔹 어떤 기능을 만들 것인가 ?

- 기존에 배운 BootStrap을 사용 ✔
- 반복되어 사용하는 div는 따로 생성해 JSP 파일을 Include하여 사용 ✔
- 회원가입 ✔
- 로그인 / 로그아웃 기능
- 게시판
- 게시판 댓글 작성
- 게시판 검색
- 첨부파일 업로드 / 다운로드

<hr>

#### 🔹 jar 파일 라이브러리 추가

1️⃣ https://mvnrepository.com/artifact/org.apache.ibatis/ibatis-sqlmap/2.3.4.726

2️⃣ Files - jar 파일 다운로드

3️⃣ - 1 프로젝트구조 - 라이브러리 - ibatis-sqlmap-2.3.4.726.jar 파일 추가 (인텔리제이) <br>
3️⃣ - 2 src - main - webapp - WEB_INF - lib - 파일 붙여넣기 (이클립스)

<br>
<hr>

#### 🔹 ibatis Mapper 작성

insert, update, delete ,select 태그를 사용해 sql문 작성
파라미터클래스와 result클래스 매핑

<br>
📌 인텔리제이 - resources 폴더에 생성 <br>
📌 이클립스 - Java Resources - src - main - java에 생성

<hr>

#### 🔹 DAO 클래스 작성

- DAO 에는 sqlMapClient 객체의 insert() , update() , delete() , queryForObject() , quetForList()
- 메서드를 사용해 ibatis 매퍼파일에 정의된 SLQ 구문 실행

<br>
<hr>

### 🔹 iBatis

- SQL Mapper Framework
- SQL 과 Java 객체를 매핑 시켜서 데이터베이스 엑세스 작업을 수행한다
    + SQL 실행에 필요한 겂을 포함하고 있는 Java 객체
    + SQL 실행 결과 값을 저장하는 Java 객체를 각각 지정하고 SQL과 연결하면
    + iBatis 혹은 myBatis 가 SQL을 실행해서 데이터베이스 엑세스 작업을 수행한다

#### 🔹 iBatis 주요 API

- SqlMapClient 인터페이스
    + 데이터 베이스에 대한 CRUD 지원 메서드가 정의된 인터페이스

주요메서드

```HTML
Object insert(String sql);
Object insert(String sql, Object parameterClass);
- INSERT 구문을 실행
- insert 태그 안에 selectkey 태그를 사용하는 경우 selectkey 태그에서 획득한 값이 반환

int update (String sql);
int update (String sql , Object parameterClass);
- UPDATE 구문을 실행
- 변경된 행의 객수 반환 (의미없음)

int delete (String sql);
int delete (Steing sql , Object parameterClass);
- DELETE 구문을 실행
- 삭제된 행의 갯수 반환 (의미없음)


Object queryForObject(String sql);
Object queryForObject(String sql , Object parameterClass);
- 조회 결과가 1건이 조회되는 경우 사용
- 기본키나 유니크 컬럼이 조회조건으로 사용되는경우 조회결과가 1건이다
- 그외 경우에는 조회결과가 1건 조회되더라도 사용하면 안된다.
- resultClass 속성에서 지정한 그 객체를 생성해서 조회결과를 저장한다음 반환한다
- 조회결과가 없으면 null 반환


List queryForList(String sql);
List queryForList(String sql , Object parameterClass);
- SELECT 구문을 실행
- 조회결과가 1건이상 조회되는 경우 사용
- 조회결과 유무와 상관없이 List 객체 생성
- 조회결과 하나당 (행마다) resultClass 속성에서 지정한 그 객체를 생성해서 조회 결과를 저장한 다음 위에 생성한 List 객체에 저장
- 최종적으로 List 객체가 반환 (List 객체에서 resultClass 속성에서 지정한 객체가 여러개 저장되어 있다)
- 조회 결과가 하나도 없으면 사이즈가 0인 List 객체가 반환
```

#### 📌 예시

```java
public class Dept {
    int id;
    String name;
    int managerId;
    int locationId;

    public class Dept() {
    }
    // Getter , Setter , toString
}
```

<hr>

```xml
<!----IBatis----->
<insert id="insertDepartment" parameterClass="vo.Dept">
    INSERT INTO departments
    (department_id , department_name , manager_id , location_id)
    values
    ( #id# , #name#, #managerId#, #locationId# )
</insert>
```

- ````<insert>````
    + INSERT SQL구문 정의


- ```id = "insertDepartment"```
    + INSERT SQL 구문을 식별하는 ID 값 지정


- ```parameterClass = "vo.Dept"```
    + INSERT SQL 구문을 실행하는데 필요한 vo.Dept 객체에 담아서 parameter 값으로 제공하는다는 것을 지정


- `````#id# `````
    - 파라미터로 전달받을 vo.dept 객체의 id 멤버변수에 저장된 값이 치환될 위치를 지정

- ``` #name# ```
    - 파라미터로 전달받을 vo.dept 객체의 name 멤버변수에 저장된 값이 치환될 위치를 지정


 