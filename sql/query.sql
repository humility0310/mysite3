--user
--insert

INSERT INTO USERS
     VALUES (user_seq.NEXTVAL,
             '김영조',
             'deckmama9999',
             '1234',
             'male');

--delete

DELETE FROM USERS;

COMMIT;

SELECT * FROM USERS;

--select

SELECT no, name FROM USERS WHERE EMAIL = '111' AND PASSWORD = '111';

--update
UPDATE USERS SET NAME='111' , PASSWORD='111', GENDER='male' WHERE NO=2;

SELECT no, name, email,gender FROM USERS WHERE no='2';

