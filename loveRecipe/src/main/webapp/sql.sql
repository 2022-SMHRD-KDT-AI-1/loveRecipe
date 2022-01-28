-- 1. 회원가입한 정보를 저장할 수 있는 'web_member'테이블을 만드시오.
create table test_member (  
id varchar2(100),
pw varchar2(100) not null,
nickname varchar2(100) not null,
email varchar2(100) not null,
phone varchar2(100) not null,
constraint test_id_pk primary key(id)
);

-- 2. web_member 테이블에 가데이터 넣기
insert into test_member values('a','a','a','a','a');

-- 3. 가데이터 조회하기
select * from test_member;

-- 데이터 삭제 (pw로 지정)
delete from test_member where pw in('ㅁ');

update test_member set 컬럼명 = '바꿀값' where email ='바꾸고자하는이메일'

-- 테이블 전체 삭제
drop table test_member;



-- 1. 메시지 정보를 저장할 수 있는 'web_message' 테이블을 만드시오.
-- 컬럼명 : num / sedName / receiveEmail / message / m_tate
-- 데이터 타입 : number(36), varchar2(500), date
-- 제약조건 : PK-num
create table test_message (  
num number(36),
sendName varchar2(500),
receiveEmail varchar2(500),
message varchar2(500),
m_date date,
constraint message_num primary key(num)
);

-- 2. num컬럼에 넣을 시퀀스 생성하시오.
-- 시퀀스 이름 : num_message
-- 시작숫자 : 1
-- 증감숫자 : 1
-- 시퀀스 : 순차적으로 번호를 부여하는 데이터베이스 객체, 주로pk값을 지정하기 위해서 사용
CREATE SEQUENCE num_message
start with 1
increment by 1;

-- 3.web_message테이블 가데이터 넣으시오.
-- num : 만들어진 시퀀스로 넣기
-- m_date : 현재 시간
insert into test_message
values(num_message.nextval,'sendName', 'receiveEmail', 'message', sysdate);

-- 4. 가데이터 잘 들어갔는지 조회하기
select * from test_message;

-- 메시지 삭제 (sendName으로 지정)
delete from test_message where sendName in('john')



-- 1. 게시판 테이블 만들기
-- num, title, writer, fileName, content, b_date
create table web_board (
num number,
title varchar2(500),
writer varchar2(500),
fileName varchar2(500),
content varchar2(500),
b_date date,
constraint board_pk primary key(num)
);

-- 2. 게시판 테이블에서 사용할 시퀀스 만들기
-- num_board
CREATE SEQUENCE num_board
INCREMENT BY 1
START WITH 1;

-- 3. 가데이터 넣기
insert into web_board values(num_board.nextval, 'test', 'test', 'test', 'test', sysdate);

-- 4. 조회하기
select * from web_board;



----- 피드백 db 가설정
create sequence feed_seq start with 1 increment by 1

create table feed_board (
	num number,
	writer varchar2(500),
	content varchar2(500),
	f_date date,
	constraint board_pk primary key(num)
)

insert into feed_board values(feed_seq.nextval, 'test', 'test', sysdate);

select * from feed_board



