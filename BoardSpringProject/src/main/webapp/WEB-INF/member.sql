select * from member;

create table MemberLog(
	log_date date not null,
	code_number number not null,
	message varchar2(300 byte) not null	
)
select * from MEMBERLOG;
insert into MEMBERLOG 
values(to_date('2021/02/01 14:44:15','YYYY/MM/DD HH24:MI:SS'), 1000, 'TEST ERROR 메세지');
