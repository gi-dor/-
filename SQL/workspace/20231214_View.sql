/*
View  (가상의 테이블)
    테이블 혹은 다른 뷰를 기반으로 생성하는 가상의 테이블
    물리적인 저장공간을 가지지 않느다
    뷰를 대상으로 insert , update , delete 작업을 수행하기 어렵다
    뷰를 대상으로 select 작업을 주로 수행



뷰  생성하기

    CREATE OR REPLACE VIEW 뷰이름
           AS 서브쿼리
           WITH READ ONLY;

- 부서에 대한 상세정보를 제공하는 뷰 생성
- 요구조건 :
    + 부서아이디 , 부서명 , 관리자 아이디, 관리자 이름, 소재지 아이디, 소재지 도시
    + 우편번호 주소 , 국가코드, 국가명을 포함한다
*/

CREATE
OR REPLACE VIEW DEPT_DETAIL_VIEW
AS (SELECT D.DEPARTMENT_ID,
           D.DEPARTMENT_NAME,
           D.MANAGER_ID,
           M.FIRST_NAME,
           D.LOCATION_ID,
           L.CITY,
           L.POSTAL_CODE,
           L.STREET_ADDRESS,
           L.COUNTRY_ID,
           C.COUNTRY_NAME
    FROM DEPARTMENTS D, EMPLOYEES M, LOCATIONS L, COUNTRIES C
    WHERE D.MANAGER_ID = M.EMPLOYEE_ID(+)
    AND D.LOCATION_ID = L.LOCATION_ID
    AND L.COUNTRY_ID = C.COUNTRY_ID)
WITH READ ONLY;



select *
from DEPT_DETAIL_VIEW
WHERE DEPARTMENT_ID = 60;



