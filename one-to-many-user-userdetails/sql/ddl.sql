drop table if exists zara_userdetails;
drop table if exists zara_user;

CREATE TABLE zara_user (
    userid BIGINT(20) NOT NULL AUTO_INCREMENT,
    username VARCHAR(50) NOT NULL ,
    password VARCHAR(50) NOT NULL ,
    enabled TINYINT NOT NULL ,
    accountNonExpired TINYINT NOT NULL ,
    credentialsNonExpired TINYINT NOT NULL ,
    accountNonLocked TINYINT NOT NULL ,
    PRIMARY KEY (userid)
);

CREATE TABLE zara_userdetails (
    id BIGINT(20) NOT NULL AUTO_INCREMENT,
    userid BIGINT(20) NOT NULL,
    username VARCHAR(50) NOT NULL ,
    authority VARCHAR(20) NOT NULL ,
    PRIMARY KEY (id),
    FOREIGN KEY (userid) REFERENCES zara_user (userid)
);

select * from zara_user;
select * from zara_userdetails;