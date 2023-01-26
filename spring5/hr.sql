DROP TABLE spring5_member;
CREATE TABLE spring5_member (
    memberid VARCHAR2(20) PRIMARY KEY,          --사용자 ID 
	memberpw VARCHAR2(100) NOT NULL,	 	    --비밀번호
    membername VARCHAR2(30) NOT NULL,		    --사용자 이름
    email VARCHAR2(50),			                --이메일
    phone VARCHAR2(50),			                --전화번호
    address VARCHAR2(150),			            --주소
    enabled NUMBER(1) DEFAULT 1,                --계정 상태 (1-사용가능, 0-불가능)
    rolename VARCHAR2(20) DEFAULT 'ROLE_USER'   --Role('ROLE_USER' - 일반회원, 'ROLE_ADMIN')
);

CREATE SEQUENCE spring5_member;

INSERT INTO spring5_member (memberid, memberpw, membername, email,phone,address)
VALUES ('aaa', '111','박잼민','aa@naver.com','010-1111-1111,', '서울시 강남구 삼성동');
SELECT * FROM spring5_member;
commit;
ROLLBACK;