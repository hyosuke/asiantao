create table SCHEDULE (
    USER_ID varchar(10) not null,
    SELECT_MONTH varchar(6) not null,
    FIRST_FG varchar(1) not null,
    TOROKU_DT timestamp not null,
    constraint SCHEDULE_PK primary key(USER_ID, SELECT_MONTH, FIRST_FG)
);
