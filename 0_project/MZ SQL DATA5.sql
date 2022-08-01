
DROP TABLE MEMBER CASCADE CONSTRAINTS;
DROP TABLE NOTICE CASCADE CONSTRAINTS;
DROP TABLE REPLY CASCADE CONSTRAINTS;
DROP TABLE RESTAURANT CASCADE CONSTRAINTS;
DROP TABLE FOOD CASCADE CONSTRAINTS;
DROP TABLE BOARD CASCADE CONSTRAINTS;
DROP TABLE IMAGE CASCADE CONSTRAINTS;


DROP SEQUENCE SEQ_NID;
DROP SEQUENCE SEQ_RID;
DROP SEQUENCE SEQ_FID;
DROP SEQUENCE SEQ_BID;
DROP SEQUENCE SEQ_RPID;
DROP SEQUENCE SEQ_IID;


--------------------------------------------------
--------------     MEMBER ����	------------------	
--------------------------------------------------


CREATE TABLE MEMBER (
	USER_ID	VARCHAR2(20) PRIMARY KEY,
	USER_PWD	VARCHAR2(100)	NOT NULL,
    USER_NAME VARCHAR2(20) NOT NULL,
    PHONE	VARCHAR2(13)	NOT NULL,
	USER_EMAIL	VARCHAR2(50)	NOT NULL,
	GENDER	CHAR(1)		DEFAULT 'M',
    ADDRESS VARCHAR2(100)    NOT NULL,	
	BORN_DATE	DATE    NOT NULL,	
  	ENROLL_DATE DATE    DEFAULT SYSDATE,
    MODIFY_DATE DATE    DEFAULT SYSDATE,
  	STATUS VARCHAR2(1) DEFAULT 'Y'
					             
);

INSERT INTO MZ.MEMBER VALUES ('admin', '1234', '������',  '010-1111-2222', 'admin@naver.com', 'M', '����� �д籸 ���ڵ�', '90/02/06', SYSDATE, SYSDATE, DEFAULT);
INSERT INTO MZ.MEMBER VALUES ('user01', 'pass01', '�ֱ���', '010-1111-1111', 'itkw87@naver.com', 'M', '������ �д籸 �Ǳ���', '95/09/25', SYSDATE, SYSDATE, DEFAULT);
INSERT INTO MZ.MEMBER VALUES ('user02', 'pass02', '����ȯ', '010-2222-5555', 'user02@naver.com', 'M', '��õ�� ���� �ΰ���', '90/02/06' , SYSDATE, SYSDATE, DEFAULT);
INSERT INTO MZ.MEMBER VALUES ('user03', 'pass03', '���ټ�', '010-3333-4444', 'user03@naver.com', 'W', '���ֽ� ���� ġ��', '90/02/06', SYSDATE, SYSDATE, DEFAULT);
INSERT INTO MZ.MEMBER VALUES ('user04', 'pass04', '�ֽſ�', '010-5555-4444', 'user04@naver.com', 'M', '����� ��õ�� ��', '88/06/25', SYSDATE, SYSDATE, DEFAULT);
INSERT INTO MZ.MEMBER VALUES ('user05', 'pass05', '��ö��', '010-5555-4444', 'user05@naver.com', 'M', '����� ��õ�� ��', '90/08/06', SYSDATE, SYSDATE, DEFAULT);
INSERT INTO MZ.MEMBER VALUES ('user06', 'pass06', '��ö��', '010-5555-4444', 'user06@naver.com', 'M', '����� ��õ�� ��', '98/05/08', SYSDATE, SYSDATE, DEFAULT);
INSERT INTO MZ.MEMBER VALUES ('user07', 'pass07', '��ö��', '010-5555-4444', 'user07@naver.com', 'M', '����� ��õ�� ��', '96/02/06', SYSDATE, SYSDATE, DEFAULT);
INSERT INTO MZ.MEMBER VALUES ('user08', 'pass08', '��ö��', '010-5555-4444', 'user08@naver.com', 'M', '����� ��õ�� ��', '93/04/21', SYSDATE, SYSDATE, DEFAULT);
INSERT INTO MZ.MEMBER VALUES ('user09', 'pass09', '�迵��', '010-5555-4444', 'user09@naver.com', 'W', '����� ��õ�� ��', '97/02/13', SYSDATE, SYSDATE, DEFAULT);
INSERT INTO MZ.MEMBER VALUES ('user10', 'pass10', '�ֿ���', '010-5555-4444', 'user10@naver.com', 'W', '����� ��õ�� ��', '99/03/27', SYSDATE, SYSDATE, DEFAULT);


--------------------------------------------------
--------------     NOTICE ����	------------------	
--------------------------------------------------

CREATE TABLE NOTICE (
  NOTICE_NO NUMBER PRIMARY KEY,
  NOTICE_TITLE VARCHAR2(100) NOT NULL,
  NOTICE_CONTENT VARCHAR2(4000) NOT NULL,
  NOTICE_WRITER VARCHAR2(30) NOT NULL,
  NOTICE_COUNT NUMBER DEFAULT 0,
  NOTICE_DATE DATE DEFAULT SYSDATE,
  STATUS VARCHAR2(1) DEFAULT 'Y'
);

CREATE SEQUENCE SEQ_NID

MAXVALUE 10000
NOCYCLE
NOCACHE;

INSERT INTO NOTICE VALUES (SEQ_NID.NEXTVAL, 'ù��° ���������Դϴ�.', 'ȯ���մϴ�.', 'admin', DEFAULT, SYSDATE, DEFAULT);





--------------------------------------------------
--------------     RESTAURANT ����	------------------	
--------------------------------------------------

CREATE TABLE RESTAURANT (
	RESTAURANT_NO	NUMBER PRIMARY KEY,
	RESTAURANT_NAME	VARCHAR2(30)	NOT NULL,
	RESTAURANT_ADDRESS	VARCHAR2(200)	NOT NULL,
	RESTAURANT_PHONE	VARCHAR2(13) NULL, -- NULL ���� -- NVL(RESTAURANT_PHONE, '-')
    RESTAURANT_INTRO VARCHAR(300) NULL, -- �Ĵ� ���ܼҰ�
    RESTAURANT_CONTENT VARCHAR(4000) NULL, -- �󼼺��� ���� ����
	STATUS VARCHAR2(1) DEFAULT 'Y'       
);

CREATE SEQUENCE SEQ_RID
MAXVALUE 10000
NOCYCLE
NOCACHE;

INSERT INTO RESTAURANT VALUES(SEQ_RID.NEXTVAL,'��ȭ�丮 �Ȱ�','���� ���Ǳ� �Ÿ��� 10-621 ���� 1��','02-877-9815',' �ټ��� �Դ� ���� ����. «���� �ع� ���� ���� Ǫ���ϴ�',
'<���׿� �־� ������ �߽Ĵ�>
�������� �������� ���ְ� �Ծ��� �Ȱ��� �ٽ� �湮�ߴ�. ���� �湮 ���� ��� ���� ���� �� �־��µ� �̹����� 30�� ���� ����ؾ� �ߴ�. 
��� �Ŀ� ���̺��� �ɾ� �ع�«�Ͱ� �����θ� �ֹ��ߴ�. �����ΰ� ���� ���� �� ���̾� �ٷ� «���� ���Դ�. 
������ : ���� ����� �� Ƣ���� �����δ� �ǿ� �� ��� Ư������ �ʾ����� �ٷ� Ƣ����� ������ ���ְ� �Ծ���. 
�ع�«�� : ���� ������ �Բ� ����, ��¡��, ����, ǥ��, �Ǹ�, ����ݸ� �� �پ��� ������ ������ ���Դ�. �������� �ػ깰�� ��ĥ���� ��ä���� �����Կ� �Ҹ����� ������ �����鼭�� �ʹ� �⸧���� �ʰ� ����� ������ ���Ҵ�. �ػ깰�鵵 �� ���� �ε巴�� �̱��ϰ� ���� �� �־���. 
�մԵ��� ������ �Ļ�ð����� �� �׸�, �� �׸� �ٷ� �ٷ� �����ϴ� ������ ������. ���׿� �̷��� ���������� ���ִ� �߽Ĵ��� �־� ��ڰ� �����ϴ�. ','Y');
INSERT INTO RESTAURANT VALUES(SEQ_RID.NEXTVAL,'¥�����','���� ���Ǳ� �Ÿ��� 1636-35','02-623-9525','���� �ʿ���� �ְ� ������ ¥��� 3000��!', 
'�ȳ��ϼ��� ������, GeniusJW �Դϴ�.
���� �Ұ��ص帱 ���Դ� ���Ǳ� �Ÿ��� 1636-35 �� ��ġ�� 3,000�� ¥����� �Ǹ��ϴ� ���� <¥�����>�Դϴ�.
�Ÿ��� ¥������� ������ ���� ������ ������ ¥���� «��, ������ ���� �Ǹ��ϰ� �ִ� �߽����̾����ϴ�. 
�������� �� �� �̿��� ���� �;��µ� �̹��� ��ȸ�� �Ǿ� �湮�߽��ϴ�.','Y');
INSERT INTO RESTAURANT VALUES(SEQ_RID.NEXTVAL,'�����','���� ���Ǳ� �Ÿ��� 10-621','02-877-9815','�������� �Ծ�� ���� ���� ���� ��?',
'��޸��� �������� �湮��. ���߳����� ���ĵκ���õ. ��õ�� �αٿ��� �߽� ���Ͽ丮 �����ϴ� ���̸� �ѹ� �����ñ� ��õ. 
��*����ó�� �������� ������ �絵 ���� ���� ����. ������ �ѽ����̾��� ���� �������� �ѿ���Ÿ���� �Ĵ� ���׸�� Ư���ϴ�. 
�а� ����ϰ� ������ ��. ������ä, ���߳���, ���ĵκε��� �ֹ��ϰ� �ǵκγ� ä�� ���񽺷� ���Դµ� ��ä �ʹ� ���� ���ͼ� �����.
���� �����ϴ� �ƽ���...�Ф� ���߳��� ���� �ٻ��ϰ�, ���� Ƣ��ŵ� �����ϴ� �����ʾ� ������ ��鿩 �Ծ���.
�����ַ� ���ε�. ������ä�� ��ŭ�ϴ� �����ѵ� ������������ �ʹ� ���Ƽ� ���� �����ϴ� �п��� �� ���� ��. 
���Ը����� ���񽺷� ���� �ǵκγ�ä�� �� ������. ��湮 �ǻ� ����. ��޵� �� ��ų ���� ��','Y');
INSERT INTO RESTAURANT VALUES(SEQ_RID.NEXTVAL,'�ƶ�����','���� ���Ǳ� ��õ�� 22','02-877-9815','���� �߽� �ڽ��丮�� ������ ��. ��߷�, �߿� ���� �� ��õ','�󼼺��� ����','Y');
INSERT INTO RESTAURANT VALUES(SEQ_RID.NEXTVAL,'ȫ�����','���� ���Ǳ� �Ÿ��� 35','02-826-8855','�鼱���� ���� ������ �귣�� ����','�󼼺��� ����','Y');
INSERT INTO RESTAURANT VALUES(SEQ_RID.NEXTVAL,'ä��','���� ���Ǳ� ��õ�� 232','02-499-3400','�ֺ� �ֹε��� ���÷��̽�. �� ���� ����� �־ �ѹ� �� ����� ���� ','�󼼺��� ����','Y');
INSERT INTO RESTAURANT VALUES(SEQ_RID.NEXTVAL,'����','���� �߱� ������ 30 �Ե�ȣ�ڼ��� ���� 37��','02-317-7101','�߱� �丮�ƽþ� �丮����','�󼼺��� ����','Y');
INSERT INTO RESTAURANT VALUES(SEQ_RID.NEXTVAL,'��ϴ��ø�','���� ��걸 ������59�� 5','02-790-8830','����(���ø�) ������','�󼼺��� ����','Y');
INSERT INTO RESTAURANT VALUES(SEQ_RID.NEXTVAL,'����«��','���� ���α� ������59�� 5','02-790-8830','«������ ������ �� ��. �ſ�� �� ����?','�󼼺��� ����','Y');
INSERT INTO RESTAURANT VALUES(SEQ_RID.NEXTVAL,'Ȳ����� �Ÿ�','����Ư���� ���Ǳ� �Ÿ��� ����� 35','02-859-0035','������ ��� ¥���� ������ ��','�󼼺��� ����','Y');


--------------------------------------------------
--------------     FOOD ����	------------------	
--------------------------------------------------


CREATE TABLE FOOD (
	FOOD_NO	NUMBER PRIMARY KEY,
	FOOD_NAME	VARCHAR2(20)	NOT NULL,
    FOOD_TYPE VARCHAR2(20) NOT NULL,
	RESTAURANT_NO	NUMBER ,
	STATUS	VARCHAR2(1)	DEFAULT 'Y', --���� �߰�
	CONSTRAINT FD_RESN_FK FOREIGN KEY (RESTAURANT_NO) REFERENCES RESTAURANT(RESTAURANT_NO) 
);

CREATE SEQUENCE SEQ_FID
MAXVALUE 10000
NOCACHE;

INSERT INTO FOOD VALUES(SEQ_FID.NEXTVAL, '«��', '�߽�', 1, 'Y');
INSERT INTO FOOD VALUES(SEQ_FID.NEXTVAL, '¥��', '�߽�', 2, 'Y');
INSERT INTO FOOD VALUES(SEQ_FID.NEXTVAL, '��������', '�߽�', 3, 'Y');
INSERT INTO FOOD VALUES(SEQ_FID.NEXTVAL, '������', '�߽�', 4, 'Y');
INSERT INTO FOOD VALUES(SEQ_FID.NEXTVAL, '������', '�߽�', 5, 'Y');
INSERT INTO FOOD VALUES(SEQ_FID.NEXTVAL, '���ø�', '�߽�', 6, 'Y');
INSERT INTO FOOD VALUES(SEQ_FID.NEXTVAL, '������', '�߽�', 7, 'Y');
INSERT INTO FOOD VALUES(SEQ_FID.NEXTVAL, '����', '�߽�', 8, 'Y');
INSERT INTO FOOD VALUES(SEQ_FID.NEXTVAL, '«��', '�߽�', 9, 'Y');
INSERT INTO FOOD VALUES(SEQ_FID.NEXTVAL, '���¥��', '�߽�', 10, 'Y');

select * from user_sequences;

--------------------------------------------------
--------------     BOARD ����	------------------	
--------------------------------------------------


CREATE TABLE BOARD (
	BOARD_NO	NUMBER	CONSTRAINT BO_BON_PK PRIMARY KEY,
	BOARD_TYPE NUMBER, -- �Ϲ� �Խ���(1)�̳� ���� �Խ���(2)�̳� Ȯ���ʿ�
	BOARD_TITLE	VARCHAR2(30)	NOT NULL,
	REF_RESTAURANT_NO	NUMBER,
	REF_FOOD_NO	NUMBER ,
	REF_USER_ID VARCHAR2(30),         	
	BOARD_COUNT	NUMBER	DEFAULT 0, -- ��ȸ��
	BOARD_CONTENT	VARCHAR2(4000)	NOT NULL,
	BOARD_DATE	DATE	NULL,    
  	MODIFY_DATE DATE DEFAULT SYSDATE,             
	STATUS VARCHAR2(1) DEFAULT 'Y' CHECK (STATUS IN('Y', 'N')),   --������ ����
	CONSTRAINT BO_USI_FK FOREIGN KEY (REF_USER_ID) REFERENCES MEMBER(USER_ID),
    CONSTRAINT BO_RRN_FK FOREIGN KEY (REF_RESTAURANT_NO) REFERENCES RESTAURANT(RESTAURANT_NO),
    CONSTRAINT BO_FDN_FK FOREIGN KEY (REF_FOOD_NO) REFERENCES FOOD(FOOD_NO)
);

CREATE SEQUENCE SEQ_BID
MAXVALUE 10000;


--	4 RESTAURANT_NO	NUMBER,
--	5 FOOD_NO	NUMBER ,
--	6 USER_ID VARCHAR2(30), 
-- ������.currval �������� �������̺����� ������ �� �������� ���� �����������θ� ������ ��
INSERT INTO BOARD VALUES(SEQ_BID.NEXTVAL, 2, '�Ȱ�', 1, 1, 'user01', DEFAULT, 'board_contetnt �߱� ���� �丮', SYSDATE, NULL, 'Y');
INSERT INTO BOARD VALUES(SEQ_BID.NEXTVAL, 2, '¥�����', 2, 2, 'user02', DEFAULT, 'board_contetnt �߱� ���� �丮', SYSDATE, NULL, 'Y');
INSERT INTO BOARD VALUES(SEQ_BID.NEXTVAL, 2, '�����', 3, 3, 'user03', DEFAULT, 'board_contetnt �߱� ���� �丮', SYSDATE, NULL, 'Y');
INSERT INTO BOARD VALUES(SEQ_BID.NEXTVAL, 2, '�ƶ�����', 4, 4, 'user04', DEFAULT, 'board_contetnt �߱� ���� �丮', SYSDATE, NULL, 'Y');
INSERT INTO BOARD VALUES(SEQ_BID.NEXTVAL, 2, 'ȫ�����', 5, 5, 'user05', DEFAULT, 'board_contetnt �߱� ���� �丮', SYSDATE, NULL, 'Y');
INSERT INTO BOARD VALUES(SEQ_BID.NEXTVAL, 2, 'ä��', 6, 6, 'user06', DEFAULT, 'board_contetnt �߱� ���� �丮', SYSDATE, NULL, 'Y');
INSERT INTO BOARD VALUES(SEQ_BID.NEXTVAL, 2, '����', 7, 7, 'user07', DEFAULT, 'board_contetnt �߱� ���� �丮', SYSDATE, NULL, 'Y');
INSERT INTO BOARD VALUES(SEQ_BID.NEXTVAL, 2, '��ϴ��ø�', 8, 8, 'user08', DEFAULT, 'board_contetnt �߱� ���� �丮', SYSDATE, NULL, 'Y');
INSERT INTO BOARD VALUES(SEQ_BID.NEXTVAL, 2, '����«��', 9, 9, 'user08', DEFAULT, 'board_contetnt �߱� ���� �丮', SYSDATE, NULL, 'Y');
INSERT INTO BOARD VALUES(SEQ_BID.NEXTVAL, 2, '����8', 10, 10, 'user08', DEFAULT, 'board_contetnt �߱� ���� �丮', SYSDATE, NULL, 'Y');


--
--INSERT INTO BOARD VALUES(SEQ_BID.NEXTVAL, 1, '�Ȱ�', 1, 1, 'user01', DEFAULT, '�߱� ���� �丮', SYSDATE, NULL, 'Y');
--INSERT INTO BOARD VALUES(SEQ_BID.NEXTVAL, 1, '¥�����', 2, 2, 'user02', DEFAULT, '�߱� ���� �丮', SYSDATE, NULL, 'Y');
--INSERT INTO BOARD VALUES(SEQ_BID.NEXTVAL, 1, '�����', 3, 2, 'user03', DEFAULT, '�߱� ���� �丮', SYSDATE, NULL, 'Y');
--INSERT INTO BOARD VALUES(SEQ_BID.NEXTVAL, 1, '�ƶ�����', 4, 3, 'user04', DEFAULT, '�߱� ���� �丮', SYSDATE, NULL, 'Y');
--



--------------------------------------------------
--------------     REPLY ����	------------------	
--------------------------------------------------


CREATE TABLE REPLY (
	REPLY_NO NUMBER	CONSTRAINT RE_REN_PK PRIMARY KEY,
    REPLY_CONTENT	VARCHAR2(300)	NOT NULL,
	REPLY_DATE DATE, -- ��� �ۼ���
	STATUS VARCHAR2(1) DEFAULT 'Y' CHECK (STATUS IN ('Y', 'N')),
	BOARD_NO	NUMBER	NOT NULL,     -- ������ ����Խ��� ��ȣ
	USER_ID	VARCHAR2(30)	NOT NULL, -- ��� �ۼ���
	NOTICE_NO	NUMBER	NOT NULL, -- �������� �Խ��� ��ȣ
    CONSTRAINT RE_BON_FK FOREIGN KEY (BOARD_NO) REFERENCES BOARD,            --�ܷ�Ű �߰�
	CONSTRAINT RE_USI_FK FOREIGN KEY (USER_ID) REFERENCES MEMBER,          --�ܷ�Ű�� �߰�
	CONSTRAINT RE_NON_FK FOREIGN KEY (NOTICE_NO) REFERENCES NOTICE 
);


CREATE SEQUENCE SEQ_RPID
INCREMENT BY 1
START WITH 1
MINVALUE 1
MAXVALUE 10000
NOCYCLE
NOCACHE;


--------------------------------------------------
--------------     IMAGE ����	------------------	
--------------------------------------------------


CREATE TABLE IMAGE (
	IMAGE_NO	NUMBER CONSTRAINT IM_IMN_PK	NOT NULL,
    BOARD_NO	NUMBER	NOT NULL,
	IMAGE_ORIGIN_NAME	VARCHAR2(255) NOT NULL,
	IMAGE_CHANGE_NAME	VARCHAR2(255) NOT NULL,
	IMAGE_PATH	VARCHAR2(1000)	NULL,
	IMAGE_UPLOAD_DATE	DATE DEFAULT SYSDATE,
	IMAGE_LEVEL	NUMBER	NULL,
	STATUS	VARCHAR2(1)	DEFAULT 'Y',
	FOREIGN KEY (BOARD_NO) REFERENCES BOARD(BOARD_NO)      --�ܷ�Ű �߰� 
);

CREATE SEQUENCE SEQ_IID
INCREMENT BY 1
START WITH 1
MINVALUE 1
MAXVALUE 10000    
NOCYCLE
NOCACHE;


--------------------------------------------------
--------------------- commit ---------------------
--------------------------------------------------

COMMIT;

