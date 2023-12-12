/*
테이블 JOIN

    select *
    from 테이블 1, 테이블2;
    * 테이블의 조인은 조인대상이 되는 테이블의 이름을 FROM절에 나열하기만 하면 된다.
    * 별도의 조건이 없으면 테이블1의 모든행과 테이블2의 모든행이 연결된 가상의 테이블이 생성된다.
    * ( 테이블1의 행 갯수 * 테이블2의 행갯수 ) 만큼의 행이 조회된다

조인조건 지정하기
    select *
    from 테이블1 , 테이블2
    where 테이블1.컬럼명 = 테이블2.컬럼명2;
    * 조인된 테이블의 모든 행에서 조인조건을 만족하는 행이 의미있게 연결되는 행
    * 조인조건을 지정하면 의미있게 연결된 행만 조회할 수 있다.
    * 조인조건의 갯수 = 조인된 테이블의 갯수 - 1

*/

-- REGIONS 테이블과 COUNTRIES 테이블 JOIN
-- REGIONS 테이블의 모든 행과 COUNTRIES 테이블의 모든행 JOIN
select *
from regions,
     countries;

-- REGIONS 테이블과 COUNTRIES 테이블 JOIN , 서로 연관있는 행만 필터링
select c.country_id,
       c.country_name,
       r.region_name
from regions r,
     countries c
where r.region_id = c.region_id;

-- 직원 아이디 , 직원 이름 , 직종아이디 , 직종최소급여 , 직종최대급여 , 급여조회하기
select *
from employees;
select *
from jobs;

select e.employee_id,
       e.first_name,
       e.job_id,
       j.min_salary,
       j.max_salary,
       e.salary
from employees e,
     jobs j
where e.job_id = j.job_id;



/*
등가조인 EQUI JOIN
    조인 조건에서 Equal (=)연산자를 사용한다.
    조인에 참여하는 테이블에서 같은 값을 가지고있는 행끼리 조인한다.


    Oracle 등가조인
        select a.컬럼명 , a.컬럼명 , b.컬럼명 , b.컬럼명...
        from 테이블 A , 테이블 B
        where A.컬럼명 = B.컬럼명;

    ANSI SQL 등가조인
        select a.컬럼명 , a.컬럼명 , b.컬럼명 , b.컬럼명...
        from 테이블 A JOIN 테이블 B
        ON A.컬럼명 = B.컬럼명;
*/

-- 직원아이디,직원이름, 소속부서아이디 , 소속부서명 조회
select *
from employees;
select *
from departments;

-- Oracle의 등가조인
select e.employee_id,
       e.first_name,
       e.department_id,
       d.department_name
from employees e,
     departments d
where e.department_id = d.department_id;


--ANSI SQL의 등가조인
select e.employee_id,
       e.first_name,
       e.department_id,
       d.department_name
from employees e
         JOIN departments d
              ON e.department_id = d.department_id;


-- 부서관리자가 지정된 부서의 부서아이디 , 부서명 , 부서관리자명 조회하기
--                          D       D           D
--                                              E
select *
from employees;
select *
from departments;

-- Oracle 버전
select d.department_id, d.department_name, e.first_name
from employees e,
     departments d
where d.department_id = e.department_id;

-- ANSI 버전
select d.department_id, d.department_name, e.first_name
from employees e
         JOIN departments d
              ON d.department_id = e.department_id
where d.manager_id is not null;

-- 직원의 아이디 이름  소속부서아이디 소속부서명 직종아이디 직종이름 급여 조회
--      E       E       E                   E              E
--              D                   D
--                                          J       J
select *
from employees;
select *
from jobs;
select *
from departments;

select e.employee_id,
       e.first_name,
       e.department_id,
       d.department_name,
       j.job_id,
       j.job_title,
       e.salary
from employees e,
     jobs j,
     departments d
where e.job_id = j.job_id
  and e.department_id = d.department_id;

-- ANSI 버전
select e.employee_id,
       e.first_name,
       e.department_id,
       d.department_name,
       j.job_id,
       j.job_title,
       e.salary
from employees e
         JOIN jobs j ON e.job_id = j.job_id
         JOIN departments d ON e.department_id = d.department_id;



-- 직원 아이디 , 직원이름 , 근무지역 도시명 조회
--  E           E
--                          L

select *
from employees;
select *
from locations;
select *
from departments;

select e.employee_id, e.first_name, l.city
from employees e,
     departments d,
     locations l
where e.department_id = d.department_id
  and d.location_id = l.location_id;


/*
비등가조인용 샘플 테이블 추가
*/

CREATE TABLE SALARY_GRADES
(
    GRADE      CHAR(1) PRIMARY KEY,
    MIN_SALARY NUMBER(8, 2),
    MAX_SALARY NUMBER(8, 2)
);

INSERT INTO SALARY_GRADES
VALUES ('A', 0, 2499);
INSERT INTO SALARY_GRADES
VALUES ('B', 2500, 4999);
INSERT INTO SALARY_GRADES
VALUES ('C', 5000, 9999);
INSERT INTO SALARY_GRADES
VALUES ('D', 10000, 19999);
INSERT INTO SALARY_GRADES
VALUES ('E', 20000, 39999);

commit;
select *
from salary_grades;


/*  NON_EQUI JOIN
    비등가 조인 - 등급을 판단
        조인 조건을 지정할 때 조인 대상테이블에서 같은 값을 가진 데이터를 가져오는대신,
        크거나 작은 경우의 조건으로 데이터를 조회하는 조인방식이 비등가 조인 이다
*/

-- 직원아이디 , 직원 이름    ,    급여   ,    급여 등급 조회
--  E           E           E
--                         G(최소/최대)       G
select *
from employees;
select *
from SALARY_GRADES;

select e.employee_id,
       e.first_name,
       e.salary,
       g.grade,
       g.min_salary,
       g.max_salary
from employees e,
     salary_grades g;



select e.employee_id,
       e.first_name,
       e.salary,
       g.grade
from employees e,
     SALARY_GRADES g
where e.salary <= max_salary
  and e.salary >= min_salary
order by e.employee_id;


--ANSI SQL
select e.employee_id,
       e.first_name,
       e.salary,
       g.grade
from employees e
         JOIN salary_grades g
              ON e.salary <= max_salary
                  and e.salary >= min_salary
order by e.employee_id;


/*
포괄조인 Outer JOIN
    한쪽 테이블에만 데이터가 있고 , 다른 쪽 테이블에 조인 조건을 만족하는 데이터가 없는 경우
    조인에 참여하지 못하기 때문에 해당 행은 조회되지 않는다
    데이터가 없는 경우에도 데이터가 있는 쪽 테이믈의 모든 행을 조회하는
*/

-- 부서 아이디 , 부서이름 , 부서관리자 아이디 , 부서관리자 이름
--      D       D       D - manager_id
--                      E - employee_id           E - first_name
select *
from departments;
select *
from employees;

select d.department_id, d.department_name, d.manager_id, e.first_name
from employees e,
     departments d
where e.employee_id(+) = d.manager_id
order by d.department_id;



-- 직원의 아이디 , 직원의 이름 , 소속부서 아이디 , 소속부서명 조회하기
--  E               E       E
--                          D               D
select *
from employees;
select *
from departments;

select e.employee_id, e.first_name, e.department_id, d.department_name
from employees e,
     departments d
where e.department_id = d.department_id;
-- 총107개인데 106개가 조회됨

select *
from employees
where employee_id = 178;
-- 178번에 department_id 가 null

select e.employee_id, e.first_name, e.department_id, d.department_name
from employees e,
     departments d
where e.department_id = d.department_id(+);


-- ANSI 버전
select e.employee_id,
       e.first_name,
       e.department_id,
       d.department_name
from employees e
         LEFT OUTER JOIN departments d -- LEFT OUTER JOIN은 선행테이블의 모든 행을 조회한다
                         ON e.department_id = d.department_id;


/*

//          ORACLE                  ANSI

// Table1의 모든 행이 조회
SELECT *                        select *
FROM TABLE1 A , TABLE2 B         from TABLE1 A
WHERE A.COLUMN = B.COLOMN(+);   LEFT OUTER JOIN TABLE2 B
                                ON A.COLUMN = B.COLUMN;
// Table2의 모든행이 조회
select *                        select *
from table1 A, table2           from table1 A
where a.column(+) = b.column    right outer JOIN table2 B
                                on A.COLUMN = B.COLUMN;

// TABLE1 과 TABLE2의 모든행이 조회
select *                            select *
from table1 A , table2 B            from table1 A
where A.column(+) = b.column(+);    FULL OUTER JOIN table2 B
                                    on A.column = B.column;

** 오라클은 FULL OUTER JOIN 허용 안함
*/


/*
SELF JOIN

자체 조인

- JOIN 대상이 되는 테이블이 같은 테이블 일 때 발생 ㅡ 서로 연관지어서 조회할 때 사용
- 하나의 테이블을 이용해서 JOIN구성 , 조회하는 컬럼명이 동일한 경우가 발생할 수 있음
    + ✔ 별칭 적절히 사용
- 서로 역할을 각각 나누어 별칭을 정하고 그 역할에 맞게 JOIN 조건 정의

 */

-- emplpyees 테이블에서 직원아이디 , 직원이름 , 해당직원의 상사아이디 , 상사 이름 조회

select emp.employee_id as emp_id,
       emp.first_name  as emp_name,
       mgr.employee_id as mgr_id,
       mgr.first_name  as mgr_name
from employees emp,
     employees mgr
where emp.manager_id = mgr.employee_id;


-- 직원 아이디, 직원 이름 , 직원의 소속부서명 , 상사의 아이디 , 상사의 이름 , 상사의 소속부서명
--      E       E               E           E
--                              D1                                      D2
--                                           M          M
select *
from DEPARTMENTS;

select emp.EMPLOYEE_ID    직원아이디,
       emp.FIRST_NAME     직원이름,
       d1.DEPARTMENT_NAME 직원의소속부서,
       mgr.EMPLOYEE_ID    상사아이디,
       mgr.FIRST_NAME     상사이름,
       d2.DEPARTMENT_NAME 상사의부서
from employees emp,  -- 직원
     employees mgr,  -- 관리자
     departments d1, -- 직원 부서
     departments d2  -- 관리자 부서
where emp.MANAGER_ID = mgr.EMPLOYEE_ID(+)
  and emp.department_id = d1.DEPARTMENT_ID (+)
  and mgr.DEPARTMENT_ID = d2.DEPARTMENT_ID (+)
order by emp.EMPLOYEE_ID;