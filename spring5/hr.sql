DROP TABLE spring5_member;
CREATE TABLE spring5_member (
    memberid VARCHAR2(20) PRIMARY KEY,          --����� ID 
	memberpw VARCHAR2(100) NOT NULL,	 	    --��й�ȣ
    membername VARCHAR2(30) NOT NULL,		    --����� �̸�
    email VARCHAR2(50),			                --�̸���
    phone VARCHAR2(50),			                --��ȭ��ȣ
    address VARCHAR2(150),			            --�ּ�
    enabled NUMBER(1) DEFAULT 1,                --���� ���� (1-��밡��, 0-�Ұ���)
    rolename VARCHAR2(20) DEFAULT 'ROLE_USER'   --Role('ROLE_USER' - �Ϲ�ȸ��, 'ROLE_ADMIN')
);

CREATE SEQUENCE spring5_member;

INSERT INTO spring5_member (memberid, memberpw, membername, email,phone,address)
VALUES ('aaa', '111','�����','aa@naver.com','010-1111-1111,', '����� ������ �Ｚ��');
SELECT * FROM spring5_member;
commit;
ROLLBACK;