create table if not exists course
(
    id bigint(19) not null primary key ,
    name varchar(45) not null ,
    teacher_id bigint(19) not null ,
    create_time datetime not null default current_timestamp,
    update_time datetime not null default current_timestamp on update current_timestamp,
    index (teacher_id)
);
create table if not exists user
(
    id bigint(19) not null primary key ,
    name varchar(45) not null ,
    number varchar(12) not null ,
    password varchar(65) not null ,
    role int not null default 1 ,
    create_time datetime not null default current_timestamp,
    update_time datetime not null default current_timestamp on update current_timestamp,
    unique (number),
    index (number)
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
    id bigint(19) not null primary key ,
    number bigint(19) ,
    detail varchar(45) not null ,
    create_time datetime not null default current_timestamp,
    update_time datetime not null default current_timestamp on update current_timestamp
);
