INSERT INTO ABONNE (ID, NOM, PRENOM, MAIL, TELEPHONE, IMAGE)
VALUES (1, ' ahmed', 'hmayer', 'ahmed.hmayer@gma.com', '+21627119665', '/images/moi.jpg');
INSERT INTO ABONNE (ID, NOM, PRENOM, MAIL, TELEPHONE, IMAGE)
VALUES (2, ' mohamed', 'souidi', 'ahmed.hmayer@gma.com', '+21627119665', '/images/person1.png');
INSERT INTO ABONNE (ID, NOM, PRENOM, MAIL, TELEPHONE, IMAGE)
VALUES (3, ' mohamed', 'souidi', 'ahmed.hmayer@gma.com', '+21627119665', '/images/person2.png');
INSERT INTO ABONNE (ID, NOM, PRENOM, MAIL, TELEPHONE, IMAGE)
VALUES (4, ' mohamed', 'souidi', 'ahmed.hmayer@gma.com', '+21627119665', '/images/person4.jpg');
INSERT INTO ABONNE (ID, NOM, PRENOM, MAIL, TELEPHONE, IMAGE)
VALUES (5, ' mohamed', 'souidi', 'ahmed.hmayer@gma.com', '+21627119665', '/images/person5.png');
INSERT INTO ABONNE (ID, NOM, PRENOM, MAIL, TELEPHONE, IMAGE)
VALUES (6, ' mohamed', 'souidi', 'ahmed.hmayer@gma.com', '+21627119665', '/images/person6.jpg');

insert into descipline (id, libel, prix)
values (1, 'zumba', 5.5);
insert into descipline (id, libel, prix)
values (2, 'd2', 5.5);
insert into descipline (id, libel, prix)
values (3, 'd3', 5.5);
insert into descipline (id, libel, prix)
values (4, 'd4', 5.5);
insert into descipline (id, libel, prix)
values (5, 'd5', 5.5);


INSERT INTO entraineur (ID, NOM, PRENOM, MAIL, TELEPHONE, IMAGE)
VALUES (1, ' trainer 1', 'souidi', 'ahmed.hmayer@gma.com', '+21627119665', '/images/person6.jpg');
INSERT INTO entraineur (ID, NOM, PRENOM, MAIL, TELEPHONE, IMAGE)
VALUES (2, ' trainer 2', 'souidi', 'ahmed.hmayer@gma.com', '+21627119665', '/images/person6.jpg');


insert into abonnement (id, debut, fin, descipline_id)
values (1, '2019-01-01', '2019-01-01', 1);
insert into abonnement (id, debut, fin, descipline_id)
values (2, '2019-01-01', '2020-01-01', 3);
insert into abonnement (id, debut, fin, descipline_id)
values (3, '2019-01-01', '2020-01-01', 5);
insert into abonnement (id, debut, fin, descipline_id)
values (4, '2019-01-01', '2019-01-01', 2);
insert into abonnement (id, debut, fin, descipline_id)
values (5, '2019-01-01', '2019-01-01', 4);
insert into abonnement (id, debut, fin, descipline_id)
values (6, '2019-01-01', '2018-01-01', 4);

insert into abonnement_facture (id, abonne_id, abonnement_id)
values (1, 1, 1);
insert into abonnement_facture (id, abonne_id, abonnement_id)
values (2, 2, 2);
insert into abonnement_facture (id, abonne_id, abonnement_id)
values (3, 3, 3);
insert into abonnement_facture (id, abonne_id, abonnement_id)
values (4, 4, 4);
insert into abonnement_facture (id, abonne_id, abonnement_id)
values (5, 5, 5);
insert into abonnement_facture (id, abonne_id, abonnement_id)
values (6, 6, 6);

insert into entraineur_descipline (id, entraineur_id, descipline_id)
values (1, 1, 1);
insert into entraineur_descipline (id, entraineur_id, descipline_id)
values (2, 1, 2);
insert into entraineur_descipline (id, entraineur_id, descipline_id)
values (3, 2, 1);



insert into produit (id, libel, prix, prix_achat, image)
values (1, 'produit x', 5.5, 4.5, '/images/prod-1.jpg');

insert into produit_facture (id, abonne_id, produit_id)
values (1, 1, 1);

-- Used by Spring Remember Me API. h2
CREATE TABLE Persistent_Logins
(

    username  varchar(64) not null,
    series    varchar(64) not null,
    token     varchar(64) not null,
    last_used Datetime    not null,
    PRIMARY KEY (series)

);



insert into app_user (USER_ID, USER_NAME, ENCRYTED_PASSWORD, IMAGE, ENABLED)
values (2, 'user1', '$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu', '/images/user-1.png', 1);

insert into app_user (USER_ID, USER_NAME, ENCRYTED_PASSWORD, IMAGE, ENABLED)
values (1, 'admin1', '$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu', '/images/img.jpg', 1);

insert into app_role (ROLE_ID, ROLE_NAME)
values (1, 'ROLE_ADMIN');

insert into app_role (ROLE_ID, ROLE_NAME)
values (2, 'ROLE_USER');



insert into user_role (ID, USER_ID, ROLE_ID)
values (1, 1, 1);

insert into user_role (ID, USER_ID, ROLE_ID)
values (2, 1, 2);

insert into user_role (ID, USER_ID, ROLE_ID)
values (3, 2, 2);


-- insert into msg( id , date_time, etat, object , text , destination_user_id , source_user_id   ) values ( 1, '2019-12-29T14:22:38.357', true, 'text text text text text text text text text text text ', 'text', 2 ,1 );
-- insert into msg( id , date_time, etat, object , text , destination_user_id , source_user_id   ) values ( 2, '2019-12-29T14:22:38.357', true, 'objet', 'text text text text text text text text text ', 2 ,1 );
-- insert into msg( id , date_time, etat, object , text , destination_user_id , source_user_id   ) values ( 3, '2019-12-29T14:22:38.357', true, 'objet', 'text text text text text text text text text text text text ', 2 ,1 );
insert into msg(id, date_time, etat, object, text, destination_user_id, source_user_id)
values (4, '2019-12-29T14:22:38.357', true, 'objet', 'text text text text text text text text text text text ', 1, 2);
insert into msg(id, date_time, etat, object, text, destination_user_id, source_user_id)
values (5, '2019-12-29T14:22:38.357', true, 'objet', 'text text text text text text text text text text text ', 1, 2);
insert into msg(id, date_time, etat, object, text, destination_user_id, source_user_id)
values (6, '2019-12-29T14:22:38.357', true, 'objet', 'text text text text text text text text text text text ', 1, 2);

