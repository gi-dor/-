### 🔸 NON EQUI JOIN

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