### 테이블 생성하기

    CREATE TABLE 테이블명 (
            컬럼명 데이터타입 제약조건,
            컬럼명 데이터타입 ,
            컬럼명 데이터타입(사이즈),
            컬럼명 데이터타입 DEFAULT 기본값
                    )   

<br>

        CREATE TABLE
            테이블을 생성시키는 SQL 명령어
        BOOK_NO ,BOOK_TITLE ,BOOK_WRITER,BOOK_PRICE      
        BOOK_STOCK , BOOK_REG_DATE
            새로 생성한 테이블릐 컬럼이름
        NUMBER
            해당컬럼의 데이터 타입을 숫자형으로 지정
        VARCHAR2
            해당컬럼의 데이터 타입을 가변길이문자형으로 지정
        DATE    
            해당컬럼의 데이터타입을 날짜형으로 지정
        PRIMARY KEY
            해당 컬럼을 테이블에서 행의 식별하기 위한 값을 가지는 기본키 컬럼으로 지정
            해당컬럼은 NULL을 허용하지 않으며 , 값은 테이블 전체에서 고유하다
        NOT NULL
            해당 컬럼은 NULL인 상태를 가질수 없다
        DEFAULT 10
            새로운 행을 추가할 때 해당 컬럼에 값을 지정하지 않으면 10이 기본값으로 저장
        DEFAULT SYSDATE
            새로운 행을 추가할 때 해당 컬럼에 값을 지정하지 않으면 시스템의 현재 날짜가 저장    

<Br>

#### 실제예시

    CREATE TABLE SAMPLE_BOOKS (
    BOOK_NO         NUMBER(6) PRIMARY KEY,
    BOOK_TITLE      VARCHAR(255) NOT NULL,
    BOOK_WRITER     VARCHAR(255),
    BOOK_PRICE       NUMBER(7,0) NOT NULL,
    BOOK_STOCK      NUMBER(3,0)DEFAULT 10,
    BOOK_REG_DATE   DATE        DEFAULT SYSDATE
         );

----

### 테이블에 신규 행 추가하기

        INSERT INTO 테이블명 (컬럼명 , 컬럼명 , 컬럼명)
        values              (값    , 값  , 값)

- 신규 행을 추가할 때 값이 저장될 컬럼을 직접 나열하는 방식
- 생략된 컬럼에는 NULL 값이나 기본값이 저장된다
- 테이블의 컬럼순서와 상관없이 지정된 컬럼과 같은 순서로 값을 지정한다
- 실제 개발환경에서 사용한다

<br>

     INSERT INTO 테이블명
        VALUES (값,값,값,값,값,값)

- 신규 행을 추가할 때 컬럼명을 생략하는 방식
- 신규 행의 모든 컬럼에 대해서 값을 지정해야 한다      (저장할 것이 없다면 NULL을 명시적으로 적는다)
- 테이블의 컬럼순서와 동일한 순서로 값을 지정해야한다

<br>

#### 실제예시

    Insert into SAMPLE_BOOKS
    (BOOK_NO , BOOK_TITLE , BOOK_WRITER , BOOK_PRICE)
    VALUES
    (10 , '자바의정석' ,'남궁성', 32000);

<br>

    INSERT INTO SAMPLE_BOOKS
    (BOOK_NO , BOOK_TITLE  , BOOK_WRITER , BOOK_PRICE ,BOOK_STOCK)
    VALUES
    (12 , '이것이 자바다' , '신용균' , 35000 ,  25);

<br>

    INSERT INTO SAMPLE_BOOKS
    VALUES (14 , 'Spring Quick Startr' , '기억안남' , 35000 , 30 , SYSDATE);

<br>

#### COMMIT

        COMMIT;

- COMMIT 실행 이후 데이터 베이스에 영구적으로 저장

----

### 데이터 수정하기

    UPDATE 테이블명
    SET
    컬럼명 = 값,
    컬럼명 = 값
     where 조건식

where 조건식

- 테이블에서 지정된 컬럼의 값을 변경시킨다
- where 절을 생략하게 된다면 테이블의 모든 행에 컬럼값이 변경된다  (가장 중요!!)
- where 절이 있는 경우 조건식을 만족하는 행에 대해서만 지정된 컬럼의 값이 변경된다

#### 실제 예시

- SAMPLE_BOOKS 테이블에서 책번호가 10번 인 책의 재고수량을 9권으로 변경하기

        UPDATE SAMPLE_BOOKS
        SET
        BOOK_STOCK = 9
        where BOOK_NO = 10;

- 도서 테이블에서 책번호가 12인 책의 가격을 10% 할인하고 ,재고 수량을 1감소 시킨다

        UPDATE SAMPLE_BOOKS
        SET
        BOOK_PRICE = BOOK_PRICE - BOOK_PRICE*0.1,
        BOOK_STOCK = BOOK_STOCK - 1
        where BOOK_NO = 12;

        COMMIT;

----

### 테이블의 행 삭제하기

    DELETE FROM 테이블명
    [WHERE 조건식]

- where절을 생략하면 테이블의 모든 행이 삭제
- where절이 있다면 조건식을 만족하는 행만 삭제

* where 절의 조건식은 특벙 행 하나만 삭제되도록 조건식을 작성하자
* 특정 행 하나만 삭제되도록 하기위해 조건식은 해당 테이블에서 기본키 제약조건이 적용된
  컬럼이 사용되어야한다

      DELETE FROM SAMPL_BOOKS
      WHERE BOOK_NO = ?       -- 삭제 혹은 수정을 위해서는 기본키 제약조건 PK 컬럼을 사용
      WHERE BOOK_TITLE = ?
      WHERE BOOK_WRITER = ?
      WHERE BOOK_PRICE = ?

----

### 테이블 절단하기

    TRUNCATE TABLE 테이블명;

- 테이블은 존재 하고 데이터를 전부 삭제한다 사용하고 있던 공간을 반납한다

<br>

#### 실제예시

- 도서 테이블에서 책번호가 10인 책정보(행) 삭제

        DELETE FROM SAMPLE_BOOKS
        WHERE BOOK_NO = 10;

- 도서 테이블의 모든 데이터 전달하기

        TRUNCATE TABLE SAMPLE_BOOKS;
