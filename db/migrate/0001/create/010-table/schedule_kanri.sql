create table SCHEDULE_KANRI (
    SELECT_MONTH varchar(6) not null,
    FIRST_FG varchar(1) not null,
    KAKUTEI_DT timestamp,
    constraint SCHEDULE_KANRI_PK primary key(SELECT_MONTH, FIRST_FG)
);
