INSERT INTO emp VALUES(1, 'KING', 'PRESIDENT', NULL, TO_DATE('1981-11-17', 'yyyy-mm-dd'), 5000, NULL, 10);
insert into book(seq, isbn, name, author) values (auto_seq.NEXTVAL, 'isbn1', 'name1', 'author1');
insert into book(seq, isbn, name, author) values (auto_seq.NEXTVAL, 'isbn2', 'name2', 'author2');
insert into zthm_user(username, password, email, role, picture, enable, create_id, create_time, update_id, update_time) values('ywbest.park', '$2a$10$RWq20vPGyVlHLMxPCuyd6e9NFcqpCijj2MeWOMt/AcE4UcdN2qLZq', 'ywbest.park@gmail.com', 'sysadmin', '', '1', 'ywbest.park', to_char(sysdate,'yyyymmddhh24mmss'), 'ywbest.park', to_char(sysdate,'yyyymmddhh24mmss'));