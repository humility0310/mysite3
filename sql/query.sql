SELECT title, content, USERS_NO
  FROM BOARD
 WHERE no = 1;

INSERT INTO BOARD VALUES(board_seq.NEXTVAL, 'title', 'content', reg_date, hit, group_no, order_no, depth, users_no)

--user
--insert

SELECT title, content from BOARD WHERE no=3;



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

SELECT * FROM GUESTBOOK;

--select

SELECT no, name
  FROM USERS
 WHERE EMAIL = '111' AND PASSWORD = '111';

--update

UPDATE USERS
   SET NAME = '111', PASSWORD = '111', GENDER = 'male'
 WHERE NO = 2;

SELECT no,
       name,
       email,
       gender
  FROM USERS
 WHERE no = '2';

--board

--view

SELECT no, title, content
  FROM BOARD
 WHERE no = 2;

UPDATE BOARD
   SET HIT = hit + 1
 WHERE NO = 2;--조회수늘리기

--list

SELECT COUNT (*) FROM BOARD;

SELECT *
  FROM (SELECT ROWNUM AS rn,
               no,
               title,
               hit,
               reg_date,
               name,
               DEPTH,
               users_no
          FROM (  SELECT a.no,
                         a.title,
                         a.hit,
                         TO_CHAR (a.reg_date, 'yyyy-mm-dd hh:mi:ss')
                            AS reg_date,
                         b.NAME,
                         a.users_no,
                         a.DEPTH
                    FROM BOARD a, USERS b
                   WHERE a.USERS_NO = b.NO
                --AND title LIKE '%kwd%' OR CONTENT LIKE '%kwd%'
                ORDER BY a.GROUP_NO DESC, order_no ASC))
 WHERE (1 - 1) * 5 + 1 <= rn AND rn <= 1 * 5;-- 5->page_size, 앞1->현재page



--insert1(새글)

INSERT INTO BOARD
     VALUES (board_seq.NEXTVAL,
             '그만',
             '그만',
             SYSDATE,
             0,
             NVL ( (SELECT MAX (group_no) FROM BOARD), 0) + 1,
             1,
             0,
             21);

INSERT INTO BOARD
     VALUES (board_seq.NEXTVAL,
             '점심?',
             '점심!',
             SYSDATE,
             0,
             NVL ( (SELECT MAX (group_no) FROM BOARD), 0) + 1,
             1,
             0,
             21);

INSERT INTO BOARD
     VALUES (board_seq.NEXTVAL,
             '새글1',
             '새글1',
             SYSDATE,
             0,
             NVL ( (SELECT MAX (group_no) FROM BOARD), 0) + 1,
             1,
             0,
             21);

COMMIT;

SELECT MAX (group_no) FROM BOARD;

SELECT MAX (group_no) FROM BOARD;

SELECT * FROM USERS;

SELECT * FROM BOARD;

--insert2(답글)

UPDATE BOARD
   SET ORDER_NO = order_no + 1
 WHERE GROUP_NO = 2 AND ORDER_NO > 1;--무모 글 순서

INSERT INTO BOARD
     VALUES (board_seq.NEXTVAL,
             '난짜장',
             '난짜장',
             SYSDATE,
             0,
             2,                                                      --부모글의 그룹
             2,                                                  -- 부모글의 순서 +1
             1,                                                   --무보글 깊이의 +1
             21);