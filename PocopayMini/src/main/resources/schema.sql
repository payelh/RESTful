CREATE TABLE  Account(
account_id 			int(15) 	unsigned 	NOT NULL 	auto_increment,
owner_name 			varchar(45) 			NOT NULL,
date_of_birth 		varchar(12) 			NOT NULL,
account_balance 	DECIMAL(18,2),
PRIMARY KEY  (account_id)
);


CREATE TABLE  Payment(
payment_id 		int(10)	 	unsigned 	NOT NULL auto_increment,
src_account_id 	int(15) 				NOT NULL,
dest_account_id int(15) 				NOT NULL,
payment_amount DECIMAL(18,3),
payment_reference	varchar(255),
transaction_time DATETIME,
PRIMARY KEY  (payment_id)
);