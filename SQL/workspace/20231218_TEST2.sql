-- employees 테이블에서 사원들의 모든 업무아이디를 조회하기
select distinct JOB_ID
from EMPLOYEES;

-- 급여를 12,000달러 이상 받는 사원의 이름과 급여를 조회하기
select FIRST_NAME, trunc(SALARY)
from EMPLOYEES
where SALARY >= 12000;

-- 사원번호가 176번 사원의 아이디와 이름 직종을 조회하기
select EMPLOYEE_ID, FIRST_NAME, DEPARTMENT_ID, JOB_ID
from EMPLOYEES
where EMPLOYEE_ID = 176;

-- 급여를 12,000달러 이상 15,000달러 이하 받는 사원들의 사원 아이디와 이름과 급여를 조회하기
select EMPLOYEE_ID, FIRST_NAME, trunc(SALARY)
from EMPLOYEES
where SALARY >= 12000
  and SALARY <= 15000;

-- 2005년 1월 1일부터 2005년 6월 30일 사이에 입사한 사원의 아이디, 이름, 업무아이디, 입사일을 조회하기
select EMPLOYEE_ID, FIRST_NAME, JOB_ID, DEPARTMENT_ID, HIRE_DATE
from EMPLOYEES
where TO_CHAR(HIRE_DATE, 'YYYY-MM_DD') >= TO_CHAR('2005-01-01')
  and TO_CHAR(HIRE_DATE, 'YYYY-MM_DD') <= TO_CHAR('2005-06-30')
order by HIRE_DATE;

select FIRST_NAME, HIRE_DATE
from EMPLOYEES
order by HIRE_DATE;

-- 급여가 5,000달러와 12,000달러 사이이고, 부서번호가 20 또는 50인 사원의 이름과 급여를 조회하기
select FIRST_NAME, SALARY
from EMPLOYEES
where DEPARTMENT_ID IN (20, 50)
  and SALARY BETWEEN 5000 AND 12000;

-- 관리자가 없는 사원의 이름과 업무아이디를 조회하기
select FIRST_NAME, JOB_ID, MANAGER_ID
from EMPLOYEES
where MANAGER_ID is null;

-- 커미션을 받는 모든 사원의 이름과 급여, 커미션을 급여 및 커미션의 내림차순으로 정렬해서 조회하기
select FIRST_NAME, trunc(SALARY) 급여, COMMISSION_PCT 커미션, salary + (salary * COMMISSION_PCT) 커미션포함급여
from EMPLOYEES
where COMMISSION_PCT is not null
order by salary desc, COMMISSION_PCT desc;

-- 이름의 2번째 글자가 e인 모든 사원의 이름을 조회하기
select FIRST_NAME
from EMPLOYEES
where FIRST_NAME like '_e%';
-- where substr(FIRST_NAME, 2, 1) = 'e';

-- 업무아이디가 ST_CLERK 또는 SA_REP이고 급여를 2,500달러, 3,500달러, 7,000달러 받는 모든 사원의 이름과 업무아이디, 급여를 조회하기
select FIRST_NAME, EMPLOYEE_ID, trunc(SALARY)
from EMPLOYEES
where JOB_ID IN ('ST_CLERK', 'SA_REP')
  and SALARY IN (2500, 3500, 7000);


-- 모든 사원의 이름과 입사일, 근무 개월 수를 계산하여 조회하기, 근무개월 수는 정수로 반올림하고, 근무개월수를 기준으로 오름차순으로 정렬하기
select FIRST_NAME, HIRE_DATE, ROUND(MONTHS_BETWEEN(SYSDATE, HIRE_DATE), 0) 근무개월수
from EMPLOYEES
order by 근무개월수 asc;


-- 사원의 이름과 커미션을 조회하기, 커미션을 받지 않는 사원은 '없음'으로 표시하기
select FIRST_NAME, NVL(TO_CHAR(COMMISSION_PCT), '없음')
from EMPLOYEES;


-- 모든 사원의 이름, 부서번호, 부서이름을 조회하기
select DEPARTMENT_ID, DEPARTMENT_NAME
from DEPARTMENTS;

-- 80번부서에 소속된 사원의 이름과 업무아이디, 업무제목, 부서이름을 조회하기
select e.FIRST_NAME, d.DEPARTMENT_ID, e.JOB_ID, d.DEPARTMENT_NAME
from DEPARTMENTS d,
     EMPLOYEES e
where e.DEPARTMENT_ID = d.DEPARTMENT_ID
  and e.DEPARTMENT_ID = 80;


-- 커미션을 받는 모든 사원의 이름과 업무아이디, 업무제목, 부서이름, 부서소재지 도시명을 조회하기
select *
from EMPLOYEES
where EMPLOYEE_ID = 178;


select *
from LOCATIONS;


select e.FIRST_NAME, j.JOB_ID, d.DEPARTMENT_ID, d.DEPARTMENT_NAME, l.CITY
from EMPLOYEES e,
     DEPARTMENTS d,
     JOBS j,
     LOCATIONS l
where e.JOB_ID = j.JOB_ID
  and e.DEPARTMENT_ID = d.DEPARTMENT_ID(+)
  and d.LOCATION_ID = l.LOCATION_ID(+)
  and e.COMMISSION_PCT is not null;


-- 유럽에 소재지를 두고 있는 모든 부서아이디와 부서이름을 조회하기
select *
from REGIONS;
select *
from COUNTRIES;
select *
from LOCATIONS;


select d.DEPARTMENT_ID, d.DEPARTMENT_NAME, c.COUNTRY_NAME, l.CITY
from DEPARTMENTS d,
     LOCATIONS l,
     COUNTRIES c,
     REGIONS r
where r.REGION_ID = c.REGION_ID
  and r.REGION_NAME = 'Europe'
  and d.LOCATION_ID = l.LOCATION_ID
  and c.COUNTRY_ID = l.COUNTRY_ID;


-- 사원의 이름과 소속부서명, 급여, 급여 등급을 조회하기
select e.FIRST_NAME, d.DEPARTMENT_NAME, trunc(e.SALARY), g.GRADE
from DEPARTMENTS d,
     SALARY_GRADES g,
     EMPLOYEES e
where e.SALARY <= g.MAX_SALARY
  and e.SALARY >= g.MIN_SALARY
  and e.DEPARTMENT_ID = d.DEPARTMENT_ID(+);


-- 사원의 이름과 소속부서명, 소속부서의 관리자명을 조회하기, 소속부서가 없는 사원은 소속부서명 '없음, 관리자명 '없음'으로 표시하기
select *
from DEPARTMENTS;

select e.FIRST_NAME, NVL(d.DEPARTMENT_NAME, '없음'), NVL(m.first_name, '없음'), d.MANAGER_ID
from EMPLOYEES e,
     DEPARTMENTS d,
     EMPLOYEES m
where e.DEPARTMENT_ID = d.DEPARTMENT_ID(+)
  and d.MANAGER_ID = m.EMPLOYEE_ID(+);


-- 모든 사원의 급여 최고액, 급여 최저액, 급여 총액, 급여 평균액을 조회하기
select max(SALARY), min(SALARY), sum(salary), trunc(avg(SALARY))
from EMPLOYEES;

-- 업무별 급여 최고액, 급여 최저액, 급여 총액, 급여 평균액을 조회하기
select JOB_ID, min(SALARY), max(SALARY), sum(SALARY), avg(SALARY)
from EMPLOYEES e
group by JOB_ID;



-- 풀수 없는문제
-- ==============================================================================================================

-- 각 업무별 사원수를 조회해서 가장 사원수가 많은 업무 3개를 조회하기, 업무아이디와 사원수 표시하기
WITH TEMP1
         as (select JOB_ID, count(*) CNT
             from EMPLOYEES
             group by JOB_ID)
select ROWNUM, job_id, CNT
from (select JOB_ID, CNT
      from TEMP1
      order by CNT DESC)
WHERE ROWNUM <= 3;

-- 관리자별 사원수를 조회하기, 관리자 이름과 그 관리자가 관리하는 사원수 표시하기

SELECT B.FIRST_NAME, A.CNT
FROM (SELECT MANAGER_ID, COUNT(*) CNT
      FROM EMPLOYEES
      WHERE MANAGER_ID IS NOT NULL
      GROUP BY MANAGER_ID) A,
     EMPLOYEES B
WHERE A.MANAGER_ID = B.EMPLOYEE_ID;


-- 각 부서에 대해 부서이름, 관리자 이름, 소속사원 수, 소속사원들의 평균 급여를 조회하기
SELECT D.DEPARTMENT_NAME,
       (SELECT E.FIRST_NAME
        FROM EMPLOYEES E
        WHERE E.EMPLOYEE_ID = D.MANAGER_ID)      MANAGER_NAME,
       (SELECT COUNT(*)
        FROM EMPLOYEES E
        WHERE E.DEPARTMENT_ID = D.DEPARTMENT_ID) CNT,
       (SELECT TRUNC(AVG(E.SALARY)) AVG_SALARY
        FROM EMPLOYEES E
        WHERE E.DEPARTMENT_ID = D.DEPARTMENT_ID) AVG_SALARY
FROM DEPARTMENTS D;


select d.DEPARTMENT_ID, d.DEPARTMENT_NAME, c.CNT, round(a.avg_salary, 0)
from DEPARTMENTS d,
     EMPLOYEES m,
     (select DEPARTMENT_ID, count(*) CNT
      from EMPLOYEES
      group by DEPARTMENT_ID) C,
     (select DEPARTMENT_ID, avg(SALARY) avg_salary
      from EMPLOYEES
      group by DEPARTMENT_ID) A
where d.MANAGER_ID = m.EMPLOYEE_ID
  and d.DEPARTMENT_ID = c.DEPARTMENT_ID
  and d.DEPARTMENT_ID = a.DEPARTMENT_ID;
-- ==============================================================================================================


-- Steven King과 같은 부서에 속한 사원의 이름과 입사일을 조회하기
select e.FIRST_NAME, e.LAST_NAME, e.HIRE_DATE
from EMPLOYEES e
where e.DEPARTMENT_ID = (select e2.DEPARTMENT_ID
                         from EMPLOYEES e2
                         where e2.FIRST_NAME like '%Steven%'
                           and e2.LAST_NAME like '%King%')
  and e.LAST_NAME != 'King';

select FIRST_NAME, LAST_NAME
from EMPLOYEES
where FIRST_NAME = 'Steven';


SELECT FIRST_NAME, HIRE_DATE
FROM EMPLOYEES
WHERE DEPARTMENT_ID = (SELECT DEPARTMENT_ID
                       FROM EMPLOYEES
                       WHERE FIRST_NAME = 'Steven'
                         AND LAST_NAME = 'King');


-- 소속 부서의 평균급여보다 많은 급여를 받는 사원의 아이디와 사원이름, 급여, 그 부서의 평균 급여를 조회하기
SELECT E.EMPLOYEE_ID, E.SALARY, A.AVG_SALARY
FROM (SELECT DEPARTMENT_ID, TRUNC(AVG(SALARY)) AVG_SALARY
      FROM EMPLOYEES
      WHERE DEPARTMENT_ID IS NOT NULL
      GROUP BY DEPARTMENT_ID) A,
     EMPLOYEES E
WHERE A.DEPARTMENT_ID = E.DEPARTMENT_ID
  AND A.AVG_SALARY > E.SALARY;


-- Kochhar과 동일한 급여 모든 사원의 이름과 입사일 급여를 조회하기, 결과에 Kochhar은 포함시키지 않기

select e.FIRST_NAME, e.HIRE_DATE, e.SALARY
from EMPLOYEES e
where e.SALARY = (select e2.SALARY
                  from EMPLOYEES e2
                  where e2.FIRST_NAME like '%Neena%')
  and e.FIRST_NAME != 'Neena';



-- 소속 부서에 입사일이 늦지만, 더 많은 급여를 받는 사원의 이름과 소속부서명, 급여를 조회하기


-------- ================ 풀기 실패 문제-----------------------------------------------
-- 관리자 아이디, 관리자명, 그 관리자가 관리하는 사원수, 그 관리자가 소속된 부서를 조회하기
SELECT EMPLOYEE_ID, FIRST_NAME, C.CNT, D.DEPARTMENT_NAME
FROM EMPLOYEES M,
     (SELECT MANAGER_ID, COUNT(*) CNT
      FROM EMPLOYEES
      WHERE MANAGER_ID IS NOT NULL
      GROUP BY MANAGER_ID) C,
     DEPARTMENTS D
WHERE M.EMPLOYEE_ID IN (SELECT DISTINCT MANAGER_ID
                        FROM EMPLOYEES
                        WHERE MANAGER_ID IS NOT NULL)
  AND M.EMPLOYEE_ID = C.MANAGER_ID
  AND M.DEPARTMENT_ID = D.DEPARTMENT_ID;