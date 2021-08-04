------------------------------ INSERT INTO ACCOUNT TABLE ------------------------------------
INSERT INTO `account` (`id`,
                       `account_number`,
                       `account_name`,
                       `cust_id`,
                       `type`,
                       `balance_date`,
                       `currency`,
                       `balance`)
VALUES (1, '1010101010', 'TEST Acct001', 'sub001', 'Savings', '2020-07-11 17:00:00', 'AUD', 10000.00);

INSERT INTO `account` (`id`,
                       `account_number`,
                       `account_name`,
                       `cust_id`,
                       `type`,
                       `balance_date`,
                       `currency`,
                       `balance`)
VALUES (2, '1010101015', 'TEST Acct002','sub001', 'Current', '2020-05-10 17:00:00','AUD', 0.0);

INSERT INTO `account` (`id`,
                       `account_number`,
                       `account_name`,
                       `cust_id`,
                       `type`,
                       `balance_date`,
                       `currency`,
                       `balance`)
VALUES (3, '2020101019', 'TEST Acct003','test0012', 'Savings','2008-05-10 17:00:00','SGD', 0.00);

INSERT INTO `account` (`id`,
                       `account_number`,
                       `account_name`,
                       `cust_id`,
                       `type`,
                       `balance_date`,
                       `currency`,
                       `balance`)
VALUES (4, '1010101900', 'TEST Acct004','test0012', 'Savings', '2008-05-10 17:00:00','SGD', 67002.00);

INSERT INTO `account` (`id`,
                       `account_number`,
                       `account_name`,
                       `cust_id`,
                       `type`,
                       `balance_date`,
                       `currency`,
                       `balance`)
VALUES (5, '1010101902', 'TEST Acct010','test0011', 'Savings', '2008-05-10 17:00:00','AUD', 88778.90);

INSERT INTO `account` (`id`,
                       `account_number`,
                       `account_name`,
                       `cust_id`,
                       `type`,
                       `balance_date`,
                       `currency`,
                       `balance`)
VALUES (6, '1010101903', 'Test Acct 0011','test0011', 'Savings', '2008-06-10 17:00:00','AUD', 0.00);

INSERT INTO `account` (`id`,
                       `account_number`,
                       `account_name`,
                       `cust_id`,
                       `type`,
                       `balance_date`,
                       `currency`,
                       `balance`)
VALUES (7, '1010101904', 'TEST ACCT 006', 'test0011', 'Savings', '2008-05-10 17:00:00','SGD', 90778.90);


----------------- INSERT INTO TRANSACTION TABLE --------------------------

INSERT INTO `TRANSACTION` (`id`,
                           `account_number`,
                           `amount`,
                           `currency`,
                           `message`,
                           `debit_credit`,
                           `value_date`)
VALUES (100, '1010101010', 1004.00, 'AUD' ,'Credited to account', 'CREDIT', '2020-07-11 19:00:00');

INSERT INTO `TRANSACTION` (`id`,
                           `account_number`,
                           `amount`,
                           `currency`,
                           `message`,
                           `debit_credit`,
                           `value_date`)
VALUES (101, '1010101010', 6000.98, 'AUD', 'Credited to savings account', 'CREDIT', '2020-07-15 19:00:00');

INSERT INTO `TRANSACTION` (`id`,
                           `account_number`,
                           `amount`,
                           `currency`,
                           `message`,
                           `debit_credit`,
                           `value_date`)
VALUES (102, '1010101010', 200.00, 'AUD', 'Debited from account', 'DEBIT', '2020-09-15 19:00:00');

INSERT INTO `TRANSACTION` (`id`,
                           `account_number`,
                           `amount`,
                           `currency`,
                           `message`,
                           `debit_credit`,
                           `value_date`)
VALUES (103, '1010101900', 2200.80, 'SGD', 'Debited from account', 'DEBIT', '2020-09-15 19:00:00');

INSERT INTO `TRANSACTION` (`id`,
                           `account_number`,
                           `amount`,
                           `currency`,
                           `message`,
                           `debit_credit`,
                           `value_date`)
VALUES (104, '1010101900', 1005.68, 'SGD', 'Credit interest', 'CREDIT', '2020-10-15 19:00:00');

INSERT INTO `TRANSACTION` (`id`,
                           `account_number`,
                           `amount`,
                           `currency`,
                           `message`,
                           `debit_credit`,
                           `value_date`)
VALUES (105, '1010101904', 3400.00, 'AUD', 'Credit interest', 'CREDIT', '2020-10-15 19:00:00');

INSERT INTO `TRANSACTION` (`id`,
                           `account_number`,
                           `amount`,
                           `currency`,
                           `message`,
                           `debit_credit`,
                           `value_date`)
VALUES (106, '1010101904', 200.00, 'AUD', 'Credit interest', 'CREDIT', '2020-11-15 19:00:00');

INSERT INTO `TRANSACTION` (`id`,
                           `account_number`,
                           `amount`,
                           `currency`,
                           `message`,
                           `debit_credit`,
                           `value_date`)
VALUES (107, '1010101904', 3299.70, 'SGD', 'Credit interest', 'CREDIT', '2020-12-15 19:00:00');

INSERT INTO `TRANSACTION` (`id`,
                           `account_number`,
                           `amount`,
                           `currency`,
                           `message`,
                           `debit_credit`,
                           `value_date`)
VALUES (108, '1010101904', 500.00, 'SGD', 'Pay bill', 'DEBIT', '2021-01-15 19:00:00');

