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

drop table zthm_user;
CREATE TABLE zthm_user
(
    username      VARCHAR2(30) NOT NULL,
    password      VARCHAR2(100),
    email         VARCHAR2(30),
    role          VARCHAR2(30),
    picture       VARCHAR2(50),
    enable        CHAR(1), 
    create_id     VARCHAR2(30),
    create_time   VARCHAR2(14),
    update_id     VARCHAR2(30),
    update_time   VARCHAR2(14)
);
COMMENT ON TABLE zthm_user IS '유저정보';
COMMENT ON COLUMN zthm_user.username IS '유저이름';
COMMENT ON COLUMN zthm_user.password IS '패스워드';
COMMENT ON COLUMN zthm_user.email IS '이메일';
COMMENT ON COLUMN zthm_user.role IS '역할';
COMMENT ON COLUMN zthm_user.picture IS '사진';
COMMENT ON COLUMN zthm_user.enable IS '사용여부';
COMMENT ON COLUMN zthm_user.create_id IS '생성자';
COMMENT ON COLUMN zthm_user.create_time IS '생성시간';
COMMENT ON COLUMN zthm_user.update_id IS '수정장';
COMMENT ON COLUMN zthm_user.update_time IS '수정시간';