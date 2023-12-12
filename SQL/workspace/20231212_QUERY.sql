/*QUERY

 내포된 SQL문의 구분

- SUB QUERY : where절이나 having 절에서 조건식에 사용되는 값을 제공하는 SQL문
- Inline-View : From 절에서 가상의 테이블(가상의 테이블을 뷰 라고함)을 제공하는 SQL문
- Scalar_SUB_QUERY : Select절에서 사용되는 서크붜리
- Correlative Subquery (상호연관 서브쿼리) : 내포된 SQL문에서 메인쿼리의 컬럼을 참조하는 서브쿼리


 SubQuery

- select 문 내부에 정의된 select 문을 서브쿼리라 한다
- SubQuery는 where절의 조건식에서 사용되는 값을 제공한다
    - 이경우 조건식에서 사용되는 값이 SQL을 실행해야만 획득 가능한 값이 경우가 많다

           select 컬럼 , 컬럼
           from 테이블명
           where 조건식 연산자 ( select 컬럼
                               from 테이블명
                               [where 조건식])

  특징

- 한번만 실행된다
- 메인쿼리보다 먼저 실행된다
- 서브쿼리의 실행결과가 메인쿼리의 조건식에서 사용된다.


 주의 사항

- 서브쿼리는 반드시 괄호 안에 작성
- 서브쿼리는 조건식에서 오른쪽에 위치 시켜서 가독성을 높인다
- 서브쿼리의 실행결과가 단일행 인지 다중행 인지 조사해서 적절한 연산자를 사용한다

*/


-- 전체 직원의 평균급여 보다 많이 받는 직원의 아이디 , 이름 , 급여 조회

/*
select EMPLOYEE_ID, FIRST_NAME, SALARY
FROM EMPLOYEES
WHERE SALARY > 평균급여;
*/

select EMPLOYEE_ID, FIRST_NAME, salary
from EMPLOYEES
where salary > (select avg(salary)
                from EMPLOYEES);


-- B등급의 최고 급여보다 급여를 '적게' 받는 직원의 아이디 이름 급여 조회하기

/*select EMPLOYEE_ID, FIRST_NAME, salary
from EMPLOYEES
where SALARY < B등급의 최고급여
*/

-- B등급 최고급여 구하기
select *
from SALARY_GRADES;

select MAX_SALARY
from SALARY_GRADES
where GRADE = 'B';

select EMPLOYEE_ID, FIRST_NAME, salary
from EMPLOYEES
where SALARY < (select MAX_SALARY
                from SALARY_GRADES
                where GRADE = 'B');


-- 60번부서의 직원과 같은해에 입사한 직원들의 아이디 이름 입사일을 조회하기
select TO_CHAR(HIRE_DATE, 'YYYY')
from EMPLOYEES
where DEPARTMENT_ID = 60;


/* [21000][1427] ORA-01427: 단일 행 하위 질의에 2개 이상의 행이 리턴되었습니다. Position: 80 */
select FIRST_NAME, HIRE_DATE
from EMPLOYEES
where TO_CHAR(HIRE_DATE, 'YYYY') = (select TO_CHAR(HIRE_DATE, 'YYYY')
                                    from EMPLOYEES
                                    where DEPARTMENT_ID = 60);

-- 최종
select FIRST_NAME, HIRE_DATE
from EMPLOYEES
where TO_CHAR(HIRE_DATE, 'YYYY') IN (select TO_CHAR(HIRE_DATE, 'YYYY')
                                     from EMPLOYEES
                                     where DEPARTMENT_ID = 60);
