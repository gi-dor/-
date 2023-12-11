#### 테이블 JOIN

    select *
    from 테이블 1, 테이블2;

- 테이블의 조인은 조인대상이 되는 테이블의 이름을 FROM절에 나열하기만 하면 된다.
- 별도의 조건이 없으면 테이블1의 모든행과 테이블2의 모든행이 연결된 가상의 테이블이 생성된다
- ( 테이블1의 행 갯수 * 테이블2의 행갯수 ) 만큼의 행이 조회된다

❓ REGIONS 테이블의 모든 행과 COUNTRIES 테이블의 모든행 JOIN

    select *
    from regions ,countries;

----

#### JOIN 조건 지정하기

    select *
    from 테이블1 , 테이블2
    where 테이블1.컬럼명 = 테이블2.컬럼명2;

- 조인된 테이블의 모든 행에서 조인조건을 만족하는 행이 의미있게 연결되는 행
- 조인조건을 지정하면 의미있게 연결된 행만 조회할 수 있다.
- 조인조건의 갯수 = 조인된 테이블의 갯수 - 1

❓ REGIONS 테이블과 COUNTRIES 테이블 JOIN , 서로 연관있는 행만 필터링

    select c.country_id ,
           c.country_name,
           r.region_name
    from regions r ,countries c
        where r.region_id = c.region_id;

❓ 직원 아이디 , 직원 이름 , 직종아이디 , 직종최소급여 , 직종최대급여 , 급여조회하기

    select * from employees;
    select * from jobs;
    
    select e.employee_id ,
           e.first_name ,
           e.job_id,
           j.min_salary ,
           j.max_salary ,
           e.salary
    from employees e , jobs j
        where e.job_id = j.job_id;

----
