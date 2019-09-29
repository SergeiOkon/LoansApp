CREATE TABLE banks
(
    id INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    name VARCHAR(20) NOT NULL
);
CREATE TABLE loans
(
    id INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    ofBank INT(11),
    size INT(11),
    interest DECIMAL(10,2),
    termInDays INT(11),
    earlyRepaiment TINYINT(1) DEFAULT '0',
    work_officially TINYINT(1) DEFAULT '0',
    temp_not_work TINYINT(1) DEFAULT '0',
    businessman TINYINT(1) DEFAULT '0',
    retiree TINYINT(1) DEFAULT '0',
    student TINYINT(1) DEFAULT '0',
    maternity_leave TINYINT(1) DEFAULT '0',
    vehicle TINYINT(1) DEFAULT '0',
    real_estate TINYINT(1) DEFAULT '0',
    consumer TINYINT(1) DEFAULT '0',
    house_repairs TINYINT(1) DEFAULT '0',
    business TINYINT(1) DEFAULT '0',
    CONSTRAINT ofBank FOREIGN KEY (ofBank) REFERENCES banks (id)
);
CREATE INDEX ofBank ON loans (ofBank);