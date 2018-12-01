drop table if exists owner3;
drop table if exists employee3;
drop table if exists person3;

CREATE TABLE person3 (
    person_id BIGINT(20) NOT NULL AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL,
    PRIMARY KEY (person_id)
);
 
CREATE TABLE employee3 (
    person_id BIGINT(10) NOT NULL,
    deptName VARCHAR(50) NULL DEFAULT NULL,
    PRIMARY KEY (person_id),
    FOREIGN KEY (person_id) REFERENCES person3 (person_id)
);
 
CREATE TABLE owner3 (
    person_id BIGINT(20) NOT NULL,
    city VARCHAR(50) NULL DEFAULT NULL,
    PRIMARY KEY (person_id),
    FOREIGN KEY (person_id) REFERENCES person3 (person_id)
);

select * from owner3;
select * from employee3;
select * from person3;
