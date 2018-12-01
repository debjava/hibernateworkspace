/* Concept : Customer has an address */
/*Drop the table*/
drop table IF EXISTS customer;
drop table IF EXISTS address;

/*Create the required tables*/
CREATE TABLE IF NOT EXISTS address (
  addressId int(11) NOT NULL AUTO_INCREMENT,
  city varchar(255) DEFAULT NULL,
  PRIMARY KEY (addressId)
) ;

CREATE TABLE IF NOT EXISTS customer (
  customerId int(11) NOT NULL AUTO_INCREMENT,
  firstName varchar(255) DEFAULT NULL,
  lastName varchar(255) DEFAULT NULL,
  addressId int(11) DEFAULT NULL,
  PRIMARY KEY (customerId),
  FOREIGN KEY (addressId) REFERENCES address (addressId)
) ;

/*Select the created table*/
select * from customer;
select * from address;
