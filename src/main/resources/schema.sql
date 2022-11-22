drop table  if exists book;
create table book (id INT AUTO_INCREMENT, isbn varchar(255), name varchar(255), author varchar(255), primary key (id));