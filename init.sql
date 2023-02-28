CREATE TABLE IF NOT EXISTS employees 
(
    employee_id SERIAL PRIMARY KEY,
    first_name varchar(255),
    last_name varchar(255)
    );

insert into employees (first_name, last_name) VALUES ('Jane', 'Doe');
insert into employees (first_name, last_name) VALUES ('John', 'Smith');
insert into employees (first_name, last_name) VALUES ('Joey', 'Dot');
