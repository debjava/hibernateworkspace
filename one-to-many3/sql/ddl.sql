/* Concept : Bank Customer has multiple accounts*/
/*Drop the table*/
drop table IF EXISTS BankAccount;
drop table IF EXISTS BankCustomer;

CREATE TABLE BankCustomer(
  custId int(11) NOT NULL AUTO_INCREMENT,
  name varchar(10),
  PRIMARY KEY (custId)
);


CREATE TABLE BankAccount (
  actId int(11) NOT NULL AUTO_INCREMENT,
  custId int(11) NOT NULL,
  currency varchar(10) NOT NULL,
  accountNo varchar(10) NOT NULL,
  PRIMARY KEY (actId),
  KEY custId (custId),
  FOREIGN KEY (custId) REFERENCES BankCustomer (custId)
);

select * from BankCustomer;
select * from BankAccount;

======================Some Queries===================
select * from BankCustomer bc , BankAccount ba where bc.custId = ba.custId and ba.currency = 'INR';

SELECT bc.custId,bc.name
FROM BankCustomer bc, BankAccount ba
WHERE bc.custId = ba.custId AND ba.currency = 'EUR';