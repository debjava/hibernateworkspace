drop table cart;

CREATE TABLE Cart(
  cart_id int(11) NOT NULL AUTO_INCREMENT,
  total decimal(10,0) NOT NULL,
  name varchar(10),
  PRIMARY KEY (cart_id)
);


CREATE TABLE Items (
  id int(11) NOT NULL AUTO_INCREMENT,
  cart_id int(11) NOT NULL,
  item_id varchar(10) NOT NULL,
  item_total decimal(10,0) NOT NULL,
  quantity int(3) NOT NULL,
  PRIMARY KEY (id),
  KEY cart_id (cart_id),
  FOREIGN KEY (cart_id) REFERENCES Cart (cart_id)
);