-- Zhihao Xu
-- 101306742

-- schema creation
create table students(
    student_id      serial,
    first_name      text   not null,
    last_name       text   not null,
    email           text   not null unique,
    enrollment_date date,
    primary key     (student_id)
);



-- table initialization
delete from students;

insert into students(first_name, last_name, email, enrollment_date) values
('John', 'Doe', 'john.doe@example.com', '2023-09-01'),
('Jane', 'Smith', 'jane.smith@example.com', '2023-09-01'),
('Jim', 'Beam', 'jim.beam@example.com', '2023-09-02');