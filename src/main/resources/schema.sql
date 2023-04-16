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
    username      VARCHAR2(30),
    password      VARCHAR2(100),
    email         VARCHAR2(30),
    role          VARCHAR2(30),
    picture       VARCHAR2(50),
    enable        CHAR(1), 
    create_id     VARCHAR2(30),
    create_time   VARCHAR2(14),
    update_id     VARCHAR2(30),
    update_time   VARCHAR2(14),
    CONSTRAINT PK_ZTHM_USER_USERNAME PRIMARY KEY (username)
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
COMMENT ON COLUMN zthm_user.update_id IS '수정자';
COMMENT ON COLUMN zthm_user.update_time IS '수정시간';


DROP TABLE zthh_error;
CREATE TABLE zthh_error
(
    id             VARCHAR2(30),
    error_message   VARCHAR2(4000),
    create_id      VARCHAR2(30),
    create_time    VARCHAR2(14),
    update_id      VARCHAR2(30),
    update_time    VARCHAR2(14),
    CONSTRAINT zthh_error_pk PRIMARY KEY (id)
);
COMMENT ON TABLE zthh_error IS '에러 테이블';
COMMENT ON COLUMN zthh_error.id IS '에러 ID';
COMMENT ON COLUMN zthh_error.error_message IS '에러 메세지';
COMMENT ON COLUMN zthh_error.create_id IS '생성자';
COMMENT ON COLUMN zthh_error.create_time IS '생성시간';
COMMENT ON COLUMN zthh_error.update_id IS '수정자';
COMMENT ON COLUMN zthh_error.update_time IS '수정시간';

DROP TABLE zthh_file_attach;
CREATE TABLE zthh_file_attach (
    attach_id VARCHAR2(200),
    sequence NUMBER,
    original_file_name VARCHAR2(255),
    file_name VARCHAR2(255),
    file_type VARCHAR2(255),
    file_size NUMBER,
    file_path VARCHAR2(1000),
    create_id      VARCHAR2(30),
    create_time    VARCHAR2(14),
    update_id      VARCHAR2(30),
    update_time    VARCHAR2(14),
    PRIMARY KEY (attach_id, sequence)
);
COMMENT ON TABLE zthh_file_attach IS '파일 첨부 테이블';
COMMENT ON COLUMN zthh_file_attach.attach_id IS '첨부 ID';
COMMENT ON COLUMN zthh_file_attach.sequence IS '1개의 첨부 ID에 파일이 여러개 일때 순서 기본은 1';
COMMENT ON COLUMN zthh_file_attach.original_file_name IS '첨부 파일 원복 이름';
COMMENT ON COLUMN zthh_file_attach.file_name IS '첨부 파일 이름';
COMMENT ON COLUMN zthh_file_attach.file_type IS '첨부 파일 타입';
COMMENT ON COLUMN zthh_file_attach.file_size IS '첨부 파일 사이즈';
COMMENT ON COLUMN zthh_file_attach.create_id IS '생성자';
COMMENT ON COLUMN zthh_file_attach.create_time IS '생성시간';
COMMENT ON COLUMN zthh_file_attach.update_id IS '수정자';
COMMENT ON COLUMN zthh_file_attach.update_time IS '수정시간';

DROP TABLE zthh_board;
CREATE TABLE zthh_board (
    board_id VARCHAR2(200),
    title VARCHAR2(255),
    content CLOB,
    create_id      VARCHAR2(30),
    create_time    date,
    update_id      VARCHAR2(30),
    update_time    date,
    PRIMARY KEY (board_id)
);
COMMENT ON TABLE zthh_board IS '글쓰기 테이블';
COMMENT ON COLUMN zthh_board.board_id IS '글쓰기 ID';
COMMENT ON COLUMN zthh_board.title IS '제목';
COMMENT ON COLUMN zthh_board.content IS '내용';
COMMENT ON COLUMN zthh_board.create_id IS '생성자';
COMMENT ON COLUMN zthh_board.create_time IS '생성시간';
COMMENT ON COLUMN zthh_board.update_id IS '수정자';
COMMENT ON COLUMN zthh_board.update_time IS '수정시간';