--계정생성

conn system/Java0311;
CREATE USER CUPBOB identified BY JAVA;
GRANT connect, resource TO CUPBOB;
conn CUPBOB/JAVA;
show user;











--계정삭제

conn system/Java0311;
drop user CUPBOB CASCADE; 
