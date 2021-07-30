create table t_permission
(
    id   int auto_increment
        primary key,
    name varchar(128) null,
    url  varchar(255) null
)
    charset = utf8;

INSERT INTO shiro.t_permission (name, url) VALUES ('user:*:*', null);
INSERT INTO shiro.t_permission (name, url) VALUES ('order:*:*', null);
INSERT INTO shiro.t_permission (name, url) VALUES ('order:find:*', null);

create table t_role
(
    id   int auto_increment
        primary key,
    name varchar(64) null
)
    charset = utf8;

INSERT INTO shiro.t_role (name) VALUES ('admin');
INSERT INTO shiro.t_role (name) VALUES ('user');

create table t_role_permission
(
    id            int auto_increment
        primary key,
    role_id       int null,
    permission_id int null
)
    charset = utf8;

INSERT INTO shiro.t_role_permission (role_id, permission_id) VALUES (1, 1);
INSERT INTO shiro.t_role_permission (role_id, permission_id) VALUES (1, 2);
INSERT INTO shiro.t_role_permission (role_id, permission_id) VALUES (2, 3);

create table t_user
(
    id       int          null,
    username varchar(32)  null,
    password varchar(32)  null,
    salt     varchar(32)  null,
    age      int          null,
    email    varchar(32)  null,
    address  varchar(128) null
);

INSERT INTO shiro.t_user (id, username, password, salt, age, email, address) VALUES (1, 'christy', '0610e3ac1b6a40bcc0e078b12175a6e1', '5ByaU!h5', null, null, null);
INSERT INTO shiro.t_user (id, username, password, salt, age, email, address) VALUES (2, 'tom', 'c320a37e935d4c6a4c7597fe616c5e8a', '9zEY!#$J', null, null, null);

create table t_user_role
(
    id      int auto_increment
        primary key,
    user_id int(8) null,
    role_id int(8) null
)
    charset = utf8;

INSERT INTO shiro.t_user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO shiro.t_user_role (user_id, role_id) VALUES (2, 2);