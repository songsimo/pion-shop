CREATE TABLE IF NOT EXISTS product (
	id bigInt auto_increment,
	name varchar(50),
	price int,
	primary key(id)
);

CREATE TABLE IF NOT EXISTS transaction (
	errorType varchar(50),
	content varchar(255)
);