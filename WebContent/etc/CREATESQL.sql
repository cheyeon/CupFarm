--회원 : 아이디, 멤버이름, 비밀번호, 핸드폰, 로그인날짜, 가입날짜
CREATE  TABLE MEMBER (
	M_ID VARCHAR2(15) CONSTRAINT MEMBER_M_ID_PK PRIMARY KEY,
	M_NAME VARCHAR2(15) NOT NULL,
	M_PWD VARCHAR2(15) NOT NULL,
	M_PHONE VARCHAR2(11) NOT NULL, 
	M_LDATE DATE,
	M_MDATE DATE NOT NULL
);
--그룹 : 그룹고유번호, 그룹이름, 생성날짜
CREATE TABLE GROUPLIST(
	G_IDX NUMBER CONSTRAINT GROUPLIST_G_IDX_PK PRIMARY KEY,
	G_NAME VARCHAR2(30) NOT NULL,
	G_DATE DATE NOT NULL
);
CREATE SEQUENCE GROUPLIST_SEQ START WITH 1 INCREMENT BY 1 NOCACHE;  
--그룹멤버 : 소속고유번호, 그룹고유번호, 아이디, 직책, 그룹가입일
CREATE TABLE GRMEM(
	GM_IDX NUMBER CONSTRAINT GRMEM_GM_IDX_PK PRIMARY KEY,
	G_IDX NUMBER NOT NULL,
	M_ID VARCHAR2(15) NOT NULL,
	GM_GRADE CHAR(1) NOT NULL,
	GM_DATE DATE NOT NULL,
	CONSTRAINT GRMEM_G_IDX_FK FOREIGN KEY(G_IDX) REFERENCES GROUPLIST(G_IDX) on delete cascade,
	CONSTRAINT GRMEM_M_ID_FK FOREIGN KEY(M_ID) REFERENCES MEMBER(M_ID) on delete cascade
);
CREATE SEQUENCE GRMEM_SEQ START WITH 1 INCREMENT BY 1 NOCACHE;  
--컵밥 소유 : 소유고유번호, 컵밥이름, 소속고유번호, 컵밥상태, 컵밥등록일, 컵밥소멸일
CREATE TABLE CUPBOB(
	C_IDX NUMBER CONSTRAINT CUPBOB_C_IDX_PK PRIMARY KEY,
	C_NAME VARCHAR2(50) NOT NULL,
	GM_IDX NUMBER NOT NULL,
	C_STATE NUMBER(1) NOT NULL,
	C_CDATE DATE NOT NULL,
	C_DDATE DATE,
	CONSTRAINT CUPBOB_GM_IDX_FK FOREIGN KEY(GM_IDX) REFERENCES GRMEM(GM_IDX) on delete cascade
);
CREATE SEQUENCE CUPBOB_SEQ START WITH 1 INCREMENT BY 1 NOCACHE;  
--컵밥이동로그 : 로그고유번호, 로그구분번호, 컵밥발송, 컵밥수신, 이동일
CREATE TABLE LOG(
	L_IDX NUMBER CONSTRAINT LOG_L_IDX_PK PRIMARY KEY,
	L_SEQ NUMBER NOT NULL,
	L_SENDER NUMBER NOT NULL,
	L_RECEIVER NUMBER NOT NULL,
	L_DATE DATE NOT NULL,
	CONSTRAINT LOG_L_SENDER_FK FOREIGN KEY(L_SENDER) REFERENCES CUPBOB(C_IDX) on delete cascade,
	CONSTRAINT LOG_L_RECEIVER_FK FOREIGN KEY(L_RECEIVER) REFERENCES CUPBOB(C_IDX) on delete cascade
);
CREATE SEQUENCE LOG_SEQ START WITH 1 INCREMENT BY 1 NOCACHE;  
CREATE SEQUENCE LOG_IDX START WITH 1 INCREMENT BY 1 NOCACHE;
--게시판 : 게시판고유번호, 말머리, 제목, 아이디, 내용, 소유고유번호, 완료여부, 비밀번호, 작성일
CREATE TABLE BOARD(
	B_IDX NUMBER CONSTRAINT BOARD_B_IDX_PK PRIMARY KEY,
	B_HEAD CHAR(1) NOT NULL,
	B_TITLE VARCHAR2(50) NOT NULL,
	M_ID VARCHAR2(15) NOT NULL,
	B_CONTENT VARCHAR2(300),
	C_IDX NUMBER NOT NULL,
	B_OX NUMBER(1) NOT NULL,
	B_PWD NUMBER(4) NOT NULL,
	B_WDATE DATE NOT NULL,
	CONSTRAINT BOARD_M_ID_FK FOREIGN KEY(M_ID) REFERENCES MEMBER(M_ID) on delete cascade,
	CONSTRAINT BOARD_C_IDX_FK FOREIGN KEY(C_IDX) REFERENCES CUPBOB(C_IDX) on delete cascade
);
CREATE SEQUENCE BOARD_SEQ START WITH 1 INCREMENT BY 1 NOCACHE;  
--댓글 : 댓글고유번호, 아이디, 댓글내용, 선택유무, 댓글작성일, 게시판고유번호
CREATE TABLE REPLY(
	R_IDX NUMBER CONSTRAINT REPLY_R_IDX_PK PRIMARY KEY,
	M_ID VARCHAR2(15) NOT NULL,
	R_CONTENT VARCHAR2(300) NOT NULL,
	R_CHECK NUMBER(1) NOT NULL,
	R_DATE DATE NOT NULL,
	B_IDX NUMBER NOT NULL,
	CONSTRAINT REPLY_M_ID_FK FOREIGN KEY(M_ID) REFERENCES MEMBER(M_ID) on delete cascade,
	CONSTRAINT REPLY_B_IDX_FK FOREIGN KEY(B_IDX) REFERENCES BOARD(B_IDX) on delete cascade
);
CREATE SEQUENCE REPLY_SEQ START WITH 1 INCREMENT BY 1 NOCACHE;  

