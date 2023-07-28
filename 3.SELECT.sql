/*
   SELECT문장 - DQL문장
    : 구조
    select distinct | * | 컬럼명 as 별칭, 컬럼명 별칭,....   : 열을 제한 :PROJECTION
    from 테이블이름     
    [where 조건식 ]  : 레코드(튜플)제한  - SELECTION
    [order by 컬럼명 desc | asc , .. ] -정렬
    
    
    * distinct 는 중복레코드를 제거
    * AS 는 컬럼에 별칭 만들기 
    * 실행순서
      SELECT   3) 
      FROM     1)
      WHERE    2) 
      ORDER BY 4) 
    
*/

--EX) SCOTT계정 접속 

SELECT * FROM EMP; --사원테이블
SELECT * FROM DEPT;--부서정보테이블

--1) EMP테이블에서 원하는 컬럼(별칭)
-- AS : 보여줄 때 COLUMN에 별칭을 부여. 담당 업무처럼 중간에 공백을 주려면 ""로 묶어주기.
SELECT EMPNO AS 사원번호, ENAME AS 사원이름, JOB AS "담당 업무", HIREDATE AS 고용일
FROM EMP;

--2) 중복행 제거하기 - DISTINCT
 --EX) 우리회사에 어떤 JOB있는지 JOB의 종류를 알고싶다!!!
-- DISTINCT를 쓸 때는 COLUMN을 최소화해야함. 두개를 같이 비교해서 중복되는 값을 잘 지우지 못함.
SELECT DISTINCT JOB FROM EMP;

 
--3) 조건 만들기 
 -- 급여가 3000이상인 사원 검색
SELECT *
FROM EMP
WHERE SAL >= 3000;
 
 --4) 정렬
 -- 급여가 2000이상인 사원을 검색하고 급여를 기준으로 정렬
SELECT *
FROM EMP
WHERE SAL >= 2000
ORDER BY SAL; -- 오름차순
-- 내림차순은 DESC;
 --JOB을 기준으로 내림차순정렬하고 JOB이 같으면 급여를 기준으로 정렬
SELECT *
FROM EMP
ORDER BY JOB DESC, SAL;

-------
SELECT EMPNO, ENAME, JOB, SAL AS 급여
FROM EMP
WHERE SAL>2000 -- WHERE문은 별칭을 사용할 수 없음. -> 실행순서 때문에 불가능.
ORDER BY 급여; -- ORDER BY 00을 별칭으로 사용할 수 있음.

-- 정렬 대상 컬럼을 INDEX 사용
SELECT EMPNO, ENAME, JOB, SAL
FROM EMP
ORDER BY 3, 4; -- SELECT절에 나온 컬럼 순서를 기준으로 정렬함(1부터 시작함) => JOB, SAL로 감.


--칼럼들끼리 연산이 가능하다

SELECT EMPNO, ENAME, SAL, COMM, (SAL+COMM) * 12 AS 연봉
FROM EMP;

-- NULL은 연산이 안됨. 
-- NULL값을 다른 값으로 변경해서 연산 할 수 있다  -->  NVL(칼럼명, 변경값)
            -- NULL이 0으로  -- NULL이 100으로
SELECT COMM, NVL(COMM, 0), NVL(COMM, 100) FROM EMP;

SELECT EMPNO, ENAME, SAL, COMM,(SAL + NVL(COMM, 0)) * 12 AS 연봉
FROM EMP;

--님 년봉은 ~입니다. 출력 ---  문자열 연결 || 이용
SELECT ENAME || '님 연봉은' || (SAL + NVL(COMM, 0)) * 12 || '입니다.' AS MESSAGE
FROM EMP;

--님 년봉은 ~입니다. 출력 ---  CONCAT() 함수 활용 CONCAT(A, B) A 뒤에 B를 붙임
SELECT CONCAT(CONCAT(ENAME, '님 연봉은'), (SAL + NVL(COMM, 0)) * 12)
FROM EMP;
SELECT ENAME || '님 연봉은' || (SAL + NVL(COMM, 0)) * 12 || '입니다.' AS MESSAGE
FROM EMP;

  
-----------------------------------------------------------------------------------
/*
  연산자 종류
  1) 산술연산자
     +, -, *, / 
     나머지 : MOD(값, 나눌수)
     
   2) 관계연산자
       > , <, >= , <= , !=, <>
       같다  :  =
       
   3) 비교연산자
    - AND
    - OR
    - IN :  컬럼명 IN (값, 값, 값)  - 하나의 컬럼을 대상으로 또는으로 비교할때 사용한다.
    
    - BETWEEN AND :  컬럼명 BETWEEN 최소 AND 최대 - 하나의 컬럼을 대상으로 최소 ~ 최대를 비교할때
    
    - LIKE  : 와일드카드 문자와 함께 사용한다.
        1. % : 0개이상의 문자
        2. _ : 한글자  
        
        EX)  name like 'J%' ;   - NAME에 첫글자가 J로 시작하는 모든 문자
             name like '___' ;  - NAME이 3글자 
             name like 'J_J%';  - NAME의 첫글자가 J로 시작하고 3번째 글자 A인 정보 검색
             
    
    - NOT : 위의 모든 연산자들 앞에 NOT을 붙히면 반대 개념.
        
*/
--EX) 산술연산자 : EMP에서 년봉계산 = (SAL + COMM) *12  해서 년봉 컬럼 
 
 
 -- * NVL(값, 대치값)  : NULL을 찾아 대치값으로 변경한다. 


--EX) 년봉을 계산하기 위해서 COMM의 NULL을 찾아 0으로 변경한후 연산한다. - NVL함수 사용


--EX) ~님의 년봉은 ~ 입니다. 출력  : 문자열을 연결할때 || 사용한다.



--EX) SAL 가 2000 ~ 4000사원 검색(AND, BETWEEN AND )
SELECT ENAME
FROM EMP
WHERE SAL>=2000 AND SAL<=4000;

SELECT ENAME
FROM EMP
WHERE SAL BETWEEN 2000 AND 4000;
 

--EX) SAL 가 2000 ~ 4000사원아닌 레코드 검색 -  NOT
SELECT ENAME
FROM EMP
WHERE SAL NOT BETWEEN 2000 AND 4000;



--EX) EMPNO 가 7566, 7782,7844인 사원검색 ( OR, IN)
SELECT ENAME
FROM EMP
WHERE EMPNO = 7566 OR EMPNO = 7782 OR EMPNO = 7844;

SELECT ENAME
FROM EMP
WHERE EMPNO IN (7566, 7782, 7844);


--EX) EMPNO 가 7566, 7782,7844인 사원이 아닌 검색 ( NOT)
SELECT ENAME
FROM EMP
WHERE EMPNO NOT IN (7566, 7782, 7844);

---------------------------------------------------------------------------
--1) JOB에 'A' 문자로시작하는 레코드 검색
SELECT ENAME
FROM EMP
WHERE LOWER(JOB) LIKE 'A%';

--2) JOB에 끝 끌자가 'N'으로 끝나는 레코드 검색
SELECT ENAME
FROM EMP
WHERE JOB LIKE '%N';

--3) ENAME이 4글자인 레코드 검색
SELECT ENAME
FROM EMP
WHERE ename LIKE '____';

--4) ENAME에 A글자가 포함된 레코드 검색
SELECT ENAME
FROM EMP
WHERE ENAME LIKE '%A%';

--5) ENAME전체 글자가 5글자이고 두번째 글자가 m이면서끝글자가 h인 레코드 검색
SELECT ENAME
FROM EMP
WHERE UPPER(ENAME) LIKE '_M__H'; 
-------------------------------------------------------------------------------------------------
-- WOONG 계정으로 접속
SELECT * FROM MEMBER;
INSERT INTO MEMBER(ID, NAME, JUMIN, AGE) VALUES ('NA', 'WOONG%KI', '111', 29);
INSERT INTO MEMBER(ID, NAME, JUMIN, AGE) VALUES ('N', 'WOO', '222', 29);
SELECT * FROM MEMBER
WHERE NAME LIKE '%%%';
-- LIKE를 활용할 때 찾을 데이터 값에 %가 있어서 % 기준으로 찾으려할때 %%%를 쓸 수 없음.
SELECT * FROM MEMBER
WHERE NAME LIKE '%@%%' ESCAPE '@';
-- 안에 특수기호가 있을 때 그걸 찾을 때는 ESCAPE라는 키워드를 주고 그 키워드 뒤에 해당 기호를 넣으면
-- 그 자체를 문자 취급해줌. => 찾을 수 있음.

/*
    NULL 찾기
    1) IS NULL
    2) IS NOT NULL
*/

-- COMM이 NULL인 레코드 검색
SELECT * FROM EMP WHERE COMM IS NULL;
SELECT * FROM EMP WHERE COMM IS NOT NULL;
--COPY_EMP 테이블에서 COMM이 NULL레코드를 COMM의 값을 100으로 변경
SELECT * FROM COPY_EMP;

UPDATE copy_emp
SET COMM = 100
WHERE COMM IS NULL;
 
 
-- NULL이 있는 컬럼을 대상으로 정렬을 해보자
SELECT * FROM EMP ORDER BY COMM; -- 오름차순일때는 NULL은 마지막에 조회된다
SELECT * FROM EMP ORDER BY COMM DESC; -- 내름차순일때는 NULL은 처음에 조회된다 
SELECT * FROM EMP ORDER BY COMM ASC NULLS FIRST; --NULL을 우선적으로 출력




                    
                    
                    
 
 

------------------------------------------------------------------
