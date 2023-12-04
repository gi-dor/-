/*

 테이블의 데이터 조회
--  1. 지정된 테이블의 모든 행, 모든 열을 조회한다
*/

select *
from regions;

// 국가 테일블의 모든행 , 모든열 조회
select *
from countries;

// 직종 테이블의 모든 행 , 모든열 조회
select *
from jobs;

//  부서 테이블의 모든 행 , 열 조회
select *
from departments;

// 직원 테이블의 모든 행 모든열 조회

select *
from employees;

// 직종 테이블에서 직종 아이디 , 최소급여 ㅡ 최대 급여 조회하기
select job_id , Min_salary, Max_salary
from jobs;

// 직원 테이블에서 직원 아이디 , 직원이름 , 급여 조회하기
select Employee_id , FIRST_Name , SALARY
from Employees;


// 소재지 테이블에서 소재지 아이디 , 주소 , 도시명 조회하기
select location_id , street_address , city
from locations;

// SELECT 절에서 산술연산을 할수 있다.
// select 컬럼명 * 숫자 , 컬럼명 * 숫자 .....
    // from 테이블명;

// 별칭 부여하기 Alias
/*
select 컬럼명 as 별칭 , 컬럼명 as 별칭
from 테이블명

select 컬럼명 별칭 , 컬럼명 별칭
from 테이블명
*/

select job_id , job_title ,   min_salary ,(min_salary * 12) as 최소연봉 , max_salary , max_salary * 12 as 최대연봉
from jobs;

select employee_id , first_name 이름 , last_name 성 , salary  급여 , salary * 12  연봉
from employees;

/*
     직원 테이블에서 직원 아이디 , 직원 이름 , 급여 , 연봉 조회
     연봉은 급여 * 12
     연병 별칭은 ANNUAL_SALARY
*/
select * from employees;
select employee_id , first_name , salary , salary * 12 as ANNUAL_SALARY
from employees;

// 직업 테이블에서 직업 아이디 , 최대급여 , 최저급여 , 최대급여와 최저급여의 차이 조회
// 최대 급여와 최저 급여의 차이는 SALARY_GAP 으로 별칭
select * from jobs;
select job_id , max_salary , min_salary , max_salary - min_salary as SALARY_GAP
from jobs;


/*
데이터 필터링 하기
1.
where 절 조건식 작성해서 해당 조건식에 만족시키는 행만 조회하기
select 컬럼명 , 컬럼명 , 컬럼명...
from 테이블명
where 조건식;

2. where 절에서 2개 이상의 조건으로 데이터를 필터링
2개 이상의 조건식을 작성할 때는 and , or , not 논리 연산자를 사용
select 컬럼명 , 컬럼명 , 컬럼명....
from 테이블명
where 조건식1 and 조건식2;
+ 조건식1과 조건식2가 모두 true로 판정되는 행만 조회

select 컬럼명 , 컬럼명 , 컬럼명....
from 테이블명
where 조건식1 or 조건식2;
+ 조건식1과 조건식2 중에서 하나라도 true로 판정되는 행만 조회

select 컬럼명 , 컬럼명 , 컬럼명....
from 테이블명
where 조건식1 and (조건식2 or 조건식3);
+ and 연산자와 or 연산자를 같이 사용 할 때는 or 연산식을 괄호로 묶는다

*/

// 직원 테이블에서 소속 부서 아이디가 60번인 직원의 아이디 , 이름 , 직종아이디 조회
select * from Employees;
select employee_id , first_name , last_name , job_id
from employees
where department_id = 60;

// 직원 테이블에서 급여를 10000달러 이상 받는 직원의
// 아이디 , 이름 , 직종아이디 ,급여 조회

select employee_id , first_name , salary
from employees
where salary >= 10000;

-- 직원 테이블에서 직종 아이디가 'SA_MAN'인 직원의 아이디 , 이름, 급여 , 소속부서 아이디 조회
select employee_id , first_name , salary , department_id
from employees
--where job_id = "SA_MAN";  invalid identifier"
where job_id = 'SA_MAN';


// 직원 테이블에서 급여를 5000 ~ 10000에 속하는 직원 아이디 , 이름 ,직종아이디 , 급여 조회
select * from employees;
select employee_id , first_name , job_id , salary
from employees
where 10000 >= salary
  and salary >= 5000;

-- 직원 테이블에서 10번 부서 , 20번부서 ,30번부서에서 근무하는 직원 아이디 ,이름 , 부서아이디 조회
select  employee_id , first_name , department_id
from employees
where department_id = 10 or department_id = 20 or department_id = 30;