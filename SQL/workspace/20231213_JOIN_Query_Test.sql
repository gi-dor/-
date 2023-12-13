select *
from employees;

-- 60번 부서에 소속된 직원들의 아이디, 이름, 관리자의 아이디, 관리자의 이름을 조회하기
--                  E1              E1          E1              E2
select e1.EMPLOYEE_ID 직원아이디, e1.FIRST_NAME 직원이름, e2.EMPLOYEE_ID 관리자아이디, e2.FIRST_NAME 관리자이름
from EMPLOYEES e1,
     EMPLOYEES e2
where e1.MANAGER_ID = e2.EMPLOYEE_ID
  and e1.DEPARTMENT_ID = 60;


-- 60번 부서에 소속된 직원들의 아이디, 이름, 급여, 급여등급을 조회하기
select *
from SALARY_GRADES;
select *
from EMPLOYEES;

select e.EMPLOYEE_ID 직원아이디, e.FIRST_NAME 직원이름, e.SALARY 급여, g.GRADE 급여등급
from EMPLOYEES e,
     SALARY_GRADES g
where e.SALARY <= g.MAX_SALARY
  and e.SALARY >= MIN_SALARY
  and e.DEPARTMENT_ID = 60;



-- 직원들 중에서 자신의 상사보다 먼저 입사한 직원들의 아이디, 이름, 입사일, 관리자의 이름, 관리자의 입사일을 조회하기
--                                           e1         e1  e1      e1          e2
select e1.EMPLOYEE_ID 직원아이디,
       e1.FIRST_NAME  직원이름,
       e1.HIRE_DATE   직원입사일,
       e2.EMPLOYEE_ID 관리자아이디,
       e2.FIRST_NAME,
       e2.HIRE_DATE   관리자입사일
from EMPLOYEES e1,
     EMPLOYEES e2
where e1.MANAGER_ID = e2.EMPLOYEE_ID
  and TO_CHAR(e1.HIRE_DATE, 'YYYY/MM/DD') < TO_CHAR(e2.HIRE_DATE, 'YYYY/MM/DD');


-- 직원들의 직종아이디별 평균급여를 조회해서 직종아이디, 평균급여로 조회하기
-- 단, 평균급여의 소수점부분은 전부 버린다.
-- TRUNC

select job_id, trunc(avg(SALARY)) 평균급여
from EMPLOYEES e
group by job_id
order by JOB_ID;



-- 관리자별(상사)로 담당자는 직원수를 조회해서 관리자 아이디, 직원수를 출력하기
-- 1. 관리자별로 직원수 조회
select *
from EMPLOYEES;

-- 103번 관리자가 몇명 담당하는지 알기위해
select EMPLOYEE_ID, MANAGER_ID
from EMPLOYEES
where MANAGER_ID = 103;


select MANAGER_ID, count(*)
from EMPLOYEES
where MANAGER_ID is not null
group by MANAGER_ID;



-- 직원들의 전체 평균급여보다 급여를 적게 받는 직원들의 아이디, 이름, 급여를 출력하기
-- 1. 직원 전체 평균 구하기
select trunc(avg(SALARY))
from EMPLOYEES;
-- 평균 급여는 6461이 나왔다.

-- 2. 평균급여보다 더 적게 받는 직원 아이디 이름 급여 출력하기ㅣ
select e.EMPLOYEE_ID, e.FIRST_NAME, e.SALARY
from EMPLOYEES e
where SALARY < (select trunc(avg(SALARY)) 전체평균급여
                from EMPLOYEES);


-- 전체 직원의 평균급여보다 2배 이상의 급여를 받는 직원들의 아이디, 이름, 직종아이디, 급여를 조회하기
-- 1.전체 평균의 2배값부터 출력하기
(select trunc(avg(SALARY)) 전체평균급여, trunc(avg(SALARY)) * 2 전체평균급여2배
 from EMPLOYEES);

select e.EMPLOYEE_ID, e.FIRST_NAME, e.DEPARTMENT_ID, e.SALARY
from EMPLOYEES e
where SALARY > (select trunc(avg(SALARY)) * 2 전체평균급여2배
                from EMPLOYEES);


-- 80번 부서에 근무하고, 80번 부서의 최저급여와 동일한 급여를 받는 직원의 아이디, 이름, 직종, 급여를 조회하기
-- 1. 80부서에 근무하는 아이디 이름 직종 급여부터 조회
select e.EMPLOYEE_ID, e.FIRST_NAME, e.DEPARTMENT_ID, trunc(e.SALARY)
from EMPLOYEES e
where DEPARTMENT_ID = 80;

-- 2. 부서별 최저 급여
select DEPARTMENT_ID 부서, min(salary) 최저급여
from EMPLOYEES
group by DEPARTMENT_ID;

-- 3. 부서번호 80 번인놈 최저급여
select DEPARTMENT_ID 부서, min(SALARY) 최저급여
from EMPLOYEES e
group by DEPARTMENT_ID
having DEPARTMENT_ID = 80;

-- 4. 부서번호 80번의 최저급여 받는 사람의 아이디, 이름 , 직종 , 급여 조회
select EMPLOYEE_ID, FIRST_NAME, JOB_ID, SALARY
from EMPLOYEES
where DEPARTMENT_ID = 80
  and SALARY = (select min(SALARY)
                from EMPLOYEES
                where DEPARTMENT_ID = 80);



-- 직원들의 급여등급을 계산해서 급여등급별 직원수를 조회해서 급여등급, 직원수를 출력하기
-- 1. 직원별 급여 등급 조회하기
select e.EMPLOYEE_ID, e.FIRST_NAME, g.GRADE
from EMPLOYEES e,
     SALARY_GRADES g
where e.SALARY >= g.MIN_SALARY
  and e.SALARY <= g.MAX_SALARY;

-- 2. 급여 등급별 직원수 조회
select g.GRADE, count(*)
from EMPLOYEES e,
     SALARY_GRADES g
where e.SALARY >= g.MIN_SALARY
  and e.SALARY <= g.MAX_SALARY
group by g.GRADE;



-- 'Neena'와 같은 해에 입사한 직원들의 아이디, 이름, 입사일을 조회하기

-- 1. Neena 에 대한 정보부터 출력
select *
from EMPLOYEES
where FIRST_NAME like 'Neena';
-- 101,Neena,Kochhar,NKOCHHAR,515.123.4568,2005-09-21,AD_VP,17000.00,,100,90

-- 2. where 절 조건으로 Neena 입사날짜 = 연산자 해보자
select e.EMPLOYEE_ID, e.FIRST_NAME, e.HIRE_DATE
from EMPLOYEES e
where e.EMPLOYEE_ID != 101
  and TO_CHAR(HIRE_DATE, 'YYYY') = (select TO_CHAR(HIRE_DATE, 'YYYY')
                                    from EMPLOYEES
                                    where FIRST_NAME like 'Neena');

