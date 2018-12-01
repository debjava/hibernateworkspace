drop table if exists person2;

CREATE TABLE person2 (
    person_id BIGINT(10) NOT NULL AUTO_INCREMENT,
    name VARCHAR(50) NULL DEFAULT NULL,
    deptName VARCHAR(50) NULL DEFAULT NULL,
    discriminator VARCHAR(20) NOT NULL,
    PRIMARY KEY (person_id)
);

select * from person2;