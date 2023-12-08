### 오라클의 데이터 타입

----

- VARCHAR2(size)
    + 가변길이 문자 데이터 , 최대 4000
    + size 범위내에 실제 데이터의 크기만큼만 저장공간 사용
        + Ex > 이름 , 주소 , 과목명 , 사품명 , 뉴스제복


- CHAR(size)
    + 고정길이 문자 데이터 최대값 2000
    + size 크기만큼의 저장공간 사용
        + Ex> 주민등록번호 , 학번 , 수강과목 코드


- Long
    + 가변길이 대용량 문자데이터 최대 2GB
    + 현재는 잘 사용안함
    + 테이블당 하나밖에 사용할수 없다
    + 제약조건을 정의할 수 없다
    + order by , group by도 포함된다


- CLOB
    + 가변길이 대용량 문자 , 데이터 최대값 4GB
        + EX > 블로그의 본문 , 신문기사 논문
        +

- DATE

    + 날짜 및 시간 데이터
        + 예) 입사일, 가입일, 주문날짜, 이체날짜, 신청날짜 ...

----

- ROWID
    + 테이블에서 행의 고유주소를 나타내는 64진수 숫자데이터

            select rowid, department_id, department_name
            from departments;
            
            rowid			departmet_id	department_name
            --------------------------------------------------------
            AAAEAWAAEAAAACtAAA	10		Administration
            AAAEAWAAEAAAACtAAB	20		Marketing
            AAAEAWAAEAAAACtAAC	30		건희 영업팀
            
            오브젝트번호  파일번호  블록번호  데이터번호
            AAAEAW  AAE  AAAACt  AAA
            AAAEAb  AAE  AAAADN  AAA 
- 오브젝트번호

    + 해당 데이터가 속해있는 데이터베이스 객체(테이블)의 번호
    + 데이터베이스 객체마다 고유하다.


- 파일번호

    + 해당 데이터가 위치하고 있는 테이블스페이스 파일번호


- 블록번호

    + 파일내부의 블록번호
    + 데이터번호
    + 데이터가 저장되어있는 데이터 디렉토리 슬롯 번호