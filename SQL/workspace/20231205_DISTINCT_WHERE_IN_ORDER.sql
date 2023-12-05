/*
    중복된 행을 한번만 조회하기
        DISTINCT
    select DISTINCT 컬럼명 , 컬럼명 ,....
    from 테이블명;
    지정된 컬럼들이 서로같은 값을 가지는 행은 한번만 조회한다.
*/

-- 직원 테이블에서 직원들이 종사하는 직종 아이디 조회
-- 50개행 출력됨
select job_id
from employees;

-- 50개 행에서 19개 행으로 바뀌었다
select DISTINCT job_id
from employees;

-- 2개의 컬럼 모두 중복이 되야 DISTINCT 적용됨
select DISTINCT job_id, EMPLOYEE_ID
from employees;

-- 직종변경 이력 테이블에서 직종을 한번이라도 변경한 적이 있는 직원의 아이디를 조회하기
select DISTINCT employee_id
from job_history;

------------------------------------------------------------------------------------

/*
조회 결과를 정렬하기
select 컬럼명  , 컬럼명
from 테이블명
[where 조건식]
[order by {컬럼명} [asc / desc]]
* order by 절을 사용하면 조회결과를 오름차순 혹은 내림차순으로 정렬할수 있다
* order by 절에 컬럼명이 오면 해당 컬럼의 값을 기준으로 행들을 오름차순 내림차순으로 정렬한다
* asc 오름차순  - 생략가능  desc 내림차순

 여러 컬럼의 값을 기준으로 정렬하기
select 컬럼명  , 컬럼명
from 테이블명
[where 조건식]
[order by {컬럼명} [asc / desc] , {컬럼명} [asc / desc] ]
 */

-- 직원테이블에서 직원아이디 , 이름 , 급여를 조회한다 단, 급여를 내림차순으로 정렬해서 조회하기
select employee_id, first_name, salary
from employees
order by salary desc;


-- 직원 테이블에서 60번 부서에 소속된 직원들의 아이디 이름 급여를 조회하고 급여순으로 오름차순 정렬해서 조회하기
select *
from employees; -- 테이블에 어떤컬럼이 있는지 먼저 전체 조회
select employee_id, first_name, salary
from employees
where department_id = 60
order by salary asc;


-- 직원 테이블에서 50번 부서에 소속된 직원의 아이디 , 이름 , 입사일 , 급요를 조회
-- 단 입사일 기준으로 오름차순으로 정렬조회
select *
from employees;
select employee_id, first_name, hire_date, salary
from employees
where department_id = 50
order by hire_date asc;


-- 직원 테이블에서 전체 직원들의 아이디 , 이름  , 급여 , 입사일을 조회하라
-- 단 부서 아이디를 기준으로 오름차순으로 정렬하고
-- 부서아이디가 동일하면 급여를 기준으로 내림차순 정렬
select employee_id, first_name, salary, hire_date
from employees
order by department_id asc, salary desc;

/*
    where절의 조건식에서 다양한 연산자 사용하기
    1. 비교연산자 = , != , > , >= , <  , <=
        오라클에서는 <> 이렇게 적으면 != 을 뜻함
    2. 논리연산자
        AND , OR , NOT
    3. 기타연산자
        BETWEEN  값1 AND 값2

        select 컬럼명 , 컬럼명 , 컬럼명...
        from 테이블명
        where 컬럼명 BETWEEN 값1 AND 값2 ;
            * where 절에 지정된 컬럼의 값이 값1이상 , 값2 이하 인것으 ㄹ조회
            * where 컬럼명 >= 값1 and 컬럼명 <= 값2
            위의 두 조건은 같다

    IN (값1 , 값2 , 값3......)

    select 컬럼명 , 컬럼명 , 컬럼명
    from 테이블명
    where 컬럼명in (값1 , 값2 , 값3..........)
        * where 절에서 지정된 컬럼의 값이 1 , 2, 3, 중 하나가 일치하면 조회한다
        * where 컬럼명 IN(값1, 값2, 값3.......)
        * where 컬럼명 = 값1 or 컬럼명 = 값3 or 칼람명 == p3;


        is null과 is not null , where 절에서 지정된 컬럼



        패턴문자
        '%' 0 개이상의 임의의문자
        '_' 임의의문자 하나를 나타낸다

        제목이'자바'로 시작하는 도서를 조회하기
        where book_title like 자바%'
        + '자바' ,'자바의정석' , '자바프로그래밍' 전부 위의 패턴과 일치

        제목이 '자바로' 끝나는 도서 조회
        where book_title like '%자바'
        + '자바' '일주일 만에 끝나는 자바' ,  '이펙티브 자바'는 전부 위의 패턴과 일치

        제목이 '자바' 가 포함되어있는 도서 조회
        whrere book_title like '%자바%' ,
        '자바' ,'자바의정석','이것이 장비다' 는 전부 위의 패턴가 같다

        성씨가 '김'씨인 고객을 조회
        where name like '김_%'
        + '김'불가 '김김' , '김유신' 가능

    '김'씨고 외름이 외자인 고객으 조회
    where name like '김'

    '김'씨고 2글자인 고객조회
    whewre name like '김_'

 */

-- 직원 테이블에서 급여가 3000이상 5000이하인 직원의 아이디, 이름,  직종아이디, 급여를 조회하라
-- 단 급여를 오름차 순으로 정렬
select *
from employees;
select employee_id, first_name, department_id, salary
from employees
where salary BETWEEN 3000 and 5000
order by salary asc;

-- 직원 테이블에서 2005 년도에 입사한 직원의 아이디 , 이름, 임사일을 조회
-- 입사일 순으로 오름차순으로 정렬
select employee_id, first_name, hire_date
from employees
where hire_date Between '2005/01/01' and '2005 / 12 /31'
order by hire_date;

select employee_id, first_name, hire_date
from employees
where hire_date Between '2005-01-01' and '2005 - 12 - 31'
order by hire_date;

---------------------------------------------------------------------

-- 직원 테이블에서 소속사가 10번 이거나 20번이거나 30번인 직원의 아이디 이름 급여 소속부서아이디 조회
select employee_id, first_name, salary, department_id
from employees
where department_id In (10, 20, 30);

-- 비추천
select employee_id, first_name, department_id
from employees
where department_id = 10
   or department_id = 20
   or department_id = 30;

-- 직원 테이블에서 소속부서가 10번이거나 20번이거나 30번이고
-- 급여를 3000이하로 받는
-- 직원의 아이디 , 이름 , 급여 , 소속부서 아이디
select employee_id, first_name, salary, department_id
from employees
where department_id IN (10, 20, 30)
  and salary <= 3000;

select *
from departments;

-- 부서테이블에서 관리자가 , 지정되어있지 않는 부서 아이디와 부서 이르으 조화
select department_id, department_name
from departments
where manager_id is null;

-- 부서 테이블에서 관리자가 지정된 부서의 아이디와 이름 관리자 아이이디 조회
select department_id, department_name, manager_id
from departments
where manager_id is not null;

-- 직원 테이블에서 소속부서가 결정되지 않은직원의 아이디 이름 직종 조회
select employee_id, first_name, job_id
from employees
where department_id is null;

-- 직원테이블에서 직종 아이디가 'SA'로 시작하는 직원의 아이디 , 이름 , 직종아이디 조화ㅣ
select employee_id, first_name, job_id
from employees
where job_id like '%SA%';
