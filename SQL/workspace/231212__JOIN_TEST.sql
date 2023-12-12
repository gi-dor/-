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


-- 급여가 12000을 넘는 직원의 아이디, 이름, 급여를 조회하기
select *
from employees;
select employee_id, first_name, salary
from employees
where salary >= 12000;


-- 급여가 5000이상 12000이하인 직원의 아이디, 이름, 급여를 조회하기
select employee_id, first_name, salary
from employees
where salary <= 12000
  and salary >= 5000;

-- 2007년에 입사한 직원의 아이디, 이름, 입사일을 조회하기
select employee_id, first_name, hire_date
from employees
where hire_date >= '2007-01-01'
  and hire_date <= '2007-12-31';

select employee_id, first_name, hire_date
from EMPLOYEES
where TO_CHAR(HIRE_DATE, 'YYYY') = '2007';

-- 20번 혹은 50번 부서에 소속된 직원의 이름과 부서번호를 조회하고, 이름을 알파벳순으로 정렬해서 조회하기
select *
from employees;
select *
from DEPARTMENTS;

select first_name, DEPARTMENT_ID
from employees
where department_id = 20
   or department_id = 50
order by first_name asc;


select first_name, DEPARTMENT_ID
from employees
where department_id IN (20, 50)
order by first_name asc;

select first_name
from employees
where department_id IN (20, 50)
order by first_name asc;


-- 급여가 5000이상 12000이하고, 20번 혹은 50번 부서에 소속된 사원의 이름과 급여, 부서번호를 조회하기
select first_name, salary, department_id
from employees
where salary <= 12000
  and salary >= 5000
  and department_id IN (20, 50);

select first_name, salary, department_id
from employees
where salary BETWEEN 5000 and 12000
  and department_id IN (20, 50);


-- 관리자가 없는 직원의 이름과 직종, 급여를 조회하기
-- manager_id = null , first_name , salary
select first_name, job_id, salary, manager_id
from employees
where manager_id is null;

-- 직종이 'SA_MAN'이거나 'ST_MAN'인 직원중에서 급여를 8000이상 받는 직원의 아이디, 이름, 직종, 급여를 조회하기
select employee_id, first_name, salary, job_id
from employees
where (job_id like 'SA_MAN'
    OR job_id like 'ST_MAN')
  and salary >= 8000;


select employee_id, first_name, salary, job_id
from employees
where job_id IN ('ST_MAN', 'SA_MAN')
  and salary >= 8000;


-- 모든 직원의 이름, 직종아이디, 급여, 소속부서명을 조회하기
select *
from employees;
select *
from departments;

select e.first_name, e.employee_id, e.job_id, e.salary, d.department_name
from employees e,
     departments d
where e.department_id = d.department_id(+);
-- OUTER JOIN


-- 모든 직원의 이름, 직종아이디, 직종제목, 급여, 최소급여, 최대급여를 조회하기
--          E       E                  E
--                  J           J           J       J

select *
from salary_grades;

select e.first_name, e.employee_id, e.salary, g.min_salary, g.max_salary
from employees e,
     salary_grades g
where e.salary >= g.min_salary
  and e.salary <= g.max_salary;



-- 모든 직원의 이름, 직종아이디, 직종제목, 급여, 최소급여와 본인 급여의 차이를 조회하기
--          E       E                  E              E  (E-J)
--                  J            J              J      J  (E-J)
select *
from jobs;
select *
from salary_grades;


select e.first_name, e.EMPLOYEE_ID, e.job_id, j.job_title, e.salary, e.salary - j.min_salary GAP
from employees e,
     jobs j
where e.job_id = j.job_id;


-- 커미션을 받는 모든 직원의 아이디, 이름, 부서이름, 소속부서의 소재지(도시명)을 조회하기
--  E               E           E       D       L

select *
from employees
where commission_pct is not null;

select *
from locations;
select *
from departments;

select e.employee_id, e.first_name, d.department_name, lo.city, e.commission_pct
from employees e,
     locations lo,
     departments d
where e.department_id = d.department_id(+)
  and d.location_id = lo.location_id(+)
  and e.commission_pct is not null;


-- 이름이 A나 a로 시작하는 모든 직원의 이름과 직종아이디, 직종제목, 급여, 소속부서명을 조회하기
select *
from jobs;
select *
from departments;
select *
from employees;

select e.first_name, e.job_id, j.job_title, e.salary, d.department_name
from employees e,
     departments d,
     jobs j
where j.job_id = e.job_id
  and d.department_id = e.department_id
  and (e.first_name like 'A%'
    OR e.first_name Like 'a%');


-- 30, 60, 90번 부서에 소속되어 있는 직원들 중에서 100에게 보고하는 직원들의 이름, 직종아이디, 급여, 급여등급을 조회하기
select *
from salary_grades;
select *
from departments;
select *
from employees;
select *
from employees
where manager_id = 100;


select e.employee_id, e.job_id, e.salary, g.grade, e.manager_id
from employees e,
     jobs j,
     SALARY_GRADES g,
     DEPARTMENTS d
where e.department_id = 80
  and e.job_id = j.job_id
  and e.salary >= g.min_salary
  and e.salary <= g.max_salary
  and e.department_id = d.department_id(+);


-- 80번 부서에 소속된 직원들의 이름, 직종아이디, 직종제목, 급여, 최소급여, 최대급여, 급여등급, 소속부서명을 조회하기
select *
from employees;
select *
from jobs;
select *
from departments;
select *
from salary_grades;

select e.first_name,
       e.job_id,
       j.job_title,
       e.salary,
       j.min_salary,
       j.max_salary,
       g.grade,
       d.department_name
from employees e,
     salary_grades g,
     jobs j,
     departments d
where e.job_id = j.job_id
  and e.DEPARTMENT_ID = 80
  and e.department_id = d.department_id(+)
  and e.salary >= g.min_salary
  and e.salary <= g.max_salary;


-- 'ST_CLERK'로 근무하다가 다른 직종으로 변경한 직원의 아이디, 이름, 변경전 부서명, 현재 직종아이디, 현재 근무부서명을 조회하기
select *
from job_history;
select *
from employees;

select e.employee_id,
       e.first_name,
       h.job_id           as 이전직종,
       e.job_id           as 현재직종,
       d1.department_name as 예전부서,
       d2.department_name as 현재부서
from job_history h,  -- 직종 변경 이력정보 (예전직종 , 이전소속부서아이디)
     employees e,    -- 직원정보 (현재직종 , 현재소속부서 아이디)
     departments d1, -- 예전소속부서 정보
     departments d2  -- 현재 소속부서 정보
where h.job_id = 'ST_CLERK'
  and h.employee_id = e.employee_id
  and h.department_id = d1.department_id
  and e.department_id = d2.department_id;


-- 'IT' 부서에서 근무하는 직원의 아이디, 이름을 조회하기
select *
from employees;
select *
from DEPARTMENTS;

select e.EMPLOYEE_ID, e.FIRST_NAME, d.DEPARTMENT_NAME, e.JOB_ID
from employees e,
     DEPARTMENTS d
where d.department_name = 'IT'
  and d.DEPARTMENT_ID = e.DEPARTMENT_ID;


-- 직원들이 근무 중인 도시명을 중복없이 조회하기
select *
from locations;
select *
from departments;

select DISTINCT ls.city, ls.LOCATION_ID
-- , e.EMPLOYEE_ID, e.FIRST_NAME, d.DEPARTMENT_NAME, d.DEPARTMENT_ID
from employees e,
     locations ls,
     departments d
where d.location_id = ls.location_id
  and e.department_id = d.department_id(+);


-- 급여로 급여등급을 산정했을 때 'A' 등급에 해당되는 직원들의 아이디, 이름, 급여, 직종을 조회하기
select *
from jobs;
select *
from salary_grades;

select e.employee_id, e.first_name, e.salary, g.grade, j.job_title
from employees e,
     jobs j,
     salary_grades g
where e.salary <= g.max_salary
  and e.salary >= g.min_salary
  and e.job_id = j.job_id
  and g.grade = 'A'
order by e.employee_id;


-- 200번 직원이 관리하는 부서에서 근무하는 직원의 아이디, 이름, 직종을 조회하기
select *
from departments
where manager_id = 200;
select *
from departments;
select *
from employees;
select *
from jobs;

select e.employee_id, e.first_name, j.job_title, d.manager_id
from employees e,
     jobs j,
     departments d
where e.job_id = j.job_id
  and e.department_id = d.department_id
  and d.manager_id = 200;

select e.employee_id, e.first_name, e.JOB_ID, d.MANAGER_ID
from employees e,
     departments d
where d.manager_id = 200
  and e.department_id = d.department_id;

-- 모든 직원의 아이디, 이름, 급여, 커미션이 고려한 급여, 급여등급, 직종아이디, 소속부서아이디, 소속부서명, 근무지 도시명을 조회하기
--  커미션이 포함된 급여  =  급여 + (급여 * 커미션 포인트)
select *
from departments;
select *
from employees;
select *
from salary_grades;
select *
from locations;
select *
from jobs;


select e.employee_id,
       e.first_name,
       e.salary,
       e.salary + e.salary * NVL(e.commission_pct, 0) as 커미션포함,
       g.grade,
       e.job_id,
       d.department_id,
       d.department_name,
       l.city
from employees e,
     salary_grades g,
     departments d,
     locations l
where e.salary <= g.max_salary
  and e.salary >= g.min_salary
  and e.department_id = d.department_id(+)
  and d.location_id = l.location_id(+)
order by employee_id;


select *
from employees
where employee_id = 178;


