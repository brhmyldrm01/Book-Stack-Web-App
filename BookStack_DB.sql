create schema bookstack;



create table person (
id char(11) PRIMARY KEY,
name varchar (45) not null,
surname varchar(45) not null,
password varchar(45) not null
);

CREATE TABLE book (
id INT  AUTO_INCREMENT PRIMARY KEY,
person_id char(11) ,
name VARCHAR(50) NOT NULL,
author VARCHAR(50) NOT NULL,
due_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
page smallint not null,
FOREIGN KEY(person_id) references person(id)
)

