-- 모든 직원의 아이디, 이름, 부서번호, 부서명을 조회하기
select e.EMPLOYEE_ID 아이디, e.FIRST_NAME 이름, e.DEPARTMENT_ID 부서번호, d.DEPARTMENT_NAME 부서명
from Employees e,
     DEPARTMENTS d
where e.DEPARTMENT_ID = d.DEPARTMENT_ID(+);


-- 커미션을 받는 직원의 아이디, 이름, 직종아이디, 급여, 커미션을 조회하기
select e.EMPLOYEE_ID 아이디, e.FIRST_NAME 이름, e.JOB_ID 직종아이디, e.SALARY 급여, e.COMMISSION_PCT 커미션
from EMPLOYEES e
where e.COMMISSION_PCT is not null;


-- 커미션을 받는 직원의 아이디, 이름, 급여, 커미션, 급여등급을 조회하기

select e.EMPLOYEE_ID 직원아이디, e.FIRST_NAME 이름, e.SALARY 급여, e.COMMISSION_PCT 커미션, g.GRADE 급여등급
from EMPLOYEES e,
     SALARY_GRADES g
where e.SALARY <= g.MAX_SALARY
  and e.SALARY >= g.MIN_SALARY
  and e.COMMISSION_PCT is not null;


-- 80번 부서에 소속된 직원들의 평균급여, 최저급여, 최고급여를 조회하기
select trunc(avg(salary)) 평균급여, min(salary) 최소급여, max(SALARY) 최고급여
from EMPLOYEES
group by DEPARTMENT_ID
having DEPARTMENT_ID = 80;


select trunc(avg(SALARY)) 평균급여, min(SALARY) 최소급여, max(SALARY) 최고급여
from EMPLOYEES
where DEPARTMENT_ID = 80;


-- 80번 부서에 소속된 직원들의 직원아이디, 이름, 직종제목, 급여, 직종에 대한 최고급여와 최저급여의 차이
select e.EMPLOYEE_ID 직원아이디,
       e.FIRST_NAME  이름,
       j.JOB_TITLE   "직업 명",
       e.SALARY      급여,
       j.MAX_SALARY - e.SALARY
from EMPLOYEES e,
     JOBS j
where e.JOB_ID = j.JOB_ID -- JOIN 조건
-- 조회 조건
  and e.DEPARTMENT_ID = 80;


-- 각 부서별 최고급여, 최저급여, 최고급여와 최저급여의 차이를 조회하기
select *
from DEPARTMENTS;
select *
from JOBS;

select e.DEPARTMENT_ID, max(SALARY), min(SALARY), max(SALARY) - min(SALARY) as "최고급여 - 최저급여"
from EMPLOYEES e
where DEPARTMENT_ID is not null
group by e.DEPARTMENT_ID;


-- 'Executive' 부서의 모든 직원아이디, 이름, 직종아이디를 조회하기
select *
from DEPARTMENTS;

select e.EMPLOYEE_ID, e.FIRST_NAME, e.JOB_ID
from EMPLOYEES e,
     DEPARTMENTS d
where e.DEPARTMENT_ID = d.DEPARTMENT_ID
  and d.DEPARTMENT_NAME = 'Executive'; -- 조회

select EMPLOYEE_ID, FIRST_NAME, JOB_ID
from EMPLOYEES
where DEPARTMENT_ID IN (select DEPARTMENT_ID
                        from DEPARTMENTS
                        where DEPARTMENT_NAME = 'Executive');


-- 전체 직원의 평균급여보다 급여를 적게 받는 직원의 아이디, 이름, 급여를 조회하기
-- 1.전체 직원의 평균 급여
select avg(SALARY)
from EMPLOYEES; -- 평균급여 6462

select e.EMPLOYEE_ID, e.FIRST_NAME, e.SALARY
from EMPLOYEES e
where e.SALARY < (select avg(e2.SALARY)
                  from EMPLOYEES e2);


-- 'Ismael'과 같은 해에 입사했고, 같은 부서에 근무하고 있는 직원의 아이디, 이름, 입사일을 조회하기

--Ismael 에 입사 날짜 부터 구하자
select e.EMPLOYEE_ID, e.FIRST_NAME, TO_CHAR(e.HIRE_DATE, 'YYYY')
from EMPLOYEES e
where e.FIRST_NAME = 'Ismael';


-----------
select e.EMPLOYEE_ID, e.FIRST_NAME, TO_CHAR(e.HIRE_DATE, 'YYYY')
from EMPLOYEES e
where TO_CHAR(HIRE_DATE, 'YYYY') = (select TO_CHAR(e.HIRE_DATE, 'YYYY')
                                    from EMPLOYEES e
                                    where e.FIRST_NAME = 'Ismael')
  and e.DEPARTMENT_ID = (select DEPARTMENT_ID
                         from EMPLOYEES
                         where FIRST_NAME = 'Ismael');


---------------
select EMPLOYEE_ID, FIRST_NAME, TO_CHAR(HIRE_DATE, 'YYYY')
from EMPLOYEES
where (DEPARTMENT_ID, TO_CHAR(HIRE_DATE, 'YYYY')) IN
      (Select DEPARTMENT_ID, TO_CHAR(HIRE_DATE, 'YYYY')
       from EMPLOYEES
       where FIRST_NAME = 'Ismael');



-- 부서별 최고급여를 조회했을 때 최고급여가 15000을 넘는 부서의 아이디와 최고급여를 조회하기

-- 1. 부서별 최고급여 구하기
select e.DEPARTMENT_ID, max(SALARY)
from EMPLOYEES e
group by e.DEPARTMENT_ID;

--2.  최고급여 15000 넘는 부서 찾기
select e.DEPARTMENT_ID, max(SALARY)
from EMPLOYEES e
group by e.DEPARTMENT_ID
having max(SALARY) > 15000;



-- 'Neena'보다 급여을 많이 받는 직원의 아이디, 이름, 직종아이디, 급여를 조회하기

-- 1. Neena 급여 구하기
select EMPLOYEE_ID, FIRST_NAME, SALARY
from EMPLOYEES
where FIRST_NAME = 'Neena';

select FIRST_NAME, SALARY
from EMPLOYEES
order by SALARY desc;

select e.EMPLOYEE_ID, e.FIRST_NAME, e.JOB_ID, e.SALARY
from EMPLOYEES e
where SALARY > (select SALARY
                from EMPLOYEES
                where FIRST_NAME = 'Neena');


-- 급여등급별로 직원수를 조회하기
select g.GRADE, count(*)
from EMPLOYEES e,
     SALARY_GRADES g
where e.SALARY <= g.MAX_SALARY
  and e.SALARY >= g.MIN_SALARY
group by g.GRADE;


-- 부서별 평균급여를 계산했을 그 부서의 평균급여보다 급여를 적게 받는 직원의 아이디, 이름, 급여, 부서명을 조회하기
-- 1. 부서별 평균구하기
select DEPARTMENT_ID, trunc(avg(SALARY))
from EMPLOYEES
where DEPARTMENT_ID = 60 -- 60번부서 평균급여 5760
group by DEPARTMENT_ID;


/**
* 오답
-- 2. 부서별 평균 급여보다 적게 받는놈 구하기
select e.EMPLOYEE_ID, e.FIRST_NAME, e.SALARY, d.DEPARTMENT_NAME, d.DEPARTMENT_ID
from EMPLOYEES e,
     DEPARTMENTS d
where SALARY < (select trunc(avg(SALARY))
                from EMPLOYEES e2)
  and e.DEPARTMENT_ID = d.DEPARTMENT_ID;
*/

select B.EMPLOYEE_ID, B.FIRST_NAME, B.SALARY, C.DEPARTMENT_NAME
from (select DEPARTMENT_ID, trunc(avg(SALARY)) as avg_Salary
      from EMPLOYEES
      where DEPARTMENT_ID is not null
      group by DEPARTMENT_ID) A,
     EMPLOYEES B,
     DEPARTMENTS C
where A.DEPARTMENT_ID = B.DEPARTMENT_ID
  and A.avg_Salary > B.salary
  and B.DEPARTMENT_ID = C.DEPARTMENT_ID;



-- 'Ismael' 직원이 근무하는 부서의 아이디와 이름을 조회하기(서브쿼리)
-- 1. Isamael 정보 조회
select EMPLOYEE_ID, FIRST_NAME, DEPARTMENT_ID
from EMPLOYEES
where FIRST_NAME = 'Ismael';
-- Isamael 부서번호 100번

-- 2. 부서번호 100에 일하는 놈들 조회
select *
from EMPLOYEES
where DEPARTMENT_ID = 100;

select d.DEPARTMENT_ID, d.DEPARTMENT_NAME
from DEPARTMENTS d
where d.DEPARTMENT_ID = (select DEPARTMENT_ID
                         from EMPLOYEES
                         where FIRST_NAME = 'Ismael');

select d.DEPARTMENT_ID, d.DEPARTMENT_NAME
from EMPLOYEES e,
     DEPARTMENTS d
where E.FIRST_NAME = 'Ismael'
  and e.DEPARTMENT_ID = d.DEPARTMENT_ID;



-- 'Neena'에게 보고하는 직원의 아이디와 이름을 조회하기(서브쿼리)
-- manager_id 가 Neena
select e.EMPLOYEE_ID 직원아이디, e.FIRST_NAME 직원이름, e.MANAGER_ID 담당자, e2.FIRST_NAME 담당자이름
from EMPLOYEES e,
     EMPLOYEES e2
where e.MANAGER_ID = e2.EMPLOYEE_ID
  and e2.FIRST_NAME = (select FIRST_NAME
                       from EMPLOYEES
                       where FIRST_NAME = 'Neena');



-- 부서별 평균급여를 계산했을 때 'Ismael'이 근무하는 부서의 평균급여보다 급여를 많이 받는 부서의 아이디와 평균급여를 조회하기(GROUP BY, 인라인뷰, 서브쿼리)

-- 부서별 평균 급여
select DEPARTMENT_ID, trunc(avg(SALARY)) avg_salary
from EMPLOYEES
group by DEPARTMENT_ID;


--
select DEPARTMENT_ID, trunc(avg(SALARY)) as avg_salary
from EMPLOYEES
group by DEPARTMENT_ID
having avg(SALARY) > (select trunc(avg(SALARY))
                      from EMPLOYEES
                      where DEPARTMENT_ID = (select DEPARTMENT_ID
                                             from EMPLOYEES
                                             where FIRST_NAME = 'Ismael'));



select trunc(avg(SALARY))
from EMPLOYEES
where DEPARTMENT_ID = 100;



/*
    오답
*/
-- 부서별 평균급여를 계산했을 때 'Ismael'이 근무하는 부서의 평균급여보다 급여를 많이 받는 부서의 아이디와 평균급여를 조회하기(GROUP BY, 인라인뷰, 서브쿼리)

/*
-- Ismael  급여 구하기
select SALARY, DEPARTMENT_ID
from EMPLOYEES
where FIRST_NAME = 'Ismael';
-- 7700 101번 부서

-- 부서별 평균 급여
select DEPARTMENT_ID, trunc(avg(SALARY))
from EMPLOYEES
group by DEPARTMENT_ID;

--  'Ismael'이 근무하는 부서의 평균급여
select e.DEPARTMENT_ID
from EMPLOYEES e
where e.FIRST_NAME = 'Ismael';

select trunc(avg(SALARY))
from EMPLOYEES
where DEPARTMENT_ID = 100;

-- Isamael 부서아이디 , 부서평균급여  -- 8601
select DEPARTMENT_ID, trunc(avg(SALARY))
from EMPLOYEES
where DEPARTMENT_ID = (select e.DEPARTMENT_ID
                       from EMPLOYEES e
                       where e.FIRST_NAME = 'Ismael')
group by DEPARTMENT_ID;

-- View 만들기 ?
CREATE OR REPLACE VIEW Ismael_View
AS
(
select DEPARTMENT_ID, trunc(avg(SALARY)) as 평규급여
from EMPLOYEES
where DEPARTMENT_ID = (select e.DEPARTMENT_ID
                       from EMPLOYEES e
                       where e.FIRST_NAME = 'Ismael')
group by DEPARTMENT_ID)
WITH READ ONLY;

select *
from Ismael_View;

---------------------------------------------------------------

select e.DEPARTMENT_ID, trunc(avg(SALARY))
from EMPLOYEES e
where SALARY > (Select 평규급여
                from Ismael_View)
group by DEPARTMENT_ID;



select DEPARTMENT_ID, avg(SALARY)
from EMPLOYEES
group by DEPARTMENT_ID
having avg(SALARY) > 8601;
 */