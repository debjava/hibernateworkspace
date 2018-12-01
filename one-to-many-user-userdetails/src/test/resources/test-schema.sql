drop table if exists zara_userdetails;

drop table if exists zara_user;

CREATE TABLE zara_user (
    userid INTEGER IDENTITY ,
    username VARCHAR(50) NOT NULL ,
    password VARCHAR(50) NOT NULL ,
    enabled TINYINT NOT NULL ,
    accountNonExpired TINYINT NOT NULL ,
    credentialsNonExpired TINYINT NOT NULL ,
    accountNonLocked TINYINT NOT NULL
);

CREATE TABLE zara_userdetails (
    id INTEGER IDENTITY,
    userid INTEGER NOT NULL,
    username VARCHAR(50) NOT NULL ,
    authority VARCHAR(20) NOT NULL ,
    PRIMARY KEY (id),
    FOREIGN KEY (userid) REFERENCES zara_user (userid)
);



