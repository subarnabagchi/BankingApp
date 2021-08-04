DROP TABLE IF EXISTS `account`;

CREATE TABLE `account`
(
    `id`             INTEGER PRIMARY KEY AUTO_INCREMENT,
    `account_number` VARCHAR(10) not null,
    `account_name`   VARCHAR(100) not null,
    `cust_id`        VARCHAR(20) not null,
    `type`           VARCHAR(20) not null default 'Savings',
    `balance_date`   DATETIME not null,
    `currency`       VARCHAR2(3),
    `balance`        number(10,2) not null
);

DROP TABLE IF EXISTS `transaction`;

CREATE TABLE `transaction`
(
    `id`               INTEGER PRIMARY KEY AUTO_INCREMENT,
    `account_number`  VARCHAR(10) not null,
    `amount`        number(10,2) not null,
    `currency`       VARCHAR2(3),
    `message`       VARCHAR(100) ,
    `debit_credit`         VARCHAR(10) not null,
    `value_date`         DATETIME not null
);

ALTER TABLE transaction ADD FOREIGN KEY (account_number) REFERENCES account(account_number);
