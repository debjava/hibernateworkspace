drop table IF EXISTS author_book;
drop table IF EXISTS book;
drop table IF EXISTS author;


CREATE TABLE IF NOT EXISTS author (
  AUTHOR_ID bigint(20) NOT NULL AUTO_INCREMENT,
  author_name varchar(255) DEFAULT NULL,
  PRIMARY KEY (AUTHOR_ID)
);

CREATE TABLE IF NOT EXISTS book (
  BOOK_ID bigint(20) NOT NULL AUTO_INCREMENT,
  book_name varchar(255) DEFAULT NULL,
  PRIMARY KEY (BOOK_ID)
);

CREATE TABLE IF NOT EXISTS author_book (
  book_id bigint(20) NOT NULL,
  author_id bigint(20) NOT NULL,
  PRIMARY KEY (book_id,author_id),
  FOREIGN KEY (book_id) REFERENCES book (BOOK_ID),
  FOREIGN KEY (author_id) REFERENCES author (AUTHOR_ID)
);

select * from book;
select * from author;
select * from author_book;
