create table S_DV (
    DV varchar(20) not null,
    DV_VALUE varchar(3) not null,
    DV_NAME varchar(20) not null,
    constraint S_DV_PK primary key(DV, DV_VALUE)
);
