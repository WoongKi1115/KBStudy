/*
   SELECT���� - DQL����
    : ����
    select distinct | * | �÷��� as ��Ī, �÷��� ��Ī,....   : ���� ���� :PROJECTION
    from ���̺��̸�     
    [where ���ǽ� ]  : ���ڵ�(Ʃ��)����  - SELECTION
    [order by �÷��� desc | asc , .. ] -����
    
    
    * distinct �� �ߺ����ڵ带 ����
    * AS �� �÷��� ��Ī ����� 
    * �������
      SELECT   3) 
      FROM     1)
      WHERE    2) 
      ORDER BY 4) 
    
*/

--EX) SCOTT���� ���� 

SELECT * FROM EMP; --������̺�
SELECT * FROM DEPT;--�μ��������̺�

--1) EMP���̺��� ���ϴ� �÷�(��Ī)
-- AS : ������ �� COLUMN�� ��Ī�� �ο�. ��� ����ó�� �߰��� ������ �ַ��� ""�� �����ֱ�.
SELECT EMPNO AS �����ȣ, ENAME AS ����̸�, JOB AS "��� ����", HIREDATE AS �����
FROM EMP;

--2) �ߺ��� �����ϱ� - DISTINCT
 --EX) �츮ȸ�翡 � JOB�ִ��� JOB�� ������ �˰�ʹ�!!!
-- DISTINCT�� �� ���� COLUMN�� �ּ�ȭ�ؾ���. �ΰ��� ���� ���ؼ� �ߺ��Ǵ� ���� �� ������ ����.
SELECT DISTINCT JOB FROM EMP;

 
--3) ���� ����� 
 -- �޿��� 3000�̻��� ��� �˻�
SELECT *
FROM EMP
WHERE SAL >= 3000;
 
 --4) ����
 -- �޿��� 2000�̻��� ����� �˻��ϰ� �޿��� �������� ����
SELECT *
FROM EMP
WHERE SAL >= 2000
ORDER BY SAL; -- ��������
-- ���������� DESC;
 --JOB�� �������� �������������ϰ� JOB�� ������ �޿��� �������� ����
SELECT *
FROM EMP
ORDER BY JOB DESC, SAL;

-------
SELECT EMPNO, ENAME, JOB, SAL AS �޿�
FROM EMP
WHERE SAL>2000 -- WHERE���� ��Ī�� ����� �� ����. -> ������� ������ �Ұ���.
ORDER BY �޿�; -- ORDER BY 00�� ��Ī���� ����� �� ����.

-- ���� ��� �÷��� INDEX ���
SELECT EMPNO, ENAME, JOB, SAL
FROM EMP
ORDER BY 3, 4; -- SELECT���� ���� �÷� ������ �������� ������(1���� ������) => JOB, SAL�� ��.


--Į���鳢�� ������ �����ϴ�

SELECT EMPNO, ENAME, SAL, COMM, (SAL+COMM) * 12 AS ����
FROM EMP;

-- NULL�� ������ �ȵ�. 
-- NULL���� �ٸ� ������ �����ؼ� ���� �� �� �ִ�  -->  NVL(Į����, ���氪)
            -- NULL�� 0����  -- NULL�� 100����
SELECT COMM, NVL(COMM, 0), NVL(COMM, 100) FROM EMP;

SELECT EMPNO, ENAME, SAL, COMM,(SAL + NVL(COMM, 0)) * 12 AS ����
FROM EMP;

--�� ����� ~�Դϴ�. ��� ---  ���ڿ� ���� || �̿�
SELECT ENAME || '�� ������' || (SAL + NVL(COMM, 0)) * 12 || '�Դϴ�.' AS MESSAGE
FROM EMP;

--�� ����� ~�Դϴ�. ��� ---  CONCAT() �Լ� Ȱ�� CONCAT(A, B) A �ڿ� B�� ����
SELECT CONCAT(CONCAT(ENAME, '�� ������'), (SAL + NVL(COMM, 0)) * 12)
FROM EMP;
SELECT ENAME || '�� ������' || (SAL + NVL(COMM, 0)) * 12 || '�Դϴ�.' AS MESSAGE
FROM EMP;

  
-----------------------------------------------------------------------------------
/*
  ������ ����
  1) ���������
     +, -, *, / 
     ������ : MOD(��, ������)
     
   2) ���迬����
       > , <, >= , <= , !=, <>
       ����  :  =
       
   3) �񱳿�����
    - AND
    - OR
    - IN :  �÷��� IN (��, ��, ��)  - �ϳ��� �÷��� ������� �Ǵ����� ���Ҷ� ����Ѵ�.
    
    - BETWEEN AND :  �÷��� BETWEEN �ּ� AND �ִ� - �ϳ��� �÷��� ������� �ּ� ~ �ִ븦 ���Ҷ�
    
    - LIKE  : ���ϵ�ī�� ���ڿ� �Բ� ����Ѵ�.
        1. % : 0���̻��� ����
        2. _ : �ѱ���  
        
        EX)  name like 'J%' ;   - NAME�� ù���ڰ� J�� �����ϴ� ��� ����
             name like '___' ;  - NAME�� 3���� 
             name like 'J_J%';  - NAME�� ù���ڰ� J�� �����ϰ� 3��° ���� A�� ���� �˻�
             
    
    - NOT : ���� ��� �����ڵ� �տ� NOT�� ������ �ݴ� ����.
        
*/
--EX) ��������� : EMP���� ������ = (SAL + COMM) *12  �ؼ� ��� �÷� 
 
 
 -- * NVL(��, ��ġ��)  : NULL�� ã�� ��ġ������ �����Ѵ�. 


--EX) ����� ����ϱ� ���ؼ� COMM�� NULL�� ã�� 0���� �������� �����Ѵ�. - NVL�Լ� ���


--EX) ~���� ����� ~ �Դϴ�. ���  : ���ڿ��� �����Ҷ� || ����Ѵ�.



--EX) SAL �� 2000 ~ 4000��� �˻�(AND, BETWEEN AND )
SELECT ENAME
FROM EMP
WHERE SAL>=2000 AND SAL<=4000;

SELECT ENAME
FROM EMP
WHERE SAL BETWEEN 2000 AND 4000;
 

--EX) SAL �� 2000 ~ 4000����ƴ� ���ڵ� �˻� -  NOT
SELECT ENAME
FROM EMP
WHERE SAL NOT BETWEEN 2000 AND 4000;



--EX) EMPNO �� 7566, 7782,7844�� ����˻� ( OR, IN)
SELECT ENAME
FROM EMP
WHERE EMPNO = 7566 OR EMPNO = 7782 OR EMPNO = 7844;

SELECT ENAME
FROM EMP
WHERE EMPNO IN (7566, 7782, 7844);


--EX) EMPNO �� 7566, 7782,7844�� ����� �ƴ� �˻� ( NOT)
SELECT ENAME
FROM EMP
WHERE EMPNO NOT IN (7566, 7782, 7844);

---------------------------------------------------------------------------
--1) JOB�� 'A' ���ڷν����ϴ� ���ڵ� �˻�
SELECT ENAME
FROM EMP
WHERE LOWER(JOB) LIKE 'A%';

--2) JOB�� �� ���ڰ� 'N'���� ������ ���ڵ� �˻�
SELECT ENAME
FROM EMP
WHERE JOB LIKE '%N';

--3) ENAME�� 4������ ���ڵ� �˻�
SELECT ENAME
FROM EMP
WHERE ename LIKE '____';

--4) ENAME�� A���ڰ� ���Ե� ���ڵ� �˻�
SELECT ENAME
FROM EMP
WHERE ENAME LIKE '%A%';

--5) ENAME��ü ���ڰ� 5�����̰� �ι�° ���ڰ� m�̸鼭�����ڰ� h�� ���ڵ� �˻�
SELECT ENAME
FROM EMP
WHERE UPPER(ENAME) LIKE '_M__H'; 
-------------------------------------------------------------------------------------------------
-- WOONG �������� ����
SELECT * FROM MEMBER;
INSERT INTO MEMBER(ID, NAME, JUMIN, AGE) VALUES ('NA', 'WOONG%KI', '111', 29);
INSERT INTO MEMBER(ID, NAME, JUMIN, AGE) VALUES ('N', 'WOO', '222', 29);
SELECT * FROM MEMBER
WHERE NAME LIKE '%%%';
-- LIKE�� Ȱ���� �� ã�� ������ ���� %�� �־ % �������� ã�����Ҷ� %%%�� �� �� ����.
SELECT * FROM MEMBER
WHERE NAME LIKE '%@%%' ESCAPE '@';
-- �ȿ� Ư����ȣ�� ���� �� �װ� ã�� ���� ESCAPE��� Ű���带 �ְ� �� Ű���� �ڿ� �ش� ��ȣ�� ������
-- �� ��ü�� ���� �������. => ã�� �� ����.

/*
    NULL ã��
    1) IS NULL
    2) IS NOT NULL
*/

-- COMM�� NULL�� ���ڵ� �˻�
SELECT * FROM EMP WHERE COMM IS NULL;
SELECT * FROM EMP WHERE COMM IS NOT NULL;
--COPY_EMP ���̺��� COMM�� NULL���ڵ带 COMM�� ���� 100���� ����
SELECT * FROM COPY_EMP;

UPDATE copy_emp
SET COMM = 100
WHERE COMM IS NULL;
 
 
-- NULL�� �ִ� �÷��� ������� ������ �غ���
SELECT * FROM EMP ORDER BY COMM; -- ���������϶��� NULL�� �������� ��ȸ�ȴ�
SELECT * FROM EMP ORDER BY COMM DESC; -- ���������϶��� NULL�� ó���� ��ȸ�ȴ� 
SELECT * FROM EMP ORDER BY COMM ASC NULLS FIRST; --NULL�� �켱������ ���




                    
                    
                    
 
 

------------------------------------------------------------------
