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
VALUES('board_uuid', 'TEST', 'TEST', 'ywbest.park', sysdate, 'ywbest.park', sysdate);
*/   