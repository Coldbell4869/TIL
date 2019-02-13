INSERT INTO roles (id, name) VALUES (1, 'USER');
INSERT INTO roles (id, name) VALUES (2, 'ADMIN');

INSERT INTO account (id, create_date, email, name, nick_name, passwd)
 VALUES(1, now(), 'coldbell89@gmail.com', 'chanjong', 'coldbell', '1234');

INSERT INTO account (id, create_date, email, name, nick_name, passwd)
 VALUES (2, now(), 'coldbell4869@gmail.com', 'joseph', 'coldpaper', 'asdf');

INSERT INTO account_roles(account_id, role_id) VALUES( 1, 1);
INSERT INTO account_roles(account_id, role_id) VALUES( 2, 1);
INSERT INTO account_roles(account_id, role_id) VALUES( 1, 2);
