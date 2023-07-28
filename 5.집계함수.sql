/*
  집계함수
     - sum(컬럼명) => 합계
     - avg(컬럼명) => 평균(null값은 제외하고 나눔)
     - max(컬럼명) => 최대값
     - min(컬럼명) => 최소값
     
     - count(컬럼명) => 총 레코드수(null값은 제외함)
     - count(*) => null을 포함한 총 레코드수
     
     - rank(expr) within group(order by 컬럼명 asc | desc )
        => 전체 값을 대상으로 각 값의 순위를 구함.
     ex) --급여가 3000의 등수 구하기
        SELECT RANK(3000) within GROUP(ORDER BY sal desc) FROM EMP
*/

-----------------------------------------------------
--집계함수

CREATE TABLE REPORT(
 NAME VARCHAR2(20) CONSTRAINT REPORT_NAME_PK PRIMARY KEY,
 BAN CHAR(1),
 KOR NUMBER(3) CHECK(KOR BETWEEN 0 AND 100),
 ENG NUMBER(3) CHECK(ENG BETWEEN 0 AND 100),
 MATH NUMBER(3) CHECK(MATH BETWEEN 0 AND 100)
);



--샘플레코드
INSERT INTO REPORT VALUES('희정', 1 , 80, 70,90);
INSERT INTO REPORT VALUES('효리', 1 , 90, 50,90);

INSERT INTO REPORT VALUES('나영', 2 , 100, 65,85);
INSERT INTO REPORT VALUES('재석', 2 , 80, 70, 95);
INSERT INTO REPORT VALUES('희선', 2 , 85, 45,80);

INSERT INTO REPORT VALUES('승기', 3 , 50, 70,70);
INSERT INTO REPORT VALUES('중기', 3 , 90, 75,80);
INSERT INTO REPORT VALUES('혜교', 3 , 70, 90,95);
INSERT INTO REPORT VALUES('미나', 3 , NULL, 80,80);

SELECT * FROM REPORT;
-- 개인별 전체총점, 전체평균을 검색해보자.
SELECT NAME, BAN, KOR, ENG, MATH, (NVL(KOR, 0) + NVL(ENG, 0) + NVL(MATH,0)) AS 총점,
FLOOR((NVL(KOR, 0) + NVL(ENG, 0) + NVL(MATH,0))/3) AS 평균
FROM REPORT;


-- 국어점수의 최대, 최소, 전체학생수를 검색해보자. - 집계함수
SELECT MAX(KOR), MIN(KOR), COUNT(KOR), COUNT(*)
FROM REPORT; -- 집계(그룹)함수는 일반 컬럼을 SELECT절에 함께 사용 안함. (GROUP BY 필요)

-- 각 반별 국어 최대, 최소, 학생 수 평균, 총점
-- AVG는 NULL을 제외하고 계산함.
SELECT MAX(KOR), MIN(KOR), COUNT(*), COUNT(KOR),SUM(KOR), AVG(KOR), AVG(NVL(KOR, 0)) 
FROM REPORT
GROUP BY BAN;  --GROUP BY절에 나온 컬럼은 SELECT 절에 사용할 수 있음.
  

--수학점수 최대, 최소, 학생수 



--국어점수의 총점, 평균, NULL을 0으로 변경해서 평균 검색해보자 - AVG()함수는 NULL을 제외한 레코드수로 평균을 구한다. 



--반별 국어 최대, 최소 총점 평균 인원수 - GROUP BY절에 나온 컬럼은 SELECT절에 집계함수와 함게 사용가능




-- KOR의 점수가 70이상인 학생들의 반별 국어 최대, 최소 총점 평균 인원수
SELECT MAX(KOR), MIN(KOR), SUM(KOR), AVG(NVL(KOR, 0)), COUNT(*)
FROM REPORT
WHERE KOR >= 70
GROUP BY BAN;

 

-- KOR의 평균이 80 이상인 학생들의 반별 국어 최대, 최소 총점 평균 인원수 
SELECT MAX(KOR), MIN(KOR), SUM(KOR), AVG(NVL(KOR, 0)), COUNT(*)
FROM REPORT
GROUP BY BAN
HAVING AVG(KOR) >= 80; -- 집계함수(그룹함수)를 조건으로 사용할 때 HAVING 사용

/*
  중요!!
 SELECT   5)
 FROM     1)
 WHERE    2)
 GROUP BY 3)
 HAVING   4)
 ORDER BY 6)

*/




-----------------------------------------------
SELECT BAN , SUM(KOR) 총점
FROM REPORT
--WHERE KOR >=70
GROUP BY rollup(BAN); -- 소계 + 총계


SELECT BAN , SUM(KOR) 총점
FROM REPORT
WHERE KOR >=70
GROUP BY CUBE(BAN);

SELECT BAN , SUM(KOR) 총점
FROM REPORT
WHERE KOR >=70
GROUP BY GROUPING SETS(BAN);


---------------------------------------
/*
 ROLLUP VS CUBE VS GROUPING SETS
*/
CREATE TABLE MONTHLY_SALES( --월별매출
  GOODS_ID VARCHAR2(5), --상품아이디
  MONTH VARCHAR2(10), -- 월
  COMPANY VARCHAR2(20), --회사
  SALES_AMOUNT NUMBER -- 매출금액
);

INSERT INTO MONTHLY_SALES VALUES('P01','2023-01', '롯데', 15000);
INSERT INTO MONTHLY_SALES VALUES('P01','2023-02', '롯데', 25000);

INSERT INTO MONTHLY_SALES VALUES('P02','2023-01', '삼성', 8000);
INSERT INTO MONTHLY_SALES VALUES('P02','2023-02', '삼성', 12000);


INSERT INTO MONTHLY_SALES VALUES('P03','2023-01', 'LG', 8500);
INSERT INTO MONTHLY_SALES VALUES('P03','2023-02', 'LG', 13000);

SELECT * FROM MONTHLY_SALES;
-- ROLLUP 중간 소계를 내는데 용이 ROLLUP은 첫번째 인자로만 소계부분이 나옴.
-- CUBE는 괄호 안의 모든 것들이 서브로 다 나옴.
SELECT GOODS_ID ,MONTH, SUM(SALES_AMOUNT)
FROM MONTHLY_SALES
GROUP BY ROLLUP(GOODS_ID,MONTH); -- 총계 함께 출력 

SELECT MONTH , SUM(SALES_AMOUNT)
FROM MONTHLY_SALES
GROUP BY ROLLUP(MONTH);


SELECT GOODS_iD, MONTH , SUM(SALES_AMOUNT) 총매출액
FROM MONTHLY_SALES
GROUP BY ROLLUP(GOODS_iD,MONTH); -- ROLLUP 첫번째 나온 컬럼을 기준으로 소계, 전체 (인수의 순서가 중요)

SELECT MONTH , GOODS_iD  , SUM(SALES_AMOUNT) 총매출액
FROM MONTHLY_SALES
GROUP BY ROLLUP(MONTH , GOODS_iD);

--CUBE
SELECT GOODS_iD, MONTH , SUM(SALES_AMOUNT) 총매출액
FROM MONTHLY_SALES
GROUP BY CUBE(GOODS_iD,MONTH); -- CUBE 소계부분을 각 컬럼을 기준으로 나오기때문에서 인수의 순서가 상관없다. 

SELECT  MONTH , GOODS_ID, SUM(SALES_AMOUNT) 총매출액
FROM MONTHLY_SALES
GROUP BY CUBE(MONTH , GOODS_ID);


--GROUPING SETS 
SELECT GOODS_iD, MONTH , SUM(SALES_AMOUNT) 총매출액
FROM MONTHLY_SALES
GROUP BY GROUPING SETS(GOODS_iD,MONTH);

SELECT  MONTH , GOODS_ID, SUM(SALES_AMOUNT) 총매출액
FROM MONTHLY_SALES
GROUP BY GROUPING SETS(MONTH ,GOODS_iD);
