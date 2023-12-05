### 테이블의 데이터 조회

- 지정된 테이블의 모든 행, 모든 열을 조회한다

        select * from 테이블명    - 모든 행과 열 조회
- 테이블의 특정 행 , 열 조회

        select 컬럼 , 컬럼 , 컬럼
        from  테이블명

<br>

#### 데이터 필터링 하기

1.where 절 조건식 작성해서 해당 조건식에 만족시키는 행만 조회하기

        select 컬럼명 , 컬럼명 , 컬럼명...
        from 테이블명
        where 조건식;

2. where 절에서 2개 이상의 조건으로 데이터를 필터링
   <br><br>

    - 2개 이상의 조건식을 작성할 때는 and , or , not 논리 연산자를 사용

          select 컬럼명 , 컬럼명 , 컬럼명....
            from 테이블명
            where 조건식1 and 조건식2;

    - 조건식1과 조건식2가 모두 true로 판정되는 행만 조회

            select 컬럼명 , 컬럼명 , 컬럼명....
            from 테이블명
            where 조건식1 or 조건식2;

    - 조건식1과 조건식2 중에서 하나라도 true로 판정되는 행만 조회

             select 컬럼명 , 컬럼명 , 컬럼명....
             from 테이블명
             where 조건식1 and (조건식2 or 조건식3);

            + )and 연산자와 or 연산자를 같이 사용 할 때는 or 연산식을 괄호로 묶는다

<br>

### 별칭 부여하기

    select 컬럼명 as 별칭 , 컬럼명 as 별칭
    from 테이블명
    
    select 컬럼명 별칭 , 컬럼명 별칭
    from 테이블명

    select department_id as 부서 , department_name 부서명 , manager_id 관리자
    from departments
    where manager_id is  not null;
