drop table USERS if exists;
create table USERS (USER_ID bigint primary key auto_increment, USERNAME varchar(128) unique, PASSWORD varchar(256), ENABLED boolean);

drop table T_DEMO_OBJECT if exists;
create table T_DEMO_OBJECT (ID integer identity primary key, NAME varchar(50) not null, DESCRIPTION varchar(250) not null);
