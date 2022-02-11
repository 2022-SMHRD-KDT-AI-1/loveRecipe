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

create sequence test_seq start with 1 increment by 1;

-- 2. web_member 테이블에 가데이터 넣기
insert into test_member values(test_seq.nextval,'test','test','test','test','test',sysdate);

-- 3. 가데이터 조회하기
select * from test_member;

-- 전체 행 갯수 가져오기
select count (*) from test_member;

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

select * from recipe
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
values(recipe_seq.nextval,'가지토마토그라탕', '구이', '양식', '254',
'토마토 2개, 가지 1개, 모짜렐라치즈 100g, 올리브오일 5큰술, 소금 약간, 후춧가루 약간',
'1. 토마토를 도톰하게 저며 썬다. 2. 가지는 너무 두껍지 않게 어슷하게 저며 썬다. 3. 내열 그릇에 토마토와 가지를 켜켜이 담고 올리브 오일과 소금, 후춧가루를 뿌린다. 4. ③에 모차렐라치즈를 잘라 얹는다. 5. 190℃로 예열한 오븐에 ④를 넣어 15∼20분 정도 굽는다.',
'https://www.menupan.com/cook/cookimg/150600.jpg', sysdate);

insert into recipe
values(recipe_seq.nextval,'감자치즈구이', '구이', '양식', '183',
'감자 4개, 치즈(피자용) 30g, 베이컨 2장, 토마토케첩 약간',
'1. 감자는 껍질을 벗기지 말고 깨끗하게 씻어 찜통에 넣어 익힌다. 2. ①번의 찐 감자는 껍질을 벗기지 않은채 반으로 자른다. 3. 베이컨은 잘게 썰어 기름기 두르지 않은 팬에 바삭하게 구워낸다. 4. 치즈는 곱게 다지고 토마토 케첩을 준비한다. 5. ②에 케첩을 살짝 바르고 베이컨을 토핑으로 얹은 후 오븐에 굽기전에 치즈를 올린다. 6. 180℃의 오븐에서 치즈가 녹을 정도로 굽는다.',
'https://www.menupan.com/cook/cookimg/063800.jpg', sysdate);

insert into recipe
values(recipe_seq.nextval,'닭가슴살구이와채소샐러드', '구이', '양식', '216',
'닭가슴살 100g, 양상추 30g, 각종유기농채소 적량, 마늘(갈은 것) 조금, 소금 조금, 통후추 조금, [발사믹드레싱] 발사믹식초 40ml, 올리브오일 60ml, 럼주 2ml, 생레몬주스 5ml, 설탕 약간, 소금 약간, 후춧가루 약간',
'1. 닭가슴살은 손질한 다음 마늘, 소금, 통후추를 뿌려 160℃ 오븐에서 10분간 구워준다. 2. 채소는 손질하여 잘 씻어 물기를 뺀다. 3. 드레싱은 발사믹 식초를 반으로 졸인 다음 냉장고에서 식혀서 올리브오일을 조금씩 나눠 부어가며 거품기로 저어 농도를 짙게 만든다. 농도가 나오기 시작하면 럼주, 설탕, 소금, 후춧가루를 기호에 맞고 잘 섞는다. 4. 접시에 채소를 깔고 오븐에 구운 닭가슴살을 슬라이스하여 놓고 드레싱으로 마무리한다.',
'https://www.menupan.com/cook/cookimg/147400.jpg', sysdate);

insert into recipe
values(recipe_seq.nextval,'몬테리치킨', '구이', '양식', '312',
'닭고기(가슴살) 200g, 베이컨 3장, 아메리칸치즈 2장, 감자 2개, 토마토 1/2개, 실파 1뿌리, 브로콜리 20g, 당근 1/4개, 애호박 1/4개, 소금 약간, 후춧가루 약간, 간장 3/4컵, 꿀 3큰술, 마늘가루 1작은술, 생강가루 1/2작은술, 물 1컵, 우스터소스 1큰술',
'1. 닭고기를 분량의 양념 재료를 섞어 만든 소스에 10시간 동안 재운 후 210℃로 예열한 오븐에 굽는다. 2. 베이컨은 프라이팬에 바싹 구워낸다. 3. ①의 닭고기 위에 베이컨을 얹고, 아메리칸치즈 2장을 올려 치즈가 살짝 녹을 정도로 전자레인지에 돌린다. 4. 토마토는 씨를 제거하고 1cm x 1cm로 썰어서 ③위에 얹고, 실파를 송송 썰어 올린다. 5. 감자는 깨끗이 씻은 후 껍질째 삶아 으깨서 소금과 후춧가루로 간을 맞춘다. 6. 브로콜리는 큼직하게 썰고, 당근은 얇게 채썰고 애호박은 2㎝ x 3㎝로 썰어 프라이팬에 볶아 소금, 후춧가루 간을 한다. 7. ④를 접시에 담고 ⑤의 감자와 ⑥의 채소를 곁들인다.',
'https://www.menupan.com/cook/cookimg/045300.jpg', sysdate);

insert into recipe
values(recipe_seq.nextval,'버팔로윙', '구이', '양식', '230',
'닭(날개) 10개, 화이트와인 2큰술, 소금 약간, 후춧가루 약간, 버터 4큰술, 밀가루 1/4컵, 핫소스 5큰술, 버터 2큰술, 식초 2큰술, 설탕 1큰술, 소금 1/4작은술, 후춧가루 약간',
'1. 닭날개는 손질한 후 한쪽 면에 사선으로 칼집을 세개 정도 낸 후, 분량의 양념에 재워둔다. 2. 30분 정도 재워놓은 닭날개에 밀가루를 묻힌다. 3. 오븐 팬에 호일을 깔고 바닥에 버터를 발라 둔다. 4. 닭날개에 버터를 넉넉히 바르고 팬에 올려둔다. 5. 오븐을 200℃로 예열한 후 10분 정도 굽고 다시 뒤집어 갈색이 날때까지 10분 정도 더 굽는다. 6. 버터를 실온에서 해동한 후, 핫소스와 섞는다. 7. ⑥에 식초, 설탕, 소금을 넣어 잘 저어 소스를 만든다. 8. 바삭하게 구워진 닭날개를 소스에 가볍게 버무려 낸다.',
'https://www.menupan.com/cook/cookimg/081200.jpg', sysdate);

insert into recipe
values(recipe_seq.nextval,'새우구이', '구이', '양식', '320',
'새우(중하),밥,양송이버섯,청피망,양파,버터,당근,샐러리,홍피망,소금,홀랜다이즈소스,파슬리,타라곤',
'1. 새우는 등쪽에 들어있는 내장을 제거한 뒤 껍질을 벗긴다., 2. 양송이버섯은 이등분하고 피망은 가로, 세로 2.5cm의 사각형으로 썬다., 3. 양파, 당근, 샐러리, 청피망, 홍피망을 잘게 썰어 밥에 넣고 버터로 볶으면서 소금, 후춧가루로 간을 하여 버터라이스를 만든다.,4. 꼬치에 새우, 양송이버섯, 피망, 양파를 교대로 끼워서 석쇠에 구워 익힌다., 5. 홀랜다이즈 소스에 다진 타라곤과 파슬리를 섞어서 베이네즈 소스를 만든다., 6. 접시에 버터 라이스와 새우 꼬치구이를 담고 베이네즈 소스를 끼얹는다.',
'https://www.menupan.com/cook/cookimg/041800.jpg', sysdate);

-- 4. 가데이터 조회하기
select * from recipe;

-- 전체 행 갯수 가져오기
select count (*) from recipe;

-- 데이터 삭제 (레시피 이름으로 지정)
delete from recipe where recipe_name in('abc');

-- 테이블 전체 삭제
drop table recipe;

-- '조리 방법' 카운트
SELECT count (DISTINCT food_type) FROM recipe;

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

<<<<<<< HEAD
select * from test_ingredient
=======
drop table test_refi

-------냉장고 테이블 만들기
create table test_refi (  
mingre_seq number,
ingre_seq number,
ingre_amount number,
temp varchar2(100) not null,
refidate date,
mb_id varchar2(100) not null,
ingre_name varchar2(100) not null
);

select * from test_refi

CREATE SEQUENCE refi_seq
CREATE SEQUENCE refi_seq2

delete from test_refi where mb_id in(1);

select * from test_refi where mb_id = 1

---------재료 테이블
create table test_ingredient (
ingre_seq number,
ingre_name varchar2(100) not null,
ingre_type varchar2(100),
ingre_expire number,
ingre_season varchar2(100),
ingre_carloy number,
inger_temp varchar2(100),
constraint ingredient_pk primary key(ingre_seq)
);

CREATE SEQUENCE ingre_seq

insert into test_ingredient values(ingre_seq.nextval, '닭가슴살','육류',7,'연중',102,'냉장')

insert into test_ingredient values(ingre_seq.nextval, '사과','과실류',7,'연중',21,'냉장')

select * from test_ingredient

select * from test_refi where mb_id='test'

select * from test_ingredient where ingre_name='사과'

select to_char (sysdate+7) from dual

>>>>>>> refs/remotes/origin/master



create table test_ingredient (
ingre_seq number,
ingre_name varchar2(100) not null,
ingre_type varchar2(100),
ingre_expire number,
ingre_season varchar2(100),
ingre_carloy number,
inger_temp varchar2(100),
constraint ingredient_pk primary key(ingre_seq)
);



CREATE SEQUENCE ingre_seq



insert into test_ingredient values(ingre_seq.nextval, '닭가슴살','육류',7,'연중',102,'냉장')

insert into test_ingredient values(ingre_seq.nextval, '사과','과실류',7,'연중',21,'냉장')



create table test_refi (  
mingre_seq number,
ingre_seq number,
ingre_amount number,
temp varchar2(100) not null,
refidate date,
mb_id varchar2(100) not null,
ingre_name varchar2(100) not null
);



CREATE SEQUENCE refi_seq2



select * from recipe where  FOOD_TYPE =  ?  and RECIPE_COUNTRY = ? and RECIPE_CALORY<?
