drop table person;
create table person (
	idnum 	varchar2(20) primary key, 
	name	varchar2(30) not null,
	age 	number(3) default 0
);

INSERT INTO person(idnum,name,age)
VALUES ('A','A','1');
SELECT * FROM person;
commit;
ROLLBACK;

delete
person
where
    name like ('%¹Ú%');