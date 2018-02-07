# spring-data-training

use shop;

drop table book;
create table book (id integer  NOT NULL AUTO_INCREMENT primary key, name varchar (100), author_id integer);

select * from book;

insert into book values(1, 'Tom Sawyerr', 1);

select column_name from information_schema.columns where table_name='book';
