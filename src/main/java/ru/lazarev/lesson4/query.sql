-- ошибки в расписании (фильмы накладываются друг на друга), отсортированные по возрастанию времени.
-- Выводить надо колонки «фильм 1», «время начала», «длительность», «фильм 2», «время начала»,
-- «длительность»;


select first_movie.movie_name     as first_movie,
       first_movie.session_start  as first_movie_session_start,
       first_movie.duration       as first_movie_duration,
       second_movie.movie_name    as second_movie,
       second_movie.session_start as second_movie_session_start,
       second_movie.duration      as second_movie_duration
from (
--     фильмы с рассчитанным временем окончанием сеанса
         select session.id                                               as session,
                movie.name                                               as movie_name,
                session.startDate                                        as session_start,
                movie.duration                                           as duration,
                session.startDate + movie.duration * interval '1 minute' as endDate
         from cinema.movies as movie
                  inner join cinema.sessions as session
                             on movie.id = session.movie_id
     ) as first_movie
         inner join
     (
         select session.id        as session,
                movie.name        as movie_name,
                session.startDate as session_start,
                movie.duration    as duration
         from cinema.movies as movie
                  inner join cinema.sessions as session
                             on movie.id = session.movie_id
     ) as second_movie
     on
             first_movie.session_start <= second_movie.session_start
             and first_movie.endDate > second_movie.session_start
             and first_movie.session != second_movie.session
order by first_movie.session_start;

-- перерывы 30 минут и более между фильмами — выводить по уменьшению длительности перерыва.
-- Колонки «фильм 1», «время начала», «длительность», «время начала второго фильма»,
-- «длительность перерыва»;
select first_movie.movie_name          as first_movie_name,
       first_movie.session_start       as first_movie_session_start,
       first_movie.duration            as first_movie_duration,
       min(second_movie.session_start) as second_movie_session_start,
       min(EXTRACT(EPOCH FROM AGE(second_movie.session_start, first_movie.endDate)) /
           60)                         as duration
from (
         select sesson.id                                               as session,
                movie.name                                              as movie_name,
                sesson.startDate                                        as session_start,
                movie.duration                                          as duration,
                sesson.startDate + movie.duration * interval '1 minute' as endDate
         from cinema.movies as movie
                  inner join cinema.sessions as sesson
                             on movie.id = sesson.movie_id
     ) as first_movie
         inner join
     (
         select session.id        as session,
                movie.name        as movie_name,
                session.startDate as session_start,
                movie.duration    as duration
         from cinema.movies as movie
                  inner join cinema.sessions as session
                             on movie.id = session.movie_id
     ) as second_movie
     on
             first_movie.session_start < second_movie.session_start
             and
             first_movie.session_start::date = second_movie.session_start::date
group by first_movie_name,
         first_movie_session_start,
         first_movie_duration

having min(EXTRACT(EPOCH FROM AGE(second_movie.session_start, first_movie.endDate)) / 60) >= 30

order by min(EXTRACT(EPOCH FROM AGE(second_movie.session_start, first_movie.endDate)) / 60) desc,
         first_movie_session_start;


