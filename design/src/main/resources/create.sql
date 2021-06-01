create table if not exists course
(
    id bigint(19) not null primary key ,
    course_name varchar(45) ,
    start bigint(19) ,
    end bigint(19) ,
    `period` bigint(19) ,
    teacher_name varchar(45),
    student_number bigint(19),
    create_time datetime not null default current_timestamp,
    update_time datetime not null default current_timestamp on update current_timestamp,
    index (teacher_name)
);
create table if not exists user
(
    id bigint(19) not null primary key ,
    name varchar(45) not null ,
    user_name varchar(12) not null ,
    password varchar(65) not null ,
    role int not null default 1 ,
    create_time datetime not null default current_timestamp,
    update_time datetime not null default current_timestamp on update current_timestamp,
    unique (user_name),
    index (user_name)
);
create table if not exists teacher
(
    id bigint(19) not null primary key ,
    title varchar(8),
    create_time datetime not null default current_timestamp,
    update_time datetime not null default current_timestamp on update current_timestamp
);
create table if not exists lab
(
    id varchar(45) not null primary key ,
    number bigint(19) ,
    detail varchar(45) ,
    create_time datetime not null default current_timestamp,
    update_time datetime not null default current_timestamp on update current_timestamp
);
create table if not exists classroomMessage
(
    id bigint(45) not null primary key ,
    lesson varchar(45) ,
    course_name varchar(45),
    start bigint(19) ,
    end bigint(19) ,
    teacher_name varchar(45),
    title varchar(45),
    index(id)
);
