--SCOTT���� 

SELECT * FROM emp;
SELECT * FROM dept; --�μ�����
SELECT * FROM salgrade; --�޿����


-- 1. SMITH �� ����  ���� �˻�(ename, emp.deptno, loc .)
SELECT ENAME, EMP.DEPTNO, LOC
FROM EMP JOIN DEPT
ON emp.deptno = dept.deptno
WHERE ENAME = 'SMITH';

--2. NEW YORK�� �ٹ��ϴ� ����� �̸��� �޿��� ���
SELECT ENAME, SAL
FROM EMP JOIN DEPT
USING (DEPTNO)
WHERE LOC = 'NEW YORK';

-- 3. ACCOUNTING �μ� �Ҽ� ����� �̸��� �Ի��� ���
SELECT ENAME, HIREDATE
FROM EMP JOIN DEPT
USING (DEPTNO)
WHERE DNAME = 'ACCOUNTING';

-- 4. ������ MANAGER�� ����� �̸�, �μ��� ���
SELECT ENAME, DNAME
FROM EMP JOIN DEPT
USING (DEPTNO)
WHERE JOB = 'MANAGER';

-- 5. ����� �޿��� �� ��������� �˻�
SELECT ENAME, SAL, GRADE, LOSAL, HISAL
FROM EMP JOIN SALGRADE
ON SAL BETWEEN LOSAL AND HISAL;

-- between A and B
select * from salgrade;
select * from emp;

SELECT EMPNO, ENAME, SAL, GRADE, LOSAL, HISAL
 FROM EMP JOIN salgrade
 ON SAL BETWEEN LOSAL AND HISAL;
 


--6. ��� ���̺��� �μ� ��ȣ�� �μ� ���̺��� �����ؼ� �μ���, �޿� ��޵� �˻�
SELECT ENAME, DNAME, GRADE
FROM EMP JOIN DEPT
USING (DEPTNO) JOIN SALGRADE
ON SAL BETWEEN LOSAL AND HISAL;

--7. SMITH�� �޴���(mgr) �̸�(ename) �˻�
SELECT E2.ENAME �޴����̸�
FROM EMP E1 JOIN EMP E2
ON E1.MGR = E2.EMPNO
WHERE E1.ENAME = 'SMITH';


--8. �����ڰ� KING�� ������� �̸��� ����(job) �˻�
SELECT E1.ENAME, E1.JOB
FROM EMP E1 JOIN EMP E2
ON E1.MGR = E2.EMPNO AND E2.ENAME = 'KING';

--9. SMITH �� ������ �μ���ȣ(DEPTNO)���� �ٹ��ϴ� ����� �̸� ���
-- ��, SMITH ������ ���� ��� �Ұ�
SELECT E2.ENAME
FROM EMP E1 JOIN EMP E2
ON E1.DEPTNO = E2.DEPTNO
WHERE E1.ENAME = 'SMITH' AND E2.ENAME != 'SMITH';

--10. SMITH �� ������ �ٹ���(LOC)���� �ٹ��ϴ� ����� �̸� ���
-- ��, SMITH ������ ���� ��� �Ұ�

SELECT E1.ENAME, D1.LOC, E2.ENAME, D2.LOC
FROM 
(EMP E1 JOIN DEPT D1
ON E1.DEPTNO = D1.DEPTNO)
JOIN
(EMP E2 JOIN DEPT D2
ON E2.DEPTNO = D2.DEPTNO)
ON D1.LOC = D2.LOC
WHERE E1.ENAME = 'SMITH' AND E2.ENAME != 'SMITH';

-- FROM (2���� ���̺��� JOIN�� ���) JOIN (2���� ���̺��� JOIN�� ���)

-- 11, �����, �ش� �ϴ� �޴����� �˻�
-- �ݵ�� ��� �����(CEO����) ���� �˻�
-- CEO�� ��� �޴��� ���� null
SELECT E1.ENAME, E2.ENAME �޴�����
FROM EMP E1 LEFT JOIN EMP E2
ON E1.MGR = E2.EMPNO;










