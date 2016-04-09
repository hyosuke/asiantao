create table WK_SCHEDULE_DETAIL (
    USER_ID varchar(10) not null,
    SELECT_MONTH varchar(6) not null,
    FIRST_FG varchar(1) not null,
    DAY varchar(2) not null,
    TOROKU_DT timestamp not null,
    POZISHON_DV varchar(3) not null,
    BIKOU varchar(30),
    SCHEDULE_DV varchar(3) not null,
    constraint WK_SCHEDULE_DETAIL_PK primary key(USER_ID, SELECT_MONTH, FIRST_FG, DAY)
);
