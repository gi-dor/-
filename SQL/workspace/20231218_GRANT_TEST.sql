-- 권한 부여
-- hr2 사용자에게 권한부여하기
GRANT select
    on EMPLOYEES
    TO hr2;

-- 스키마 (SCHEMA)
-- 특정 사용자와 연결된 데이터베이스 객체 (테이블, 뷰, 시퀀스 , 인덱스 등의 데이터베이스 객체의 집합)
-- 데이터 베이스 객체는 대부분 사용자가 소유하고 있기 때문에 사용자의 이름과 동일한 이름을 갖는다.


-- hr에게 권한이 부여된 hr2의 EMPLOYEES 테이블 조회하기
select *
from hr.employees;


-- hr2 사용자에게 부여된 객체 권한 회수하기
REVOKE SELECT
    ON EMPLOYEES
    FROM hr2;

-- 특정사용자에게 EMPLOYEES 객체에 대한 모든 객체권한 부여하기
GRANT SELECT , INSERT , UPDATE , DELETE
    ON EMPLOYEES
    TO hr2;

-- 모든 사용자에게 EMPLOYEES 객체에 대한 모든 객체권한 부여하기
GRANT select
    ON EMPLOYEES
    TO PUBLIC;

-- WITH GRANT OPTION을 사용하면 SELECT 권한을 부여 받은 hr2가 다른 사용자에게 select 권한을 부여할 수 있다.
GRANT SELECT
    ON EMPLOYEES
    TO HR2
    WITH GRANT OPTION;

