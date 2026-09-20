set names utf8;
set foreign_key_checks=0;
drop database if exists wedding;
create database if not exists wedding;
use wedding;

drop table if exists login_user;

create table login_user(
	id int(100) not null primary key auto_increment,
	family_name varchar(100),
	last_name varchar(100),
	family_name_alphabet varchar(100),
	last_name_alphabet varchar(100),
	mail varchar(255),
	password varchar(255),
	user_gender int(1),
	delete_flg int(1),
	invitation_slug VARCHAR(100) UNIQUE;
	registered_time datetime,
	update_time datetime
);

drop table if exists user_gender_info;

create table user_gender_info(
	id int not null primary key,
	user_gender_info varchar(2),
	insert_date datetime,
	update_date datetime
);

drop table if exists flg_info;

create table flg_info(
	id int not null primary key,
	flg varchar(2),
	insert_date datetime,
	update_date datetime
);

drop table if exists guest_info;

create table guest_info(
	id int(100) not null primary key auto_increment,
	user_id int(100),
	family_name varchar(100),
	last_name varchar(100),
	family_name_kana varchar(100),
	last_name_kana varchar(100),
	family_name_alphabet varchar(100),
	last_name_alphabet varchar(100),
	honorifics varchar(3),
	attendance varchar(6),
	which_guest varchar(5),
	guest_gender int(1),
	relation varchar(20),
	birth int(8),
	allergies varchar(10),
	allergies_details varchar(100),
	add1 varchar(100),
	add1_details varchar(100),
	add2 varchar(100),
	add2_details varchar(100),
	add3 varchar(100),
	add3_details varchar(100),
	add4 varchar(100),
	add4_details varchar(100),
	add5 varchar(100),
	add5_details varchar(100),
	postal_code varchar(7),
	prefecture varchar(100),
	address_1 varchar(100),
	address_2 varchar(255),
	tel varchar(11),
	mail varchar(255),
	invitation varchar(10),
	survey_answer varchar(3),
	delete_flg int(1),
	registered_time datetime,
	update_time datetime
);

drop table if exists guest_gender_info;

create table guest_gender_info(
	id int not null primary key,
	guest_gender_info varchar(1),
	insert_date datetime,
	update_date datetime
);

drop table if exists invitation_info;

create table invitation_info(
	id int(100) not null primary key auto_increment,
	user_id int(100),
	main_groom_name varchar(100),
	main_bride_name varchar(100),
	message varchar(300),
	groom_name varchar(100),
	groom_title varchar(10),	
	groom_message varchar(300),
	bride_name varchar(100),
	bride_title varchar(10),	
	bride_message varchar(300),
	family1_name varchar(100),
	family1_title varchar(10),	
	family1_message varchar(300),
	family2_name varchar(100),
	family2_title varchar(10),	
	family2_message varchar(300),
	family3_name varchar(100),
	family3_title varchar(10),	
	family3_message varchar(300),
	family4_name varchar(100),
	family4_title varchar(10),	
	family4_message varchar(300),
	family5_name varchar(100),
	family5_title varchar(10),	
	family5_message varchar(300),
	wedding_date int(8),
	types varchar(100),
	ceremony_time int(4),
	reception_time int(4),
	gift_money varchar(6),
	ceremony_add_info varchar(300),
	venue_name varchar(100),
	venue_name_kana varchar(100),
	venue_postal_code varchar(7),
	venue_address varchar(100),
	venue_tel int(11),
	venue_url varchar(255),
	venue_add_info varchar(300),
	add_info1_title varchar(100),
	add_info1_details varchar(300),
	add_info2_title varchar(100),
	add_info2_details varchar(300),
	add_info3_title varchar(100),
	add_info3_details varchar(300),
	add_info4_title varchar(100),
	add_info4_details varchar(300),
	add_info5_title varchar(100),
	add_info5_details varchar(300),
	which_guest_item varchar(3),
	guest_name_item varchar(3),
	guest_name_kana_item varchar(3),
	guest_name_alphabet_item varchar(3),
	relation_item varchar(3),
	guest_gender_item varchar(3),
	guest_birth_item varchar(3),
	guest_address_item varchar(3),
	guest_tel_item varchar(3),
	guest_mail_item varchar(3),
	allergies_item varchar(3),
	celebrate_photos_item varchar(3),
	celebrate_messages_item varchar(3),
	survey_title varchar(100),
	survey_details varchar(300),
	limit_date int(8),
	last_message varchar(300),
	registered_time datetime,
	update_time datetime
);

INSERT INTO user_gender_info(id,user_gender)
VALUES(0,"新郎");
INSERT INTO user_gender_info(id,user_gender)
VALUES(1,"新婦");
INSERT INTO flg_info(id,flg)
VALUES(0,"有効");
INSERT INTO flg_info(id,flg)
VALUES(1,"無効");
INSERT INTO guest_gender_info(id,guest_gender)
VALUES(0,"男");
INSERT INTO guest_gender_info(id,guest_gender)
VALUES(1,"女");
