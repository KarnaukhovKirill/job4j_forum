create table posts (
    id serial primary key,
    name varchar(2000),
    description text,
    created timestamp without time zone not null default now(),
    user_id int not null references users(id)
);

create table users (
    id serial primary key,
    username varchar(255) not null unique,
    password varchar(255) not null,
    enabled boolean not null default true,
    authority_id int references authorities(id)
);

create table authorities (
    id serial primary key,
    authority varchar(255) not null unique
);

insert into authorities (authority) values ('ADMIN');
insert into authorities (authority) values ('USER');

insert into users (username, password, authority_id) values ('admin',
                                                             '$2a$10$exj.AUDXJ4PLllo.pnftB.qDoMi1MkiW7sphDKkWZfzpUgZU0qcgG',
                                                             1);

insert into users (username, password, authority_id) values ('user',
                                                             '$2a$10$exj.AUDXJ4PLllo.pnftB.qDoMi1MkiW7sphDKkWZfzpUgZU0qcgG',
                                                             2);

insert into posts (name, description, user_id) values ('Продам гараж', 'На малых броньках', 2);
insert into posts (name, description, user_id) values ('Копаю колодцы', 'Любой сложности', 2);

