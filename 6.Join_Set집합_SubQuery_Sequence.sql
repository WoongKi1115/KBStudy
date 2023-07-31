/*
  JOIN
   : 한번의 SELECT문장으로 2개 이상의 테이블에 있는 컬럼의 정보를 검색하고 싶을 때 사용한다.
   : JOIN의 종류
     1) INNER JOIN
         - EQUI JOIN = 동등조인 = NATURAL JOIN
         - NON EQUI JOIN : 조인 대상 테이블의 어떤 컬럼의 값도 일치하지 않을 때 사용
                          EX) BETWEEN AND , IS NULL, IS NOT NULL, IN, > , < 등의  조건문을 사용할때 쓴다.
        
      2) OUTER JOIN
           : 기본 EQUI JOIN을 하면서 별도의 테이블의 모든 정보를 검색하고 싶을때 사용한다.
              - LEFT OUTER JOIN
              - RIGHT OUTER JOIN
              - FULL OUTER JOIN
    
      3) SELF JOIN
           : 자기 자신테이블을 조인하는 것(하나의 테이블을 2개처럼 사용하는 것)
           : 주로 재귀적관계일 때 많이 사용한다. (재귀적관계란 자신자신테이블의 PK를 FK로 참조하는 것)
           
    : JOIN 코딩 방법
      1) SQL JOIN  - ORACLE 방식 FULL OUTER JOIN은 제공하지 않는다. 
      2) ANSI JOIN : 미국국립표준연구소에서 정한 미국의 표준을 기본으로 한다. - 권장
*/

CREATE TABLE TEST1(
    ID VARCHAR2(10) PRIMARY KEY,
    NAME VARCHAR2(30),
    ADDR VARCHAR2(50)
);

INSERT INTO TEST1 VALUES('JANG', '희정', '서울');
INSERT INTO TEST1 VALUES('KIM', '나용', '대구');
INSERT INTO TEST1 VALUES('GYEEB', '미나', '부산');
INSERT INTO TEST1 VALUES('HEE', '미영', '서울');
INSERT INTO TEST1 VALUES('KING', '소현', '제주도');

SELECT * FROM TEST1;

-- TEST1을 참조하는 테이블 생성(ID에 해당하는 사람이 갖고 있는 JOB, SAL의 정보 제공)
CREATE TABLE TEST2(
    CODE CHAR(3) PRIMARY KEY,
    ID VARCHAR2(10) REFERENCES TEST1(ID),  ---FK (비 식별 관계)
    JOB VARCHAR2(30),
    SAL NUMBER(3)
);


INSERT INTO TEST2 VALUES('A01', 'JANG','강사',200);
INSERT INTO TEST2 VALUES('A02', 'JANG','개발자',300);
INSERT INTO TEST2 VALUES('A03', 'HEE','디자이너',250);
INSERT INTO TEST2 VALUES('A04', 'KING','기획자',400);
INSERT INTO TEST2 VALUES('A05', NULL,'백조',500);

SELECT * FROM TEST1;
SELECT * FROM TEST2;

-- 한번의 SELECT로 ID, NAME, ADDR, CODE, JOB, SAL 검색하고 싶다.
-- 1) SQL JOIN -> ORACLE 방식
-- CROSS JOIN
SELECT *
FROM TEST1, TEST2;

-- EQUI(동등) JOIN
SELECT TEST1.ID, NAME, ADDR, CODE, JOB, SAL
FROM TEST1, TEST2
WHERE TEST1.ID = TEST2.ID; -- 동등조인(EQUI JOIN) WHERE절이 없다면 CROSS JOIN이 됨.

-- TABLE 이름에 별칭 만들기
SELECT T1.ID, NAME, ADDR, CODE, JOB, SAL
FROM TEST1 T1, TEST2 T2 -- 테이블 이름 별칭을 주면 반드시 별칭으로 접근해야 함.
WHERE T1.ID = T2.ID; -- 동등조인(EQUI JOIN) WHERE절이 없다면 CROSS JOIN이 됨.

-- 2) ANSI JOIN(권장)
SELECT TEST1.ID, NAME, ADDR, CODE, JOB, SAL
FROM TEST1 INNER JOIN TEST2 -- INNER은 생략 가능
ON TEST1.ID = TEST2.ID; -- 조건절

-- TABLE 이름 별칭
SELECT T1.ID, NAME, ADDR, CODE, JOB, SAL
FROM TEST1 T1 JOIN TEST2 T2 -- INNER은 생략 가능
ON T1.ID = T2.ID; -- 조건절

-- ANSI JOIN USING 사용하기 (양쪽 테이블의 조건 대상이 컬럼이 타입과 이름이 일치할 때)
SELECT ID, NAME, ADDR, CODE, JOB, SAL
FROM TEST1 JOIN TEST2
USING (ID);

-- NATURAL JOIN (조건 필요 없이, 조인을 하는 테이블에서 같은 컬럼명, 같은 타입을 갖는 컬럼을 기준으로 모두 조인)
SELECT *
FROM TEST1 NATURAL JOIN TEST2; 

SELECT * FROM TEST1;
SELECT * FROM TEST2;
-- OUTER JOIN (LEFT, RIGHT, FULL) 기본이 EQUI(동등) 조인
-- 1) SQL JOIN - ORACLE JOIN => FULL JOIN 지원X
SELECT *
FROM TEST1 , TEST2
WHERE TEST1.ID = TEST2.ID(+); -- LEFT JOIN(+가 있는 반대쪽으로 다 더해줌)
-- 결과 : TEST1 부분에 있는 데이터는 다 출력

SELECT *
FROM TEST1 , TEST2
WHERE TEST1.ID(+) = TEST2.ID; -- RIGHT JOIN(+가 있는 반대쪽으로 다 더해줌)
-- 결과 : TEST2 부분에 있는 데이터는 다 출력

SELECT *
FROM TEST1 , TEST2
WHERE TEST1.ID(+) = TEST2.ID(+); -- 지원X
-- 결과 : 에러(FULL JOIN 지원X)

-- 2) ANSI JOIN
SELECT *
FROM TEST1 LEFT JOIN TEST2
USING(ID);
-- 결과 : TEST1 부분에 있는 데이터는 다 출력

SELECT *
FROM TEST1 RIGHT JOIN TEST2
ON TEST1.ID = TEST2.ID;
-- 결과 : TEST2 부분에 있는 데이터는 다 출력

SELECT *
FROM TEST1 FULL JOIN TEST2
ON TEST1.ID = TEST2.ID;
-- 결과 : TEST1, TEST2 부분에 있는 데이터는 다 출력
--------------------------------------------------------------------

-- 3개의 테이블 조인하기
CREATE TABLE TEST3(
    CODE CHAR(3) PRIMARY KEY REFERENCES TEST2(CODE),  -- PK, FK (식별관계)
    MANAGER_NAME VARCHAR2(30),
    PHONE VARCHAR2(30)
);


INSERT INTO TEST3 VALUES('A01', '유재석','111-1111');
INSERT INTO TEST3 VALUES('A02', '송중기','222-2222');
INSERT INTO TEST3 VALUES('A03', '이효리','333-3333');

SELECT * FROM TEST1;
SELECT * FROM TEST2;
SELECT * FROM TEST3;

-- EX) ID, NAME, ADDR, JOB, SAL, MANAGER_NAME, PHONE 검색
-- 1) SQL JOIN
SELECT *
FROM TEST1 T1, TEST2 T2, TEST3 T3
WHERE T1.ID = T2.ID AND T2.CODE = T3.CODE(+);


-- 2) ANSI JOIN
SELECT *
FROM TEST1 JOIN TEST2
USING (ID) JOIN TEST3
USING (CODE);

-- 조인에 조건 넣기 -- SAL가 300이상인 레코드 조인하기
-- 1) SQL JOIN
SELECT *
FROM TEST1 T1, TEST2 T2, TEST3 T3
WHERE T1.ID = T2.ID AND T2.CODE = T3.CODE AND SAL>=300;


-- 2) ANSI JOIN
-- ON에는 WHERE처럼 조건을 AND로 같이 넣어줄 수 있음.
SELECT *
FROM TEST1 JOIN TEST2
ON TEST1.ID = TEST2.ID JOIN TEST3
ON TEST2.CODE = TEST3.CODE AND SAL >= 300;

-- WHERE은 USING 다음에 사용 가능. JOIN문은 FROM절 다음에 나와주어야함.
SELECT *
FROM TEST1 JOIN TEST2
USING (ID) JOIN TEST3
USING (CODE)
WHERE SAL >= 300;

--NON-EQUI JOIN
-- EMP테이블에서 사원의 정보 + 급여등급을 함께 검색하고 싶다
SELECT * FROM EMP; -- 사원 테이블
SELECT * FROM SALGRADE; -- 급여등급 테이블 

-- 1) SQL JOIN
SELECT EMPNO, ENAME, JOB, SAL, GRADE
FROM EMP, SALGRADE
WHERE SAL BETWEEN LOSAL AND HISAL; -- NON EQUI JOIN;

-- 2) ANSI JOIN
SELECT EMPNO, ENAME, JOB, SAL, GRADE, LOSAL, HISAL
FROM EMP JOIN SALGRADE
ON SAL BETWEEN LOSAL AND HISAL;

-- SELF JOIN - 자기자신 테이블을 2개로 만들어서 조인(재귀적관계)

-- EX) SMITH사원의 관리자는 FORD입니다. 출력
SELECT * FROM EMP;
SELECT ENAME || '사원의 관리자는 ' || MGR || '입니다.'
FROM EMP;

-- 1) SQL JOIN
SELECT E1.EMPNO 사원번호, E1.ENAME 사원이름, E2.EMPNO 관리자사원번호, E2.ENAME 관리자이름
FROM EMP E1, EMP E2 -- E1이 사원, E2는 관리자
WHERE E1.MGR = E2.EMPNO;

-- 2) ANSI JOIN
SELECT E1.EMPNO 사원번호, E1.ENAME 사원이름, E2.EMPNO 관리자사원번호, E2.ENAME 관리자이름
FROM EMP E1 JOIN EMP E2 -- E1이 사원, E2는 관리자
ON E1.MGR = E2.EMPNO;

--------------------------------------------------------------
/*
  SET 집합
   1) 합집합
        UNION ALL - 중복레코드를포함
        UNION - 중복레코드 제외
        
   2) 교집합 
       INSERSECT : A와 B 테이블의 공통된 레코드 검색
       
   3) 차집합 
        MINUS : A테이블에서 B테이블이 레코드를 뺀 나머지 레코드 검색
*/
-- 테이블 복사
CREATE TABLE SET_TEST01
AS SELECT EMPNO, ENAME, JOB, SAL FROM EMP WHERE SAL >= 3000;

CREATE TABLE SET_TEST02
AS SELECT EMPNO, ENAME, JOB, SAL FROM EMP WHERE DEPTNO IN (10, 20);

SELECT * FROM SET_TEST01; -- 3행
SELECT * FROM SET_TEST02; -- 8행

SELECT * FROM SET_TEST01 
UNION ALL -- 중복레코드를 포함
SELECT * FROM SET_TEST02;

SELECT * FROM SET_TEST01 
UNION -- 중복레코드를 제거
SELECT * FROM SET_TEST02;

SELECT * FROM SET_TEST01 
INTERSECT -- 교집합
SELECT * FROM SET_TEST02;

-- MINUS(차집합)
SELECT EMPNO, ENAME FROM SET_TEST02 
MINUS -- 차집합
SELECT EMPNO, ENAME FROM SET_TEST01;

SELECT EMPNO, ENAME FROM SET_TEST01
MINUS -- 차집합
SELECT EMPNO, ENAME FROM SET_TEST02;
 -------------------------------------------------------------
 /*
   SUBQUERY - 부질의
    : 메인쿼리안에 또 다른 쿼리가 존재하는것
    : ()괄호로 묶는다. 괄호안에 실행문장이 먼저 실행된후 그 결과를 메인쿼리의 조건으로 주로 사용한다. 
    : 서브쿼리의 결과 행이 한개 일때  비교연산자 사용.
    : 서브쿼리의 결과 행이 여러개 일때는 ANY, ALL, IN 연산자를 사용한다. 
    : 주로 SELECT에서 많이 사용하지만 CREATE, INSERT, UPDATE ,DELTE, 
           HAVING, WHERE , FROM ,ORDER 에서도 사용가능하다.
 */
 
 --EMP테이블에서 평균 급여보다 더 많이 받는 사원 검색
-- 1) 평균 급여를 구한다
-- 2) 1에 나온 결과를 조건으로 사용한다.
SELECT *
FROM EMP
WHERE SAL >(SELECT AVG(SAL) FROM EMP);

-- JOB에 'A'문자열이 들어간 사원의 부서와 같은 곳에서 근무하는 사원의 부서이름 검색하고 싶다. 
-- 1) 'A' 문자열이 들어간 사원의 부서번호 PK를 구한다.
SELECT DISTINCT DEPTNO FROM EMP WHERE JOB LIKE '%A%';
-- 2) 1)의 결과를 조건으로 사용함
SELECT DNAME
FROM DEPT
WHERE DEPTNO = ANY (SELECT DISTINCT DEPTNO FROM EMP WHERE JOB LIKE '%A%'); -- 서브쿼리의 결과가 여러개의 행인 경우
  
SELECT DNAME
FROM DEPT
WHERE DEPTNO IN (SELECT DISTINCT DEPTNO FROM EMP WHERE JOB LIKE '%A%'); -- 서브쿼리의 결과가 여러개의 행인 경우

 -- 부서번호가 30인 사원들이 급여중에서 가장 많이 받는 사원보다 더 많이 받는 사원정보를 검색하고 싶다. 
-- 부서번화 30인 사원들의 급여중 가장 많이 받는 사원(30 부서의 급여 최대값)
SELECT *
FROM EMP
WHERE SAL > (SELECT MAX(SAL) FROM EMP WHERE DEPTNO = 30);

SELECT *
FROM EMP
WHERE SAL > ALL(SELECT SAL FROM EMP WHERE DEPTNO = 30); => -- ALL : 그 안의 모든 것을 의미. => SAL이 서브쿼리로 가져온 모든 값보다 큰 것을 나타냄.
-- SUBQUERY를 DML
-- EX) SET_TEST01 테이블의 EMPNO 7839인 사원의 JOB, ENAME, SAL을 수정한다.
-- 단 값을 EMP 테이블의 7566의 사원의 정보를 가져와 수정한다.
SELECT * FROM SET_TEST01;
INSERT INTO SET_TEST01(SELECT EMPNO, ENAME, JOB, SAL FROM EMP WHERE SAL <= 1000);


--특정한 칼럼만 다른테이블로부터 가져와서 INSERT
INSERT INTO SET_TEST01(EMPNO, JOB) (SELECT EMPNO, JOB FROM EMP WHERE SAL = 2450);

--SUBQUERY를 UPDATE
--EX) EMP테이블에서 EMPNO 7900인 사원의 JOB, MGR, DEPTNO로 SUB_EMP테이블의 7566의 사원의 정보로 수정해보자.
-- 방법 1
UPDATE SET_TEST01
SET JOB = (SELECT JOB FROM EMP WHERE EMPNO = 7566), ENAME = (SELECT ENAME FROM EMP WHERE EMPNO = 7566), SAL = (SELECT SAL FROM EMP WHERE EMPNO = 7566)
WHERE EMPNO = 7900;

-- 방법2
UPDATE SET_TEST01
SET (JOB, ENAME, SAL) = (SELECT JOB, ENAME, SAL FROM EMP WHERE EMPNO = 7839)
WHERE EMPNO = 7900;

--SUBQUERY를 DELETE
  --EX) EMP테이블이 평균 급여를 조건으로 사용해서 평균급여보다 많이 받는 사원들을 삭제한다. 
DELETE FROM SET_TEST01
WHERE SAL > (SELECT AVG(SAL) FROM EMP);

 

--------------------------------------------------------------
/*
  SUBQUERY 종류중의 하나인 인라인뷰
   : FROM절 뒤에 서브쿼리가 오는 것.
*/


-- ROWNUM : MYSQL LIMIT 느낌

-- 급여를 기준으로 정렬해서 ROWNUM을 함께 출력하고 싶다.
SELECT ROWNUM, EMPNO, ENAME, JOB, SAL 
FROM EMP
ORDER BY SAL;
-- 실행 순서의 영향으로 ROWNUM이 적용된 이후 정렬을 해서 ROWNUM과 순서가 같지 않음.
-- 먼저 정렬을 한 후에 ROWNUM을 적용
SELECT ROWNUM, EMPNO, ENAME, JOB, SAL
FROM (SELECT * FROM EMP ORDER BY SAL);

-- ROWNUM을 대상으로 조건을 만들어보자 .
--1. ROWUM이 3보다 작은 레코드 검색
SELECT ROWNUM NO, EMPNO, ENAME, JOB, SAL
FROM (SELECT * FROM EMP ORDER BY SAL)
WHERE ROWNUM <= 3;

--2. ROWUM이 3보다 큰 레코드 검색 => 아무것도 안나옴
SELECT ROWNUM NO, EMPNO, ENAME, JOB, SAL
FROM (SELECT * FROM EMP ORDER BY SAL)
WHERE ROWNUM > 3;

--3. ROWUM이 5 ~ 7 사이 레코드 검색 => 아무것도 안나옴
SELECT ROWNUM NO, EMPNO, ENAME, JOB, SAL
FROM (SELECT * FROM EMP ORDER BY SAL)
WHERE ROWNUM BETWEEN 5 AND 7;

/*
  ROWNUM은 레코드가 만들어지면서 번호가 순차적으로 부여되는 것으로 ROWNUM 1 이 없으면 2를 실행할수 없다. 
  그래서 ROWNUM를 조건으로  ~ 크다  또는 중간범위를 직접 조건으로 사용할 수 없다. 
  ROWNUM이 모두 부여된 결과를 조건으로 사용해야한다. 
*/
-- 먼저 ROWNUM을 만들어 놓은 테이블을 가지고 조건으로 사용해야함
SELECT *
FROM (SELECT ROWNUM NO, EMPNO, ENAME, JOB, SAL
FROM (SELECT * FROM EMP ORDER BY SAL DESC))
WHERE NO > 3;

SELECT *
FROM (SELECT ROWNUM NO, EMPNO, ENAME, JOB, SAL
FROM (SELECT * FROM EMP ORDER BY SAL DESC))
WHERE NO BETWEEN 5 AND 7;



----------------------------------------------------------
/*
  SEQUENCE : 자동 증가 값 설정
    :생성방법
      CREATE SEQUENCE 시퀀스이름
      [START WITH 초기값]
      [INCREMENT BY 증가값]
      [MAXVALUE 최댓값]
      [MINVALUE 최솟값]
      [CACHE | NOCACHE]-- 보통 NOCACHE 사용
      [CYCLE | NOCYCLE]
      
    : 사용방법
      시퀀스이름.NEXTVAL : 시퀀스를 증가
      시퀀스이름.CURRVAL : 시퀀스의 현재값 가져오기
       
    : 시퀀스 수정
    ALTER SEQUENCE 시퀀스이름;
    
    : 시퀀스 삭제
    DROP SEQUENCE 시퀀스이름;
*/
CREATE SEQUENCE SEQ_TEST;
SELECT SEQ_TEST.NEXTVAL, SEQ_TEST.CURRVAL
FROM DUAL;

-- 테이블 생성
CREATE TABLE BOARD(
BNO NUMBER PRIMARY KEY,
SUBJECT VARCHAR2(50),
REG_DATE DATE DEFAULT SYSDATE
);

-- 시퀀스 생성
CREATE SEQUENCE BOARD_BNO_SEQ NOCACHE;

-- 데이터 추가
INSERT INTO BOARD (BNO, SUBJECT)
VALUES (BOARD_BNO_SEQ.NEXTVAL, '제목' || BOARD_BNO_SEQ.CURRVAL);

SELECT * FROM BOARD;
