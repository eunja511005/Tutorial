/*
INSERT INTO emp VALUES(1, 'KING', 'PRESIDENT', NULL, TO_DATE('1981-11-17', 'yyyy-mm-dd'), 5000, NULL, 10);

insert into book(seq, isbn, name, author) values (auto_seq.NEXTVAL, 'isbn1', 'name1', 'author1');

insert into book(seq, isbn, name, author) values (auto_seq.NEXTVAL, 'isbn2', 'name2', 'author2');

insert into zthm_user(username, password, email, role, picture, enable, create_id, create_time, update_id, update_time) values('ywbest.park', '$2a$10$RWq20vPGyVlHLMxPCuyd6e9NFcqpCijj2MeWOMt/AcE4UcdN2qLZq', 'ywbest.park@gmail.com', 'sysadmin', '20230412/137215184927261.jpeg', '1', 'ywbest.park', to_char(sysdate,'yyyymmddhh24mmss'), 'ywbest.park', to_char(sysdate,'yyyymmddhh24mmss'));

INSERT INTO ZTHH_FILE_ATTACH
(ATTACH_ID, SEQUENCE, ORIGINAL_FILE_NAME, FILE_NAME, FILE_TYPE, FILE_SIZE, FILE_PATH, create_id, create_time, update_id, update_time)
VALUES('user_attach_1', 1, '7_2i3Ud018svck2mp5ywpv1zq_2gsiif.jpg', '563086458821600.png', 'PNG', 856, 'D:\Users\ywbes\git\Tutorial\user-photos\20230411\563086458821600.png', 'ywbest.park', to_char(sysdate,'yyyymmddhh24mmss'), 'ywbest.park', to_char(sysdate,'yyyymmddhh24mmss'));

INSERT INTO ZTHH_BOARD
(BOARD_ID, TITLE, CONTENT, create_id, create_time, update_id, update_time)
VALUES('board_uuid', 'TEST', 'TEST', 'ywbest.park', CURRENT_DATE, 'ywbest.park', CURRENT_DATE);

INSERT INTO ZTHM_COMMON_CODE
(id, code_group_id, code_group_name, code_group_description, code_id, code_level, code_sequence, code_name, code_description, 
 enable, create_id, create_time, update_id, update_time)
VALUES(code_seq.NEXTVAL, 'ROLE', '역할', '역할 구분', 'ROLE', '0', '', '', '', 
'1', 'ywbest.park', CURRENT_DATE, 'ywbest.park', CURRENT_DATE);

INSERT INTO ZTHM_COMMON_CODE
(id, code_group_id, code_group_name, code_group_description, code_id, code_level, code_sequence, code_name, code_description, 
 enable, create_id, create_time, update_id, update_time)
VALUES(code_seq.NEXTVAL, 'ROLE', '역할', '역할 구분', 'ADMIN', '1', '1', '관리자', '관리자', 
'1', 'ywbest.park', CURRENT_DATE, 'ywbest.park', CURRENT_DATE);

INSERT INTO ZTHM_COMMON_CODE
(id, code_group_id, code_group_name, code_group_description, code_id, code_level, code_sequence, code_name, code_description, 
 enable, create_id, create_time, update_id, update_time)
VALUES(code_seq.NEXTVAL, 'ROLE', '역할', '역할 구분', 'FAMILY', '1', '2', '가족', '가족', 
'1', 'ywbest.park', CURRENT_DATE, 'ywbest.park', CURRENT_DATE);

INSERT INTO ZTHM_COMMON_CODE
(id, code_group_id, code_group_name, code_group_description, code_id, code_level, code_sequence, code_name, code_description, 
 enable, create_id, create_time, update_id, update_time)
VALUES(code_seq.NEXTVAL, 'ROLE', '역할', '역할 구분', 'USER', '1', '3', '일반 사용자', '일반 사용자', 
'1', 'ywbest.park', CURRENT_DATE, 'ywbest.park', CURRENT_DATE);
*/   