create table addressbook(
	seq int auto_increment primary key,
	name varchar(30) not null,
	age decimal(3),
	phone varchar(30),
	address varchar(100),
	memo varchar(1000)
);
alter table addressbook convert to character set utf8;
select * from addressbook;

update addressbook
set phone = '010-1234-1234'
where name = 'È«±æµ¿';

select * from addressbook
where memo like '%µ¿%';