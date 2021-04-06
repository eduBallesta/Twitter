insert into tweet (is_Validated, text, id) values (false, 'Suben las pensiones', '23');
insert into tweet (is_Validated, text, id) values (false, 'El covid remite', '24');
insert into tweet (is_Validated, text, id) values (true,  'Elecciones YA!', '25');
insert into hashtag (hash_tag, id) values ('Ayuso', 1);
insert into hashtag (hash_tag, id) values ('M.Rajoy', 2);
insert into user_tweet (email, favourites_count, followers_count, friends_count, location, name, status, fk_tweet, id) values ('email@gmail.com', 1520, 3000, 200, 'es', 'user1', null, '23', 1);