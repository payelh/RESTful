drop database if EXISTS pocopay;
create database pocopay;
use pocopay;

drop table if EXISTS Account;
CREATE TABLE  Account(
account_id 			int(15) 	unsigned 	NOT NULL 	auto_increment,
owner_name 			varchar(45) 			NOT NULL,
date_of_birth 		varchar(12) 			NOT NULL,
account_balance 	DECIMAL(18,2),
PRIMARY KEY  (account_id)
);


drop table if EXISTS Payment;
CREATE TABLE  Payment(
payment_id 		int(10)	 	unsigned 	NOT NULL auto_increment,
src_account_id 	int(15) 				NOT NULL,
dest_account_id int(15) 				NOT NULL,
payment_amount DECIMAL(18,3),
payment_reference	varchar(255),
transaction_time DATETIME,
PRIMARY KEY  (payment_id)
);

insert into Account(owner_name,date_of_birth,account_balance) values ('PAYEL','25-11-1982',500.00);
insert into Account(owner_name,date_of_birth,account_balance) values ('SOHEL','15-09-1978',500.00);
insert into payment (payment_id, src_account_id, dest_account_id, payment_amount, payment_reference, transaction_time ) values(1,1,2,100,'Test Payment', '2016-01-01 01:01:01');