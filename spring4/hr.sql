drop table guestbook;
create table guestbook (
    num number PRIMARY key,
	name varchar(30) not null, 
	password varchar2(30) not null,
    contents varchar2(3000) not null,
	inputdate date default sysdate
);

create SEQUENCE guestbook_seq;

INSERT INTO guestbook(num, name, password, contents)
VALUES (guestbook_seq.nextval,'�����','111','�۳���');
SELECT * FROM guestbook;
commit;
ROLLBACK;

delete guestbook where name like ('%��%');