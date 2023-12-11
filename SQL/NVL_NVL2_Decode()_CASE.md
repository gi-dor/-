### 🔸 단일행 함수 - 기타 함수

1️⃣ NVL

        NVL(컬럼 , 대체값)

- NVL 함수는 NULL 값을 다른 값으로 변환한다
- 지정된 컬럼의 값이 NULL 아닌 경우 해당컬럼의 값을 반환한다
- 해당 컬럼과 대체값은 데이터 타입이 동일한 타입이어야 한다

2️⃣ NVL2

    NVL2(컬럼, 대체값1 , 대체값2)

- 지정된 컬럼의 값이 NULL이 아니면 대체값 1이 반환되고 NULL이면 대체값 2 반환
- 대체 값1과 대체값2는 데이터 타입이 동일한 타입이어야 한다.

<br>

---

#### ❓ 모든 직원의 아이디 이름 급여 커미션포인트를 조회한다 (단 , 커미션포인트가 null 이라면 0 을 반환)

    select employee_id , first_name , salary , commission_pct from employees;
    
    select employee_id , first_name , salary , NVL(commission_pct,0) commission
    from employees;

#### ❓ 모든 직원의 아이디 , 이름 , 급여 , 커미션 , 연봉을 조회하기

단, 커미션이 포함된 급여 = 급여 + (급여 * 커미션 포인트)

    select employee_id , first_name , salary , commission_pct ,
    salary + (salary * NVL(commission_pct,0))
    from employees;

❓ 모든 부서의 부서아이디 , 부서의 이이름 , 관리자 아이디 조회

(단 관리자가 지정되지 않은 부서는 관리자 없음 으로 조회)

    select department_id , department_name , manager_id
    from departments;
    
    select department_id , department_name , NVL(TO_CHAR(manager_id) ,'관리자 없음') 담당관리자
    from departments
                                           -- manager_id가 number 타입이라 TO_CHAR로 문자열로 변환해줌

<br>

-------------
<br>

### 🔸 단일행 함수 - 기타 함수2

1️⃣ DECODE ()

    DECODE(컬럼 , 비교값1, 값1,
                비교값2 , 값2,  
                비교값3 , 값3,
                값4)

    지정된 컬럼의 값이 비교값 1 과 같으면 값1이 반환
                    비교값 2와 같으면 값2 반환
                    비교값 3 과 같으면 값3 반환
                    일치하는게 없다면 값4 반환
            SWITCH 비슷한 느낌 ?

2️⃣ CASE ~ WHEN

CASE ~ WHEN 표현식

        CASE 
            WHEN 조건식1 THEN 값1
            WHEN 조건식2 THEN 값2
            WHEN 조건식3 THEN 값
            ELSE 값
        from 테이블

<br>    

    CASE 컬럼 
        WHEN 비교값1 THEN 값1
        WHEN 비교값2 THEN 값2
        WHEN 비교값3 THEN 값3
        ELSE 값4
    from 테이블

* 지정된 컬럼의 값이 비교값들 중 하나와 일치하면 해당 THEN의 값이 최종값이 된다
* 모든 비교값과 일치하지 않으면 ELSE 의 값4가 최종 값이 된다
* DECODE() 함수와 기능면에서 동일함.

<br>

------
<br>
❓ 모든 직원에 대해 직원 아이디 , 이름 , 급여 , 보너스를 조회하라!

- 급여가 5000 이하라면 보너스를 1000 지급
- 급여가 10000 이하 라면 보너스를 2000 지급
- 그외는 3000을 지급한다.

            select employee_id , first_name , salary , 
                case
                    when salary <= 5000 THEN 1000
                    when salary <= 10000 THEN 2000
                    ELSE 3000
                END Bonus
            from employees;

<br>
❓ 모든 직원에 대해서 부서아이디를 기준으로 팀 정하기

- 10 , 20 , 30 부서는 A팀
- 40 , 50 , 60 부서는 B팀
- 그외는 C팀

        selct employee_id , first_name ,department_id , 
              CASE 
                When department_id IN (10,20,30) THEN 'A'
                When department_id IN (40,50,60) THEN 'B'
                ELSE 'C'
              END as TEAM
        from employees;

<br>
❓ REGIONS 지역 테이블에서 지역 아이디빌려 지역명 조회하기

- 1은 유럽
- 2는 아메리카
- 3은 아시아
- 4는 아프리카 및 중동

        select * from regions;

        select region_id 
            CASE 
                WHEN region_id = 1 THEN '유럽'
                WHEN region_id = 2 THEN '아메리카'
                WHEN region_id = 3 THEN '아시아'
                WHEN region_id = 4 THEN '아프리카 및 중동'
            END REGION_NAME
        from regions;

<br>

❓ 부서의 아이디 , 부서이름명 , 담당 관리자의, 이름 조회하기

- 관리자가 지정되어 있지 않다면 관리자 없음 으로 조회
  ▶ 관리자 = null 이면 '관리자 없음'

    select B.department_id , B.department_name,
         CASE
             WHEN B.manager_id is not null THEN (select A.first_name
                                                 from employees A
                                                 where A.employee_id = B.manager_id)
             ELSE '없음'
          END manager_name
    from departments B;