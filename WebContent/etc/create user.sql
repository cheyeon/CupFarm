--��������

conn system/Java0311;
CREATE USER CUPBOB identified BY JAVA;
GRANT connect, resource TO CUPBOB;
conn CUPBOB/JAVA;
show user;











--��������

conn system/Java0311;
drop user CUPBOB CASCADE; 
