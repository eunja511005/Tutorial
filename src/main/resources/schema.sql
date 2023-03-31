DROP TABLE emp;
CREATE TABLE emp
(
    empno       NUMBER(4)	NOT NULL,
    ename       VARCHAR2(10),
    job         VARCHAR2(9),
    mgr         NUMBER(4),
    hiredate    DATE,
    sal         NUMBER(7,2),
    comm        NUMBER(7,2),
    deptno      NUMBER(2),
    CONSTRAINT emp_pk PRIMARY KEY (empno)
);
COMMENT ON TABLE emp IS '사원정보';
COMMENT ON COLUMN emp.empno IS '사원번호';
COMMENT ON COLUMN emp.ename IS '성명';
COMMENT ON COLUMN emp.job IS '직군';
COMMENT ON COLUMN emp.mgr IS '직속상사';
COMMENT ON COLUMN emp.hiredate IS '입사일';
COMMENT ON COLUMN emp.sal IS '급여';
COMMENT ON COLUMN emp.comm IS '보너스';
COMMENT ON COLUMN emp.deptno IS '부서코드';

drop table book;
create table book (seq number(4), isbn VARCHAR2(255), name VARCHAR2(255), author VARCHAR2(255), primary key (seq));
