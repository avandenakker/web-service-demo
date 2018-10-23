drop table T_DEMO_OBJECT if exists;

create table T_DEMO_OBJECT (ID integer identity primary key, NAME varchar(50) not null, DESCRIPTION varchar(250) not null);
