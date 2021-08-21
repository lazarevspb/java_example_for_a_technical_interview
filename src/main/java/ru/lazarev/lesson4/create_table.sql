-- Задача про кинотеатр.
-- У фильма, который идет в кинотеатре, есть название,
-- длительность (пусть будет 60, 90 или 120 минут),
-- цена билета (в разное время и дни может быть разной),
-- время начала сеанса (один фильм может быть показан
-- несколько раз в разное время и с разной ценой билета).
-- Есть информация о купленных билетах (номер билета,
-- на какой сеанс).


CREATE SCHEMA cinema
    AUTHORIZATION postgres;

set search_path to cinema;

drop table if exists movies;
create table movies
(
    id       bigserial PRIMARY KEY,
    name     VARCHAR(255) NOT NULL,
    duration integer      NOT NULL
);

drop table if exists sessions;
create table sessions
(
    id        bigserial PRIMARY KEY,
    movie_id   bigint    NOT NULL REFERENCES movies (id),
    startDate timestamp NOT NULL,
    price     decimal   NOT NULL

);

drop table if exists sold_tickets;
create table sold_tickets
(
    id         bigserial PRIMARY KEY,
    session_id bigint NOT NULL REFERENCES sessions (id)
);

insert into movies (name, duration)
values ('Movie One', 60),
       ('Movie Two', 90),
       ('Movie Three', 120),
       ('Movie Four', 60);

insert into sessions (movie_id, startDate, price)
values (1, '2021-01-01 9:00:00', 50),
       (1, '2021-01-01 18:00:00', 150),
       (2, '2021-01-01 10:00:00', 50),
       (2, '2021-01-01 20:00:00', 150),
       (3, '2021-01-01 11:00:00', 50),
       (3, '2021-01-01 21:00:00', 150),
       (4, '2021-01-01 12:00:00', 50),
       (4, '2021-01-01 22:00:00', 150)
;

insert into sold_tickets (session_id)
values (1),
       (2),
       (3),
       (4);