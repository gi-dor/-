/*

### 🔸Group Function

다중행 함수

조회된 행들의 집합그룹에 적용되어 그룹당 하나의 결과를 생성하는 함수

        * 집합그룹 : 테이블전체
                    그룹화된 테이블의 행들  (group by 를 사용해 테이블의 행을 그룹화 할 수 있다.)

- count(*)
    - 조회된 모든행의 갯수를 반환한다

- count(컬럼명)
    - 조회된 행에서 지정된 컬럼의 값이 NULL 이 아닌 행의 갯수를 반환한다

- SUM(컬럼명)
    - 조회된 행에서 지정된 컬럼 값의 합계를 반환 (NULL 무시)

- AVG(컬럼명)
    - 조회된 행에서 지정된 컬럼 값의 평균을 반환한다 (NULL 무시)

- MIN(컬럼명)
    - 조회된 행에서 지정된 컬럼의 최소값을 반환 (NULL 무시)

- MAX(컬럼명)
    - 조회된 행에서 지정된 컬럼의 최대값을 반환 (NULL 무시)

 다중행 함수 작성시 주의사항
-- 다중행 함수는 where절에서 사용할수 없다

select *
from employees
where count(*) > 10

    - 다중행 함수와 일반 컬럼명을 select절에 같이 적을수 없다
    - group by 절에 사용한 컬럼명은 select 절에 적을수 있다

-- 불가
select department_id , count(*)
from employees

-- 가능
select department_id , count(*)
from employees
group by department_id

             - 다중행 함수의 중첩은 한번만 허용

#### 예시

   -- 집합그룹이 테이블 전체

select count(*)
from employees;

-- 집합그룹이 여러개다 , 직원 테이블에서 부서아이디가 같은 것 끼리 그룹화

select department_id , count(*)
from employees
group by department_id;


 */


-- 커미션을 받는 직원의 수를 조회화기

select count(*)
from employees
where commission_pct is not null;

select count(COMMISSION_PCT)
from employees;


-- 60번 부서의 평균 급여 조회하기
select avg(salary)
from EMPLOYEES
where DEPARTMENT_ID = 60;


-- 80번 부서에 소속된 직원의 급여 총합계 평균급여 최소급여 최대급여 조회

select sum(salary), Trunc(avg(salary)), min(salary), max(salary)
from EMPLOYEES
where DEPARTMENT_ID = 80;


-- 직원들이 종사하고 있는 직업아이디를 중복없이 조회하기
select DISTINCT JOB_ID
from JOBS;

-- 직원들이 종사하고있는 직업 아이디를 중복을 제외한 행갯수 조회
select count(distinct (JOB_ID))
from JOBS;

/*

    그룹화 하기
        Group by절을 사용해서 테이블의 행을 지정된 컬럼의 값이 같은 값을 가지는 행끼리 그룹화 할 수 있다.

        select 컬럼명 , 그룹함수() , 그룹함수 ()
        from 테이블명
        [where 조건식]
        [group by 컬럼명,컬럼명,컬럼명....]
        [order by 컬럼명]
            * group by 절에는 테이블의 행을 그룹화 할 때 기준이 되는 컬럼을 지정한다.
            * group by 절에는 컬럼을 하나 이상 지정할 수 있다.
            * select 절의 컬럼명은 group by 절에 사용한 컬럼명과 동일한 컬럼만 가능하다
            * group by 절을 사용하면 테이블의 행을 그룹화 하고 그룹화된 각 그룹에 다중행 함수를 적용하고 실행시켜
            * 결과를 반환

            * Ex )  부서별 최고급여 , 최저급여 , 평균급여 , 급여 총합을 조회 할 수 있다.
                    직종별 최고급여 , 최저급여 , 평균급여 , 급여 총합 행의 갯수 등을 조회할 수 있다
                    입사년도별 최고급여 , 최저급여 , 평균급여 , 급여 총합을 조회
                    급여등급별 최고급여 , 최저급여 , 평균급여 , 급여 총합을 조회

*/

-- 직종별 사원수를 조회하기
select job_id, count(*)
from EMPLOYEES
group by job_id;

-- 부서별 사원수 조회
select d.DEPARTMENT_NAME, count(*)
from employees e,
     DEPARTMENTS d
where e.DEPARTMENT_ID = d.DEPARTMENT_ID
group by d.DEPARTMENT_NAME;


-- 근무지별 사원수 조회

select ls.CITY, Count(*)
from EMPLOYEES e,
     DEPARTMENTS d,
     LOCATIONS ls
where e.DEPARTMENT_ID = d.DEPARTMENT_ID
  and d.LOCATION_ID = ls.LOCATION_ID
group by ls.CITY;


-- 입사년도별 사원수 조회

select TO_CHAR(HIRE_DATE, 'YYYY'), Count(*)
from EMPLOYEES e
GROUP BY TO_CHAR(HIRE_DATE, 'YYYY')
order by 1;
-- select 첫번쨰 컬럼 기준으로 정렬
-- order by TO_CHAR(HIRE_DATE, 'YYYY');

-- 부서별 입사년도월 사원수 조회하기
-- 부서 id로 그룹 만든 뒤에 입사 연도별로 그룹지정
select DEPARTMENT_ID, to_char(HIRE_DATE, 'YYYY'), Count(*)
from EMPLOYEES e
group by DEPARTMENT_ID, to_char(HIRE_DATE, 'YYYY')
order by 1 asc, 2 asc;


/*

그룹함수 실행결과를 필터링 하기

    select 컬럼명 , 그룹함수()
    from 테이블명
    [where 조건식]
    [group by 컬럼명]
    [having 조건식]
    [order by 컬럼명]
        * having 절은 group by 절과 함께 사용
        * where 절의 조건식에는 그룹함수를 사용할수 없지만 having절의 조건식에는 그룹함수를 사용 할 수 있다.

*/
-- 부서별 직원수를 조회했을 때 직원수가 10명 이상인 부서의 아이디와 직원수를 조회하기

select DEPARTMENT_ID, COUNT(*)
from EMPLOYEES e
group by DEPARTMENT_ID
having count(*) >= 10;

-- 2005년 이전에 입사한 직원들을 부서별로 직원수를 조회하기

select DEPARTMENT_ID, count(*)
from EMPLOYEES
where HIRE_DATE <= '2005-01-01'
group by DEPARTMENT_ID
;

-- - 2005년 이전에 입사한 직원들을 부서별로 직원수를 조회했을 때 직원수가 5명이상인 부서 아이디와 직원수 조회

select DEPARTMENT_ID 부서아이디, count(*) 직원수
from EMPLOYEES
where HIRE_DATE <= '2005-01-01'
group by DEPARTMENT_ID
having count(*) >= 5;

/*
SUB QUERY
서브쿼리

    select 문 내부에 정의된 select 문을 서브쿼리라 한다
    서브쿼리는 where 절의 조건식에서 사용되는 값을 제공한다
    조건식에서 사용되는 값이 sql을 실행 해야만 획득 가능한 값이 경우가 많다.

    select 컬럼 , 컬럼
    from 테이블명
    where 조건식 연산자 ( select 컬럼
                        from 테이블명
                        [where 조건식])


*/


-- 전체의 평균급여 보다 많이 받는 사람 찾기

select EMPLOYEE_ID, FIRST_NAME, trunc(salary)
from EMPLOYEES
where salary > (select trunc(avg(salary))
                from EMPLOYEES);