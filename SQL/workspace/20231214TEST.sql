/*
수강 신청 시스템용 테이블

학과 deptNo  (number3,0) NN
교수  varchar2(256) deptNO(()
학생
과정
수강신청
*/

-- 학과 테이블
CREATE TABLE DEPTS
(
    DEPT_NO   NUMBER(3),
    DEPT_NAME VARCHAR2(255) NOT NULL,

    CONSTRAINT DEPT_NO_PK PRIMARY KEY (DEPT_NO)
);


/* 교수 테이블

교수 번호
   PROF_NO number(3,0) NN
   Prof_name varchar(255) NN
   DEPT_NO number(3,0) NN
*/


CREATE TABLE PROFESSORS
(
    PROF_NO       NUMBER(3)     NOT NULL,
    PROF_NAME     VARCHAR2(255) NOT NULL,
    PROF_POSITION VARCHAR2(100) NOT NULL,
    DEPT_NO       NUMBER(3)     NOT NULL,

    CONSTRAINT PROF_NO_PK PRIMARY KEY (PROF_NO),
    CONSTRAINT DEPT_NO_FK FOREIGN KEY (DEPT_NO) REFERENCES DEPTS (DEPT_NO)
);


/*
학생 테이블
*/
CREATE TABLE STUDENTS
(
    STUD_NO    NUMBER(3),
    STUD_NAME  VARCHAR2(100) NOT NULL,
    STUD_GRADE NUMBER(1),
    DEPT_NO    NUMBER(3)     NOT NULL,
    PROF_NO    NUMBER(3),

    CONSTRAINT STUD_NO_PK PRIMARY KEY (STUD_NO),
    CONSTRAINT STUD_GRADE_CK CHECK ( STUD_GRADE IN (1, 2, 3, 4) ),
    CONSTRAINT STUD_DEPTNO_FK FOREIGN KEY (DEPT_NO) REFERENCES DEPTS (DEPT_NO),
    CONSTRAINT STUD_PROFNO_FK FOREIGN KEY (PROF_NO) REFERENCES PROFESSORS (PROF_NO)

);


/*
개설 과정 테이블
*/

CREATE TABLE COURSES
(
    COURSE_NO   NUMBER(3),
    COURSE_NAME VARCHAR2(255) NOT NULL,
    DEPT_NO     NUMBER(3),
    PROF_NO     NUMBER(3),

    CONSTRAINT COURSE_NO_PK PRIMARY KEY (COURSE_NO),
    CONSTRAINT COURSE_DEPT_NO_FK FOREIGN KEY (DEPT_NO) REFERENCES DEPTS (DEPT_NO),
    CONSTRAINT COURSE_PROF_NO_FK FOREIGN KEY (PROF_NO) REFERENCES PROFESSORS (PROF_NO)
);


/*
수강 신청 테이블
*/

CREATE TABLE REQUESTS
(
    REQ_NO    NUMBER(3),
    STUD_NO   NUMBER(3),
    COURSE_NO NUMBER(3),
    REG_DATE  DATE DEFAULT SYSDATE,

    CONSTRAINT REQ_STUD_COURSENO_PK PRIMARY KEY (STUD_NO, COURSE_NO),
    CONSTRAINT REQ_STUDNO_FK FOREIGN KEY (STUD_NO) REFERENCES STUDENTS (STUD_NO),
    CONSTRAINT REQ_COURSENO_FK FOREIGN KEY (COURSE_NO) REFERENCES COURSES (COURSE_NO)
);


INSERT INTO DEPTS (DEPT_NO, DEPT_NAME)
VALUES (101, '컴퓨터공학과');

INSERT INTO DEPTS (DEPT_NO, DEPT_NAME)
VALUES (102, '전자공학과');

INSERT INTO DEPTS (DEPT_NO, DEPT_NAME)
VALUES (103, '기계공학과');

INSERT INTO PROFESSORS (PROF_NO, PROF_NAME, PROF_POSITION, DEPT_NO)
VALUES (201, '김교수', '정교수', 101);

INSERT INTO PROFESSORS (PROF_NO, PROF_NAME, PROF_POSITION, DEPT_NO)
VALUES (202, '한교수', '정교수', 101);

INSERT INTO PROFESSORS (PROF_NO, PROF_NAME, PROF_POSITION, DEPT_NO)
VALUES (203, '노교수', '정교수', 102);

INSERT INTO PROFESSORS (PROF_NO, PROF_NAME, PROF_POSITION, DEPT_NO)
VALUES (203, '신교수', '정교수', 100); -- 부모키 PK 가 없어서 저장되지 않음

DELETE
FROM DEPTS
WHERE DEPT_NO = 101; -- 참조하는 자식 레코드가 존재하기 때문에 삭제가 안됨


INSERT INTO STUDENTS (STUD_NO, STUD_NAME, STUD_GRADE, DEPT_NO, PROF_NO)
VALUES (301, '박화요비', 1, 101, 201);

INSERT INTO STUDENTS (STUD_NO, STUD_NAME, STUD_GRADE, DEPT_NO, PROF_NO)
VALUES (302, '캠핑차', 1, 101, 201);

INSERT INTO STUDENTS (STUD_NO, STUD_NAME, STUD_GRADE, DEPT_NO, PROF_NO)
VALUES (303, '곽두팔', 1, 102, 203);

INSERT INTO STUDENTS (STUD_NO, STUD_NAME, STUD_GRADE, DEPT_NO, PROF_NO)
VALUES (304, '의부증', 1, 102, 203);

INSERT INTO STUDENTS (STUD_NO, STUD_NAME, STUD_GRADE, DEPT_NO, PROF_NO)
VALUES (305, '삽살개', 1, 103, 202);

-- 모든 학생 정보 조회
-- 학번 , 이름 , 학년 , 소속학과명 , 담당교수명

select s.STUD_NO 학번, s.STUD_NAME 이름, s.STUD_GRADE 학년, d.DEPT_NAME 학과, p.PROF_NAME 담당교수
from STUDENTS s,
     PROFESSORS p,
     DEPTS d
where s.DEPT_NO = d.DEPT_NO
  and p.PROF_NO = s.PROF_NO;



INSERT INTO COURSES (course_no, course_name, dept_no, prof_no)
VALUES (401, '객체지향이란', 101, 201);

INSERT INTO COURSES (course_no, course_name, dept_no, prof_no)
VALUES (402, '데이터모델링', 101, 201);

INSERT INTO COURSES (course_no, course_name, dept_no, prof_no)
VALUES (403, 'Java', 101, 202);

INSERT INTO COURSES (course_no, course_name, dept_no, prof_no)
VALUES (404, 'Python', 101, 202);

INSERT INTO COURSES (course_no, course_name, dept_no, prof_no)
VALUES (405, 'RUST', 101, 202);

-- 개설과정 조회
-- 과정번호 , 과정명 , 개설학과 , 담당교수 이름 조회하기
--  C       C           D       P

select c.COURSE_NO 과정번호, c.COURSE_NAME 과정, d.DEPT_NAME 학과, p.PROF_NAME 담당교수
from COURSES c,
     DEPTS d,
     PROFESSORS p
where c.DEPT_NO = d.DEPT_NO
  and c.PROF_NO = p.PROF_NO;


INSERT INTO REQUESTS (STUD_NO, COURSE_NO)
values (301, 401);
INSERT INTO REQUESTS (STUD_NO, COURSE_NO)
values (301, 402);
INSERT INTO REQUESTS (STUD_NO, COURSE_NO)
values (302, 401);
INSERT INTO REQUESTS (STUD_NO, COURSE_NO)
values (302, 403);

commit;

select *
from REQUESTS;

select *
from STUDENTS;

-- 캠핑차 학생이 신청한 과정 조회하기
-- 과정번호 , 과정명 , 개설학과 , 담당교수 , 신청일
-- R
--  C       C
--                      D
--                              P

-- 신청정보     r                   과정 정보       c                             학과정보   d             교수정보 p
-- 학번 , 과정번호 , 신청일          과정번호 , 과정명 , 학과번호 , 교수번호         학과번호 ,학과명        교수번호 교수명 ,학과번호

-- 무지성 버전
select r.COURSE_NO, c.COURSE_NAME, d.DEPT_NAME, p.PROF_NAME, r.REG_DATE
from REQUESTS r,
     PROFESSORS p,
     DEPTS d,
     COURSES c
where d.DEPT_NO = c.DEPT_NO
  and r.COURSE_NO = c.COURSE_NO
  and c.DEPT_NO = p.DEPT_NO
  and r.STUD_NO IN (select STUD_NO
                    from STUDENTS
                    where STUD_NAME = '캠핑차')
order by COURSE_NO;


-- 그나마 다듬어서 ?
select c.COURSE_NO, c.COURSE_NAME, d.DEPT_NAME, p.PROF_NAME, r.REG_DATE
from REQUESTS r,
     COURSES c,
     DEPTS d,
     PROFESSORS p
where r.COURSE_NO = c.COURSE_NO -- 학번. 과정번호. 신청일  - 과정번호 , 과정명 , 학과번호 , 교수번호
  and c.DEPT_NO = d.DEPT_NO     -- 과정번호 과정명 , 학과번호 교수번호 - 학과번호 학과명
  and c.PROF_NO = p.PROF_NO     -- 과정번호 , 과정명 학과번호 교수번호 - 교수번호 교수명
  and r.STUD_NO IN (select STUD_NO
                    from STUDENTS
                    where STUD_NAME = '캠핑차');


/*
테이블 생성순서
    부모테이블 -->  자식 테이블


테이블 삭제순서
    자식테이블 --> 부모테이블

    REQUESTS -> COURSES
             -> STUDENTS    -> PROFESSORS   -> DEPTS
*/


-- 테이블삭제
DROP TABLE DEPTS; -- PROFESSORS , STUDENTS , COURSES 에서 참조하는중
DROP TABLE PROFESSORS; -- STUDENTS , COURSES 에서 참조하는중
DROP TABLE STUDENTS; -- REQUESTS에서 참조하는중
DROP TABLE COURSES; -- REQUESTS에서 참조하는중
DROP TABLE REQUESTS;
-- 참조하고있는게 없어서 삭제 가능

-- CASECADE CONSTRAINTS 는 해당 테이블을 참조하는 자식테이블에서 FK 제약조건을 제거한다음 테이블 삭제한다
-- 제약조건 무시하고 삭제가능
DROP TABLE DEPTS CASCADE CONSTRAINTS;
DROP TABLE PROFESSORS CASCADE CONSTRAINTS;
DROP TABLE STUDENTS CASCADE CONSTRAINTS;
DROP TABLE COURSES CASCADE CONSTRAINTS;
DROP TABLE REQUESTS CASCADE CONSTRAINTS;

/*
제약 조건의 추가
                  ALTER TABLE  테이블명
                  ADD CONSTRAINT 제약조건별칭 FOREIGN KEY (컬럼이름) REFERENCES 부모테이블이름 (컬럼이름);

제약 조건의 삭제
                ALTER TABLE  테이블명 DROP CONSTRAINT 제약조건별칭;

제약조건의 비활성하기
                ALTER TABLE 테이블이름 DISABLE    CONSTRAINT 제약조건별칭 ;

제약조건의 활성하기
                ALTER TABLE 테이블이름 ENABLE    CONSTRAINT 제약조건별칭 ;
*/

