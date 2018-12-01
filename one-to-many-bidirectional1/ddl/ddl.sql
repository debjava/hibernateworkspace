drop table if exists emp;
drop table if exists department;

CREATE TABLE  department (
    department_id BIGINT(20) NOT NULL AUTO_INCREMENT,
    dept_name VARCHAR(50) NOT NULL ,
    PRIMARY KEY (department_id)
);

CREATE TABLE emp (
    employee_id BIGINT(10) NOT NULL AUTO_INCREMENT,
    firstname VARCHAR(50) NULL DEFAULT NULL,
    lastname VARCHAR(50) NULL DEFAULT NULL,
    department_id BIGINT(20) NULL DEFAULT NULL,
    PRIMARY KEY (employee_id),
    FOREIGN KEY (department_id) REFERENCES department (department_id)
);

select * from emp;
select * from department;