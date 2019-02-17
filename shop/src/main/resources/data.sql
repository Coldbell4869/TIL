insert into lvl (id, name) values (1, 'ADMIN');
insert into lvl (id, name) values (2, 'USER');

insert into usr (id, create_date, email, name, nick_name, pswd)
 values(1, now(), 'coldbell89@gmail.com', 'ChanjongPark', 'Coldbell', '1234');

insert into usr (id, create_date, email, name, nick_name, pswd)
 values(2, now(), 'coldbell4869@gmail.com', 'JosephPark', 'coldpaper', 'asdf');

insert into usr_lvl(usr_id, lvl_id) values( 1, 1);
insert into usr_lvl(usr_id, lvl_id) values( 1, 2);
insert into usr_lvl(usr_id, lvl_id) values( 2, 1);