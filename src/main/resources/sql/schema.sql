drop table if exists demo_transact.DT_AGREEMENT;
create table demo_transact.DT_AGREEMENT
(
    ID         serial       not null primary key,
    AGR_NUMBER varchar(255) not null,
    OPEN_DATE  timestamptz(9),
    ORG_NAME   varchar(255),
    INN        varchar(255),
    KPP        varchar(255)
);

drop table if exists demo_transact.DT_TRANSACTION;
create table demo_transact.DT_TRANSACTION
(
    ID                   serial not null primary key,
    AGREEMENT_ID         serial not null,
    TRANSACTION_DATETIME timestamptz(9),
    TRANSACTION_SUM      decimal(19, 2),
    COMMISSION           decimal(19, 2),
    TRANSACTION_NUM      varchar(255)
);

ALTER TABLE demo_transact.DT_TRANSACTION
    ADD CONSTRAINT fk_agreement_tr
        FOREIGN KEY (AGREEMENT_ID)
            REFERENCES demo_transact.DT_AGREEMENT(ID);
