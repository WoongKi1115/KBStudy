/*
  JOIN
   : �ѹ��� SELECT�������� 2�� �̻��� ���̺� �ִ� �÷��� ������ �˻��ϰ� ���� �� ����Ѵ�.
   : JOIN�� ����
     1) INNER JOIN
         - EQUI JOIN = �������� = NATURAL JOIN
         - NON EQUI JOIN : ���� ��� ���̺��� � �÷��� ���� ��ġ���� ���� �� ���
                          EX) BETWEEN AND , IS NULL, IS NOT NULL, IN, > , < ����  ���ǹ��� ����Ҷ� ����.
        
      2) OUTER JOIN
           : �⺻ EQUI JOIN�� �ϸ鼭 ������ ���̺��� ��� ������ �˻��ϰ� ������ ����Ѵ�.
              - LEFT OUTER JOIN
              - RIGHT OUTER JOIN
              - FULL OUTER JOIN
    
      3) SELF JOIN
           : �ڱ� �ڽ����̺��� �����ϴ� ��(�ϳ��� ���̺��� 2��ó�� ����ϴ� ��)
           : �ַ� ����������� �� ���� ����Ѵ�. (���������� �ڽ��ڽ����̺��� PK�� FK�� �����ϴ� ��)
           
    : JOIN �ڵ� ���
      1) SQL JOIN  - ORACLE ��� FULL OUTER JOIN�� �������� �ʴ´�. 
      2) ANSI JOIN : �̱�����ǥ�ؿ����ҿ��� ���� �̱��� ǥ���� �⺻���� �Ѵ�. - ����
*/

CREATE TABLE TEST1(
    ID VARCHAR2(10) PRIMARY KEY,
    NAME VARCHAR2(30),
    ADDR VARCHAR2(50)
);

INSERT INTO TEST1 VALUES('JANG', '����', '����');
INSERT INTO TEST1 VALUES('KIM', '����', '�뱸');
INSERT INTO TEST1 VALUES('GYEEB', '�̳�', '�λ�');
INSERT INTO TEST1 VALUES('HEE', '�̿�', '����');
INSERT INTO TEST1 VALUES('KING', '����', '���ֵ�');

SELECT * FROM TEST1;

-- TEST1�� �����ϴ� ���̺� ����(ID�� �ش��ϴ� ����� ���� �ִ� JOB, SAL�� ���� ����)
CREATE TABLE TEST2(
    CODE CHAR(3) PRIMARY KEY,
    ID VARCHAR2(10) REFERENCES TEST1(ID),  ---FK (�� �ĺ� ����)
    JOB VARCHAR2(30),
    SAL NUMBER(3)
);


INSERT INTO TEST2 VALUES('A01', 'JANG','����',200);
INSERT INTO TEST2 VALUES('A02', 'JANG','������',300);
INSERT INTO TEST2 VALUES('A03', 'HEE','�����̳�',250);
INSERT INTO TEST2 VALUES('A04', 'KING','��ȹ��',400);
INSERT INTO TEST2 VALUES('A05', NULL,'����',500);

SELECT * FROM TEST1;
SELECT * FROM TEST2;

-- �ѹ��� SELECT�� ID, NAME, ADDR, CODE, JOB, SAL �˻��ϰ� �ʹ�.
-- 1) SQL JOIN -> ORACLE ���
-- CROSS JOIN
SELECT *
FROM TEST1, TEST2;

-- EQUI(����) JOIN
SELECT TEST1.ID, NAME, ADDR, CODE, JOB, SAL
FROM TEST1, TEST2
WHERE TEST1.ID = TEST2.ID; -- ��������(EQUI JOIN) WHERE���� ���ٸ� CROSS JOIN�� ��.

-- TABLE �̸��� ��Ī �����
SELECT T1.ID, NAME, ADDR, CODE, JOB, SAL
FROM TEST1 T1, TEST2 T2 -- ���̺� �̸� ��Ī�� �ָ� �ݵ�� ��Ī���� �����ؾ� ��.
WHERE T1.ID = T2.ID; -- ��������(EQUI JOIN) WHERE���� ���ٸ� CROSS JOIN�� ��.

-- 2) ANSI JOIN(����)
SELECT TEST1.ID, NAME, ADDR, CODE, JOB, SAL
FROM TEST1 INNER JOIN TEST2 -- INNER�� ���� ����
ON TEST1.ID = TEST2.ID; -- ������

-- TABLE �̸� ��Ī
SELECT T1.ID, NAME, ADDR, CODE, JOB, SAL
FROM TEST1 T1 JOIN TEST2 T2 -- INNER�� ���� ����
ON T1.ID = T2.ID; -- ������

-- ANSI JOIN USING ����ϱ� (���� ���̺��� ���� ����� �÷��� Ÿ�԰� �̸��� ��ġ�� ��)
SELECT ID, NAME, ADDR, CODE, JOB, SAL
FROM TEST1 JOIN TEST2
USING (ID);

-- NATURAL JOIN (���� �ʿ� ����, ������ �ϴ� ���̺��� ���� �÷���, ���� Ÿ���� ���� �÷��� �������� ��� ����)
SELECT *
FROM TEST1 NATURAL JOIN TEST2; 

SELECT * FROM TEST1;
SELECT * FROM TEST2;
-- OUTER JOIN (LEFT, RIGHT, FULL) �⺻�� EQUI(����) ����
-- 1) SQL JOIN - ORACLE JOIN => FULL JOIN ����X
SELECT *
FROM TEST1 , TEST2
WHERE TEST1.ID = TEST2.ID(+); -- LEFT JOIN(+�� �ִ� �ݴ������� �� ������)
-- ��� : TEST1 �κп� �ִ� �����ʹ� �� ���

SELECT *
FROM TEST1 , TEST2
WHERE TEST1.ID(+) = TEST2.ID; -- RIGHT JOIN(+�� �ִ� �ݴ������� �� ������)
-- ��� : TEST2 �κп� �ִ� �����ʹ� �� ���

SELECT *
FROM TEST1 , TEST2
WHERE TEST1.ID(+) = TEST2.ID(+); -- ����X
-- ��� : ����(FULL JOIN ����X)

-- 2) ANSI JOIN
SELECT *
FROM TEST1 LEFT JOIN TEST2
USING(ID);
-- ��� : TEST1 �κп� �ִ� �����ʹ� �� ���

SELECT *
FROM TEST1 RIGHT JOIN TEST2
ON TEST1.ID = TEST2.ID;
-- ��� : TEST2 �κп� �ִ� �����ʹ� �� ���

SELECT *
FROM TEST1 FULL JOIN TEST2
ON TEST1.ID = TEST2.ID;
-- ��� : TEST1, TEST2 �κп� �ִ� �����ʹ� �� ���
--------------------------------------------------------------------

-- 3���� ���̺� �����ϱ�
CREATE TABLE TEST3(
    CODE CHAR(3) PRIMARY KEY REFERENCES TEST2(CODE),  -- PK, FK (�ĺ�����)
    MANAGER_NAME VARCHAR2(30),
    PHONE VARCHAR2(30)
);


INSERT INTO TEST3 VALUES('A01', '���缮','111-1111');
INSERT INTO TEST3 VALUES('A02', '���߱�','222-2222');
INSERT INTO TEST3 VALUES('A03', '��ȿ��','333-3333');

SELECT * FROM TEST1;
SELECT * FROM TEST2;
SELECT * FROM TEST3;

-- EX) ID, NAME, ADDR, JOB, SAL, MANAGER_NAME, PHONE �˻�
-- 1) SQL JOIN
SELECT *
FROM TEST1 T1, TEST2 T2, TEST3 T3
WHERE T1.ID = T2.ID AND T2.CODE = T3.CODE(+);


-- 2) ANSI JOIN
SELECT *
FROM TEST1 JOIN TEST2
USING (ID) JOIN TEST3
USING (CODE);

-- ���ο� ���� �ֱ� -- SAL�� 300�̻��� ���ڵ� �����ϱ�
-- 1) SQL JOIN
SELECT *
FROM TEST1 T1, TEST2 T2, TEST3 T3
WHERE T1.ID = T2.ID AND T2.CODE = T3.CODE AND SAL>=300;


-- 2) ANSI JOIN
-- ON���� WHEREó�� ������ AND�� ���� �־��� �� ����.
SELECT *
FROM TEST1 JOIN TEST2
ON TEST1.ID = TEST2.ID JOIN TEST3
ON TEST2.CODE = TEST3.CODE AND SAL >= 300;

-- WHERE�� USING ������ ��� ����. JOIN���� FROM�� ������ �����־����.
SELECT *
FROM TEST1 JOIN TEST2
USING (ID) JOIN TEST3
USING (CODE)
WHERE SAL >= 300;

--NON-EQUI JOIN
-- EMP���̺��� ����� ���� + �޿������ �Բ� �˻��ϰ� �ʹ�
SELECT * FROM EMP; -- ��� ���̺�
SELECT * FROM SALGRADE; -- �޿���� ���̺� 

-- 1) SQL JOIN
SELECT EMPNO, ENAME, JOB, SAL, GRADE
FROM EMP, SALGRADE
WHERE SAL BETWEEN LOSAL AND HISAL; -- NON EQUI JOIN;

-- 2) ANSI JOIN
SELECT EMPNO, ENAME, JOB, SAL, GRADE, LOSAL, HISAL
FROM EMP JOIN SALGRADE
ON SAL BETWEEN LOSAL AND HISAL;

-- SELF JOIN - �ڱ��ڽ� ���̺��� 2���� ���� ����(���������)

-- EX) SMITH����� �����ڴ� FORD�Դϴ�. ���
SELECT * FROM EMP;
SELECT ENAME || '����� �����ڴ� ' || MGR || '�Դϴ�.'
FROM EMP;

-- 1) SQL JOIN
SELECT E1.EMPNO �����ȣ, E1.ENAME ����̸�, E2.EMPNO �����ڻ����ȣ, E2.ENAME �������̸�
FROM EMP E1, EMP E2 -- E1�� ���, E2�� ������
WHERE E1.MGR = E2.EMPNO;

-- 2) ANSI JOIN
SELECT E1.EMPNO �����ȣ, E1.ENAME ����̸�, E2.EMPNO �����ڻ����ȣ, E2.ENAME �������̸�
FROM EMP E1 JOIN EMP E2 -- E1�� ���, E2�� ������
ON E1.MGR = E2.EMPNO;

--------------------------------------------------------------
/*
  SET ����
   1) ������
        UNION ALL - �ߺ����ڵ带����
        UNION - �ߺ����ڵ� ����
        
   2) ������ 
       INSERSECT : A�� B ���̺��� ����� ���ڵ� �˻�
       
   3) ������ 
        MINUS : A���̺��� B���̺��� ���ڵ带 �� ������ ���ڵ� �˻�
*/
-- ���̺� ����
CREATE TABLE SET_TEST01
AS SELECT EMPNO, ENAME, JOB, SAL FROM EMP WHERE SAL >= 3000;

CREATE TABLE SET_TEST02
AS SELECT EMPNO, ENAME, JOB, SAL FROM EMP WHERE DEPTNO IN (10, 20);

SELECT * FROM SET_TEST01; -- 3��
SELECT * FROM SET_TEST02; -- 8��

SELECT * FROM SET_TEST01 
UNION ALL -- �ߺ����ڵ带 ����
SELECT * FROM SET_TEST02;

SELECT * FROM SET_TEST01 
UNION -- �ߺ����ڵ带 ����
SELECT * FROM SET_TEST02;

SELECT * FROM SET_TEST01 
INTERSECT -- ������
SELECT * FROM SET_TEST02;

-- MINUS(������)
SELECT EMPNO, ENAME FROM SET_TEST02 
MINUS -- ������
SELECT EMPNO, ENAME FROM SET_TEST01;

SELECT EMPNO, ENAME FROM SET_TEST01
MINUS -- ������
SELECT EMPNO, ENAME FROM SET_TEST02;
 -------------------------------------------------------------
 /*
   SUBQUERY - ������
    : ���������ȿ� �� �ٸ� ������ �����ϴ°�
    : ()��ȣ�� ���´�. ��ȣ�ȿ� ���๮���� ���� ������� �� ����� ���������� �������� �ַ� ����Ѵ�. 
    : ���������� ��� ���� �Ѱ� �϶�  �񱳿����� ���.
    : ���������� ��� ���� ������ �϶��� ANY, ALL, IN �����ڸ� ����Ѵ�. 
    : �ַ� SELECT���� ���� ��������� CREATE, INSERT, UPDATE ,DELTE, 
           HAVING, WHERE , FROM ,ORDER ������ ��밡���ϴ�.
 */
 
 --EMP���̺��� ��� �޿����� �� ���� �޴� ��� �˻�
-- 1) ��� �޿��� ���Ѵ�
-- 2) 1�� ���� ����� �������� ����Ѵ�.
SELECT *
FROM EMP
WHERE SAL >(SELECT AVG(SAL) FROM EMP);

-- JOB�� 'A'���ڿ��� �� ����� �μ��� ���� ������ �ٹ��ϴ� ����� �μ��̸� �˻��ϰ� �ʹ�. 
-- 1) 'A' ���ڿ��� �� ����� �μ���ȣ PK�� ���Ѵ�.
SELECT DISTINCT DEPTNO FROM EMP WHERE JOB LIKE '%A%';
-- 2) 1)�� ����� �������� �����
SELECT DNAME
FROM DEPT
WHERE DEPTNO = ANY (SELECT DISTINCT DEPTNO FROM EMP WHERE JOB LIKE '%A%'); -- ���������� ����� �������� ���� ���
  
SELECT DNAME
FROM DEPT
WHERE DEPTNO IN (SELECT DISTINCT DEPTNO FROM EMP WHERE JOB LIKE '%A%'); -- ���������� ����� �������� ���� ���

 -- �μ���ȣ�� 30�� ������� �޿��߿��� ���� ���� �޴� ������� �� ���� �޴� ��������� �˻��ϰ� �ʹ�. 
-- �μ���ȭ 30�� ������� �޿��� ���� ���� �޴� ���(30 �μ��� �޿� �ִ밪)
SELECT *
FROM EMP
WHERE SAL > (SELECT MAX(SAL) FROM EMP WHERE DEPTNO = 30);

SELECT *
FROM EMP
WHERE SAL > ALL(SELECT SAL FROM EMP WHERE DEPTNO = 30); => -- ALL : �� ���� ��� ���� �ǹ�. => SAL�� ���������� ������ ��� ������ ū ���� ��Ÿ��.
-- SUBQUERY�� DML
-- EX) SET_TEST01 ���̺��� EMPNO 7839�� ����� JOB, ENAME, SAL�� �����Ѵ�.
-- �� ���� EMP ���̺��� 7566�� ����� ������ ������ �����Ѵ�.
SELECT * FROM SET_TEST01;
INSERT INTO SET_TEST01(SELECT EMPNO, ENAME, JOB, SAL FROM EMP WHERE SAL <= 1000);


--Ư���� Į���� �ٸ����̺�κ��� �����ͼ� INSERT
INSERT INTO SET_TEST01(EMPNO, JOB) (SELECT EMPNO, JOB FROM EMP WHERE SAL = 2450);

--SUBQUERY�� UPDATE
--EX) EMP���̺��� EMPNO 7900�� ����� JOB, MGR, DEPTNO�� SUB_EMP���̺��� 7566�� ����� ������ �����غ���.
-- ��� 1
UPDATE SET_TEST01
SET JOB = (SELECT JOB FROM EMP WHERE EMPNO = 7566), ENAME = (SELECT ENAME FROM EMP WHERE EMPNO = 7566), SAL = (SELECT SAL FROM EMP WHERE EMPNO = 7566)
WHERE EMPNO = 7900;

-- ���2
UPDATE SET_TEST01
SET (JOB, ENAME, SAL) = (SELECT JOB, ENAME, SAL FROM EMP WHERE EMPNO = 7839)
WHERE EMPNO = 7900;

--SUBQUERY�� DELETE
  --EX) EMP���̺��� ��� �޿��� �������� ����ؼ� ��ձ޿����� ���� �޴� ������� �����Ѵ�. 
DELETE FROM SET_TEST01
WHERE SAL > (SELECT AVG(SAL) FROM EMP);

 

--------------------------------------------------------------
/*
  SUBQUERY �������� �ϳ��� �ζ��κ�
   : FROM�� �ڿ� ���������� ���� ��.
*/


-- ROWNUM : MYSQL LIMIT ����

-- �޿��� �������� �����ؼ� ROWNUM�� �Բ� ����ϰ� �ʹ�.
SELECT ROWNUM, EMPNO, ENAME, JOB, SAL 
FROM EMP
ORDER BY SAL;
-- ���� ������ �������� ROWNUM�� ����� ���� ������ �ؼ� ROWNUM�� ������ ���� ����.
-- ���� ������ �� �Ŀ� ROWNUM�� ����
SELECT ROWNUM, EMPNO, ENAME, JOB, SAL
FROM (SELECT * FROM EMP ORDER BY SAL);

-- ROWNUM�� ������� ������ ������ .
--1. ROWUM�� 3���� ���� ���ڵ� �˻�
SELECT ROWNUM NO, EMPNO, ENAME, JOB, SAL
FROM (SELECT * FROM EMP ORDER BY SAL)
WHERE ROWNUM <= 3;

--2. ROWUM�� 3���� ū ���ڵ� �˻� => �ƹ��͵� �ȳ���
SELECT ROWNUM NO, EMPNO, ENAME, JOB, SAL
FROM (SELECT * FROM EMP ORDER BY SAL)
WHERE ROWNUM > 3;

--3. ROWUM�� 5 ~ 7 ���� ���ڵ� �˻� => �ƹ��͵� �ȳ���
SELECT ROWNUM NO, EMPNO, ENAME, JOB, SAL
FROM (SELECT * FROM EMP ORDER BY SAL)
WHERE ROWNUM BETWEEN 5 AND 7;

/*
  ROWNUM�� ���ڵ尡 ��������鼭 ��ȣ�� ���������� �ο��Ǵ� ������ ROWNUM 1 �� ������ 2�� �����Ҽ� ����. 
  �׷��� ROWNUM�� ��������  ~ ũ��  �Ǵ� �߰������� ���� �������� ����� �� ����. 
  ROWNUM�� ��� �ο��� ����� �������� ����ؾ��Ѵ�. 
*/
-- ���� ROWNUM�� ����� ���� ���̺��� ������ �������� ����ؾ���
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
  SEQUENCE : �ڵ� ���� �� ����
    :�������
      CREATE SEQUENCE �������̸�
      [START WITH �ʱⰪ]
      [INCREMENT BY ������]
      [MAXVALUE �ִ�]
      [MINVALUE �ּڰ�]
      [CACHE | NOCACHE]-- ���� NOCACHE ���
      [CYCLE | NOCYCLE]
      
    : �����
      �������̸�.NEXTVAL : �������� ����
      �������̸�.CURRVAL : �������� ���簪 ��������
       
    : ������ ����
    ALTER SEQUENCE �������̸�;
    
    : ������ ����
    DROP SEQUENCE �������̸�;
*/
CREATE SEQUENCE SEQ_TEST;
SELECT SEQ_TEST.NEXTVAL, SEQ_TEST.CURRVAL
FROM DUAL;

-- ���̺� ����
CREATE TABLE BOARD(
BNO NUMBER PRIMARY KEY,
SUBJECT VARCHAR2(50),
REG_DATE DATE DEFAULT SYSDATE
);

-- ������ ����
CREATE SEQUENCE BOARD_BNO_SEQ NOCACHE;

-- ������ �߰�
INSERT INTO BOARD (BNO, SUBJECT)
VALUES (BOARD_BNO_SEQ.NEXTVAL, '����' || BOARD_BNO_SEQ.CURRVAL);

SELECT * FROM BOARD;
