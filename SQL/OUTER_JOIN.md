### 🔸 OUTER JOIN

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