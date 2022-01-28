-- 1. 회원가입한 정보를 저장할 수 있는 'web_member'테이블을 만드시오.
create table test_member (  
num number,
id varchar2(100),
pw varchar2(100) not null,
nickname varchar2(100) not null,
email varchar2(100) not null,
phone varchar2(100) not null,
testdate date,
constraint test_id_pk primary key(id)
);

-- 2. web_member 테이블에 가데이터 넣기
insert into test_member values(test_seq.nextval,'test','test','test','test','test',sysdate);

-- 3. 가데이터 조회하기
select * from test_member;

-- 데이터 삭제 (pw로 지정)
delete from test_member where pw in('ㅁ');

update test_member set 컬럼명 = '바꿀값' where email ='바꾸고자하는이메일'

-- 테이블 전체 삭제
drop table test_member;

create sequence test_seq start with 1 increment by 1



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

-- 3. web_message테이블 가데이터 넣으시오.
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



-- 1. 레시피 테이블 (테스트를 위해 임의로 만들어봄. 수정할 사항 있으면 수정해주세요.)
--   컬럼명 : num(레시피 순번) / recipe_name(레시피 이름) / food_type(음식 분야) /
-- recipe_country(국가 분류) / recipe_calory(레시피 칼로리) / recipe_ingre(재료) /
-- cooking_method(조리 방법) / image(요리 이미지 주소)
--   제약조건 : PK - recipe_seq
create table recipe (
num number,
recipe_name varchar2(50),
food_type varchar2(20),
recipe_country varchar2(20),
recipe_calory number,
recipe_ingre varchar2(200),
cooking_method varchar2(500),
image varchar2(60),
r_date date,
constraint recipe_seq primary key(num)
);

-- 테이블 컬럼 사이즈 변경방법
-- 조리 방법이 너무 길어서 ORA-12899 에러 떴었음.
ALTER TABLE recipe MODIFY(cooking_method varchar2(1000));

-- 2. num컬럼에 넣을 시퀀스 생성
-- 시퀀스 이름 : recipe_seq
-- 시작숫자 : 1
-- 증감숫자 : 1
-- 시퀀스 : 순차적으로 번호를 부여하는 데이터베이스 객체, 주로pk값을 지정하기 위해서 사용
CREATE SEQUENCE recipe_seq
start with 1
increment by 1;

-- 3. web_message테이블에 가데이터
-- num : 만들어진 시퀀스로 넣기
-- m_date : 현재 시간
insert into recipe
values(recipe_seq.nextval,'약과', '떡,한과', '한식', '135',
'밀가루, 참기름, 소금, 조청, 생강즙, 청주, 설탕, 검은깨, 물',
'1. 밀가루에 소금, 참기름을 넣어 고루 비벼 체에 내린다. 2. ①의 밀가루에 분량의 조청, 생강즙, 청주를 넣어서 반죽을 질지 않게 한다. 3. 반죽을 밀대로 0.5cm 정도로 밀고 원형 틀로 찍어 모양을 잡는다. 4. 분량의 물과 설탕을 냄비에 넣고 반으로 줄 때까지  졸여 집청시럽을 만든다. 5. 130~140℃의 기름에서 천천히 색이 나도록 튀긴다. 6. 약과가 튀겨지면 집청시럽에 담갔다가 건진다. 7. 약과를 잣과 검은깨로 장식해서 마무리한다.',
'https://www.menupan.com/cook/cookimg/066400.jpg', sysdate);

-- 4. 가데이터 조회하기
select * from recipe;

-- 전체 행 갯수 가져오기
select count (*) from recipe;

-- 데이터 삭제 (레시피 이름으로 지정)
delete from recipe where recipe_name in('abc');

-- 테이블 전체 삭제
drop table recipe;



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



