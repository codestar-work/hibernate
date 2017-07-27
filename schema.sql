create database icoffee;
create user hibernate@'%' identified by 'p@ssword';
grant all on icoffee.* to hibernate@'%';
use icoffee;

create table coffee (
	id      serial,
	name    varchar(255),
	size    char,
	price   double
);
insert into coffee(name,size,price) values('Latte', 'S', 100);
insert into coffee(name,size,price) values('Latte', 'T', 115);
insert into coffee(name,size,price) values('Latte', 'G', 130);
insert into coffee(name,size,price) values('Latte', 'V', 145);
insert into coffee(name,size,price) values('Mocha', 'S', 115);
insert into coffee(name,size,price) values('Mocha', 'T', 130);
insert into coffee(name,size,price) values('Mocha', 'G', 145);
insert into coffee(name,size,price) values('Mocha', 'V', 160);
