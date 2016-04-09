create table M_USER (
    USER_ID varchar(10) not null,
    MAIL_AD varchar(50),
    USER_NM varchar(20),
    PW varchar(20) not null,
    constraint M_USER_PK primary key(USER_ID)
);
