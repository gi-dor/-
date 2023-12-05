-- 직원들이 수행하는 직종 아이디를 중복없이 전부 조회하기
select DISTINCT JOB_ID
from employees;


-- 다른 직원들에게 보고 받는 매니저들의 아이디를 중복없이 전부 조회하기
select DISTINCT MANAGER_ID
from employees
where manager_id is not null;


-- 보고할 상사없는 직원의 아이디, 이름, 직업아이디를 조회하기
select employee_id, first_name, job_id
from employees
where manager_id is null;


select *
from employees;
-- 커미션을 받는 직원들 중에서 급여를 10000달러 이상 받는 직원의 아이디, 이름, 급여, 커미션을 조회하기
select employee_id, first_name, salary, commission_pct
from employees
where salary >= 10000
  and commission_pct is not null;

-- 2004년도에 직종이 변경된 직원의 아이디, 해당 직종의 업무 시작일, 종료일, 직종아이디를 조회하기
select *
from job_history;

select employee_id, start_date, end_date, JOB_ID
from job_history
where start_date between '2004-01-01' and '2004-12-31';

select employee_id, start_date, end_date, JOB_ID
from job_history
where start_date >= '2004-01-01'
  and start_date < '2005-01-01';


-- 한번이라도 직종이 변경된 적이 있는 직원들의 직원 아이디를 중복없이 조회하기
select distinct employee_id
from job_history;


-- 직원 중에서 100번 상사에게 보고하고, 커미션을 받으며, 급여를 10000달러 이상 받는 직원의 아이디, 이름, 직종아이디, 급여를 조회하기
select *
from employees;

select employee_id, first_name, job_id, salary
from employees
where manager_id = 100
  and commission_pct is not null
  and salary >= 10000;

-- 직원 중에서 2006년 상반기에 입사한 직원의 아이디, 이름, 입사일을 조회하고, 입사일 순으로 오름차순 정렬하기
select *
from job_history;
select *
from employees;

select employee_id, first_name, hire_date
from employees
where hire_date BETWEEN '2006-01-01' and '2006-06-30'
-- where hire_date >= '2006-01-01' and hide_date < '2006-07-01'
order by hire_date asc;


-- 직원 중에서 소속부서가 50, 60, 80번 부서 중의 하나에 속하고, 100번 직원에게 보고하는 직원의 아이디, 이름, 직종아이디, 부서아이디를 조회하기
select employee_id, first_name, job_id, department_id
from employees
where department_id In (50, 60, 80)
  and manager_id = 100;

-- 직원 중에서 직종아이디가  'CLERK'로 끝나고, 급여를 2000불 이상 받는 직원의 아이디, 이름, 급여, 직종아이디를 조회하기
select employee_id, salary, job_id
from employees
where job_id like '%CLERK'
  and salary >= 2000;

-- 부서 소재지 정보에서 일본에 위치하고 있는 소재지의 아이디, 주소, 우편번호, 도시명을 조회하기
select *
from locations;

select location_id, street_address, postal_code, city
from locations
where country_id = 'JP';

-- 부서 소재지 정보에서 우편번호라 누락된 소재지의 아이디, 주소, 도시명을 조회하기
select location_id, street_address, city
from locations
where postal_code is null;

-- 직원 중에서 이름이 'S'로 시작하는 직원의 아이디, 이름을 조회하기
select employee_id, first_name
from employees
where first_name like 'S%';

-- 50번 부서의 소속된 직원들의 직원아이디, 이름, 급여를 조회하고 급여순으로 오름차순 정렬하기

select employee_id, first_name, salary
from employees
where department_id = 50
order by salary;