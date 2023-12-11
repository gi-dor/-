### 1️⃣ EQUI JOIN

등가 JOIN

- 조인 조건에서 Equal (=)연산자를 사용한다.
- 조인에 참여하는 테이블에서 같은 값을 가지고있는 행끼리 조인한다.

🔹 Oracle 등가조인

      select a.컬럼명 , a.컬럼명 , b.컬럼명 , b.컬럼명...
      from 테이블 A , 테이블 B
      where A.컬럼명 = B.컬럼명;

🔹 ANSI SQL 등가조인

      select a.컬럼명 , a.컬럼명 , b.컬럼명 , b.컬럼명...
      from 테이블 A JOIN 테이블 B
      ON A.컬럼명 = B.컬럼명;

🐥ANSI SQL ?

ANSI SQL은 SQL의 표준을 규정하는 국제 표준화 기구인 ANSI(미국 국가 표준협회)가 정한 표준 SQL 구문 <br>

ANSI SQL은 여러 데이터베이스 시스템에서 호환되도록 설계되었다 <br>
다른 데이터베이스 시스템에서도 동일한 SQL 문법을 사용할 수 있게 하는 장점을 가지고 있다고 한다


-----

<br>
❓ 직원아이디,직원이름, 소속부서아이디 , 소속부서명 조회

    -- Oracle EQUI JOIN
    select e.employee_id ,
           e.first_name ,
           e.department_id ,
           d.department_name
    from employees e , departments d
         where e.department_id = d.department_id;

    -- ANSI SQL EQUI JOIN
        select  e.employee_id , 
                e.first_name , 
                e.department_id , 
                d.department_name
        from employees e JOIN departments d
        ON e.department_id = d.department_id;

<br>
❓ 부서 관리자가 지정된 부서의 부서아이디 , 부서명 ,부서 관리자명 조회

        -- 부서관리자가 지정된 부서의 부서아이디 , 부서명 , 부서관리자명 조회하기
        --                          D       D           D
        --                                              E
        
        -- Oracle
        select d.department_id , d.department_name , e.first_name
        from  employees e , departments d
             where d.department_id = e.department_id;

        -- ANSI
        select d.department_id , d.department_name , e.first_name
        from employees e JOIN departments d
             ON d.department_id = e.department_id
             where d.manager_id is not null;

<br>

❓ 직원의 아이디 이름 소속부서아이디 소속부서명 직종아이디 직종이름 급여 조회

            -- 직원의 아이디 이름  소속부서아이디 소속부서명 직종아이디 직종이름 급여 조회
            --        E     E       E                   E               E
            --              D                   D
            --                                          J       J
                
                -- Oracle
                select e.employee_id , e.first_name , 
                       e.department_id , d.department_name ,
                       j.job_id, j.job_title , e.salary
                from employees e , jobs j , departments d
                    where e.job_id = j.job_id
                        and e.department_id = d.department_id;

                -- ANSI
                select e.employee_id , e.first_name , 
                       e.department_id , d.department_name ,
                       j.job_id, j.job_title , e.salary
                from employees e
                    JOIN jobs j ON e.job_id = j.job_id
                    JOIN departments d ON e.department_id = d.department_id;

<br>
❓ 직원 아이디 , 직원이름 , 근무지역 도시명 조회

            -- 직원 아이디 , 직원이름 , 근무지역 도시명 조회
            --  E           E   
            --                          L

            select e.employee_id , e.first_name , l.city
                from employees e ,departments d , locations l
              where e.department_id = d.department_id
                and d.location_id = l.location_id;


