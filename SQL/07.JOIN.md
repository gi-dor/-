### 🔸 테이블 JOIN

    select *
    from 테이블 1, 테이블2;

- 테이블의 조인은 조인대상이 되는 테이블의 이름을 FROM절에 나열하기만 하면 된다.
- 별도의 조건이 없으면 테이블1의 모든행과 테이블2의 모든행이 연결된 가상의 테이블이 생성된다
- ( 테이블1의 행 갯수 * 테이블2의 행갯수 ) 만큼의 행이 조회된다

❓ REGIONS 테이블의 모든 행과 COUNTRIES 테이블의 모든행 JOIN

    select *
    from regions ,countries;

----

#### JOIN 조건 지정하기

    select *
    from 테이블1 , 테이블2
    where 테이블1.컬럼명 = 테이블2.컬럼명2;

- 조인된 테이블의 모든 행에서 조인조건을 만족하는 행이 의미있게 연결되는 행
- 조인조건을 지정하면 의미있게 연결된 행만 조회할 수 있다.
- 조인조건의 갯수 = 조인된 테이블의 갯수 - 1

❓ REGIONS 테이블과 COUNTRIES 테이블 JOIN , 서로 연관있는 행만 필터링

    select c.country_id ,
           c.country_name,
           r.region_name
    from regions r ,countries c
        where r.region_id = c.region_id;

❓ 직원 아이디 , 직원 이름 , 직종아이디 , 직종최소급여 , 직종최대급여 , 급여조회하기

    select * from employees;
    select * from jobs;
    
    select e.employee_id ,
           e.first_name ,
           e.job_id,
           j.min_salary ,
           j.max_salary ,
           e.salary
    from employees e , jobs j
        where e.job_id = j.job_id;

----

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

-------------

### 2️⃣ NON EQUI JOIN

비등가 조인 - 주로 등급을 판단

- 조인 조건을 지정할 때 조인 대상테이블에서 같은 값을 가진 데이터를 가져오는 대신
- <b>'크거나 작은 경우의 조건 '<b/>  으로 데이터를 조회하는 조인방식이다

❓ 직원 아이디 , 직원 이름 , 급여 , 급여 등급 조회

        --  직원 아이디 , 직원 이름 ,  급여  ,  급여 등급 조회
        --      E       E           E
        --                          G (최소/최대)  G

            -- 전체 조회
            select e.employee_id , 
                    e.first_name , 
                    e.salary , 
                    g.grade,
                    g.min_salary,
                    g.max_salary
            from employess e , salary_grades g;


            
            select e.employee_id ,
                    e.first_name ,
                    e.salary ,
                    g.grade
            from employees e , SALARY_GRADES g
                where e.salary <= max_salary  and e.salary >= min_salary
            order by e.employee_id;


            -- ANSI SQL 
            select e.employee_id ,
                    e.first_name , 
                    e.salary , 
                    g.grade
            from employees e JOIN SALARY_GRADES g
            ON e.salary <= max_salary  and e.salary >= min_salary
            order by e.employee_id;

---------------

### 3️⃣ OUTER JOIN

포괄조인

- 한쪽 테이블에만 데이터가 있고 , 다른쪽 테이블에 조인조건을 만족하는 데이터가 없는경우
- 조인에 참여하지 못하기 때문에 해당행은 조회되지 않음
- 데이터가 없는 경우에도 데이터가 있는쪽 테이블의 모든 행을 조회하는 조인방법이다

----

❓ 부서아이디 , 부서 이름 , 부서관리자 아이디 , 부서 관리자 이름

            -- 부서아이디 , 부서 이름 , 부서관리자 아이디 , 부서 관리자 이름
            --      D       D       D - manager_id
            --                      E - employee_id           E - first_name


        select d.department_id , d.department_name , d.manager_id , e.first_name
        from emplyees e , departments d
        where e.employee_id(+) = d.d.manger_id
        order by d.department_id;

<br>

❓ 직원의 아이디 , 직원의 이름 , 소속부서 아이디 , 소속부서명 조회하기

        -- 직원의 아이디 , 직원의 이름 , 소속부서 아이디 , 소속부서명 조회하기
        --  E               E       E               
        --                          D               D

    select e.employee_id , e.first_name , e.department_id , d.department_name
    from employee e ,department d
    where e.department_id = d.department_id;
    -- 총107개인데 106개가 조회됨
    
    select * from employees
    where employee_id = 178;
    -- 178번에 department_id 가 null


    select e.employee_id , e.first_name , e.department_id , d.department_name
    from employees e , departments d
    where e.department_id = d.department_id(+);

    -- ANSI 버전
    select e.employee_id ,
           e.first_name ,
           e.department_id,
           d.department_name
    from employees e
    LEFT OUTER JOIN departments d   -- LEFT OUTER JOIN은 선행테이블의 모든 행을 조회한다
    ON e.department_id = d.department_id;

<br>
---

        // ORACLE                             ANSI

        // Table1의 모든 행이 조회

        SELECT *                            select *
        FROM TABLE1 A , TABLE2 B            from TABLE1 A
        WHERE A.COLUMN = B.COLOMN(+);       LEFT OUTER JOIN TABLE2 B
        ON A.COLUMN = B.COLUMN;


        // Table2의 모든행이 조회      

        select *                             select *
        from table1 A, table2                from table1 A
        where a.column(+) = b.column         right outer JOIN table2 B
        on A.COLUMN = B.COLUMN;
        
        // TABLE1 과 TABLE2의 모든행이 조회         

        select *                                select *
        from table1 A , table2 B                from table1 A
        where A.column(+) = b.column(+);        FULL OUTER JOIN table2 B
        on A.column = B.column;

▶ 오라클은 FULL OUTER JOIN 허용 안함



--------------------------

### 4️⃣ SELF JOIN

자체 조인

- JOIN 대상이 되는 테이블이 같은 테이블 일 때 발생 ㅡ 서로 연관지어서 조회할 때 사용
- 하나의 테이블을 이용해서 JOIN구성 , 조회하는 컬럼명이 동일한 경우가 발생할 수 있음
    + ✔ 별칭 적절히 사용
- 서로 역할을 각각 나누어 별칭을 정하고 그 역할에 맞게 JOIN 조건 정의

-----

<br>
❓ emplpyees 테이블에서 직원아이디 , 직원이름 , 해당직원의 상사아이디 , 상사 이름 조회

      select emp.employee_id as emp_id,
            emp.first_name as emp_name,
            mgr.employee_id as mgr_id,
            mgr.first_name as mgr_name
    from employees emp , employees mgr
    where emp.manager_id = mgr.employee_id;

❓ 직원 아이디, 직원 이름 , 직원의 소속부서명 , 상사의 아이디 , 상사의 이름 , 상사의 소속부서명

    -- 직원 아이디, 직원 이름 , 직원의 소속부서명 , 상사의 아이디 , 상사의 이름 , 상사의 소속부서명
    --      E       E               E              E
    --                              D1                                        D2
    --                                              M               M

    select emp.EMPLOYEE_ID 직원아이디,
            emp.FIRST_NAME 직원이름,
            d1.DEPARTMENT_NAME 직원의소속부서,
            mgr.EMPLOYEE_ID 상사아이디,
            mgr.FIRST_NAME 상사이름,
            d2.DEPARTMENT_NAME 상사의부서
    from employees emp, -- 직원
         employees mgr, -- 관리자
         departments d1,    -- 직원 부서
         departments d2     -- 관리자 부서
    where emp.MANAGER_ID = mgr.EMPLOYEE_ID(+) 
      and emp.department_id = d1.DEPARTMENT_ID (+)
      and mgr.DEPARTMENT_ID = d2.DEPARTMENT_ID (+)
    order by emp.EMPLOYEE_ID;